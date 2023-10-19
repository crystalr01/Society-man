package com.rameshwar.societyman;

public class NoticeData2 {


    String userName,image,date,time,key,houseNo,family,goTime,returnTime,work,vehicals,title;

    public NoticeData2() {
    }

    public NoticeData2(String userName, String image, String date, String time, String key, String house, String family, String goTime, String returnTime, String work, String vehicals) {
        this.userName = userName;
        this.image = image;
        this.date = date;
        this.time = time;
        this.key = key;
        this.houseNo = house;
        this.family = family;
        this.goTime = goTime;
        this.returnTime = returnTime;
        this.work = work;
        this.vehicals = vehicals;
    }

    public NoticeData2(String title, String image, String date, String time, String key) {
        this.title = title;
        this.image = image;
        this.date = date;
        this.time = time;
        this.key = key;
    }


    public String getUserName1() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String house) {
        this.houseNo = house;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
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



    public void setTitle(String title) {
        this.title = title;
    }


}
