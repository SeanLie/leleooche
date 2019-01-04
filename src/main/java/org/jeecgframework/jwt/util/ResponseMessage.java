package org.jeecgframework.jwt.util;

import com.leletc.base.api.response.RspHead;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;

/**
 * restful 接口响应返回结构
 * @author scott
 * @param <T>
 */
public class ResponseMessage<T> {

    private String respCode;
    private String respMsg;
    private T data;
    private boolean ok;

    public ResponseMessage() {
    }

    public ResponseMessage(ResponseMessageCodeEnum codeEnum, String message) {
        this.respCode = codeEnum.getCode();
        this.respMsg = message;
    }
    
    public ResponseMessage(ResponseMessageCodeEnum codeEnum, String message, boolean ok, T data) {
        this.respCode = codeEnum.getCode();
        this.respMsg = message;
        this.ok = ok;
        this.data = data;
    }

    /**
     * 设置返回数据
     *
     * @param response 返回对象
     * @param rsp Service层返回对象
     * @param data 返回Data
     */
    public void setReturnData(ResponseMessage<T> response, RspHead rsp, T data) {
        if (rsp.getRspcode().equals(ResponseMessageCodeEnum.ERROR.getCode())) {
            response.setMessage(rsp.getError());
        } else {
            response.setMessage(rsp.getMsg());
        }
        response.setData(data);
        response.setRespCode(rsp.getRspcode());
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getMessage() {
        return respMsg;
    }

    public void setMessage(String message) {
        this.respMsg = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
		return ok;
	}
}
