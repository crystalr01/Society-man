package com.rameshwar.societyman;

public class NoticeData {

    String userName,image,date,time,houseNo,family,goTime,returnTime,work,vehicals;

    public NoticeData() {
    }

    public NoticeData(String userName1, String image, String date, String time, String houseNo, String family, String goTime, String returnTime, String work, String vehicals) {
        this.userName = userName1;
        this.image = image;
        this.date = date;
        this.time = time;
        this.houseNo = houseNo;
        this.family = family;
        this.goTime = goTime;
        this.returnTime = returnTime;
        this.work = work;
        this.vehicals = vehicals;
    }

    public String getUserName1() {
        return userName;
    }

    public void setUserName1(String userName1) {
        this.userName = userName1;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getFamily() {
        return family;
    }

    public void setFamilyMem(String family) {
        this.family = family;
    }

    public String getGoTime() {
        return goTime;
    }

    public void setGoTime(String goTime) {
        this.goTime = goTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getVehicals() {
        return vehicals;
    }

    public void setVehicals(String vehicals) {
        this.vehicals = vehicals;
    }
}
