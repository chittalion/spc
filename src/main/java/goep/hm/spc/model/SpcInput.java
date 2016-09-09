package goep.hm.spc.model;

import java.io.Serializable;

/**
 * DTO Class for SPC Inputs
 */
public class SpcInput implements Serializable {

	private static final long serialVersionUID = 1L;
	private String numbers;

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return "SpcInput [numbers=" + numbers + "]";
	}

}
