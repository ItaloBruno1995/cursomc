package com.udemy.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDETE (1, "Pedente"),
	QUITADO (2, "Quitado"), 
	CANCELADO(3, "Cancelado");
	
	
	private int cod;
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//DEVOLVER UM TIPO DE ESTADO APARTE DE UM CODIGO
		public static  EstadoPagamento toEnum(Integer cod) {
			
			if(cod == null) {
				return null;
				
			}
			//percorre todos os valores possivel de estado pagamento(PROCURAR CODIGO INFORMADO)
			for(EstadoPagamento x: EstadoPagamento.values()) {
				if(cod.equals(x.getCod())) {
					return x; //Retorna pessoa fisica ou Pessoa Juridica
				}
			}
			throw new IllegalArgumentException("Id Invalido: "+cod);
		}
		
	
	
}
