package me.minjun.springbootwebservice.service;

import lombok.AllArgsConstructor;
import me.minjun.springbootwebservice.domain.posts.PostsRepository;
import me.minjun.springbootwebservice.web.PostsSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}
