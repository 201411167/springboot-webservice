package me.minjun.springbootwebservice.service;

import lombok.AllArgsConstructor;
import me.minjun.springbootwebservice.domain.Posts.PostsRepository;
import me.minjun.springbootwebservice.dto.PostsMainResponseDto;
import me.minjun.springbootwebservice.dto.PostsSaveRequestDto;
import me.minjun.springbootwebservice.dto.PostsUpdateDto;
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

    @Transactional
    public Long update(PostsUpdateDto dto){
        return Long.valueOf(postsRepository.update(dto.getContent(),dto.getId()));
    }
}
