package me.minjun.springbootwebservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostsUpdateDto {
    private Long id;
    private String content;

}
