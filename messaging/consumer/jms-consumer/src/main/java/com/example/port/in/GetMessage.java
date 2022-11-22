package com.example.port.in;

import java.util.List;

public interface GetMessage {

    List<UserMessageDTO> getAllMessages();
    UserMessageDTO getLastMessage();

}
