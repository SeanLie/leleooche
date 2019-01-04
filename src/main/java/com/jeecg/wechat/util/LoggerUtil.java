package com.jeecg.wechat.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeecg.wechat.page.LoggerPage;
import com.jeecg.wechat.service.ILoggerApp;

public class LoggerUtil {
	private static Logger log=LoggerFactory.getLogger(LoggerUtil.class);
	/**
	 * 	KEYWORD,--关键字 功能名称
		OPERATIONLOG,--系统日志内容，功能名称|操作数据|操作结果
		OPDATE,--操作日期，操作当前日期
		OPID,--当前登录的用户ID
		MACHINEINFO,--IP(10.52.9.55)|MAC(20:6A:8A:19:C8:AE)
		ENTERSYS --系统名称 cargo-wechat “深航货运微信订舱管理系统”
	 * @param request
	 * @return
	 */
	public static void addLogger(final ILoggerApp loggerAppImpl,final HttpServletRequest request,final String optName,final String optParam,final String optResult,final String optCode) {
		
		Thread thread = new Thread(){
			   public void run(){
				   LoggerPage dto=new LoggerPage();
					dto.setEnterSys("cargo-wechat");
					dto.setKeyWord(optName);
					dto.setOpId(optCode);
					dto.setOperationLog(optName+"|"+optParam+"|"+optResult);
					String ip=getRemoteAddress(request);
					dto.setMachineInfo("IP("+ip+")|MAC("+getMACAddress(ip)+")");
					dto.setOpDate(new Date());
					int result=loggerAppImpl.addLogger(dto);
			   }};
		thread.start();
		/*LoggerDto dto=new LoggerDto();
		dto.setEnterSys("cargo-wechat");
		dto.setKeyWord(optName);
		dto.setOpId(optCode);
		dto.setOperationLog(optName+"|"+optParam+"|"+optResult);
		String ip=getRemoteAddress(request);
		dto.setMachineInfo("IP("+ip+")|MAC("+getMACAddress(ip)+")");
		dto.setOpDate(new Date());
		int result=loggerAppImpl.addLogger(dto);*/
		//return result;
	}
	
	 public static String getRemoteAddress(HttpServletRequest request) {
	        String ip = request.getHeader("x-forwarded-for");
	        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
	            ip = request.getRemoteAddr();
	        }
	        return ip;
	  }
	 
	 public static String getMACAddress(String ip) {
	        String str = "";
	        String macAddress = "";
	        try {
	            Process p = Runtime.getRuntime().exec("nbtstat -a " + ip);
	            InputStreamReader ir = new InputStreamReader(p.getInputStream());
	            LineNumberReader input = new LineNumberReader(ir);
	            for (int i = 1; i < 100; i++) {
	                str = input.readLine();
	                if (str != null) {
	                    //if (str.indexOf("MAC Address") > 1) {
	                    if (str.indexOf("MAC") > 1) {
	                        macAddress = str.substring(
	                                str.indexOf("=") + 2, str.length());
	                        break;
	                    }
	                }
	            }
	        } catch (IOException e) {
	        	log.error("LoggerUtil.getMACAddress 【异常】 ip="+ip+";内容"+e.getMessage());
	        	return "";
	        }
	        return macAddress;
	    }
	 
}
