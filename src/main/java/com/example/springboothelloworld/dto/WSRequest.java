package com.example.springboothelloworld.dto;

import lombok.Data;

@Data
public class WSRequest {
    private Long userId;
    private String content;

    public WSRequest() {
    }

    public WSRequest(Long userId, String content) {
        this.userId = userId;
        this.content = content;
    }
}
