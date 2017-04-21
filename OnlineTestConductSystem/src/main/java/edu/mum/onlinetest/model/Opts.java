package edu.mum.onlinetest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Opts {
	@javax.persistence.Id
	@GeneratedValue
	private int Id;
	private String opt;

	public String getOption() {
		return opt;
	}

	public void setOption(String opt) {
		this.opt = opt;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
}
