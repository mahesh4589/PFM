package com.pfm.user_service.model.dto;

public class LoginDto {

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String emailId;
    String password;

    public String getMessages() {
        return messages;
    }

    public LoginDto(String messages, Integer code) {
        this.messages = messages;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public LoginDto()
    {

    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    String messages;
    Integer code;

}
