package com.nhnacademy.customerservice.repository;


import com.nhnacademy.customerservice.domain.Post;
import com.nhnacademy.customerservice.exception.PostNotFoundException;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.function.Function;

@Repository("PostRepository")
public class PostRepositoryImpl implements PostRepository {
    private final Map<Long, Post> posts = new HashMap<>();

    List<Post> postList = new ArrayList<>();
    List<Post> answerList = new ArrayList<>();

    @Override
    public boolean exists(long id) {
        return posts.containsKey(id);
    }


    @Override
    public Post register(String title, String classification, String content, String answerStatus, MultipartFile fileName, String answerText, String csName, String answerTime) {
        String postTime = DateTime.now().toString("yyyy년MM월dd일 HH시mm분ss초");
        long id = posts.keySet()
                .stream()
                .max(Comparator.comparing(Function.identity()))
                .map(l -> l + 1)
                .orElse(1L);

        Post post = Post.create(id, title, classification, content, postTime, answerStatus, fileName, answerText, csName, answerTime);

        post.setId(id);
        postList.add(post);
        answerList.add(post);
        posts.put(id, post);

        return post;
    }

    @Override
    public Post getPost(long id) {
        return exists(id) ? posts.get(id) : null;
    }

    @Override
    public void answer(Post post) {
        Post dbPost = getPost(post.getId());
        if (Objects.isNull(dbPost)) {
            throw new PostNotFoundException();
        }

        dbPost.setAnswerText(post.getAnswerText());
    }

    public List<Post> getPosts() {
        return postList;
    }
    public List<Post> getAnswerList() {
        answerList.removeIf(post -> Objects.equals(post.getAnswerStatus(), "yes"));
        return answerList;
    }

}

