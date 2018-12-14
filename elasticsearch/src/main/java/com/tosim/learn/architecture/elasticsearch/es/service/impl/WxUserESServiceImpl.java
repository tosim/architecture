package com.tosim.learn.architecture.elasticsearch.es.service.impl;

import com.tosim.learn.architecture.elasticsearch.es.documnet.WxUserDoc;
import com.tosim.learn.architecture.elasticsearch.es.repo.WxUserESRepo;
import com.tosim.learn.architecture.elasticsearch.es.service.WxUserESService;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yaoyicheng
 * @data 2018/12/13 17:19
 */
@Service("wxUserESService")
public class WxUserESServiceImpl implements WxUserESService {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<WxUserDoc> findAll() {
        return null;
    }

    @Override
    public WxUserDoc findById(String id) {
        return null;
    }

    @Override
    public String save(WxUserDoc wxUserDoc) {
        return null;
    }
}
