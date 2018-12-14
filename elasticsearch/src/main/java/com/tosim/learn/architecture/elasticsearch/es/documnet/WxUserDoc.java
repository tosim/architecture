package com.tosim.learn.architecture.elasticsearch.es.documnet;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * @author yaoyicheng
 * @data 2018/12/13 11:02
 */
@Document(indexName="data",type="wx_user")
public class WxUserDoc {
    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String appId;

    @Field(type = FieldType.Keyword)
    private String openId;

    @Field(type =FieldType.Long)
    private Long interActionTime;

    @Field(type = FieldType.Long)
    private List<Long> tag;

    public WxUserDoc() {}

    public WxUserDoc(String id, String appId, String openId, Long interActionTime, List<Long> tag) {
        this.id = id;
        this.appId = appId;
        this.openId = openId;
        this.interActionTime = interActionTime;
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getInterActionTime() {
        return interActionTime;
    }

    public void setInterActionTime(Long interActionTime) {
        this.interActionTime = interActionTime;
    }

    public List<Long> getTag() {
        return tag;
    }

    public void setTag(List<Long> tag) {
        this.tag = tag;
    }
}
