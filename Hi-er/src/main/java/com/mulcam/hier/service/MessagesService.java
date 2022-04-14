package com.mulcam.hier.service;

import com.mulcam.hier.dto.Messages;
import com.mulcam.hier.dto.User;

public interface MessagesService {
    void send_message(Messages msg) throws Exception;

}
