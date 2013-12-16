package com.iris.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Archive
 *
 * @author: zhangteng
 * @time: 13-12-5 下午3:19
 */
@Entity
@Table(name = "t_archive")
public class Archive implements Serializable {

    @Id
    private Integer id;

    @Column(name = "admin_id")
    private Integer adminId;

    // 文章标题
    private String title;

    // 文章内容
    private String content;

    // 点击量
    @Column(name = "view_count")
    private Integer viewCount;

    // 0 隐藏，1 显示
    private Integer status;

    // 创建时间
    @Column(name = "create_time")
    private Date createTime;

    // 不与数据库关联，数据库中没有该字段，该字段仅用于前台展示用
    private String createTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
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

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}
