package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;

public class CadastroProduto extends Cadastro {
	
	private List<Produto> produtos;
	private Entrada entrada;
	
	public CadastroProduto(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub

	}

}
