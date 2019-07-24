package com.fy.staff.domain;

import java.io.Serializable;
import java.util.Date;

public class Staff implements Serializable{
    //员工编号
    private Integer staffId;
    //员工名称
    private String staffName;
    //员工性别
    private Integer staffSex;
    //员工年龄
    private Integer staffAge;
    //员工职位（1110为管理员，1111为普通员工）
    private Integer staffType;
    //部门（ 1 旅游部门，2 商品部门）
    private Integer staffPosition;
    //手机号
    private String staffPhone;
    //邮箱
    private String staffEmail;
    //密码
    private String staffPass;
    //员工住址
    private String staffAddress;
    //紧急联系人
    private String staffEmergencyRen;
    //紧急电话
    private String staffEmergencyIphone;
    //出生年月
    private Date staffDatet;
    //创建时间
    private Date staffCreate;
    //修改时间
    private Date staffUpdate;
    //状态
    private Integer staffYn;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public Integer getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(Integer staffSex) {
        this.staffSex = staffSex;
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public Integer getStaffType() {
        return staffType;
    }

    public void setStaffType(Integer staffType) {
        this.staffType = staffType;
    }

    public Integer getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(Integer staffPosition) {
        this.staffPosition = staffPosition;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone == null ? null : staffPhone.trim();
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail == null ? null : staffEmail.trim();
    }

    public String getStaffPass() {
        return staffPass;
    }

    public void setStaffPass(String staffPass) {
        this.staffPass = staffPass == null ? null : staffPass.trim();
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress == null ? null : staffAddress.trim();
    }

    public String getStaffEmergencyRen() {
        return staffEmergencyRen;
    }

    public void setStaffEmergencyRen(String staffEmergencyRen) {
        this.staffEmergencyRen = staffEmergencyRen == null ? null : staffEmergencyRen.trim();
    }

    public String getStaffEmergencyIphone() {
        return staffEmergencyIphone;
    }

    public void setStaffEmergencyIphone(String staffEmergencyIphone) {
        this.staffEmergencyIphone = staffEmergencyIphone == null ? null : staffEmergencyIphone.trim();
    }

    public Date getStaffDatet() {
        return staffDatet;
    }

    public void setStaffDatet(Date staffDatet) {
        this.staffDatet = staffDatet;
    }

    public Date getStaffCreate() {
        return staffCreate;
    }

    public void setStaffCreate(Date staffCreate) {
        this.staffCreate = staffCreate;
    }

    public Date getStaffUpdate() {
        return staffUpdate;
    }

    public void setStaffUpdate(Date staffUpdate) {
        this.staffUpdate = staffUpdate;
    }

    public Integer getStaffYn() {
        return staffYn;
    }

    public void setStaffYn(Integer staffYn) {
        this.staffYn = staffYn;
    }

    public Staff(Integer staffId, String staffName, Integer staffSex, Integer staffAge, Integer staffType, Integer staffPosition, String staffPhone, String staffEmail, String staffPass, String staffAddress, String staffEmergencyRen, String staffEmergencyIphone, Date staffDatet, Date staffCreate, Date staffUpdate, Integer staffYn) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffSex = staffSex;
        this.staffAge = staffAge;
        this.staffType = staffType;
        this.staffPosition = staffPosition;
        this.staffPhone = staffPhone;
        this.staffEmail = staffEmail;
        this.staffPass = staffPass;
        this.staffAddress = staffAddress;
        this.staffEmergencyRen = staffEmergencyRen;
        this.staffEmergencyIphone = staffEmergencyIphone;
        this.staffDatet = staffDatet;
        this.staffCreate = staffCreate;
        this.staffUpdate = staffUpdate;
        this.staffYn = staffYn;
    }

    public Staff() {
    }
}