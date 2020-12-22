package org.example.entity;

import java.io.Serializable;

public class Community03VO implements Serializable {
    private Integer communityId;
    private String name;
    private String createDate;
    private Double area;
    private String type;
    private String feature;
    private String renovationRecommendation;
    private String note;
    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getRenovationRecommendation() {
        return renovationRecommendation;
    }

    public void setRenovationRecommendation(String renovationRecommendation) {
        this.renovationRecommendation = renovationRecommendation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
