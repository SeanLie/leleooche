package com.jeecg.wechat.page;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class LoggerPage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String logId;
	private String keyWord;
	private String operationLog;
	private Date opDate;
	private String opId;
	private String machineInfo;
	private String enterSys;

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getOperationLog() {
		return operationLog;
	}

	public void setOperationLog(String operationLog) {
		this.operationLog = operationLog;
	}

	public Date getOpDate() {
		return opDate;
	}

	public void setOpDate(Date opDate) {
		this.opDate = opDate;
	}

	public String getOpId() {
		return opId;
	}

	public void setOpId(String opId) {
		this.opId = opId;
	}

	public String getMachineInfo() {
		return machineInfo;
	}

	public void setMachineInfo(String machineInfo) {
		this.machineInfo = machineInfo;
	}

	public String getEnterSys() {
		return enterSys;
	}

	public void setEnterSys(String enterSys) {
		this.enterSys = enterSys;
	}

	@Override
	public String toString() {
		return "LoggerDto [logId=" + logId + ", keyWord=" + keyWord + ", operationLog=" + operationLog + ", opDate="
				+ opDate + ", opId=" + opId + ", machineInfo=" + machineInfo + ", enterSys=" + enterSys + "]";
	}
}
