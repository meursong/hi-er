package com.mulcam.hier.dto;

public class Messages {
    private Integer send_user_id;
    private Integer recv_user_id;
    private String title;
    private String content;

    public Messages(int send_user_id, int recv_user_id, String title, String content) {
        this.send_user_id = send_user_id;
        this.recv_user_id = recv_user_id;
        this.title = title;
        this.content = content;
    }

    public Messages() {

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

