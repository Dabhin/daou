package com.example.app.mapper;

import com.example.app.model.Userinfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserinfoMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Delete({
        "delete from userinfo",
        "where U_ID = #{uId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String uId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Insert({
        "insert into userinfo (U_ID, U_PASSWORD, ",
        "U_AUTH)",
        "values (#{uId,jdbcType=VARCHAR}, #{uPassword,jdbcType=VARCHAR}, ",
        "#{uAuth,jdbcType=CHAR})"
    })
    int insert(Userinfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Userinfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "U_ID, U_PASSWORD, U_AUTH",
        "from userinfo",
        "where U_ID = #{uId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.example.app.mapper.UserinfoMapper.BaseResultMap")
    Userinfo selectByPrimaryKeyWithLock(String uId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "U_ID, U_PASSWORD, U_AUTH",
        "from userinfo",
        "where U_ID = #{uId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.example.app.mapper.UserinfoMapper.BaseResultMap")
    Userinfo selectByPrimaryKey(String uId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Userinfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     * @param record
     */
    @Update({
        "update userinfo",
        "set U_PASSWORD = #{uPassword,jdbcType=VARCHAR}",
        "where U_ID = #{uId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Userinfo record);
}