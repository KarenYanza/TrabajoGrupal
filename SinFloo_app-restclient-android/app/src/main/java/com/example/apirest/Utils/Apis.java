package com.example.apirest.Utils;

public class Apis {

    public static final String URL_001="http://10.0.2.2:8080/persona/";

    public static PersonaService getPersonaService(){
        return  Cliente.getClient(URL_001).create(PersonaService.class);
    }
}
