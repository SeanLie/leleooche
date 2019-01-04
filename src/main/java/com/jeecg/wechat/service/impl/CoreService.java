package com.jeecg.wechat.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.shenzhenair.cargo.freight.wechat.booking.app.IKeyWordApp;
//import com.shenzhenair.cargo.freight.wechat.booking.app.IWaybillApp;
//import com.shenzhenair.cargo.freight.wechat.controller.LoginCtr;
import com.jeecg.wechat.entity.MessageUtil;
import com.jeecg.wechat.entity.TextMessage;
import com.jeecg.wechat.service.IKeyWordAppServiceI;
import com.jeecg.wechat.util.KeyWordUtil;

public class CoreService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CoreService.class);

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @param IKeyWordAppService
	 * @param waybillAppImpl
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	// public static String processRequest(HttpServletRequest request, IKeyWordApp
	// keyWordAppImpl, IWaybillApp waybillAppImpl) {
	public static String processRequest(HttpServletRequest request, IKeyWordAppServiceI iKeyWordAppService) {
		LOGGER.info("CoreService.processRequest【入口】");
		String respMessage = null;

		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 消息内容
			String content = requestMap.get("Content");
			List<Object> keyPops = request.getSession().getServletContext().getAttribute(fromUserName) == null
					? new ArrayList<>()
					: (List<Object>) request.getSession().getServletContext().getAttribute(fromUserName);
			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			System.out.println("keyPops====>" + keyPops);
			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {

				// respContent=KeyWordUtil.keyToMsg(content, request, fromUserName,
				// keyPops,keyWordAppImpl,waybillAppImpl);
				respContent = KeyWordUtil.keyToMsg(content, request, fromUserName, keyPops, iKeyWordAppService);
				respContent = "您发送的是文本消息！";

			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				/*
				 * 订阅
				 */
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "欢迎关注乐乐集团微信公众号\n" + "官网:<a href=\"http://www.leletc.com:8080//\">深圳市乐乐网络科技有限公司</a>\n";
				}
				/*
				 * 取消订阅
				 */
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				/*
				 * 自定义菜单点击事件
				 */
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// 事件KEY值，与创建自定义菜单时指定的KEY值对应
					String eventKey = requestMap.get("EventKey");
					keyPops.clear();
					keyPops.add(eventKey);
					request.getSession().getServletContext().setAttribute(fromUserName, keyPops);
					if (eventKey.equals("YDQRY")) {
						respContent = KeyWordUtil.getKeyInfo(iKeyWordAppService, "2");
					} else if (eventKey.equals("HBHQRY")) {
						respContent = KeyWordUtil.getKeyInfo(iKeyWordAppService, "1");
					}
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}
}
