package me.minjun.springbootwebservice.domain.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();

    @Transactional
    @Modifying
    @Query(value="UPDATE Posts p SET p.content = :content WHERE p.id =:id")
    Integer update(@Param("content") String content, @Param("id") Long id);
}
