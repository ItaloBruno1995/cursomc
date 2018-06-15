package com.udemy.cursomc.domain.enums;



public enum TipoCliente {

	PESSOAFISICA(1,"Pessoa Fisica"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int cod;
	private String descricao;
	
	
	//CONTRUTOR DE TIPO ENUM E PRIVATE
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	//METDOS GET
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
	//DEVOLVER UM TIPO DE CLIENTE APARTE DE UM CODIGO
	public static  TipoCliente toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
			
		}
		//percorre todos os valores possivel de tipo cliente(PROCURAR CODIGO INFORMADO)
		for(TipoCliente x: TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x; //Retorna pessoa fisica ou Pessoa Juridica
			}
		}
		throw new IllegalArgumentException("Id Invalido: "+cod);
	}
	
}
