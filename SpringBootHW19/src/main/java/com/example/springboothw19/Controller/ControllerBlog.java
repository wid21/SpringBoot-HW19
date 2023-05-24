package com.example.springboothw19.Controller;

import com.example.springboothw19.Model.Blog;
import com.example.springboothw19.Service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class ControllerBlog {
    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<Blog> blogList=blogService.getBlogs();
        return ResponseEntity .status(200).body(blogList);
    }

    @PostMapping("/add")
    public ResponseEntity addAll(@RequestBody Blog blog){
        blogService.addBlogs(blog);
        return ResponseEntity .status(200).body("blog added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlogs(@RequestBody Blog blog ,@PathVariable Integer id){
        blogService.updateBlog(blog,id);
        return ResponseEntity .status(200).body("blog updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBloge( @PathVariable Integer id){
        blogService.deleteBlog(id);
        return ResponseEntity .status(200).body("blog updated");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getbytit(@PathVariable Integer id){
        Blog b= blogService.getbyid(id);
        return ResponseEntity .status(200).body(b);
    }

    @GetMapping("/gett/{titel}")
    public ResponseEntity getbytit(@PathVariable String titel){
        Blog b= blogService.getBlogtit(titel);
        return ResponseEntity .status(200).body(b);
    }

    @GetMapping("/get/{category}")

    public ResponseEntity getCategory(@PathVariable String category){
        List<Blog> list=blogService.getbycat(category);
        return ResponseEntity.status(200).body(list);
    }

    @PutMapping("/updatef/{id}")
    public ResponseEntity checkf(@PathVariable Integer id){
        Blog b= blogService.checkpubl(id);
        return ResponseEntity .status(200).body(b);
    }
}

