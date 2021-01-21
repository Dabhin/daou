package com.example.app.mapper;

import com.example.app.model.Boardinfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardinfoMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Delete({
        "delete from boardinfo",
        "where B_NO = #{bNo,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer bNo);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Insert({
        "insert into boardinfo (B_TITLE, ",
        "WRITER_ID, ",
        "UPDATE_DATE, CREATE_DATE, ",
        "B_CONTENT)",
        "values (#{bTitle,jdbcType=VARCHAR}, ",
        "#{writerId,jdbcType=VARCHAR}, ",
        "#{updateDate,jdbcType=TIMESTAMP}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{bContent,jdbcType=LONGVARCHAR})"
    })
    int insert(Boardinfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Boardinfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "B_NO, B_TITLE, B_CNT, WRITER_ID, UPDATE_DATE, CREATE_DATE, B_CONTENT",
        "from boardinfo",
        "where B_NO = #{bNo,jdbcType=INTEGER}"
    })
    @ResultMap("com.example.app.mapper.BoardinfoMapper.ResultMapWithBLOBs")
    Boardinfo selectByPrimaryKeyWithLock(Integer bNo);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Select({
        "select",
        "B_NO, B_TITLE, B_CNT, WRITER_ID, UPDATE_DATE, CREATE_DATE, B_CONTENT",
        "from boardinfo",
        "where B_NO = #{bNo,jdbcType=INTEGER}"
    })
    @ResultMap("com.example.app.mapper.BoardinfoMapper.ResultMapWithBLOBs")
    Boardinfo selectByPrimaryKey(Integer bNo);

    @Select({
            "select",
            "B_NO, B_TITLE, B_CNT, WRITER_ID, UPDATE_DATE, CREATE_DATE, B_CONTENT",
            "from boardinfo"
    })
    @ResultMap("com.example.app.mapper.BoardinfoMapper.ResultMapWithBLOBs")
    List<Boardinfo> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Boardinfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Update({
        "update boardinfo",
        "set B_TITLE = #{bTitle,jdbcType=VARCHAR},",
          "B_CNT = #{bCnt,jdbcType=INTEGER},",
          "WRITER_ID = #{writerId,jdbcType=VARCHAR},",
          "UPDATE_DATE = #{updateDate,jdbcType=TIMESTAMP},",
          "CREATE_DATE = #{createDate,jdbcType=TIMESTAMP},",
          "B_CONTENT = #{bContent,jdbcType=LONGVARCHAR}",
        "where B_NO = #{bNo,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Boardinfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @Update({
        "update boardinfo",
        "set B_TITLE = #{bTitle,jdbcType=VARCHAR},",
          "UPDATE_DATE = #{updateDate,jdbcType=TIMESTAMP},",
          "B_CONTENT = #{bContent,jdbcType=LONGVARCHAR}",
        "where B_NO = #{bNo,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Boardinfo record);
}