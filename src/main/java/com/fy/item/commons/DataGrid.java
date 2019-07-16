package com.fy.item.commons;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 返回DataGrid类型数据
 * @param <T>
 */
@Data
public class DataGrid<T> {
	
	private Long total;
	
	private List<T> rows;

	public DataGrid() {
	}

	public DataGrid(Long total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}
}
