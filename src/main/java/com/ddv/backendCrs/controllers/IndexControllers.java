package com.ddv.backendCrs.controllers;

import com.ddv.backendCrs.security.jwt.JwtUtility;
import com.ddv.backendCrs.security.jwt.model.JwtRequest;
import com.ddv.backendCrs.security.jwt.model.JwtResponse;
import com.ddv.backendCrs.security.securityServices.CrsUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexControllers {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CrsUserDetailsService crsUserDetailsService;

    @Autowired
    private JwtUtility jwtUtility;

    @RequestMapping(value = {"/","/index","home"})
    public String index(){
        return "index";
    }


    @PostMapping("/authenticate")
    public  @ResponseBody
    JwtResponse login(@RequestBody JwtRequest jwtRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()

                    )
            );
        }catch(BadCredentialsException e){
            throw  new Exception(" invalid credentials");
        }

        final UserDetails userDetails =
                crsUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtUtility.generateToken(userDetails);

        System.out.println(token);
        return new JwtResponse(token);
    }


    @RequestMapping("/altceva")
    public @ResponseBody String altceva(){
        return "altceva e protejat";
    }

}
