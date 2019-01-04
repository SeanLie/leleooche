package com.leletc.base.pushing;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import com.alibaba.fastjson.JSON;
import com.leletc.oocheorder.web.bo.OrderBO;
import com.leletc.oocheorder.web.bo.OrderReservationBO;
import com.leletc.user.bo.OrderUserBO;
import org.jeecgframework.core.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;

/**
 * 功能描述：消息推送服务端
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/10/27 16:37
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public class PushMessageServer {

    private static Logger logger = LoggerFactory.getLogger(PushMessageServer.class);

    private static String TAG = PushMessageServer.class.getSimpleName();

    private static Properties properties;

    private static JPushClient jPushClient;

    static {
        properties = new PropertiesUtil("apppush.properties").getProperties();
        jPushClient = new JPushClient(properties.getProperty("app.master_secret"),
                properties.getProperty("app.app_key"), null,
                ClientConfig.getInstance());
    }

    public static void main(String[] args) {
        // 柜子开关日志
        /*SmartCabinetLockLogEntity lockLogEntity = new SmartCabinetLockLogEntity();
        lockLogEntity.setCreateName("李斌_Sean");
        lockLogEntity.setCreateDate(new Date());
        lockLogEntity.setOrderId("4c5a500a141e47c1b74586dc2ab72231");
        lockLogEntity.setDoorId("8a9bc03f65aced930165acf1cbde0002");
        lockLogEntity.setBoxNo("1");
        lockLogEntity.setLockInstruct("1");
        lockLogEntity.setLockAct(1);
        lockLogEntity.setLockTime(new Date());
        lockLogEntity.setLockResult("箱门已打开");
        lockLogEntity.setLockUser("4aece611e8fb4dd5b6ee0871733fde0f");
        lockLogEntity.setWxUserToken("");
        String jsonObject = JSON.toJSONString(lockLogEntity);
        System.out.println(jsonObject);
        String registrationID = "13065ffa4e27c397223";
        final PushPayload result = pushToCabinet(registrationID, jsonObject);
        final JsonElement json = result.toJSON();
        System.out.println(json);*/
        // 订单信息
        OrderReservationBO orderBo = new OrderReservationBO();
        OrderUserBO userBo = new OrderUserBO();
        userBo.setUserName("李斌_Sean");
        userBo.setNickname("李斌_Sean\uD83D\uDC40");
        orderBo.setUser(userBo);
        // 返回已插入的订单
        OrderBO orderEntity = new OrderBO();
        orderEntity.setStatusName("待取车");
        orderEntity.setCreateDate(new Date());
        orderBo.setOrder(orderEntity);
        String registrationID = "13065ffa4e27c397223";
        String jsonObject = JSON.toJSONString(orderBo);
        System.out.println("jsonObject=" + jsonObject);
        final PushPayload result = pushToAllPlatform(registrationID, jsonObject);
        System.out.println(result.toString());
    }

    /**
     * 推送消息至柜子端
     *
     * @param registrationID 客户端ID
     * @param message        消息
     * @return PushPayload
     */
    public static PushPayload pushToCabinet(String registrationID, String message) {
        // For pushToCabinet, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject_android_specified_user_message(registrationID, message);
        try {
            PushResult result = jPushClient.sendPush(payload);
            logger.info(TAG + "{}", "Got result - " + result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            logger.error(TAG + "{}", "Connection error, should retry later", e);
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            logger.error(TAG + "{}", "Should review the error, and fix the request", e);
            logger.info(TAG + "{}", "HTTP Status: " + e.getStatus());
            logger.info(TAG + "{}", "Error Code: " + e.getErrorCode());
            logger.info(TAG + "{}", "Error Message: " + e.getErrorMessage());
        }
        return payload;
    }

    /**
     * 推送至所有平台
     *
     * @param registrationID 客户端ID
     * @param message        消息
     * @return
     */
    public static PushPayload pushToAllPlatform(String registrationID, String message) {
        PushPayload payload = buildPushObject_all_alias_alert(registrationID, message);
        try {
            PushResult result = jPushClient.sendPush(payload);
            logger.info(TAG + "{}", "Got result - " + result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            logger.error(TAG + "{}", "Connection error, should retry later", e);
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            logger.error(TAG + "{}", "Should review the error, and fix the request", e);
            logger.info(TAG + "{}", "HTTP Status: " + e.getStatus());
            logger.info(TAG + "{}", "Error Code: " + e.getErrorCode());
            logger.info(TAG + "{}", "Error Message: " + e.getErrorMessage());
        }
        return payload;
    }

    /**
     * 构建推送对象：Android平台，目标为指定用户，消息为 message
     *
     * @param registrationID 用户注册ID
     * @param message        消息
     * @return
     */
    public static PushPayload buildPushObject_android_specified_user_message(String registrationID, String message) {
        return PushPayload.newBuilder().setPlatform(Platform.android())
                .setAudience(Audience.registrationId(registrationID))
                .setMessage(Message.content(message))
                .build();
    }

    /**
     * 构建推送对象：所有平台，推送目标是别名为 "alias1"，通知内容为 ALERT。
     *
     * @param registrationID 客户端ID
     * @param message        消息
     * @return
     */
    public static PushPayload buildPushObject_all_alias_alert(String registrationID, String message) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.registrationId(registrationID))
                .setNotification(Notification.alert(message))
                .build();
    }

    /**
     * 构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE。
     *
     * @return
     */
    public static PushPayload buildPushObject_android_tag_alertWithTitle(String title, String alert) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.android(alert, title, null))
                .build();
    }

    /**
     * 快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知。
     *
     * @return
     */
    public static PushPayload buildPushObject_all_all_alert(String alert) {
        return PushPayload.alertAll(alert);
    }

}
