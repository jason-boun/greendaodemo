package com.jason.greendao.dao;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by JiaBo on 2017/9/19.
 */
@Entity
public class User {

    @Id
    private Long id;
    private String name;
    private int age;
    private int index;

    private Date time;

    @Convert(columnType = String.class, converter = StringConverter.class)
    private List<String> dataList;

    @Generated(hash = 1585855030)
    public User(Long id, String name, int age, int index, Date time,
            List<String> dataList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.index = index;
        this.time = time;
        this.dataList = dataList;
    }

    public User(String name, int age){}

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<String> getDataList() {
        return this.dataList;
    }

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
    }

    

}
