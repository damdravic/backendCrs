package com.ddv.backendCrs.security.jwt.model;

public class JwtResponse {

    private String jwtToken;

    public JwtResponse(){

    }

    public JwtResponse(String jwtToken){
        this.jwtToken = jwtToken;

    }

    public String getJwtToken(){
        return jwtToken;
    }

    public void setJwtToken(){
        this.jwtToken = jwtToken;
    }


}
