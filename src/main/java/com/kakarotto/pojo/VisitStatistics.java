package com.kakarotto.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class VisitStatistics {
    private Long id;
    private Integer pv;
    private Integer uv;
    private Integer ip;
    private String location;
    private Date createTime;
    private Date updateTime;

    // getters and setters
}

