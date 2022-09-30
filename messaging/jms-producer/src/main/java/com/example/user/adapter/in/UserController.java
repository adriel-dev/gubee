package com.example.user.adapter.in;

import com.example.user.domain.User;
import com.example.user.port.in.RegisterUser;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserController {

    @Inject
    RegisterUser registerUser;

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveUser(User user) {
        registerUser.registerUser(user);
    }

}