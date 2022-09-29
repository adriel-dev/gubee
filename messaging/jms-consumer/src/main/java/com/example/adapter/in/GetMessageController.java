package com.example.adapter.in;

import com.example.jms.Gateway;
import com.example.port.in.GetMessage;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/message")
public class GetMessageController {

    @Inject
    GetMessage getMessage;

    @GET
    @Path("/last")
    @Produces(MediaType.TEXT_PLAIN)
    public String getLastMessage() {
        return getMessage.getLastMessage();
    }

}