package com.example.kevin.services;

import org.apache.http.NameValuePair;
import java.util.List;

public class ServiceCaller {

    private String url;
    private List<NameValuePair> parametersList;
    private String doAction;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<NameValuePair> getParametersList() {
        return parametersList;
    }

    public void setParametersList(List<NameValuePair> parametersList) {
        this.parametersList = parametersList;
    }

    public String getDoAction() {
        return doAction;
    }

    public void setDoAction(String doAction) {
        this.doAction = doAction;
    }
}
