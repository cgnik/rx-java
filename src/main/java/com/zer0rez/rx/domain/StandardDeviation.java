package com.zer0rez.rx.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "standardDeviation")
public class StandardDeviation {
    @Id
    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
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
