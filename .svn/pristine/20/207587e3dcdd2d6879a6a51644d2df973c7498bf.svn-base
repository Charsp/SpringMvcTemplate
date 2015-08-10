package tst.comm.setting;

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

	public Map<String, String> tryOpenPort() {
		Map<String, String> result = new HashMap<String, String>();
		try {
			// 打开端口
			this.portId = CommPortIdentifier.getPortIdentifier("COM" + portID);
			this.serialPort = (SerialPort) this.portId.open("SerialReader",
					timeout);
			this.inputStream = this.serialPort.getInputStream();
			this.serialPort.addEventListener(this);
			this.serialPort.notifyOnDataAvailable(true);
			this.serialPort.setSerialPortParams(rate, dataBit, stopBit, parity);
			Thread readThread = new Thread(this);
			readThread.start();
			isOpen = true;
			result.put("errcode", "0");
			result.put("msg", "端口" + portID + "打开成功");
		} catch (PortInUseException e) {
			// 端口"+serialParams.get( PARAMS_PORT ).toString()+"已经被占用";
			result.put("errcode", "1001");
			result.put("msg", "端口" + portID + "已经被占用");
		} catch (TooManyListenersException e) {
			// "端口"+serialParams.get( PARAMS_PORT ).toString()+"监听者过多";
			result.put("errcode", "1002");
			result.put("msg", "端口" + portID + "监听者过多");
		} catch (UnsupportedCommOperationException e) {
			// "端口操作命令不支持";
			result.put("errcode", "1003");
			result.put("msg", "端口" + portID + "操作命令不支持");
		} catch (NoSuchPortException e) {
			// "端口"+serialParams.get( PARAMS_PORT ).toString()+"不存在";
			result.put("errcode", "1004");
			result.put("msg", "端口" + portID + "不存在");
		} catch (IOException e) {
			// "打开端口"+serialParams.get( PARAMS_PORT ).toString()+"失败";
			result.put("errcode", "1005");
			result.put("msg", "打开端口" + portID + "失败");
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
				System.out.println("COM" + this.portID + " Send Message:"
						+ message);
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
				log.info("端口" + portID + " 被关闭！");
			} catch (IOException ex) {
				// "关闭串口失败";
			}
		}
	}

	public void serialEvent(SerialPortEvent event) {
		try {
			Thread.sleep(delayRead);
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
				changeMessage(readBuffer, numBytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	// 通过observer pattern将收到的数据发送给observer
	// 将buffer中的空字节删除后再发送更新消息,通知观察者
	public void changeMessage(byte[] message, int length) {
		String mt = new String(message);
		System.out.println("COM" + portID + " Get Datas:" + mt);
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
	// 端口号
	private Integer portID = 1;
	// 波特率
	private Integer rate = 9600;
	// 数据传输位数
	private Integer dataBit = 8;
	// 停止位
	private Integer stopBit = 1;
	// 校验方式
	private Integer parity = 0;
	// 超时设置
	private Integer timeout = 100;
	// 端口读入数据事件触发后,等待n毫秒后再读取,以便让数据一次性读完
	private Integer delayRead = 100; // 延时等待端口数据准备的时间

	public void setPortID(Integer portID) {
		this.portID = portID;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public void setDataBit(Integer dataBit) {
		this.dataBit = dataBit;
	}

	public void setStopBit(Integer stopBit) {
		this.stopBit = stopBit;
	}

	public void setParity(Integer parity) {
		this.parity = parity;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public void setDelayRead(Integer delayRead) {
		this.delayRead = delayRead;
	}

	public Map<String, Integer> getCurrSetting() {
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("portID", this.portID);
		resultMap.put("rate", this.rate);
		resultMap.put("dataBit", this.dataBit);
		resultMap.put("stopBit", this.stopBit);
		resultMap.put("parity", this.parity);
		resultMap.put("timeout", this.timeout);
		resultMap.put("delayRead", this.delayRead);
		return resultMap;
	}

}