package com.portfotracker.api;

import com.portfotracker.api.Api;

import com.portfotracker.api.config.config;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.junit.Assert;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ApiTest {

    static String symbol = "BTC";


    @Test
    public void testUrlReturnsPrice() throws URISyntaxException, IOException {


        List<NameValuePair> values = new ArrayList<>();

        values.add(new BasicNameValuePair("amount", "1"));
        values.add(new BasicNameValuePair("symbol", symbol));

        Hashtable headers = new Hashtable();


        headers.put("X-CMC_PRO_API_KEY", config.apikey);
        headers.put("Accepts", "application/json");

        Api req = new Api(config.URL);

        System.out.println(new Api(config.URL).requestToApi(values, headers));
        JSONObject jsonObject = new JSONObject(new Api(config.URL).requestToApi(values, headers));
        System.out.println(jsonObject.getJSONObject("data").getJSONObject("quote").getJSONObject("USD")
                .getDouble("price"));
    }
}
