package com.nuc.zxxk.mapper;

import com.nuc.zxxk.pojo.Class;
import com.nuc.zxxk.pojo.ClassUpdate;
import com.nuc.zxxk.pojo.student;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Mapper
public interface ClassMapper {
    int insert(Class record);
    List<Class>  findAllClass();
    @Update("UPDATE `Class` SET peopleNum=#{peopleNum} WHERE classId=#{classId}")
    int updateClassPeople(@Param("classId") String classId,@Param("peopleNum") int peopleNum);
    @Select("select classPeople from `Class` where classId=#{classId}")
    int selectClass(String classId);
    List<student> findClassByClassId(String classId);
//    DELETE `user`,info from `user` LEFT JOIN info ON `user`.id=info.id WHERE `user`.id=2
//    @Delete("delete Class selectClass from Class LEFT JOIN selectClass ON Class.classId=selectClass.classId where classId=#{classId}")
    int deleteClass(@Param("classId") String classId);
    @Select("select * from Class where classTeacher like '%${teacher}%'")
    List<Class> findClassByTeacher(String teacher);
    @Select("select * from Class where className like '%${className}%'")
    List<Class> findClassByClassName(String className);
    @Select("select * from Class where classTeacher like '%${teacher}%' and className like '%${className}%'")
    List<Class> findClassByTeacherAndClassName(String teacher, String className);
    @Select("select * from Class where classId=#{classId}")
    Class showClass(String classId);
    int updateClass(@Param("classUpdate") ClassUpdate classUpdate);
    @Select("select * from Class where classId not in(select classId from selectClass where userId=#{userId})")
    List<Class> findAllByUserId(String userId);
    @Select("select * from Class where classTeacher like '%${classTeacher}%' and classId not in(select classId from selectClass where userId=#{userId})")
    List<Class> findAllByTeacher(String userId,String classTeacher);
    @Select("select count(*) from Class")
    int countClass();

}