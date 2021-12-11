package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Consumo;
import com.wb.modelo.Produto;

public class ListarTodosProdutos extends Listagem {
	private List<Produto> produtos;
	private List<Consumo> consumos;

	public ListarTodosProdutos(List<Produto> produtos, List<Consumo> consumos) {
		this.produtos = produtos;
		this.consumos = consumos;
	}

	@Override
	public void listar() {
		System.out.println("\nLISTA DE PRODUTOS/SERVI�OS");
		String filtro = "";

		boolean exec = true;
		while (exec) {
			System.out.println("\nPOR TIPO:");
			Entrada entrada = new Entrada();
			System.out.println("\n1 - Produto");
			System.out.println("2 - Servi�o");
			System.out.println("3 - Todos");
			System.out.println("4 - 10 Mais consumidos");
			System.out.println("5 - Mais consumidos por g�nero");
			System.out.print("\nEscolha uma op��o: ");
			String operacao = entrada.receberTexto();
			switch (operacao) {
				case "1":
					filtro = "Produto";
					System.out.println("\nPRODUTOS");
					exec = false;
					break;
				case "2":
					filtro = "Servi�o";
					System.out.println("\nSERVI�OS");
					exec = false;
					break;
				case "3":
					filtro = "Todos";
					System.out.println("\nPRODUTOS & SERVI�OS");
					exec = false;
					break;
				case "4":
					System.out.println("\nPRODUTOS & SERVI�OS MAIS CONSUMIDOS");
					Listagem listaMaisConsumidos = new ListarMaisConsumidos(produtos, consumos);
					listaMaisConsumidos.listar();
					exec = false;
					return;
				case "5":
					System.out.println("\n PRODUTOS & SERVI�OS MAIS CONSUMIDOS");
					Listagem listaMaisConsumidosGenero = new ListarMaisConsumidosGenero(produtos, consumos);
					listaMaisConsumidosGenero.listar();
					exec = false;
					break;
				default:
					System.out.println("\nOp��o inv�lida :(");
					break;
			}
		}

		for (Produto produto : produtos) {
			if (filtro.equals("Todos")) {
				ImpressaoCLI impressaoProd = new ImpressaoCLIProduto(produto);
				impressaoProd.imprimir();
			} else {
				if (filtro.equals(produto.tipo)) {
					ImpressaoCLI impressaoProd = new ImpressaoCLIProduto(produto);
					impressaoProd.imprimir();
				}
			}
			
		}
	}

}
