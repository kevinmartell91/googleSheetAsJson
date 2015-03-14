package com.example.kevin.entities;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by kevin on 3/12/2015.
 */
public class GoogleSheet {

    private final String version;
    private final String reqId;
    private final String status;
    private final String sig;
    private final Table table;
    private Map < String, Object > additionalProperties = new HashMap < String, Object > ();

    public GoogleSheet(String version, String reqId, String status, String sig, Table table) {
        this.version = version;
        this.reqId = reqId;
        this.status = status;
        this.sig = sig;
        this.table = table;
    }

    /**
     *
     * @return
     * The version
     */
    public String getVersion() {
        return version;
    }


    /**
     *
     * @return
     * The reqId
     */
    public String getReqId() {
        return reqId;
    }


    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }


    /**
     *
     * @return
     * The sig
     */
    public String getSig() {
        return sig;
    }


    /**
     *
     * @return
     * The table
     */
    public Table getTable() {
        return table;
    }

    public Map < String, Object > getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
