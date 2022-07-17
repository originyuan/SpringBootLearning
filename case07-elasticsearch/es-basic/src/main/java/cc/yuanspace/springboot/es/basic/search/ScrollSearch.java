package cc.yuanspace.springboot.es.basic.search;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 滚动查询
 */
public class ScrollSearch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));

        String scrollId = null;
        SearchResponse searchResponse = null;

        int count = 0;

        while (true) {
            if (scrollId == null) {
                // 1.构建SearchRequest检索请求
                // 专门用来进行全文检索、关键字检索的API
                SearchRequest request = new SearchRequest("user");

                // 2.创建一个SearchSourceBuilder专门用于构建查询条件
                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

                // 将查询条件设置到查询请求构建器中
                searchSourceBuilder.query(QueryBuilders.matchAllQuery());

                // 每页显示多少条
                searchSourceBuilder.size(10);

                // 4.调用SearchRequest.source将查询条件设置到检索请求
                request.source(searchSourceBuilder);

                //--------------------------
                // 设置scroll查询
                //--------------------------
                request.scroll(TimeValue.timeValueMinutes(5));

                // 5.执行RestHighLevelClient.search发起请求
                searchResponse = esClient.search(request, RequestOptions.DEFAULT);

            }
            // 第二次查询的时候，直接通过scroll id查询数据
            else {
                SearchScrollRequest searchScrollRequest = new SearchScrollRequest(scrollId);
                searchScrollRequest.scroll(TimeValue.timeValueMinutes(5));
                // 使用RestHighLevelClient发送scroll请求
                searchResponse = esClient.scroll(searchScrollRequest, RequestOptions.DEFAULT);
            }

            //--------------------------
            // 迭代ES响应的数据
            //--------------------------
            SearchHit[] hits = searchResponse.getHits().getHits();
            if (hits == null || hits.length <= 0) {
                break;
            }
            // 6.遍历结果
//            for (SearchHit doc : hits) {
//                // 1)获取命中的结果
//                String json = doc.getSourceAsString();
//
//                // 2)打印结果
//                System.out.println(json);
//            }

            scrollId = searchResponse.getScrollId();
            System.out.println("scrollId 值为：" + scrollId);
            System.out.println(++count);
        }

        esClient.close();
    }
}
