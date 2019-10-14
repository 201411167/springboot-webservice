package me.minjun.springbootwebservice.controller;

import lombok.AllArgsConstructor;
import me.minjun.springbootwebservice.domain.Posts.PostsRepository;
import me.minjun.springbootwebservice.dto.PostsSaveRequestDto;
import me.minjun.springbootwebservice.dto.PostsUpdateDto;
import me.minjun.springbootwebservice.service.PostsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.minjun.springbootwebservice.domain.Posts.Posts;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository repo;
    private PostsService service;

    @GetMapping("/insert_test")
    public void insert_test(){
        repo.save(Posts.builder().title("title").content("content").author("author").build());
    }

    @GetMapping("/delete_test")
    public void delete_test() { repo.deleteAll(); }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return service.save(dto);
    }

    @PostMapping("/updatePosts")
    public Long updatePosts(@RequestBody PostsUpdateDto dto){
        System.out.println(dto.getContent());
        System.out.println(dto.getId());
        return service.update(dto);
    }
}
