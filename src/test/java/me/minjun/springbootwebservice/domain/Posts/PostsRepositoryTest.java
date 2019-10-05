package me.minjun.springbootwebservice.domain.Posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepo;

    @After
    public void cleanUp() {
        postsRepo.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        postsRepo.save(Posts.builder()
        .title("테스트 게시글")
        .content("테스트 본문")
        .author("kim min jun")
        .build());

        //when
        List<Posts> list = postsRepo.findAll();

        //then
        Posts post = list.get(0);
        assertThat(post.getTitle(), is("테스트 게시글"));
        assertThat(post.getContent(), is("테스트 본문"));
    }
}