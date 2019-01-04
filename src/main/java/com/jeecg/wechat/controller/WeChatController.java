package com.jeecg.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeewx.api.core.exception.WexinReqException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.wechat.entity.Button;
import com.jeecg.wechat.entity.Menu;
import com.jeecg.wechat.entity.ViewButton;
import com.jeecg.wechat.service.IKeyWordAppServiceI;
import com.jeecg.wechat.service.impl.CoreService;
import com.jeecg.wechat.util.Constrants;
import com.jeecg.wechat.util.SignUtil;
import com.jeecg.wechat.util.WeixinUtil;
import com.jeecg.wechat.util.WxTools;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/infacewechat")
@Api(value = "Wechat", description = "微信服务器接口", tags = "API_WeChat")
public class WeChatController {
	private Logger log = LoggerFactory.getLogger(WeChatController.class);
	private String DNBX_TOKEN = Constrants.WeChat.APP_TOKEN;

	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatController.class);

	// @Autowired
	// private IKeyWordApp keyWordAppImpl;
	private IKeyWordAppServiceI IKeyWordAppService;

	/**
	 * 微信接入
	 * 
	 * @param wc
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/wechat.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	@ApiOperation(value = "微信公众号接入服务器地址")
	public void connectWeixin(HttpServletRequest request, HttpServletResponse response) throws IOException {

		LOGGER.info("WeChatController.connectWeixin 【入口参数】");
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8"); // 微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
		response.setCharacterEncoding("UTF-8"); // 在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
		boolean isGet = request.getMethod().toLowerCase().equals("get");

		PrintWriter out = response.getWriter();
		try {
			if (isGet) {
				String signature = request.getParameter("signature");// 微信加密签名
				String timestamp = request.getParameter("timestamp");// 时间戳
				String nonce = request.getParameter("nonce");// 随机数
				String echostr = request.getParameter("echostr");// 随机字符串

				LOGGER.info("signature=" + signature);
				LOGGER.info("timestamp=" + timestamp);
				LOGGER.info("nonce=" + nonce);
				LOGGER.info("echostr=" + echostr);

				// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
				if (SignUtil.checkSignature(DNBX_TOKEN, signature, timestamp, nonce)) {
					LOGGER.info("Connect the weixin server is successful.");
					response.getWriter().write(echostr);
				} else {
					LOGGER.error("Failed to verify the signature!");
				}
			} else {
				String respMessage = "异常消息！";

				try {
					// respMessage =
					// CoreService.processRequest(request,keyWordAppImpl,waybillAppImpl);
					respMessage = CoreService.processRequest(request, IKeyWordAppService);
					out.write(respMessage);
					LOGGER.info("The request completed successfully");
					LOGGER.info("to weixin server " + respMessage);
				} catch (Exception e) {
					LOGGER.error("Failed to convert the message from weixin!");
				}

			}
		} catch (Exception e) {
			LOGGER.error("Connect the weixin server is error.");
		} finally {
			out.close();
		}
	}

	/**
	 * 通过接口创建菜单，后门程序
	 * 
	 * @throws WexinReqException
	 */
	@RequestMapping(value = "/createmenu", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	@ApiOperation(value = "通过接口触发微信自定义菜单")
	public void createMenu(HttpServletRequest request, HttpServletResponse response)
			throws IOException, WexinReqException {

		String access_token = WxTools.getAccessToken();
		/*
		 * 菜单一
		 */
		ViewButton b11 = new ViewButton();
		b11.setUrl("http://www.ooche.cn/wcs/");
		b11.setName("预约洗车");
		b11.setType("view");

//		ViewButton b12 = new ViewButton();
//		b12.setUrl("http://www.ooche.cn/wcs/default/");
//		b12.setName("预约洗车default");
//		b12.setType("view");

//		ComplexButton cb1 = new ComplexButton();
//		cb1.setName("预约洗车");
//		cb1.setSub_button(new Button[] { b11 });

		Menu menu = new Menu();
		// menu.setButton(new Button[] { cb1, cb2, cb3 });
		menu.setButton(new Button[] { b11 });
		// menu.setButton(new Button[] {cb1,cb3});
		int createMenu = WeixinUtil.createMenu(menu, access_token);
		System.out.println("createMenu===>" + createMenu);
	}
}
