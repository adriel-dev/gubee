package com.example.adapter.in;

import com.example.port.in.GetMessage;
import com.example.port.in.UserMessageDTO;

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
    public List<UserMessageDTO> getAllMessages() {
        return getMessage.getAllMessages();
    }

    @GET
    @Path("/last")
    @Produces(MediaType.APPLICATION_JSON)
    public UserMessageDTO getLastMessage() {
        return getMessage.getLastMessage();
    }

}
