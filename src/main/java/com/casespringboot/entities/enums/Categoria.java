package com.casespringboot.entities.enums;

public enum Categoria {
	
	COMPRAS(1),
	VENDAS(2),
	FINANCEIRO(3),
	FORMULAS(4);
	
	private int code;
	
	private Categoria(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public static Categoria valueOf(int code) {
		for (Categoria value : Categoria.values()) {
			if(value.getCode() == code) {
				return value; 
			}
		}
		throw new IllegalArgumentException("Invalid code");
	}
}
