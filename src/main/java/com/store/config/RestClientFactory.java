/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author theo
 */
@Named(value = "restClientFactory")
@ApplicationScoped
public class RestClientFactory {
    
    //1 seule instance client Jax-RS pour l'application webstore
    @Produces @ApplicationScoped
    public Client createRestClient(){    
        return ClientBuilder.newClient();    
    }  
    
    public void close (@Disposes Client client){
        if(client != null){
            client.close();
        }
    }
}
