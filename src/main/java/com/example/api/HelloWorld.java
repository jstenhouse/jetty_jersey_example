package com.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by jason on 6/27/15.
 */
@Path("/api/v1")
public class HelloWorld {

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Message helloWorld() {
        return new Message("Hello, World!");
    }

    public static class Message {

        private final String message;

        public Message(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
