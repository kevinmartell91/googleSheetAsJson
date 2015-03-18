package com.example.kevin.dao.googleSheetConnection.Impl;

import com.example.kevin.dao.PostulanteDao;
import com.example.kevin.dao.entity.Postulante;
import com.example.kevin.dao.googleSheetConnection.base.EntityDao;

/**
 * Created by kevin on 3/14/2015.
 */
public final class PostulanteGoogleSheetConnectionImpl implements PostulanteDao{


    private  static final PostulanteGoogleSheetConnectionImpl POSTULANTE_GOOGLE_SHEET_CONNECTION_IMPL;

    static {
        POSTULANTE_GOOGLE_SHEET_CONNECTION_IMPL = new PostulanteGoogleSheetConnectionImpl();
    }

    public void PostulanteGoogleSheetConnection(){

    }

    public static PostulanteGoogleSheetConnectionImpl obtenerInstancia(){
        return  POSTULANTE_GOOGLE_SHEET_CONNECTION_IMPL;
    }

    @Override
    public Postulante obtener(String s) throws Exception {
        return new Postulante();
    }

}
