package com.example.kevin.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class RESTClient {

    private static int TIMEOUT_MILLISEC = 30000;

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String connectAndReturnResponsePost(String url,
                                                      List<NameValuePair> nameValuePairs) {

        String result = "";

        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
        HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
        HttpClient httpclient = new DefaultHttpClient(httpParams);
        HttpPost httppost = new HttpPost(url);

        HttpResponse response;
        try {
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            response = httpclient.execute(httppost);

            // Log.i("Android_Store",response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();

            if (entity != null) {

                InputStream instream = entity.getContent();
                result = convertStreamToString(instream);
                // Log.i("Android_Store",result);

                instream.close();

            }

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;

    }

    public static String connectAndReturnResponsePut(String url,
                                                     List<NameValuePair> nameValuePairs) {

        String result = "";

        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
        HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
        HttpClient httpclient = new DefaultHttpClient(httpParams);
        HttpPut httpput = new HttpPut(url);

        HttpResponse response;
        try {
            httpput.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            response = httpclient.execute(httpput);

            // Log.i("Android_Store",response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();

            if (entity != null) {

                InputStream instream = entity.getContent();
                result = convertStreamToString(instream);
                // Log.i("Android_Store",result);

                instream.close();

            }

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;

    }

    public static String connectAndReturnResponseDelete(String url,
                                                        List<NameValuePair> nameValuePairs) {

        String result = "";

        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
        HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
        HttpClient httpclient = new DefaultHttpClient(httpParams);
        HttpDelete httpdelete = new HttpDelete(url);

        HttpResponse response;
        try {
            // httpdelete.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            response = httpclient.execute(httpdelete);

            // Log.i("Android_Store",response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();

            if (entity != null) {

                InputStream instream = entity.getContent();
                result = convertStreamToString(instream);
                // Log.i("Android_Store",result);

                instream.close();

            }

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;

    }

    public static String connectAndReturnResponseGet(String url) {

        String result = "";

        HttpClient httpclient = new DefaultHttpClient();

        HttpGet httpget = new HttpGet(url);

        HttpResponse response;
        try {
            response = httpclient.execute(httpget);

            // Log.i("Android_Store",response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();

            if (entity != null) {

                InputStream instream = entity.getContent();
                result = convertStreamToString(instream);
                // Log.i("Android_Store",result);

                instream.close();

            }

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }
}