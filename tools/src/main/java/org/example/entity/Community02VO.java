package org.example.entity;


import java.io.Serializable;

public class Community02VO implements Serializable {
    private Integer communityId;
    private String communityName;
    private String communityAddress;
    private String name;
    private String createDate;
    private String takeKeyTime;
    private String note;
    private String designer;
    private String designAdvice;
    private String type;
    private Double area;

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityAddress() {
        return communityAddress;
    }

    public void setCommunityAddress(String communityAddress) {
        this.communityAddress = communityAddress;
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

    public String getTakeKeyTime() {
        return takeKeyTime;
    }

    public void setTakeKeyTime(String takeKeyTime) {
        this.takeKeyTime = takeKeyTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getDesignAdvice() {
        return designAdvice;
    }

    public void setDesignAdvice(String designAdvice) {
        this.designAdvice = designAdvice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
