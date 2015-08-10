package org.system.comm.serialbus;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TooManyListenersException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SerialReader implements Runnable, SerialPortEventListener {
	Log log = LogFactory.getLog(SerialReader.class);

	public boolean isOpen() {
		return isOpen;
	}

	public Map<String, String> tryOpenPort(SerialModel model) {
		Map<String, String> result = new HashMap<String, String>();
		try {
			// 打开端口
			this.portId = CommPortIdentifier.getPortIdentifier("COM"
					+ model.getPortID());
			this.serialPort = (SerialPort) this.portId.open("SerialReader",
					model.getTimeout());
			this.inputStream = this.serialPort.getInputStream();
			this.serialPort.addEventListener(this);
			this.serialPort.notifyOnDataAvailable(true);
			this.serialPort.setSerialPortParams(model.getRate(),
					model.getDataBit(), model.getStopBit(), model.getParity());
			Thread readThread = new Thread(this);
			readThread.start();
			isOpen = true;
			this.model = model;
			result.put("errcode", "0");
			result.put("msg", "端口" + model.getPortID() + "打开成功");
		} catch (PortInUseException e) {
			// 端口"+serialParams.get( PARAMS_PORT ).toString()+"已经被占用";
			result.put("errcode", "1001");
			result.put("msg", "端口" + model.getPortID() + "已经被占用");
		} catch (TooManyListenersException e) {
			// "端口"+serialParams.get( PARAMS_PORT ).toString()+"监听者过多";
			result.put("errcode", "1002");
			result.put("msg", "端口" + model.getPortID() + "监听者过多");
		} catch (UnsupportedCommOperationException e) {
			// "端口操作命令不支持";
			result.put("errcode", "1003");
			result.put("msg", "端口" + model.getPortID() + "操作命令不支持");
		} catch (NoSuchPortException e) {
			// "端口"+serialParams.get( PARAMS_PORT ).toString()+"不存在";
			result.put("errcode", "1004");
			result.put("msg", "端口" + model.getPortID() + "不存在");
		} catch (IOException e) {
			// "打开端口"+serialParams.get( PARAMS_PORT ).toString()+"失败";
			result.put("errcode", "1005");
			result.put("msg", "打开端口" + model.getPortID() + "失败");
		}
		return result;
	}

	public void run() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
	}

	public void start() {
		try {
			this.outputStream = this.serialPort.getOutputStream();
		} catch (IOException e) {
		}
		try {
			readThread = new Thread(this);
			readThread.start();
		} catch (Exception e) {
		}
	} // start() end

	public void run(String message) {
		try {
			Thread.sleep(4);
		} catch (InterruptedException e) {
		}
		try {
			if (message != null && message.length() != 0) {
				outputStream.write(message.getBytes()); // 往串口发送数据，是双向通讯的。
			}
		} catch (IOException e) {
		}
	}

	public void close() {
		if (isOpen) {
			try {
				serialPort.notifyOnDataAvailable(false);
				serialPort.removeEventListener();
				inputStream.close();
				serialPort.close();
				isOpen = false;
				log.info("端口" + model.getPortID() + " 被关闭！");
			} catch (IOException ex) {
				// "关闭串口失败";
			}
		}
	}

	public void serialEvent(SerialPortEvent event) {
		try {
			Thread.sleep(model.getDelayRead());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (event.getEventType()) {
		case SerialPortEvent.BI: // 10
		case SerialPortEvent.OE: // 7
		case SerialPortEvent.FE: // 9
		case SerialPortEvent.PE: // 8
		case SerialPortEvent.CD: // 6
		case SerialPortEvent.CTS: // 3
		case SerialPortEvent.DSR: // 4
		case SerialPortEvent.RI: // 5
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2
			break;
		case SerialPortEvent.DATA_AVAILABLE: // 1
			try {
				// 多次读取,将所有数据读入
				while (inputStream.available() > 0) {
					numBytes = inputStream.read(readBuffer);
				}
				updateMessage(readBuffer, numBytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	// 获取返回消息，放入程序buffer中
	public void updateMessage(byte[] message, int length) {
		String mt = new String(message);
		// 构造xml <xml><toUser>port3</toUser><date>2014-11-22
		// 08:11:22</date><content>你是谁呀，孩子</content></xml>
		// System.out.println("COM" + model.getPortID() + " Get Datas:" + mt);
		mt = "<xml><toUser>" + model.getPortID() + "</toUser><date>"
				+ new Date() + "</date><content>" + mt + "</content></xml>";
		messageBufferList.add(mt);
	}

	public static List<String> listPorts() {
		Enumeration<?> portEnum = CommPortIdentifier.getPortIdentifiers();
		List<String> resultList = new ArrayList<String>();
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier portIdentifier = (CommPortIdentifier) portEnum
					.nextElement();
			if (!portIdentifier.isCurrentlyOwned())
				resultList.add(portIdentifier.getName());
		}
		return resultList;
	}

	/**
	 * 往串口发送数据,实现双向通讯.
	 * 
	 * @param string
	 *            message
	 */
	public Map<String, String> send(String message) {
		Map<String, String> result = new HashMap<String, String>();
		if (!isOpen()) {
			result.put("errcode", "1001");
			result.put("msg", "请先打开串口");
			return result;
		}
		if (message != null && message.length() != 0) {
			start();
			run(message);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result.put("errcode", "0");
		result.put("msg", "数据发送成功，等待返回中...");
		return result;
	}

	static String getPortTypeName(int portType) {
		switch (portType) {
		case CommPortIdentifier.PORT_I2C:
			return "I2C";
		case CommPortIdentifier.PORT_PARALLEL:
			return "Parallel";
		case CommPortIdentifier.PORT_RAW:
			return "Raw";
		case CommPortIdentifier.PORT_RS485:
			return "RS485";
		case CommPortIdentifier.PORT_SERIAL:
			return "Serial";
		default:
			return "unknown type";
		}
	}

	public HashSet<CommPortIdentifier> getAvailableSerialPorts()// 本来static
	{
		HashSet<CommPortIdentifier> h = new HashSet<CommPortIdentifier>();
		Enumeration<?> thePorts = CommPortIdentifier.getPortIdentifiers();
		while (thePorts.hasMoreElements()) {
			CommPortIdentifier com = (CommPortIdentifier) thePorts
					.nextElement();
			switch (com.getPortType()) {
			case CommPortIdentifier.PORT_SERIAL:
				try {
					CommPort thePort = com.open("CommUtil", 50);
					thePort.close();
					h.add(com);
				} catch (PortInUseException e) {
					System.out.println("Port, " + com.getName()
							+ ", is in use.");
				} catch (Exception e) {
					System.out.println("Failed to open port " + com.getName()
							+ e);
				}
			}
		}
		return h;
	}

	private CommPortIdentifier portId;
	private int numBytes; // buffer中的实际数据字节数
	private static byte[] readBuffer = new byte[1024]; // 4k的buffer空间,缓存串口读入的数据
	private InputStream inputStream;
	private OutputStream outputStream;
	private Thread readThread;// 本来是static类型的
	// 创建一个端口控制器
	private SerialPort serialPort;
	// 端口是否打开了
	private boolean isOpen = false;
	private SerialModel model = null;
	private List<String> messageBufferList;

	public Map<String, Integer> getCurrSetting() {
		if (model == null) {
			return null;
		}
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("portID", model.getPortID());
		resultMap.put("rate", model.getRate());
		resultMap.put("dataBit", model.getDataBit());
		resultMap.put("stopBit", model.getStopBit());
		resultMap.put("parity", model.getParity());
		resultMap.put("timeout", model.getTimeout());
		resultMap.put("delayRead", model.getDelayRead());
		return resultMap;
	}

	public List<String> getMessageBufferList() {
		return messageBufferList;
	}

	public void messageClear() {
		this.messageBufferList = null;
	}
}