package me.minjun.springbootwebservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.minjun.springbootwebservice.domain.Posts.Posts;

@Getter
@Setter
@NoArgsConstructor
public class savePostsDto {
    private String title;
    private String content;
    private String author;

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
