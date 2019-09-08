package com.hwdee.springbootjsp.mapper;

import com.hwdee.springbootjsp.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/*  注解版mybatis*/
@Mapper
@Repository
public interface StudentMapper {
//    @Select("select * from student")
    public List<Student> findAll();
}
