package com.example.kevin.dao.googleSheetConnection.base;

/**
 * Created by kevin on 3/14/2015.
 */
public interface EntityDao<E, ID, String>{

    E obtener(String string) throws Exception;

    //TODO : CRUD

}
