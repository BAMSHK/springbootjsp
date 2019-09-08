package com.hwdee.springbootjsp;

import com.hwdee.springbootjsp.mapper.StudentMapper;
import com.hwdee.springbootjsp.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentMapper studentMapper;
    @RequestMapping("listStudent")
    public String listStudent(Model m) throws Exception{
        List<Student> sm = studentMapper.findAll();
        m.addAttribute("sm", sm);
        return "listStudent";
    }
}
