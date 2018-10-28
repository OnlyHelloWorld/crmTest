package com.star.utils;

import java.util.List;

import org.apache.commons.io.output.ThresholdingOutputStream;

public class PageBean {
	private Integer currentPage;		//��ǰ��Ҫ��ʾ��ҳ��
	private Integer totalCount;         //�ܵļ�¼����
	private Integer pageSize;           //ÿҳ�ļ�¼����
	private Integer totalPage;          //�ܵ�ҳ��(���Ը����ܼ�¼����/ÿҳ�ļ�¼�����������)
	private List    list;               //��ҳ���б�����
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		
		if (currentPage == null) {
			//Ĭ����ʾ��һҳ
			this.currentPage = 1;
		}
		if (pageSize == null) {
			//Ĭ��ÿҳ��ʾ����
			this.pageSize = 3;
		}
		//�����ܵ�ҳ��
		this.totalPage = (this.totalCount + this.pageSize - 1)/this.pageSize;
		
		//�ж��û������Ƿ�Ϸ�,�Բ��Ϸ�������д���
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
		
	}
	
	//������һҳ����ʼ����
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
