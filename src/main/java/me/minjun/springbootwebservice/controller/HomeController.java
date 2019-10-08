package me.minjun.springbootwebservice.controller;

import lombok.AllArgsConstructor;
import me.minjun.springbootwebservice.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    private PostsService service;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("posts", service.findAllDesc());
        return "main";
    }
}
