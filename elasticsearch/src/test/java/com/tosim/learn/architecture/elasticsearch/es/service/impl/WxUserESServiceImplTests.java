package com.tosim.learn.architecture.elasticsearch.es.service.impl;

import com.alibaba.fastjson.JSON;
import com.tosim.learn.architecture.elasticsearch.ElasticsearchApplication;
import com.tosim.learn.architecture.elasticsearch.es.documnet.WxUserDoc;
import org.apache.commons.collections4.CollectionUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @author yaoyicheng
 * @data 2018/12/13 17:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticsearchApplication.class)
public class WxUserESServiceImplTests {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void nop() {

    }

    @Test
    public void saveBulk() {
        String[] appIds = {"wx123", "wx456", "wx789", "wx147", "wx258"};
        Long[] tagEnum = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L};
        List<IndexQuery> indexQueryList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 24; j++) {
                String appId = appIds[i];
                String openId = UUID.randomUUID().toString();
                List<Long> tagList = Arrays.asList(tagEnum[j % 12]);

                IndexQuery indexQuery = new IndexQuery();
                indexQuery.setIndexName("data");
                indexQuery.setType("wx_user");
                indexQuery.setId(String.format("%s_%s", appId, openId));
                long interActionTime = j >= 12 ? System.currentTimeMillis() - 50L * 60L * 60L * 1000L : System.currentTimeMillis();
                indexQuery.setObject(new WxUserDoc(indexQuery.getId(), appId, openId, interActionTime, tagList));

                indexQueryList.add(indexQuery);
            }
        }
        elasticsearchTemplate.bulkIndex(indexQueryList);
    }

    @Test
    public void aggsByTag() {
        Long time48Ago = System.currentTimeMillis() - 48L * 60L * 60L * 1000L;

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.boolQuery()
                        .must(QueryBuilders.matchPhraseQuery("appId", "wx456"))
//                        .must(QueryBuilders.rangeQuery("interActionTime").gt(time48Ago))
                )
                .addAggregation(
                        AggregationBuilders
                                .terms("by_tag").field("tag").size(Integer.MAX_VALUE)
                )
                .build();
        System.out.println(searchQuery.toString());

        Map<String, Long> result = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<Map<String, Long>>() {
            @Override
            public Map<String, Long> extract(SearchResponse searchResponse) {
                Map<String, Long> result = new HashMap<>();
                if (searchResponse != null && searchResponse.getAggregations() != null) {
                    LongTerms tagGroup = searchResponse.getAggregations().get("by_tag");
                    List<LongTerms.Bucket> buckets = tagGroup.getBuckets();
                    if (CollectionUtils.isNotEmpty(buckets)) {
                        for (LongTerms.Bucket bucket : buckets) {
                            result.put(bucket.getKeyAsString(), bucket.getDocCount());
                        }
                    }
                }
                return result;
            }
        });
        System.out.println(result);
    }
}
