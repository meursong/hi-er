package com.mulcam.hier.dto;

import com.mulcam.hier.others.Criteria;
import com.mulcam.hier.others.Time;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

public class Messages extends Criteria {
    private Integer msg_id;
    private Integer send_user_id;
    private Integer recv_user_id;
    private String recv_nickname;
    private String send_nickname;
    private String title;
    private String content;
    private String send_time;
    private Integer read_chk;
    private String nickname;


    public Messages(int send_user_id, int recv_user_id, String title, String content) {
        this.send_user_id = send_user_id;
        this.recv_user_id = recv_user_id;
        this.title = title;
        this.content = content;

    }

    public Messages() {

    }
    public Messages(int recv_user_id) {
        this.recv_user_id=recv_user_id;

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(Integer msg_id) {
        this.msg_id = msg_id;
    }

    public void setSend_user_id(Integer send_user_id) {
        this.send_user_id = send_user_id;
    }

    public void setRecv_user_id(Integer recv_user_id) {
        this.recv_user_id = recv_user_id;
    }

    public String getRecv_nickname() {
        return recv_nickname;
    }

    public void setRecv_nickname(String recv_nickname) {
        this.recv_nickname = recv_nickname;
    }

    public String getSend_nickname() {
        return send_nickname;
    }

    public void setSend_nickname(String send_nickname) {
        this.send_nickname = send_nickname;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(Date send_time) {
        this.send_time = Time.calculateTime(send_time);
    }

    public Integer getRead_chk() {
        return read_chk;
    }

    public void setRead_chk(Integer read_che) {
        this.read_chk = read_che;
    }

    public int getSend_user_id() {
        return send_user_id;
    }

    public void setSend_user_id(int send_user_id) {
        this.send_user_id = send_user_id;
    }

    public int getRecv_user_id() {
        return recv_user_id;
    }

    public void setRecv_user_id(int recv_user_id) {
        this.recv_user_id = recv_user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}

