package com.example.kevin.entities;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by kevin on 3/12/2015.
 */
public class C {
    private final String v;
    private final String f;
    private Map < String, Object > additionalProperties = new HashMap < String, Object > ();

    public C(String v, String f) {
        this.v = v;
        this.f = f;
    }


    /**
     *
     * @return
     * The v
     */
    public String getV() {
        return v;
    }


    /**
     *
     * @return
     * The f
     */
    public String getF() {
        return f;
    }


    public Map < String, Object > getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
