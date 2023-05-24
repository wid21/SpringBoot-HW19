package com.example.springboothw19.Service;

import com.example.springboothw19.ApiException.ApiException;
import com.example.springboothw19.Model.Blog;
import com.example.springboothw19.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BlogService {
private final BlogRepository blogRepository;
    public List<Blog> getBlogs(){
        List<Blog>blogs=blogRepository.findAll();
        return blogs;
    }
    public void addBlogs (Blog blog){
        blogRepository.save(blog);
    }
    public void updateBlog(Blog blog , Integer id){
        Blog b = blogRepository.findBlogById(id);
        if (b==null){
            throw new ApiException("not found");
        }
        b.setBody(blog.getBody());
        b.setCategory(blog.getCategory());
        b.setTitle(blog.getTitle());
        b.setPublished(blog.isPublished());
        blogRepository.save(b);
    }

    public void deleteBlog(Integer id){
        Blog b = blogRepository.findBlogById(id);
        if (b==null){
            throw new ApiException("not found");
        }

        blogRepository.delete(b);
    }

    public Blog getbyid(Integer id){
        Blog b = blogRepository.getId(id);
        if (b==null){
            throw new ApiException("not found");
        }
        return b;
    }

    public Blog getBlogtit(String title){
        Blog b= blogRepository.findBlogByTitle( title);
        if(b==null){
            throw new ApiException("not found");
        }
        return b;
    }

    public List<Blog> getbycat(String category){
        List<Blog>list=blogRepository.findBlogByCategory(category);
        if(list==null){
            throw new ApiException("not found");
        }
        return list;
    }

    public Blog checkpubl(Integer id){
        Blog b = blogRepository.findBlogById(id);
        if(b==null){
            throw new ApiException("not found");
        }

        if(b.isPublished()==false){
            b.setPublished(true);
            blogRepository.save(b);
        }
        else{
            throw new ApiException("blog is published");
        }
        return b;
    }
}


