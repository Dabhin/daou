package com.example.app.model;

import java.util.Date;
import lombok.Data;

/**
 * Table: boardinfo
 */
@Data
public class Boardinfo {
    /**
     * Column: B_NO
     */
    private Integer bNo;

    /**
     * Column: B_TITLE
     */
    private String bTitle;

    /**
     * Column: B_CNT
     */
    private Integer bCnt;

    /**
     * Column: WRITER_ID
     */
    private String writerId;

    /**
     * Column: UPDATE_DATE
     */
    private Date updateDate;

    /**
     * Column: CREATE_DATE
     */
    private Date createDate;

    /**
     * Column: B_CONTENT
     */
    private String bContent;
}