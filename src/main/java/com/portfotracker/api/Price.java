package com.portfotracker.api;

import com.portfotracker.api.config.config;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Price {

    static String getPrice(String symbol) throws URISyntaxException, IOException {
        List<NameValuePair> values = new ArrayList<>();

        values.add(new BasicNameValuePair("amount", "1"));
        values.add(new BasicNameValuePair("symbol", symbol));

        Hashtable headers = new Hashtable();

        headers.put("X-CMC_PRO_API_KEY", config.apikey);
        headers.put("Accepts", "application/json");

        JSONObject jsonObject = new JSONObject(new Api(config.URL).requestToApi(values, headers));

        return String.valueOf(jsonObject.getJSONObject("data").getJSONObject("quote").getJSONObject("USD")
                .getDouble("price"));
    }

}
