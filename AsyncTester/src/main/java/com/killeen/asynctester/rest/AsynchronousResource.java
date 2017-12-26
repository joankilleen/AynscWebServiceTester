/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.killeen.asynctester.rest;

import javax.ejb.Asynchronous;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Path("/async")

public class AsynchronousResource {

   @GET

   @Asynchronous

    public void asyncRestMethod(@Suspended final AsyncResponse asyncResponse) {

                String result = heavyLifting();
                asyncResponse.resume(result);

            }

     private String heavyLifting() {
                for (int i=1000000000; i>0; i--){
                	;
                }
                return "RESULT";

      }

}


