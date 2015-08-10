package tst.comm.setting;

public class CommSerial {
	// 端口号
	private static Integer portID = 1;
	// 波特率
	private static Integer rate = 9600;
	// 数据传输位数
	private static Integer dataBit = 8;
	// 停止位
	private static Integer stopBit = 1;
	// 校验方式
	private static Integer parity = 0;
	// 超时设置
	private static Integer timeout = 1000;

	public static Integer getPortID() {
		return portID;
	}

	public static void setPortID(Integer portID) {
		CommSerial.portID = portID;
	}

	public static Integer getRate() {
		return rate;
	}

	public static void setRate(Integer rate) {
		CommSerial.rate = rate;
	}

	public static Integer getDataBit() {
		return dataBit;
	}

	public static void setDataBit(Integer dataBit) {
		CommSerial.dataBit = dataBit;
	}

	public static Integer getStopBit() {
		return stopBit;
	}

	public static void setStopBit(Integer stopBit) {
		CommSerial.stopBit = stopBit;
	}

	public static Integer getParity() {
		return parity;
	}

	public static void setParity(Integer parity) {
		CommSerial.parity = parity;
	}

	public static Integer getTimeout() {
		return timeout;
	}

	public static void setTimeout(Integer timeout) {
		CommSerial.timeout = timeout;
	}

}
