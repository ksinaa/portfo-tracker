package com.portfotracker.api;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class RequestToApi {

    private String URI;
    private String apiKey;

    public RequestToApi(String URI, String apiKey) {
        this.URI = URI;
        this.apiKey = apiKey;
    }

    public RequestToApi(String URI) {
        this.URI = URI;
    }

    public String makeApiCall(List<NameValuePair> parameters)
            throws URISyntaxException, IOException {

        String response_content = "";
        URIBuilder query = new URIBuilder(this.URI);
        query.addParameters(parameters);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(query.build());

        request.setHeader(HttpHeaders.ACCEPT, "application/json");
        request.addHeader("X-CMC_PRO_API_KEY", this.apiKey);

        CloseableHttpResponse response = client.execute(request);



        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            response_content = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }

        return response_content;

    }
}