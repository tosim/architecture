package com.tosim.learn.architecture.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yaoyicheng
 * @data 2018/12/18 19:38
 */
@Configuration
public class ESConfig {
    @Value("${elasticsearch.clusterNodes}")
    private String[] clusterNodes;

    @Bean
    public RestHighLevelClient rhlClient() {
        int nodeSize = clusterNodes.length;
        HttpHost[] hosts = new HttpHost[nodeSize];
        for (int i = 0;i < nodeSize; i++) {
            String[] ipAndPort = clusterNodes[i].split(":");
            String ip = ipAndPort[0];
            int port = Integer.parseInt(ipAndPort[1]);
            hosts[i] = new HttpHost(ip, port, HttpHost.DEFAULT_SCHEME_NAME);
        }

        RestClientBuilder restClientBuilder = RestClient.builder(hosts);
        return new RestHighLevelClient(restClientBuilder.build());
    }
}
