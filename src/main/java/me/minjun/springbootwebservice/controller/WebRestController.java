package me.minjun.springbootwebservice.controller;

import lombok.AllArgsConstructor;
import me.minjun.springbootwebservice.domain.Posts.PostsRepository;
import me.minjun.springbootwebservice.dto.savePostsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.minjun.springbootwebservice.domain.Posts.Posts;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository repo;

    @GetMapping("/insert_test")
    public void insert_test(){
        repo.save(Posts.builder().title("title").content("content").author("author").build());
    }

    @GetMapping("/delete_test")
    public void delete_test(){
        repo.deleteAll();
    }

    @PostMapping("/posts")
    public void posts(@RequestBody savePostsDto dto){
        repo.save(dto.toEntity());
    }
}
