package com.mulcam.hier.service;

import com.mulcam.hier.dto.Messages;
import com.mulcam.hier.dto.User;

import java.util.List;

public interface MessagesService {
    void send_message(Messages msg) throws Exception;
    void delete_message(Messages msg) throws Exception;
    List<Messages> message_list(Messages msg) throws Exception;
    List<Messages> message_view(Integer msg) throws Exception;

}
