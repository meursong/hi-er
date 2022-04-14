package com.mulcam.hier.service;

import com.mulcam.hier.dao.MessagesDAO;
import com.mulcam.hier.dto.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    MessagesDAO md;

    @Override
    public void send_message(Messages msg) throws Exception {
        md.send_message(msg);

    }
}
