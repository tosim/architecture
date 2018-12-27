package com.tosim.learn.architecture.elasticsearch.es.documnet;

import java.util.List;
import java.util.Objects;

/**
 * @author yaoyicheng
 * @data 2018/12/13 11:02
 */
public class WxUserDoc {
    private String id;

    private String appId;

    private String openId;

    private Long interActionTime;

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

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.id, ((WxUserDoc)obj).id);
    }
}
