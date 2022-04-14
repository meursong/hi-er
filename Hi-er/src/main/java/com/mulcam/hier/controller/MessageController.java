package com.mulcam.hier.controller;


import com.mulcam.hier.dto.Messages;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class MessageController {

    @Autowired
    MessagesService ms;
    @Autowired
    HttpSession session;

    @PostMapping("/send")
    @ResponseBody
    public String sendMessage(@RequestParam Map<String, Object> data) throws Exception {
        Messages msg = new Messages();
        String result = "메세지 전송 성공!!";
        if(((User) session.getAttribute("loginedUser"))==null) {
            result="로그인 후 이용해 주세요.";
            return result;
        }

        Integer recv_user_id = Integer.valueOf(data.get("recv_user_id").toString());
        Integer send_user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
        String title = data.get("title").toString();
        String content = data.get("content").toString();
        msg.setRecv_user_id(recv_user_id);
        msg.setSend_user_id(send_user_id);
        msg.setTitle(title);
        msg.setContent(content);
        ms.send_message(msg);

        return result;

    }

}
