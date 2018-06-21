package com.xnjcpt.domain.DTO;

public class MysqlStatusDTO {
	private String name;
	private float value;

	public MysqlStatusDTO(String name, float value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}
