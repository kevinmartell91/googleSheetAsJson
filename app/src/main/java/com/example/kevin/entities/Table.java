package com.example.kevin.entities;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kevin on 3/12/2015.
 */
public class Table {

    private final List < Col > cols ;
    private final List <Row> rows ;
    private Map < String, Object > additionalProperties = new HashMap < String, Object > ();

    public Table(List<Col> cols, List<Row> rows){
        this.cols= cols;
        this.rows = rows;
    }
    /**
     *
     * @return
     * The cols
     */
    public List < Col > getCols() {
        return cols;
    }

    /**
     *
     * @return
     * The roS
     */
    public List <Row> getRows() {
        return rows;
    }

    public Map < String, Object > getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
