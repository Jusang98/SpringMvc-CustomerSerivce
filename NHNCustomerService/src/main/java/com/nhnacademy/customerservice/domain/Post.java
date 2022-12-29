package com.nhnacademy.customerservice.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class Post {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String classification;
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    private String postTime;
    @Getter
    @Setter
    private String answerStatus;
    @Getter
    @Setter
    private MultipartFile fileName;
    @Getter
    @Setter
    private String answerText;
    @Getter
    @Setter
    private String csName;
    @Getter
    @Setter
    private String answerTime;

    public Post(long id, String title, String classification, String content, String postTime, String answerStatus, MultipartFile fileName, String answerText, String csName, String answerTime) {
        this.id = id;
        this.title = title;
        this.classification = classification;
        this.content = content;
        this.postTime = postTime;
        this.answerStatus = answerStatus;
        this.fileName = fileName;
        this.answerText = answerText;
        this.csName = csName;
        this.answerTime = answerTime;
    }

    public Post() {
    }

    public static Post create(long id, String title, String classification, String content, String postTime, String answerStatus, MultipartFile fileName, String answerText, String csName, String answerTime) {
        return new Post(id, title, classification, content, postTime, answerStatus, fileName, answerText, csName, answerTime);
    }
}

