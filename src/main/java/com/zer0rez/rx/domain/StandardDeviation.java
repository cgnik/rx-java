package com.zer0rez.rx.domain;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Date;

public class StandardDeviation {
    @Id
    private String id;
    private Date created;
    private BigDecimal answer;
    private BigDecimal[] points;

    public String getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public BigDecimal getAnswer() {
        return answer;
    }

    public void setAnswer(BigDecimal answer) {
        this.answer = answer;
    }

    public BigDecimal[] getPoints() {
        return points;
    }

    public void setPoints(BigDecimal[] points) {
        this.points = points;
    }
}
