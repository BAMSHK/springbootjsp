package com.hwdee.springbootjsp;

import com.hwdee.springbootjsp.dao.CategoryDao;
import com.hwdee.springbootjsp.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryDao categoryDao;
    @RequestMapping("/listCategory")
    public  String listCategory(Model m) throws Exception{
        List<Category> cs = categoryDao.findAll();
        m.addAttribute("cs",cs);
//        System.out.println("sssss");
        return "listCategory";
    }
}
