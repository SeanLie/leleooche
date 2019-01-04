package com.jeecg.wechat.util;

abstract class SMSConfig {

	// http://sms.snowind.cn/Service.asmx/sendsms?zh=账号&mm=密码&hm=手机号码&nr=内容&dxlbid=短信类别&extno=

	static final String smsurl = "http://sms.snowind.cn/Service.asmx/sendsms?";

	static final String smsurlParm = "zh=SMSUSERNAME&mm=SMSPASWORLD&hm=TEL&nr=CONTENT&dxlbid=DXLBID&extno=EXTNO";

	static final String smsusername = "gzlele";

	static final String smspassword = "568927";

}
