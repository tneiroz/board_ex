package com.jafa.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString


public class Criteria {

	private int page;
	private int perPageNum;
	
	//검색
	private String type;
	private String keyword;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) this.page = 1;
		else this.page = page;
	}


	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}
	
	//TC => {T,C}
	//WC => {W,C}
	// type.split("#") LEE#WCC#BB = > {LEE,WCC,BB}
	public String [] getTypeCollection() {
		return this.type !=null ? type.split("") : new String[]{};
	}
}
