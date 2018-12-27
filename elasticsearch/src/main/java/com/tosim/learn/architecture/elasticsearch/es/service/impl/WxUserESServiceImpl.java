package com.tosim.learn.architecture.elasticsearch.es.service.impl;

import com.tosim.learn.architecture.elasticsearch.es.documnet.WxUserDoc;
import com.tosim.learn.architecture.elasticsearch.es.service.WxUserESService;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequestBuilder;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequestBuilder;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author yaoyicheng
 * @data 2018/12/13 17:19
 */
@Service("wxUserESService")
public class WxUserESServiceImpl implements WxUserESService {
    @Autowired
    private RestHighLevelClient rhlClient;

    @PostConstruct
    public void checkIndex() {
    }

    @Override
    public void doUpdateESUser(WxUserDoc wxUserDoc) {

    }

    @Override
    public List<String> getTagUserList(String appId, List<Long> tagIdList) {
        return null;
    }

    @Override
    public Map<Long, Long> aggsByTag(String appId) {
        return null;
    }
}
