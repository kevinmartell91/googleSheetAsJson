package com.example.kevin.entities;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by kevin on 3/12/2015.
 */
public class Col {

    private final String id;
    private final String label;
    private final String type;
    private final String pattern;
    private Map < String, Object > additionalProperties = new HashMap < String, Object > ();

    public Col(String id, String label, String type, String pattern) {
        this.id = id;
        this.label = label;
        this.type = type;
        this.pattern = pattern;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }


    /**
     *
     * @return
     * The label
     */
    public String getLabel() {
        return label;
    }


    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }


    /**
     *
     * @return
     * The pattern
     */
    public String getPattern() {
        return pattern;
    }


    public Map < String, Object > getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}