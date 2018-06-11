package com.xnjcpt.domain.DTO;

public class CpuUserStateRadioDTO {
	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public CpuUserStateRadioDTO(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

}
