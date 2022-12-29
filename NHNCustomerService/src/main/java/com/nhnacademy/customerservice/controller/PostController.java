package com.nhnacademy.customerservice.controller;

import com.nhnacademy.customerservice.domain.Post;
import com.nhnacademy.customerservice.domain.PostRegisterRequest;
import com.nhnacademy.customerservice.exception.PostNotFoundException;
import com.nhnacademy.customerservice.repository.AdminRepository;
import com.nhnacademy.customerservice.repository.PostRepository;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/post")
public class PostController {
    private final PostRepository postRepository;

    private final AdminRepository adminRepository;

    public PostController(PostRepository postRepository, AdminRepository adminRepository) {
        this.postRepository = postRepository;
        this.adminRepository = adminRepository;
    }

    @ModelAttribute("post")
    public Post getPost(@PathVariable("postId") Long postId) {
        Post post = postRepository.getPost(postId);
        if (Objects.isNull(post)) {
            throw new PostNotFoundException();
        }
        return post;
    }

    @GetMapping("/{postId}")
    public String viewPost(@ModelAttribute("post") Post post, Model model) {
        model.addAttribute("post", post);
        return "thymeleaf/postView";
    }

    @GetMapping("/{postId}/answer")
    public String answerPostForm(@ModelAttribute("post") Post post, Model model) {
        model.addAttribute("post", post);
        return "thymeleaf/postAnswer";
    }

    @PostMapping("/{postId}/answer")
    public String answerPost(@ModelAttribute Post post,
                             @Valid @ModelAttribute PostRegisterRequest postRegisterRequest,
                             Model model) {

        post.setAnswerText(postRegisterRequest.getAnswerText());
        post.setAnswerTime(DateTime.now().toString("yyyy년MM월dd일 HH시mm분ss초"));
        post.setCsName(postRegisterRequest.getCsName());
        postRepository.answer(post);

        model.addAttribute("post", post);
        return "thymeleaf/postView";
    }
}
