package me.minjun.springbootwebservice.service;

import me.minjun.springbootwebservice.domain.posts.Posts;
import me.minjun.springbootwebservice.domain.posts.PostsRepository;
import me.minjun.springbootwebservice.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void DTO데이터가_posts테이블에_저장된다(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("kim")
                .content("테스트")
                .title("테스트 타이틀")
                .build();
        //when
        postsService.save(dto);
        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getContent().equals(dto.getContent()));
        assertThat(posts.getAuthor().equals(dto.getAuthor()));
        assertThat(posts.getTitle().equals(dto.getTitle()));
    }
}