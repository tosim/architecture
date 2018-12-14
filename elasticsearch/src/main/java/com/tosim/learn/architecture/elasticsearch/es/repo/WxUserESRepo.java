package com.tosim.learn.architecture.elasticsearch.es.repo;

import com.tosim.learn.architecture.elasticsearch.es.documnet.WxUserDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author yaoyicheng
 * @data 2018/12/13 17:16
 */
public interface WxUserESRepo extends ElasticsearchRepository<WxUserDoc, String> {
}
