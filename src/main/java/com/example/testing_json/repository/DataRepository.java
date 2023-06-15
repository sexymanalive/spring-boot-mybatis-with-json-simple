package com.example.testing_json.repository;


import com.example.testing_json.model.Person;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DataRepository {

    //JsonNodeHandler

    // using this to add the singular and multiple objects
    @Insert("insert into subject_tb (data) values (#{data,jdbcType=OTHER , typeHandler=com.example.testing_json.utils.JsonNodeHandler}) ")
    public int addingData(@Param("data") JsonNode data);


    @Select("select data from subject_tb where id = #{id}")
    JsonNode getPersonJsonByID(@Param("id") int id);


    @Select("select data from subject_tb where id = #{id}")
    String getPersonJsonAsStringById(@Param("id") int id);
}
