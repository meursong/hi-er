package com.mulcam.hier.controller;


import com.mulcam.hier.dto.Messages;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController {

    @Autowired
    MessagesService ms;
    @Autowired
    HttpSession session;

    @ResponseBody
    @PostMapping("/send")
    public String sendMessage(@RequestParam Map<String, Object> data) throws Exception {
        Messages msg = new Messages();
        String result = "메세지 전송 성공!!";
        if (session.getAttribute("loginedUser") == null) {
            result = "로그인 후 이용해 주세요.";
            return result;
        }
        Integer recv_user_id = null;
        if (data.get("recv_user_id").toString() == "") {
            recv_user_id = (Integer) session.getAttribute("send_user_id");
        } else {
            recv_user_id = Integer.valueOf(data.get("recv_user_id").toString());
        }

        Integer send_user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
        String title = data.get("title").toString();
        String content = data.get("content").toString();
        msg.setRecv_user_id(recv_user_id);
        msg.setSend_user_id(send_user_id);
        msg.setTitle(title);
        msg.setContent(content);
        ms.send_message(msg);
        session.removeAttribute("send_user_name");
        return result;

    }

    @GetMapping("/message")
    public String message(Model model, @ModelAttribute("params") Messages params) throws Exception {
        if (session.getAttribute("loginedUser") == null) {
            return "/login";
        }

        Integer logined_id = ((User) session.getAttribute("loginedUser")).getUser_id();
        params.setRecv_user_id(logined_id);
        params.setRecordsPerPage(5);
        params.setPageSize(3);
        List<Messages> msgList = ms.message_list(params);
        model.addAttribute("msgList", msgList);

        return "/messages";
    }

    @PostMapping("/message/{mid}")
    public String messageView(@PathVariable("mid") Integer mid, Model model) throws Exception {
        session.removeAttribute("send_user_name");
        List<Messages> message_view = ms.message_view(mid);
        Integer send_user_id = message_view.get(0).getSend_user_id();
        model.addAttribute("message_view", message_view);
        session.setAttribute("send_user_id", send_user_id);
        return "/messages :: #msg_list";

    }

    @ResponseBody
    @PostMapping("/message/delete/{msg_id}")
    public String messageDelete(@PathVariable("msg_id") Integer msg_id, @ModelAttribute("params") Messages params) throws Exception {
        String message = "메세지 삭제 성공!!";
        params.setMsg_id(msg_id);
        ms.delete_message(params);
        return message;

    }

    @PostMapping("/message/search")
    public String searchNickname(Model model, @ModelAttribute("params") Messages params, @RequestParam String nickname) throws Exception {
        if (session.getAttribute("loginedUser") == null) {
            return "/login";
        }

        Integer logined_id = ((User) session.getAttribute("loginedUser")).getUser_id();
        params.setRecv_user_id(logined_id);
        params.setNickname(nickname);
        params.setPageSize(3);
        params.setRecordsPerPage(5);
        List<Messages> msgList = ms.message_list(params);
        model.addAttribute("msgList", msgList);


        return "/messages :: #ms";
    }
}
