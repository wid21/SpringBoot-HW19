package com.example.springboothw19.Repository;

import com.example.springboothw19.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Blog findBlogById(Integer id);
    Blog findBlogByTitle(String titel);
    List<Blog> findBlogByCategory(String category);
    @Query("select g from Blog g where g.id = ?1")
    Blog getId(Integer id);

}

