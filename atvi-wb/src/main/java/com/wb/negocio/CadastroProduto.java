package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

public class CadastroProduto extends Cadastro {
	private List<Produto> produtos;
	private Entrada entrada;
	
	public CadastroProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		
		System.out.println("\nCADASTRO DE PRODUTO E SERVIÇOS");
		String tipo = "";
		String categoria = "";
		
		boolean exec = true;
		while (exec) {
			System.out.print("\n1 -Novo produtos\n2 - Novo serviço\n");
			
			Entrada entradaTipo = new Entrada();
			System.out.print("\nDigite a operação desejada: ");
			String operacao = entradaTipo.receberTexto();
			switch (operacao) {
				case "1":
					tipo = "Produto";
					exec = false;
					break;
				case "2":
					tipo = "Serviço";
					exec = false;
					break;
				default:
					System.out.println("\nOPERAÇÃO INVÁLIDA!(");
			}
		}

		Double preco = 0.0;
		String codigo = "0";
		System.out.print("\nNome: ");
		String nome = entrada.receberTexto();
		boolean execPreco = true;
		while (execPreco) {
			try {
				Entrada entradaPreco = new Entrada();
				System.out.print("Digite o Preço (Utilize 'Ponto .' para separar as casas decimais): \nR$ ");
				String p = entradaPreco.receberTexto();
				preco = Double.parseDouble(p);
				System.out.print("Código do produto: ");
				Entrada entradaCod = new Entrada();
				codigo = entradaCod.receberTexto();
				execPreco = false;
			} catch (Exception e) {
				
				System.out.println("\nPreço Inválido!\n");
			}
		}

		boolean execCategoria = true;
		while (execCategoria) {
			System.out.print("nF - Feminino\nM - Masculino\n");
			Entrada entradaCategoria = new Entrada();
			System.out.print("\nEscolha uma opção: ");
			String c = entradaCategoria.receberTexto();
			switch (c) {
				case "F":
					categoria = "Feminino";
					execCategoria = false;
					break;
				case "f":
					categoria = "Feminino";
					execCategoria = false;
					break;
				case "M":
					categoria = "Masculino";
					execCategoria = false;
					break;
				case "m":
					categoria = "Masculino";
					execCategoria = false;
					break;
				default:
					System.out.println("\nOPERAÇÃO INVÁLIDA!");
			}
		}
		
		Produto produto = new Produto(nome, preco, categoria, codigo, tipo);
		this.produtos.add(produto);
		ImpressaoCLI impressaoProd = new ImpressaoCLIProduto(produto);
		impressaoProd.imprimir();
		System.out.println("\n-----Cadastrado com sucesso!-----");
	
	}

}
