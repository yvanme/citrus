package com.github.yiuman.citrus.system.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 数据范围类型
 *
 * @author yiuman
 * @date 2020/5/29
 */
public enum ScopeType {

    /**
     * 若等于0表示自己部门，则为当前部门
     */
    SELF(0, "自身"),

    /**
     * 包含子部门
     */
    INCLUDE_SUB(1, "包含子部门"),

    /**
     * 包含父部门
     */
    INCLUDE_SUP(2, "包含父部门");

    private final int code;

    private final String text;

    ScopeType(int code, String text) {
        this.code = code;
        this.text = text;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
