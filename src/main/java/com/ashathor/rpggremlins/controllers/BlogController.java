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

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/blog")
public class BlogController {

    /*@Autowired
    private BlogRepository blogRepository;

    public List<Blog> list() {
        return blogRepository.findAll();
    }

    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping
    public String listClasses(ModelMap modelMap) {
        List<Blog> blogsList = blogRepository.findAll();
        List<Blog> blogsListSorted = blogsList.stream().sorted(Comparator.comparing(Blog::get)).collect(Collectors.toList());
        modelMap.put("blogsList", blogsListSorted);
        return "blog/blog";
    }


    @GetMapping("/{id}")
    public String get(@PathVariable("id") long id, ModelMap modelMap) {
        Blog blog = blogRepository.getOne(id);
        modelMap.put("blog", blog);
        return "blog/entry";
    }

    //try to get param name working
    *//*public Blog getClass(@RequestParam(value = "name") String name) {
        return blogRepository.findByName(name);
    }*//*

    @GetMapping("/new")
    public String blogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/newBlogPost";
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public String create(@ModelAttribute Blog blog, Model model) {
        model.addAttribute("blog", blog);
        blogRepository.save(blog);
        return "blog/newPostSuccess";
    }*/
}
