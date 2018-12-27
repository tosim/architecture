package com.tosim.learn.architecture.elasticsearch.es.service;


import com.tosim.learn.architecture.elasticsearch.es.documnet.WxUserDoc;

import java.util.List;
import java.util.Map;

/**
 * @author yaoyicheng
 * @data 2018/12/13 17:19
 */
public interface WxUserESService {
    void doUpdateESUser(WxUserDoc wxUserDoc);

    List<String> getTagUserList(String appId, List<Long> tagIdList);

    Map<Long, Long> aggsByTag(String appId);
}
