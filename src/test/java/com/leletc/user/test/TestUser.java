package com.leletc.user.test;

import com.alibaba.fastjson.JSON;

/**
 * 功能描述：
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/14 21:45
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public class TestUser {

    public static void main(String[] args) {
        String[] tagIdArray = new String[]{
                "123", "456"
        };
        String tagIdStr = JSON.toJSON(tagIdArray).toString();
        System.out.println(tagIdStr);
    }

}
