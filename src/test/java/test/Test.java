package test;

import tst.comm.setting.SerialReader; 
public class Test {
	private static Integer portnum = 2;
	// 写进session中去
	private static SerialReader serialReader = new SerialReader();

	public static void closePort() {
		// 关闭端口
		if (serialReader != null) {
			serialReader.close();
		}
	}

	public static void sendPort() {
		String msgString = "";
		// 关闭端口
		if (serialReader != null) {
			msgString = serialReader.send("你是谁，回答一下吧！").toString();
		}
		System.out.println(msgString);
	}

	public static void openPort() throws Exception {
		String msgString = "";
		// 每个客户的串口都放进自己的session中，

		if (serialReader != null) {
			// 设置端口号
			serialReader.setPortID(portnum);
			// 打开通向端口
			msgString = serialReader.tryOpenPort().toString();
		}
		System.out.println(msgString);
	}

	public static void main(String[] aStrings) throws InterruptedException {
		// 当前路径在
		System.out.println("当前在" + System.getProperty("user.dir"));
		System.out.println("当前所有端口" + SerialReader.listPorts());

		try {
			openPort();
			sendPort();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closePort();
		}
	}
}
