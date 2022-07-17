package cc.yuanspace.springboot.es.basic.search;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

public class SearchAllDoc {

    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));

        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.fetchSource(false);
        searchSourceBuilder.fetchSource(true);

        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        request.source(searchSourceBuilder);

        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();

        System.out.println(hits.getTotalHits());
        System.out.println(hits.getHits().length);
        System.out.println(response.getTook());
        for (SearchHit hit : hits.getHits()) {
            System.out.println(hit.getSourceAsString());
        }

        esClient.close();
    }
}
