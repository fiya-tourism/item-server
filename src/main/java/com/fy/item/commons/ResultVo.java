package com.fy.item.commons;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

/**
 * 提供返回前台信息
 */
@Data
public class ResultVo<T> implements Serializable {
    private Integer code;
    private String msg;
    private List<T> list;

    public ResultVo() {
    }
    public ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
