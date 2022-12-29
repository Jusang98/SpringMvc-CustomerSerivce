package com.nhnacademy.customerservice.repository;


import com.nhnacademy.customerservice.domain.Post;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


public interface PostRepository {

    boolean exists(long id);

    Post register(String title, String classification, String content, String answerStatus, MultipartFile fileName, String answerText, String csName, String answerTime);

    Post getPost(long id);

    void answer(Post post);

    List<Post> getPosts();
    List<Post> getAnswerList();

}
