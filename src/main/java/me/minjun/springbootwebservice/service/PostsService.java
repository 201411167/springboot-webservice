package me.minjun.springbootwebservice.service;

import lombok.AllArgsConstructor;
import me.minjun.springbootwebservice.domain.posts.PostsRepository;
import me.minjun.springbootwebservice.dto.posts.PostsMainResponseDto;
import me.minjun.springbootwebservice.dto.posts.PostsSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public List<PostsMainResponseDto> findAllDesc(){
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
