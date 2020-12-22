package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class Community{
    @TableId(type = IdType.AUTO)
    private Integer communityId;
    private String communityName;
    private String communityAddress;
    private String name;
    private String createDate;
    private String finishDate;
    private String designer;
    private String type;
    private Double area;
    private String note;
    private String designAdvice;
    private Integer communityType;
    private String takeKeyTime;
    private String renovationRecommendation;
    private String feature;

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

    public String getTakeKeyTime() {
        return takeKeyTime;
    }

    public void setTakeKeyTime(String takeKeyTime) {
        this.takeKeyTime = takeKeyTime;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Integer getCommunityType() {
        return communityType;
    }

    public void setCommunityType(Integer communityType) {
        this.communityType = communityType;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityAddress() {
        return communityAddress;
    }

    public void setCommunityAddress(String communityAddress) {
        this.communityAddress = communityAddress;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
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

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDesignAdvice() {
        return designAdvice;
    }

    public void setDesignAdvice(String designAdvice) {
        this.designAdvice = designAdvice;
    }
}
