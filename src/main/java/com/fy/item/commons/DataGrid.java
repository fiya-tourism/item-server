package com.fy.item.commons;

import lombok.Data;

import java.util.List;

/**
 * 返回DataGrid类型数据
 * @param <T>
 */
@Data
public class DataGrid<T> {
	
	private Long total;
	
	private List<T> rows;

}
