package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content){
        // get the user object
        User user;
//        try{
            user=userRepository1.findById(userId).get();
//        }catch(Exception e){
//            throw new Exception("User not found!");
//        }
        //create a blog at the current time

        Blog blog = new Blog();
        blog.setContent(content);
        blog.setTitle(title);
        blog.setPubDate(new Date());
        blog.setUser(user);// link the user to the blog


        //adding the current blog to the bloglist of user
        user.getBlogList().add(blog);
        userRepository1.save(user);// by saving user(parent) blog (child ) is autosaved

        return blog;




    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);

    }
}
