package org.example.pr11.controller;

import org.example.pr11.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // this annotation is mix of @Controller + @ResponseBody
public class IndexController {
//    @ResponseBody
//    @GetMapping("/index")
//    public String getIndexPage() {
//        return "index";
//    }

    @GetMapping("/index")
    public User getIndexPage() {
        User bob = new User();
        bob.setAge(21);
        bob.setName("Bob");
        return bob;

    }
}
