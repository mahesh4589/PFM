package com.pfm.budget_service.model.dto;

import org.springframework.http.ResponseEntity;

public class ResponceDto {

    int respCode;
    String msg;

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
