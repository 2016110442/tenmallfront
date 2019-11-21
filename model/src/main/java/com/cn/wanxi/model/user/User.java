package com.cn.wanxi.model.user;

import java.io.Serializable;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-20 12:39
 */
public class User implements Serializable {

    private Integer id;
    private String  username;
    private String  password;
    private String  phone;
    private String  email;
    private String  created;
    private String  updated;
    private String  sourceType;
    private String  nickName;
    private String  name;
    private String  status;
    private String  headPic;
    private String  qq;
    private boolean isMobileCheck;
    private boolean isMailCheck;
    private String  sex;
    private String  userLevel;
    private String  points;
    private String  experienceValue;
    private String  birthday;
    private String  lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public boolean isMobileCheck() {
        return isMobileCheck;
    }

    public void setMobileCheck(boolean mobileCheck) {
        isMobileCheck = mobileCheck;
    }

    public boolean isMailCheck() {
        return isMailCheck;
    }

    public void setMailCheck(boolean mailCheck) {
        isMailCheck = mailCheck;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(String experienceValue) {
        this.experienceValue = experienceValue;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}