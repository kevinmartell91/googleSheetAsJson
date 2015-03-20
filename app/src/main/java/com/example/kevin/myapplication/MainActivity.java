package com.example.kevin.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.kevin.dao.entity.jsonParse.C;
import com.example.kevin.dao.entity.jsonParse.GoogleSheet;
import com.example.kevin.dao.entity.jsonParse.Row;
import com.google.gson.Gson;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.example.kevin.services.*;
import com.example.kevin.email.*;
import com.example.kevin.dao.entity.*;

/*
Add imports
 */


public class MainActivity extends ActionBarActivity {

    TextView tv ;
    Integer ENTORNO_DESARROLLO;
    String fullURL;
    List<Object> lsObjects ;
    private ServicePostulante servicePostulante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.textView);
         /*
             0 -> TEST
             1 -> PRODUCCION
         */
        ENTORNO_DESARROLLO = 1 ;
        servicePostulante = new ServicePostulante();
    }

    public void buttonOnClick(View v){

        Button button = (Button) v;
        ((Button) v).setText("Clicked");

        Log.i("[  INFO : ] -- ","buttonOnClick");

        if(ENTORNO_DESARROLLO == 0){ //Test

            fullURL = "https://docs.google.com/spreadsheets/d/1ShCAenr0xi0IhVPuA4elw7kbQfnNm9CiHYEUhMauF20/gviz/tq";

        }else if(ENTORNO_DESARROLLO == 1){ //Produccion

            fullURL = "https://docs.google.com/spreadsheets/d/1kApxbLKpxogz0T9PRCvyzhNZqA8j-o6UFhOZKjMyQwo/gviz/tq";

        }

        Log.i("[  INFO : ] -- ",fullURL);

        getDataAsync();

        Thread t =new Thread(new Runnable() {
            @Override
            public void run() {
                //postData();
            }
        });
        //t.start();
    }

    public void postData(){

        try {
            Log.i("[  INFO : ] -- ","postData() - comenzo");
            String fullURL = "https://docs.google.com/forms/d/19E9PPww0pmwc11VLhdZdKFRQERr4R3clFvqKfiEmDFc/formResponse";

            HttpRequest request = new HttpRequest();

            String col_0_question = "entry_313220806=";
            String col_1_DNI = "entry_1958996361=";
            String col_2_correo = "entry_532301133=";
            String col_3_codigo = "entry_1708027560=";

            String col_0_val = "Si"; //este valor no inserta en el sheet , no se el por que todavia
            String col_1_val = "422";
            String col_2_val = "kevinmartell91@gmal.com";
            String col_3_val = "1234";

            String data = col_0_question + URLEncoder.encode(col_0_val) + "&" +
                    col_1_DNI + URLEncoder.encode(col_1_val) + "&" +
                    col_2_correo + URLEncoder.encode(col_2_val) + "&" +
                    col_3_codigo + URLEncoder.encode(col_3_val);
            String response = request.sendPost(fullURL, data);

            Log.i("[  INFO : ] -- ","Data posteada" + response);

        }catch (Exception ex){
            throw ex;
        }


    }

    public void getDataAsync(){

        try {
            ServiceCaller caller = new ServiceCaller();
            caller.setUrl(fullURL);

            Log.i("[  INFO : ] -- ","_Inicio llamada async - getDateAsync()");
            new CallServiceGoogleSheet(caller).execute();

        }catch (Exception ex){
            throw ex;
        }
    }

    public void getDataFromJson_Test(String json) {

        try {

            lsObjects = new ArrayList<Object>();

            //String jsonStatic = "{\"version\":\"0.6\",\"reqId\":\"0\",\"status\":\"ok\",\"sig\":\"2030944398\",\"table\":{\"cols\":[{\"id\":\"A\",\"label\":\"Timestamp\",\"type\":\"datetime\",\"pattern\":\"M/d/yyyy H:mm:ss\"},{\"id\":\"B\",\"label\":\"DNI\",\"type\":\"number\",\"pattern\":\"General\"},{\"id\":\"C\",\"label\":\"Correo\",\"type\":\"string\"},{\"id\":\"D\",\"label\":\"Codigo\",\"type\":\"number\",\"pattern\":\"General\"},{\"id\":\"E\",\"label\":\"Question\",\"type\":\"string\"},{\"id\":\"F\",\"label\":\"Codes\",\"type\":\"number\",\"pattern\":\"General\"}],\"rows\":[{\"c\":[{\"v\":\"new Date(2015,2,12,13,15,6)\",\"f\":\"3/12/2015 13:15:07\"},{\"v\":4.3214321E7,\"f\":\"43214321\"},{\"v\":\"kevinmartell91@gmail.com\"},{\"v\":123.0,\"f\":\"123\"},{\"v\":\"Si\"},{\"v\":1.0,\"f\":\"1\"}]},{\"c\":[{\"v\":\"new Date(2015,2,12,13,16,30)\",\"f\":\"3/12/2015 13:16:30\"},{\"v\":7.8094321E7,\"f\":\"78094321\"},{\"v\":\"kevinmartell91@outlook.com\"},{\"v\":101.0,\"f\":\"101\"},{\"v\":\"No\"},{\"v\":2.0,\"f\":\"2\"}]}]}}";

            Gson gson = new Gson();
            //Parseamos en la clases creadas
            final GoogleSheet googleSheet = gson.fromJson(json,GoogleSheet.class);

            StringBuilder sb = new StringBuilder();
            // obtiene le lista de personas
            List<Row> rows = googleSheet.getTable().getRows();

            for(int i = 0; i< rows.size() ; i++){
                // obtiene la lista de campos de una persona
                List<C> c_list = (List<C>)rows.get(i).getC();

                // Creamos un bean persona para almacenarlo
                Persona persona = new Persona();

                for(int j = 0 ; j < c_list.size(); j++){

                    //obtenemos un campo de la persona para cada if y seteamos sus valores
                    C c = c_list.get(j);

                    try {
                        // En test
                        if (j == 0) {
                            persona.setFecha(c.getF());
                        }
                        if (j == 1) {
                            persona.setDni(c.getF());
                        }
                        if (j == 2) {
                            persona.setCorreo(c.getV());
                        }
                        if (j == 4) {
                            persona.setPregunta1(c.getV());
                        }
                        if (j == 5) {
                            persona.setCodTemporal(c.getV());
                        }
                    }catch(Exception ex){
                        Log.i("Parse to class ex :",ex.toString());
                    }
                }
                lsObjects.add(persona);
            }

            tv.setText(lsObjects.toString());

        }catch (Exception ex){
               throw ex;
        }
    }

    public  void getDataFromJson_Produccion(String json) {

        try {

            lsObjects = new ArrayList<Object>();

            //String jsonStatic = "{\"version\":\"0.6\",\"reqId\":\"0\",\"status\":\"ok\",\"sig\":\"2030944398\",\"table\":{\"cols\":[{\"id\":\"A\",\"label\":\"Timestamp\",\"type\":\"datetime\",\"pattern\":\"M/d/yyyy H:mm:ss\"},{\"id\":\"B\",\"label\":\"DNI\",\"type\":\"number\",\"pattern\":\"General\"},{\"id\":\"C\",\"label\":\"Correo\",\"type\":\"string\"},{\"id\":\"D\",\"label\":\"Codigo\",\"type\":\"number\",\"pattern\":\"General\"},{\"id\":\"E\",\"label\":\"Question\",\"type\":\"string\"},{\"id\":\"F\",\"label\":\"Codes\",\"type\":\"number\",\"pattern\":\"General\"}],\"rows\":[{\"c\":[{\"v\":\"new Date(2015,2,12,13,15,6)\",\"f\":\"3/12/2015 13:15:07\"},{\"v\":4.3214321E7,\"f\":\"43214321\"},{\"v\":\"kevinmartell91@gmail.com\"},{\"v\":123.0,\"f\":\"123\"},{\"v\":\"Si\"},{\"v\":1.0,\"f\":\"1\"}]},{\"c\":[{\"v\":\"new Date(2015,2,12,13,16,30)\",\"f\":\"3/12/2015 13:16:30\"},{\"v\":7.8094321E7,\"f\":\"78094321\"},{\"v\":\"kevinmartell91@outlook.com\"},{\"v\":101.0,\"f\":\"101\"},{\"v\":\"No\"},{\"v\":2.0,\"f\":\"2\"}]}]}}";

            Gson gson = new Gson();
            //Parseamos en la clases creadas
            final GoogleSheet googleSheet = gson.fromJson(json,GoogleSheet.class);

            StringBuilder sb = new StringBuilder();
            // obtiene le lista de postulantes
            List<Row> rows = googleSheet.getTable().getRows();

            for(int i = 0; i< rows.size() ; i++){
                // obtiene la lista de campos de una persona
                List<C> c_list = (List<C>)rows.get(i).getC();

                // Creamos un bean persona para almacenarlo
                Postulante postulante = new Postulante();

                for(int j = 0 ; j < c_list.size(); j++){

                    //obtenemos un campo de la persona para cada if y seteamos sus valores
                    C c = c_list.get(j);

                    // En produccion
		   			try{
                    // TODO : falta editar y agregar mas campos manualmente en google sheet 
	                    if( j == 0) { postulante.setFecha_registro( c.getF() );} // revisar si al se el insert es mas rapido con el "v": new Date(2015, 2, 14, 0, 54, 56)
	                    if( j == 1) { postulante.setNombre(   ( c.getV()));}
	                    if( j == 2) { postulante.setApellido(    c.getV()   );}
	                    if( j == 3) { postulante.setDNI(    c.getF()   );}
	                    if( j == 4) { postulante.setE_mail(    c.getV()   );}
	                    if( j == 5) { postulante.setAlternativa_Elegida(  ( c.getV())   );}
	                    if( j == 6) { postulante.setFecha_Nacimiento(  ( c.getF())   );}
	                    if( j == 7) { postulante.setMayor_Edad(  ( c.getV())   );}

					}catch(Exception ex){
                        Log.i("Parse to class ex :",ex.toString());
                    }
                }
                lsObjects.add(postulante);
            }

            tv.setText(lsObjects.toString());

        }catch (Exception ex){
            throw ex;
        }
    }

    public void correoNotificar(final List<Object> lsObjects){

         try {

             //final List<Persona> personas = castCollection(lsObjects,Persona.class);
             //List<Postulante> pustulantes = castCollection(lsObjects,Postulante.class);


            final GMailSender sender = new GMailSender("TU_CORRO@gmail.com", "TU_PASSWORD");

            new Thread(new Runnable() {
                public void run() {
                    try {
                        if(ENTORNO_DESARROLLO == 0 ) {
                            for (int i = 0; i < lsObjects.size(); i++) {
                                sender.sendMail("Voluntades - Test envio de correos en automatico => ENTORNO_DESARROLLO : TEST" ,
                                        "Mensaje enviado en grupo , datos ingresados desde google form ",
                                        "TU_MAIL@gmail.com",
                                        ((Persona) (lsObjects.get(i))).getCorreo());
                                        //personas.get(i).getCorreo());
                                Log.i("[  INFO : ] -- ", "Envio de correo a : " + ((Persona) (lsObjects.get(i))).getCorreo());
                                /*update DB*/
                                servicePostulante.updatePostulante("","","","","","","","","","","","","","","");
                            }
                        }else if(ENTORNO_DESARROLLO == 1){
                            for (int i = 0; i < lsObjects.size(); i++) {
                                sender.sendMail("Voluntades - Test envio de correos en automatico => ENTORNO_DESARROLLO : PRODUCCION",
                                        "Mensaje enviado en grupo , datos ingresados desde google form ",
                                        "TU_MIAL@gmail.com",
                                        ((Postulante)(lsObjects.get(i))).getE_mail());
                                Log.i("[  INFO : ] -- ","Envio de correo a : " + ((Postulante)(lsObjects.get(i))).getE_mail());
                            }
                        }
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "No se eviaron los correos, intente nuevamente",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }).start();
        }catch (Exception ex){
            throw  ex;
        }
    }

    public <T>List<T> castCollection(List srcList, Class<T> clas){
        List<T> list =new ArrayList<T>();
        for (Object obj : srcList) {
            if(obj!=null && clas.isAssignableFrom(obj.getClass()))
                list.add(clas.cast(obj));
        }
        return list;
    }

    public class CallServiceGoogleSheet extends AsyncTask<String, Void, String> {

        ServiceCaller caller;
        ProgressDialog dialog;

        public CallServiceGoogleSheet(ServiceCaller caller) {
            super();
            this.caller = caller;
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            dialog =
                    ProgressDialog.show(MainActivity.this,"Cargando datos desde Google sheet",
                            "El proceso podria tardar un mometo, por favor espere...");
        }

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            String response = "";
            response = RESTClient.connectAndReturnResponseGet(caller.getUrl());
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            try {
                if(result != null) {

                    Log.i("[  INFO : ] -- ","_Retrieve Data" + (String) result);

                    String jsonEdited =  editBabJsonRevievedfromGoogleSheet((String) result);
                    Log.i("[  INFO : ] -- ","_Retrieve Data Edited : " +jsonEdited);

                    tv.setText(jsonEdited);

                    if(ENTORNO_DESARROLLO == 0){
                        getDataFromJson_Test(jsonEdited);

                    }
                    else if(ENTORNO_DESARROLLO == 1){
                        getDataFromJson_Produccion(jsonEdited);
                    }

                    correoNotificar(lsObjects);

                    Toast.makeText(
                            getApplicationContext(),
                            //properties.getProperty("table"),
                            "Se cargo la data de google sheet forms y se enviaron los correos",
                            Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Toast.makeText(
                        getApplicationContext(),
                        "No se pudo conectar con el servidor",
                        Toast.LENGTH_SHORT).show();
            }

            super.onPostExecute(result);
        }

        private String editBabJsonRevievedfromGoogleSheet(String pResult) {

            // le quitamos para que sea un json valido para parsear       http://www.jsonschema2pojo.org/
            /* lo que se quita es lo siguiente
            google.visualization.Query.setResponse(      { json Valido .... }        );
             */
            pResult = pResult.replaceAll("google.visualization.Query.setResponse\\(","");
            pResult = pResult.replaceAll("new","\"new");
            pResult = pResult.replaceAll("\\),\"f\"","\\)\",\"f\"");
            pResult = pResult.replaceAll("\\);","");
            return pResult;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
