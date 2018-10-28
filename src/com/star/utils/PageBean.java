package com.star.utils;

import java.util.List;

import org.apache.commons.io.output.ThresholdingOutputStream;

public class PageBean {
	private Integer currentPage;		//当前需要显示的页数
	private Integer totalCount;         //总的记录条数
	private Integer pageSize;           //每页的记录条数
	private Integer totalPage;          //总的页数(可以根据总记录条数/每页的记录条数计算求出)
	private List    list;               //分页的列表数据
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		
		if (currentPage == null) {
			//默认显示第一页
			this.currentPage = 1;
		}
		if (pageSize == null) {
			//默认每页显示三条
			this.pageSize = 3;
		}
		//计算总的页数
		this.totalPage = (this.totalCount + this.pageSize - 1)/this.pageSize;
		
		//判断用户输入是否合法,对不合法输入进行处理
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
		
	}
	
	//计算这一页的起始索引
	public int getStart() {
		return (this.currentPage - 1)*this.pageSize;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", totalCount=" + totalCount + ", pageSize=" + pageSize
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}
	
	
}
