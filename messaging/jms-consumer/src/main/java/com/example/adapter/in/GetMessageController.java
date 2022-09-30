package com.example.adapter.in;

import com.example.port.in.GetMessage;
import com.example.port.in.UserMessageCommand;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
public class GetMessageController {

    @Inject
    GetMessage getMessage;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserMessageCommand> getAllMessages() {
        return getMessage.getAllMessages();
    }

    @GET
    @Path("/last")
    @Produces(MediaType.APPLICATION_JSON)
    public UserMessageCommand getLastMessage() {
        return getMessage.getLastMessage();
    }

}