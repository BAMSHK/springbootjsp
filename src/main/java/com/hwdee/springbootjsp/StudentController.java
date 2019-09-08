package com.hwdee.springbootjsp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwdee.springbootjsp.mapper.StudentMapper;
import com.hwdee.springbootjsp.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
   @Autowired
    StudentMapper studentMapper;
   @RequestMapping("listStudent")
   public  String listStuent(Model m, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
       PageHelper.startPage(start,size,"id desc");
       List<Student> all = studentMapper.findAll();
       PageInfo<Student> page = new PageInfo<>(all);
       m.addAttribute("page", page);
       return "listStudent";
   }
    @RequestMapping("/addStudent")
    public String listStduent(Student s) throws Exception{
        int row = studentMapper.save(s);
        if (row <0){
            throw   new  Exception("插入学生失败");
        }else {
            return "redirect:listStudent";
        }
    }
//    删除学生信息
    @RequestMapping("/deleteStduent")
    public  String deleteStduent(int id){
       studentMapper.delete(id);
       return "redirect:listStudent";
    }
//    更新学生信息
    @RequestMapping("/updateStudent")
    public String updateStudent(Student stduent){
       studentMapper.update(stduent);
       return "redirect:listStudent";
    }
//    根据id查找学生
    @RequestMapping("/editStudent")
     public String editStudent(int id,Model m){
        Student s = studentMapper.get(id);
        m.addAttribute("s",s);
        return "editStudent";
    }
}
