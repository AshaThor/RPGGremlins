package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.Blog;
import com.ashathor.rpggremlins.repositories.BlogRepository;
import com.ashathor.rpggremlins.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping
    public String listBlogs(ModelMap modelMap) {
        List<Blog> blogsList = blogRepository.findAll();
        //List<Blog> blogsListSorted = blogsList.stream().sorted(Comparator.comparing(Blog::get)).collect(Collectors.toList());
        modelMap.put("blogsList", blogsList);
        return "blog/blogs";
    }


    @GetMapping("/{id}")
    public String get(@PathVariable("id") long id, ModelMap modelMap) {
        Blog blog = blogRepository.getOne(id);
        modelMap.put("blog", blog);
        return "blog/blog";
    }

    /*//try to get param name working
    public Blog getClass(@RequestParam(value = "name") String name) {
        return blogRepository.findByName(name);
    }*/

    @GetMapping("/new")
    public String blogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/newblog";
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public String create(@ModelAttribute Blog blog, Model model) {
        blog.setDateCreated(LocalDateTime.now());
        model.addAttribute("blog", blog);
        blogRepository.save(blog);
        return "blog/newsuccess";
    }

    @PostMapping("/like")
    @ResponseStatus(HttpStatus.OK)
    public void like(@ModelAttribute Long id){
        Blog blog = blogRepository.getOne(id);
        Integer likes =  blog.getLikes();
        blog.setLikes(++likes);
        blogRepository.save(blog);
    }
}
