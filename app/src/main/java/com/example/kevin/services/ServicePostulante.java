package com.example.kevin.services;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jonathan on 20/03/2015.
 */
public class ServicePostulante {
    private Context context;
    private static final String WS_UPDATE = "http://voluntades.org/test/webservices/client/updatePostulantes.php";

    public void updatePostulante(String fecha_registro,String nombres,String apellidos,String dni,String fecha_nacimiento,String correo,String fecha_programada,String codigo_temporal,String asistio,String resultado_test_1,String resultado_test_2,String resultado_respuesta_1,String resultado_respuesta_2,String url_foto_1,String url_foto_2){
        RequestParams params = new RequestParams();
        params.put("fecha_registro", fecha_registro);
        params.put("nombres", nombres);
        params.put("apellidos", apellidos);
        params.put("dni", dni);
        params.put("fecha_nacimiento", fecha_nacimiento);
        params.put("correo", correo);
        params.put("fecha_programada", fecha_programada);
        params.put("codigo_temporal", codigo_temporal);
        params.put("asistio", asistio);
        params.put("resultado_test_1", resultado_test_1);
        params.put("resultado_test_2", resultado_test_2);
        params.put("resultado_respuesta_1", resultado_respuesta_1);
        params.put("resultado_respuesta_2", resultado_respuesta_2);
        params.put("url_foto_1", url_foto_1);
        params.put("url_foto_2", url_foto_2);
        Log.e("params postulantes", params.toString());
        AsyncHttpClient client = new AsyncHttpClient();

        client.post(context, WS_UPDATE, params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    if(response.getInt("success")==1){
                        Log.e("WS_UPDATE", "success");
                    }else{
                        Log.e("WS_UPDATE", "fallo");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Log.e("WS_UPDATE", responseString);
            }
        });
    }
}
