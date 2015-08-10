package org.system.comm.serialbus;

public class SerialModel {
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
	private Integer timeout = 1000;
	// 端口读入数据事件触发后,等待n毫秒后再读取,以便让数据一次性读完
	private Integer delayRead = 100; // 延时等待端口数据准备的时间

	public Integer getPortID() {
		return portID;
	}

	public void setPortID(Integer portID) {
		if (portID != null && portID > 0)
			this.portID = portID;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		if (rate != null && rate > 0)
			this.rate = rate;
	}

	public Integer getDataBit() {
		return dataBit;
	}

	public void setDataBit(Integer dataBit) {
		if (dataBit != null && dataBit > 0)
			this.dataBit = dataBit;
	}

	public Integer getStopBit() {
		return stopBit;
	}

	public void setStopBit(Integer stopBit) {
		if (stopBit != null && stopBit > 0)
			this.stopBit = stopBit;
	}

	public Integer getParity() {
		return parity;
	}

	public void setParity(Integer parity) {
		if (parity != null)
			this.parity = parity;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		if (timeout != null && timeout > 100)
			this.timeout = timeout;
	}

	public Integer getDelayRead() {
		return delayRead;
	}

	public void setDelayRead(Integer delayRead) {
		if (delayRead != null && delayRead > 100)
			this.delayRead = delayRead;
	}

}
