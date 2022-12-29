package com.nhnacademy.customerservice.controller;

import com.nhnacademy.customerservice.domain.Post;
import com.nhnacademy.customerservice.domain.PostRegisterRequest;
import com.nhnacademy.customerservice.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/post/postList")
public class PostListController {
    private final PostRepository postRepository;

    public PostListController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public String PostList(Model model) {
        model.addAttribute("postList", postRepository.getPosts());
        model.addAttribute("answerList",postRepository.getAnswerList());
        return "thymeleaf/postList";
    }


}
