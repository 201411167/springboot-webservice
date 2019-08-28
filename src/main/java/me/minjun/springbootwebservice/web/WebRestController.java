package me.minjun.springbootwebservice.web;

import lombok.AllArgsConstructor;
import me.minjun.springbootwebservice.domain.posts.PostsRepository;
import me.minjun.springbootwebservice.service.PostsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {
    PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "helloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        //postsRepository.save(dto.toEntity());
        return postsService.save(dto);
    }
}
