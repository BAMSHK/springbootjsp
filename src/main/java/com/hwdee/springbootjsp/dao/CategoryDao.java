package com.hwdee.springbootjsp.dao;

import com.hwdee.springbootjsp.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//这里是接口
public interface CategoryDao extends JpaRepository<Category,Integer> {

}
