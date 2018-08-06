package com.demo.example.grpc.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 用户信息表
 * 表名 : t_user
 * </pre>
 * @author: Mybatis Generator
 */
public class User {
    /**
     * <pre>
     * 主键
     * 表字段 : t_user.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 用户编码
     * 表字段 : t_user.code
     * </pre>
     */
    private String code;

    /**
     * <pre>
     * 用户姓名
     * 表字段 : t_user.name
     * </pre>
     */
    private String name;

    /**
     * <pre>
     * 年龄
     * 表字段 : t_user.age
     * </pre>
     */
    private Integer age;

    /**
     * <pre>
     * 金额
     * 表字段 : t_user.amount
     * </pre>
     */
    private BigDecimal amount;

    /**
     * <pre>
     * 性别：0.未知 1.男 2.女
     * 表字段 : t_user.gender
     * </pre>
     */
    private Integer gender;

    /**
     * <pre>
     * 生日
     * 表字段 : t_user.birthday
     * </pre>
     */
    private Date birthday;

    /**
     * <pre>
     * 主键
     * 表字段 : t_user.id
     * </pre>
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 主键
     * 表字段 : t_user.id
     * </pre>
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 用户编码
     * 表字段 : t_user.code
     * </pre>
     */
    public String getCode() {
        return code;
    }

    /**
     * <pre>
     * 用户编码
     * 表字段 : t_user.code
     * </pre>
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * <pre>
     * 用户姓名
     * 表字段 : t_user.name
     * </pre>
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 用户姓名
     * 表字段 : t_user.name
     * </pre>
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 年龄
     * 表字段 : t_user.age
     * </pre>
     */
    public Integer getAge() {
        return age;
    }

    /**
     * <pre>
     * 年龄
     * 表字段 : t_user.age
     * </pre>
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * <pre>
     * 金额
     * 表字段 : t_user.amount
     * </pre>
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * <pre>
     * 金额
     * 表字段 : t_user.amount
     * </pre>
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * <pre>
     * 性别：0.未知 1.男 2.女
     * 表字段 : t_user.gender
     * </pre>
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * <pre>
     * 性别：0.未知 1.男 2.女
     * 表字段 : t_user.gender
     * </pre>
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * <pre>
     * 生日
     * 表字段 : t_user.birthday
     * </pre>
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * <pre>
     * 生日
     * 表字段 : t_user.birthday
     * </pre>
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}