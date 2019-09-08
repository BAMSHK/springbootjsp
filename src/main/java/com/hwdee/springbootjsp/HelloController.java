package com.hwdee.springbootjsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/abc")
    public  String hello(Model model){
        System.out.println("asd");
        model.addAttribute("msg","zhao");
        return "success";
    }
}
