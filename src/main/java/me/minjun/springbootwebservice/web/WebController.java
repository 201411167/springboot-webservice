package me.minjun.springbootwebservice.web;

import lombok.AllArgsConstructor;
import me.minjun.springbootwebservice.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

}
