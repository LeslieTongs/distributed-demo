package com.example.producer.message;

import com.alibaba.fastjson.JSONObject;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.Map;

/**
 * @Description TODO
 * @Author tangxing
 * @Date 2020/9/17 13:40
 **/
public class RokectMqMessage implements Message {

    private MessageData messageData;

    private Map<String, Object> heaer;

    public RokectMqMessage(){}

    public RokectMqMessage(MessageData messageData){
        this.messageData = messageData;
    }

    @Override
    public Object getPayload() {
        return messageData;
    }

    @Override
    public MessageHeaders getHeaders() {
        MessageHeaders messageHeaders = new MessageHeaders(heaer);
        return messageHeaders;
    }

    public MessageData getMessageData() {
        return messageData;
    }

    public void setMessageData(MessageData messageData) {
        this.messageData = messageData;
    }

    public Map<String, Object> getHeaer() {
        return heaer;
    }

    public void setHeaer(Map<String, Object> heaer) {
        this.heaer = heaer;
    }
}
