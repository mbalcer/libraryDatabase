package com.proj.library;

import java.sql.Date;

public class BorrowBooks {
	
	private Date dateBorrow;
	private Integer count;
	
	public BorrowBooks(Date dateBorrow, Integer count) {
		this.dateBorrow = dateBorrow;
		this.count = count;
	}

	public Date getDataczas_wypozyczenia() {
		return dateBorrow;
	}

	public void setDateBorrow(Date dateBorrow) {
		this.dateBorrow = dateBorrow;
	}

	public Integer getIle() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
