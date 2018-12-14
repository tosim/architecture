package com.tosim.learn.architecture.elasticsearch.es.service;

import com.tosim.learn.architecture.elasticsearch.es.documnet.WxUserDoc;

import java.util.List;

/**
 * @author yaoyicheng
 * @data 2018/12/13 17:19
 */
public interface WxUserESService {
    List<WxUserDoc> findAll();

    WxUserDoc findById(String id);

    String save(WxUserDoc wxUserDoc);
}
