package com.example.kevin.dao.googleSheetConnection.Impl;

import com.example.kevin.dao.PersonaDao;
import  com.example.kevin.dao.entity.Persona;
import com.example.kevin.dao.googleSheetConnection.base.EntityDao;

/**
 * Created by kevin on 3/14/2015.
 */
public final class  PersonaGoogleSheetConnectionImpl implements PersonaDao{

    private static final PersonaGoogleSheetConnectionImpl PERSONA_GOOGLE_SHEET_CONNECTION_IMPL;

    static {
        PERSONA_GOOGLE_SHEET_CONNECTION_IMPL = new PersonaGoogleSheetConnectionImpl();
    }

    public void PostulanteGoogleSheetConnection(){

    }

    public static PersonaGoogleSheetConnectionImpl obtenerInstancia(){
        return  PERSONA_GOOGLE_SHEET_CONNECTION_IMPL;
    }

    @Override
    public Persona obtener(String s) throws Exception {
        return new Persona();
    }

}
