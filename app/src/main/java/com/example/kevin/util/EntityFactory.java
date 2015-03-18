package com.example.kevin.util;

import com.example.kevin.dao.entity.Persona;
import com.example.kevin.dao.googleSheetConnection.Impl.PersonaGoogleSheetConnectionImpl;
import com.example.kevin.dao.googleSheetConnection.Impl.PostulanteGoogleSheetConnectionImpl;
import com.example.kevin.dao.googleSheetConnection.base.EntityDao;

/**
 * Created by kevin on 3/14/2015.
 */
public final class EntityFactory  {

    public void EntityFactory(){
    }

    public static EntityDao getEntity(String clase){

        EntityDao  entityDao = null;

        if(clase.equalsIgnoreCase("PERSONA")){

            entityDao = PersonaGoogleSheetConnectionImpl.obtenerInstancia();

        }else if(clase.equalsIgnoreCase("POSTULANTE")){

            entityDao = PostulanteGoogleSheetConnectionImpl.obtenerInstancia();
        }
        return   entityDao;

    }



}
