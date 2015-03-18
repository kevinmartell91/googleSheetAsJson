package com.example.kevin.dao.entity.jsonParse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Created by kevin on 3/12/2015.
 */

public class Row {

    private final List < C > c;
    private Map < String, Object > additionalProperties = new HashMap < String, Object > ();

    public Row(List<C> c){
        this.c = c;
    }

    /**
     *
     * @return
     * The c
     */
    public List < C > getC() {
        return c;
    }


    public Map < String, Object > getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}