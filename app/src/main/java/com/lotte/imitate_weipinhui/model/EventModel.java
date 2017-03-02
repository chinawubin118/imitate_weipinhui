package com.lotte.imitate_weipinhui.model;

/**
 * Created by wubin on 2017/3/2.
 */

public class EventModel {

    public static final int CODE_LOGIN = 1;//登录的事件码
    public static final int CODE_LOGOUT = 2;//登出的事件码

    /**
     * 事件码
     */
    private int eventCode;

    /**
     * 事件信息
     */
    private String msg;

    public EventModel(int eventCode) {
        this.eventCode = eventCode;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
