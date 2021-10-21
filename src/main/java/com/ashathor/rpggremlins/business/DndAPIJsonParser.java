package com.ashathor.rpggremlins.business;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

public class DndAPIJsonParser {

    private static final Logger log = Logger.getLogger(DndAPIJsonParser.class.getName());

    public String run(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String resp = restTemplate.getForObject(url, String.class);

        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map<String,Object> map = springParser.parseMap(resp);


        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equals("results")){
                ArrayList<Object> list = (ArrayList<Object>) entry.getValue();
                for(Object o : list) {
                    if(o instanceof Map) {
                        Map<String,Object> map2 = (Map<String,Object>) o;
                        for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
                            log.info(entry2.getKey() + " = " + entry2.getValue());
                        }
                    }
                }
            }
        }
        return "yes";
    }
}
