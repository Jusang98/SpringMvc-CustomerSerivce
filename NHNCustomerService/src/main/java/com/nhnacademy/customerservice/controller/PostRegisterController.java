package com.nhnacademy.customerservice.controller;

import com.nhnacademy.customerservice.domain.Post;
import com.nhnacademy.customerservice.domain.PostRegisterRequest;
import com.nhnacademy.customerservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@RequestMapping("/post/register")
public class PostRegisterController {
    private final PostRepository postRepository;

    public PostRegisterController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public String PostRegisterForm() {
        return "thymeleaf/postRegister";
    }

    @PostMapping
    public ModelAndView registerPost(@RequestParam("fileName") MultipartFile file,
                                     @ModelAttribute PostRegisterRequest postRegisterRequest,
                                     @Value("${upload.dir}") String uploadDir, Model model) throws IOException {

        Post post = postRepository.register(postRegisterRequest.getTitle(),
                postRegisterRequest.getClassification(),
                postRegisterRequest.getContent(),
                postRegisterRequest.getAnswerstatus(),
                postRegisterRequest.getFileName(),
                postRegisterRequest.getAnswerText(),
                postRegisterRequest.getCsName(),
                postRegisterRequest.getAnswerTime());

        file.transferTo(Paths.get(uploadDir + file.getOriginalFilename()));
        model.addAttribute("filename", file.getOriginalFilename());
        ModelAndView mav = new ModelAndView("thymeleaf/postView");

        mav.addObject("post", post);

        return mav;
    }
}
