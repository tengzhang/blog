package com.iris.common.enums;

/**
 * StatusEnum
 *
 * @author: zhangteng
 * @time: 13-12-5 下午3:28
 */
public enum StatusEnum {

    Hide(0, "隐藏"),
    Show(1, "显示");

    private Integer id;
    private String description;

    StatusEnum(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
