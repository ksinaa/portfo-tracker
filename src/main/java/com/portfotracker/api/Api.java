package com.portfotracker.api;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.List;

public class Api {

    private String URI;
    private String apiKey;


    //Two constructor, first receive URL and apikey the second one receive only URL in case the API doesn't have an apikey
    public Api(String URI, String apiKey) {
        this.URI = URI;
        this.apiKey = apiKey;
    }

    public Api(String URI) {
        this.URI = URI;
    }

    /*
    * @param parameters: receive URL parameters
    * @param headers: receive HTTP headers
    * returns JSON response but in STRING format
    * */

    public String requestToApi(List<NameValuePair> parameters, Hashtable<String, String> headers)
            throws URISyntaxException, IOException {

        String response_content = "";
        URIBuilder query = new URIBuilder(this.URI);
        query.addParameters(parameters);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(query.build());

        headers.forEach((name, value) -> request.setHeader(name, value));

        CloseableHttpResponse response = client.execute(request);



        try {
            HttpEntity entity = response.getEntity();
            response_content = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }

        return response_content;

    }
}
