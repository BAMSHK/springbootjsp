package com.hwdee.springbootjsp;

import com.hwdee.springbootjsp.dao.CategoryDao;
import com.hwdee.springbootjsp.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @Autowired
    CategoryDao categoryDao;
//    查询所有信息
    @RequestMapping("/listCategory")
//    1. 在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5。
    public  String listCategory(Model m, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
//    2. 如果 start 为负，那么修改为0. 这个事情会发生在当前是首页，并点击了上一页的时候
        start = start<0?0:start;
//    3. 设置倒排序
        Sort sort = new Sort(Sort.Direction.DESC,"id");
//    4. 根据start,size和sort创建分页对象

        Pageable pageable = new PageRequest(start,size,Sort.Direction.ASC,"id");
//     CategoryDAO根据这个分页对象获取结果page
//     在这个page对象里，不仅包含了分页信息，还包含了数据信息，即有哪些分类数据。 这个可以通过getContent()获取出来。
        Page<Category> page = categoryDao.findAll(pageable);
        m.addAttribute("page", page);
//        List<Category> cs = categoryDao.findAll();
//        System.out.println(page.getNumber());
//        System.out.println(page.getNumberOfElements());
//        System.out.println(page.getSize());
//        System.out.println(page.getTotalElements());
//        System.out.println(page.getTotalPages());
//        System.out.println(page.getContent());
//        m.addAttribute("page",page);
        return "listCategory";
    }
//    增加
    @RequestMapping("/addCategory")
    public String addCateqgory(Category c) throws Exception{
        categoryDao.save(c);
        return "redirect:listCategory";
    }
//    删除
    @RequestMapping("/deleteCategory")
    public  String deleteCategory(int id) throws Exception{
        categoryDao.deleteById(id);
        return "redirect:listCategory";
    }
//    更新信息
    @RequestMapping("/updateCategory")
    public String updateCatrgory(Category c) throws Exception{
        categoryDao.save(c);
        return "redirect:listCategory";
    }
//    查找需要修改的用户
    @RequestMapping("/editCategory")
    public String editCategory(int id,Model m) throws Exception{
        Category c = categoryDao.getOne(id);
        m.addAttribute("c", c);
        return "editCategory";
    }

}
