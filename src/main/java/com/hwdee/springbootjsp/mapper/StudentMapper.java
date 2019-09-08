package com.hwdee.springbootjsp.mapper;

import com.hwdee.springbootjsp.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*  注解版mybatis*/
@Mapper
@Repository
public interface StudentMapper {
    @Select("select * from student")  //查询所有
    public List<Student> findAll();

    @Insert("insert into student(name) values (#{name})") //插入数据
    public int save(Student student);
   @Delete("delete from student where id=#{id}")  //根据id删除数据
    public void delete(int id);
    @Select("select * from student where id=#{id}") //根据id查找
    public Student get(int id);
    @Update("update student set name=#{name} where id=#{id}")  //更新学生信息
    public int update(Student student);

}
