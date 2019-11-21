package com.cn.wanxi.model.user;

import java.io.Serializable;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-20 12:39
 */
public class User implements Serializable {

    private Integer id; //用户id
    private String  username;//xingm
    private String  password; //密码
    private String  phone; //电话号码
    private String  email; //email
    private String  created;//创建日期
    private String  updated;// 更新日期
    private String  sourceType;//认证来源
    private String  nickName; //昵称
    private String  name;//真实姓名
    private String  status;//账号状态
    private String  headPic;//头像地址
    private String  qq;//qq号
    private String isMobileCheck;//是否手机认证
    private String isMailCheck;//email认证
    private String  sex;//性别
    private String  userLevel;//等级
    private String  points;//积分
    private String  experienceValue;//经验
    private String  birthday;//生日
    private String  lastLoginTime;//上次登录时间

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

    public String isMobileCheck() {
        return isMobileCheck;
    }

    public void setMobileCheck(String mobileCheck) {
        isMobileCheck = mobileCheck;
    }

    public String isMailCheck() {
        return isMailCheck;
    }

    public void setMailCheck(String mailCheck) {
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