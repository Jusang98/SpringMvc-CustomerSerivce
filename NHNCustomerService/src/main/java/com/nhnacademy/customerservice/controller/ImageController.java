package com.nhnacademy.customerservice.controller;

import com.nhnacademy.customerservice.domain.PostRegisterRequest;
import com.nhnacademy.customerservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Controller
public class ImageController {
    private final PostRepository postRepository;

    public ImageController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/images/{postId}")
    @ResponseBody
    public Resource downloadImage(@PathVariable("postId") Long id, @RequestParam("fileName") MultipartFile file,
                                  @ModelAttribute PostRegisterRequest postRegisterRequest,
                                  @Value("${upload.dir}") String uploadDir, Model model) throws IOException {
        postRepository.exists(id);
        String origName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = origName.substring(origName.lastIndexOf("."));
        String savedName = uuid + extension;
        String savedPath = uploadDir + savedName;
        String path = uploadDir + file.getOriginalFilename();
        return new UrlResource(path);
    }
}
