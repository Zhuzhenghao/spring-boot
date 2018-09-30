package com.max.domain;


import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

  @Select("select * from User")
  List<User> findAll();

  @Select("select * from user where name = #{name}")
  User findByName(@Param("name") String name);

  @Insert("insert into user(name, age) values(#{name}, #{age})")
  int insertUser(User user);

  @Delete("delete from User where id = #{id}")
  int deleteUser(@Param("id") Long id);

  @Update("update User set name = #{name}, age = #{age} where id = #{id}")
  int updateUser(@Param("name") String name, @Param("age") Integer age, @Param("id") Long id);

}
