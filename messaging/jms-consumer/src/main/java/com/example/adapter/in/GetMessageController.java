package com.example.adapter.in;

import com.example.port.in.GetMessage;
import com.example.port.in.UserMessageCommand;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/message")
public class GetMessageController {

    @Inject
    GetMessage getMessage;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserMessageCommand> getLastMessage() {
        return getMessage.getMessages();
    }

}