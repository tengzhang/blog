package com.iris.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Admin
 *
 * @author: zhangteng
 * @time: 13-12-5 下午3:19
 */
@Entity
@Table(name = "t_admin")
public class Admin implements Serializable {

    @Id
    private Integer id;

    // 用户名
    private String name;

    // 密码
    private String password;

    // 0 隐藏，1 显示
    private Integer status;

    // 创建时间
    @Column(name = "create_time")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
