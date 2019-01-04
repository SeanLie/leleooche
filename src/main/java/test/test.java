package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.jeecg.wechat.service.impl.WxApiBaseServiceImpl;

public class test {
	private static Logger logger = Logger.getLogger(WxApiBaseServiceImpl.class);

//	@SuppressWarnings("resource")
//	public static void main(String[] args) {
//		BeanFactory factory = new ClassPathXmlApplicationContext("spring-mvc-hibernate.xml");
//		WxUserDao wxUserDao = (WxUserDao) factory.getBean("wxUserDao");
//
//		Wxuser w_x_user = new Wxuser();
//		w_x_user.setSex("1");
//		w_x_user.setNickname("刘勤");
//		w_x_user.setUnionid("oZKxt1oksNJvzP2JPiRIIt5w4UcM");
//		w_x_user.setProvince("广东");
//		w_x_user.setOpenid("oCwBj0QB5z-aI6yhAfvgMW65lACE");
//		w_x_user.setLanguage("zh_CN");
//		w_x_user.setHeadimgurl(
//				"\"http://thirdwx.qlogo.cn/mmopen/vi_32/4aRhVLwhAWcBFpqBcdhP4EkibsWdW8yVKknIhor55FFibB6BibHsJU2gfdHWk0wa41r8QVGqu1lWYYHEgTw14Plicg/132\"");
//		w_x_user.setCountry("中国");
//		w_x_user.setCity("深圳");
//
//		Wxuser wxuser = wxUserDao.getWxUserByWxOpenid(w_x_user.getOpenid());
//
//		if (wxuser.toString() == null) {
//			logger.error("wxuser:" + wxuser.toString());
//		}
//
//		wxUserDao.insert(w_x_user);
//
//	}
//	
//	
//	

//public class TestOrder extends Thread{

	private static long orderNum = 01;
	private static String date;

	public static void main(String[] args) throws InterruptedException {
		String json = "[]";
		if (json.length() == 2 || json.equals("[]")) {
			System.out.println("json长度" + json.length());
			System.out.println("json" + json.toString());
		}

		System.out.println(json.length());
		System.out.println(json.toString());
//		String URL = "http://www.ooche.cn/wcs/default/appoint";
//
//		URL = StringUtil.getDecodeUrl(URL);
//		System.out.println("decodeURL:" + URL);
//
//		URL = StringUtil.getEncodeUrl(URL);
//		System.out.println("encodeURL:" + URL);

//		for (int i = 0; i < 10000; i++) {
//			// System.out.println(test.getOrderNo());
//			System.out.println(test.getOrderCode());
//			Thread.sleep(1000);
//		}
	}

	// 订单编号前缀
	public static final String PREFIX = "Ko.";
	// 订单编号后缀（核心部分）
	private static long code;

	private static String getDateTime() {
		DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}

	// 生成订单编号
	public static synchronized String getOrderCode() {
		code++;
		String str = getDateTime();
		System.out.println("str:" + str);
		long m = Long.parseLong((str)) * 1000;
		m += code;
		return PREFIX + m;
	}

	/**
	 * 生成订单编号 18101116240007
	 * 
	 * @return
	 */
	public static synchronized String getOrderNo() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // 时间字符串产生方式
		String uid_pfix = dateFormat.format(new Date());
		// String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		// System.out.println("uid_pfix:" + uid_pfix);
//		if (date == null || !date.equals(uid_pfix)) {
//			date = uid_pfix;
//			orderNum = 01;
//		}
		orderNum++;
		// System.out.println("orderNum:" + orderNum);
		// System.out.println("date:" + date);
		long orderNo = Long.parseLong((date)) * 10000;
		// System.out.println("orderNo1:" + orderNo);
		orderNo += orderNum;
		// System.out.println("orderNo2:" + orderNo);
		return "No." + orderNo + "";
	}
}
