package com.jason.greendao.bean;

import com.jason.greendao.db.StringConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;

import java.util.List;

/**
 * Created by JiaBo on 2017/9/19.
 */
@Entity
public class User {

    @Id
    private Long id;
    @Index(unique = true)
    private String userId;
    @Property(nameInDb = "NAME")
    private String name;
    private int age;
    private int index;
    @Convert(columnType = String.class, converter = StringConverter.class)
    private List<String> dataList;

    @Generated(hash = 2000194446)
    public User(Long id, String userId, String name, int age, int index,
            List<String> dataList) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.index = index;
        this.dataList = dataList;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
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
    public List<String> getDataList() {
        return this.dataList;
    }
    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
    }

}
