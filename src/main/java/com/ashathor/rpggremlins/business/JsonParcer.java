package com.ashathor.rpggremlins.business;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;

public class JsonParcer {

    public String run(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);

        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map<String,Object> map = springParser.parseMap(resp);


        System.out.println("Items found: " + map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey() == "results"){
                ArrayList<Object> list = (ArrayList<Object>) entry.getValue();
                for(Object o : list) {
                    if(o instanceof Map) {
                        Map<String,Object> map2 = (Map<String,Object>) o;
                        System.out.println("Items found: " + map2.size());

                        int i = 0;
                        for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
                            System.out.println(entry2.getKey() + " = " + entry2.getValue());
                            i++;
                        }

                    }
                }
            }

        }
        return "yes";

    }
}
