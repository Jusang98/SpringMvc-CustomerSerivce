package com.nhnacademy.customerservice.domain;


import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class PostRegisterRequest {

    @Length(min = 0, max = 200)
    String title;


    String classification;

    @Length(min = 0, max = 40000)
    String content;

    Date posttime;

    String answerstatus;

    MultipartFile fileName;
    @Length(min = 1, max = 40000)
    String answerText;

    String csName;

    String answerTime;

    public String getAnswerTime() {
        return answerTime;
    }

    public String getCsName() {
        return csName;
    }

    public String getTitle() {
        return title;
    }

    public String getClassification() {
        return classification;
    }

    public String getContent() {
        return content;
    }

    public Date getPosttime() {
        return posttime;
    }

    public String getAnswerstatus() {
        return answerstatus;
    }

    public MultipartFile getFileName() {
        return fileName;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public void setAnswerstatus(String answerstatus) {
        this.answerstatus = answerstatus;
    }

    public void setFileName(MultipartFile fileName) {
        this.fileName = fileName;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public void setCsName(String csName) {
        this.csName = csName;
    }


    public PostRegisterRequest() {
    }

}

