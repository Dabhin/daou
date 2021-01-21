package com.example.app.mapper;

import com.example.app.model.Boardlike;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardlikeMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Insert({
        "insert into boardlike (B_NO, U_ID, ",
        "B_LIKE)",
        "values (#{bNo,jdbcType=INTEGER}, #{uId,jdbcType=VARCHAR}, ",
        "#{bLike,jdbcType=CHAR})"
    })
    int insert(Boardlike record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Boardlike record);
}