package com.wb;



import com.wb.io.Entrada;
import com.wb.modelo.Empresa;
import com.wb.negocio.Cadastro;
import com.wb.negocio.CadastroCliente;
import com.wb.negocio.CadastroConsumo;
import com.wb.negocio.CadastroProduto;
import com.wb.negocio.Listagem;
import com.wb.negocio.ListarConsumo;
import com.wb.negocio.ListarTodosClientes;
import com.wb.negocio.ListarTodosProdutos;

public class App {
	public static void main(String[] args) {
				
		Empresa empresa = new Empresa();
		boolean execucao = true;


		while (execucao) {
			System.out.println("\nAgenda World Beauty\n");
			
			System.out.println("\nO que deseja fazer?\n");
			System.out.println("1 - Clientes: Cadastro e lista de clientes");
			System.out.println("2 - Produtos e Serviços: Cadastro e lista de produtos");
			System.out.println("3 - Registrar nova venda e gerenciar vendas");
			System.out.println("4 - Sair");
			System.out.print("\nDigite a operação desejada: ");

			Entrada entrada = new Entrada();
			String operacao = entrada.receberTexto();
			
			switch (operacao) {
				case "1":
					boolean execCliente = true;
					while (execCliente) {
						System.out.println("\n-----CLIENTES-----\n");
						System.out.println("1 - Cadastrar novo cliente");
						System.out.println("2 - Listar clientes cadastrados");
						System.out.println("3 - Voltar");
						System.out.print("\nDigite a operação desejada: ");

						Entrada entradaCliente = new Entrada();
						String opCliente = entradaCliente.receberTexto();
						switch (opCliente) {
							case "1":
								Cadastro cadastro = new CadastroCliente(empresa.getClientes());
								cadastro.cadastrar();
								execCliente = false;
								break;
							case "2":
								Listagem listagem = new ListarTodosClientes(empresa.getClientes());
								listagem.listar();
								execCliente = false;
								break;
							case "3":
								execCliente = false;
								break;
							default:
								System.out.println("\nOPERAÇÃO INVÁLIDA!(");
						}
					}
					break;
				case "2":
					boolean execProds = true;
					while (execProds) {
						System.out.println("\n-----PRODUTOS-----\n");
						System.out.println("1 - Cadastrar novo Produto");
						System.out.println("2 - Lista de produtos e serviços mais vendidos");
						System.out.println("3 - Voltar");
						System.out.print("\nDigite a operação desejada: ");

						Entrada entradaProd = new Entrada();
						String opProd = entradaProd.receberTexto();
						switch (opProd) {
							case "1":
								Cadastro cadastroProduto = new CadastroProduto(empresa.getProdutos());
								cadastroProduto.cadastrar();
								execProds = false;
								break;
							case "2":
								Listagem listagemProdutos = new ListarTodosProdutos(empresa.getProdutos(), empresa.getConsumos());
								listagemProdutos.listar();
								execProds = false;
								break;
							case "3":
								execProds = false;
								break;
							default:
								System.out.println("\nOPERAÇÃO INVÁLIDA!(");
						}
					}
					break;
				case "3":
					boolean execConsumo = true;
					while (execConsumo) {
						System.out.println("\n-----CONSUMO-----\n");
						System.out.println("1 - Registrar consumo");
						System.out.println("2 - Listar consumo");
						System.out.println("3 - Voltar");
						System.out.print("\nDigite a operação desejada: ");
						Entrada entradaConsumo = new Entrada();
						String operacaoConsumo = entradaConsumo.receberTexto();
						switch (operacaoConsumo) {
							case "1":
								Cadastro cadastroConsumo = new CadastroConsumo(empresa.getConsumos(), empresa.getClientes(), empresa.getProdutos());
								cadastroConsumo.cadastrar();
								execConsumo = false;
								break;
							case "2":
								Listagem listarConsumo = new ListarConsumo(empresa.getConsumos());
								listarConsumo.listar();
								execConsumo = false;
								break;
							case "3":
								execConsumo = false;
								break;
							default:
								System.out.println("\nOPERAÇÃO INVÁLIDA!");
						}
					}
					break;
				case "4":
					execucao = false;
					System.out.println("\nA plataforma foi encerrada\n");
					break;
				default:
					System.out.println("\nOPERAÇÃO INVÁLIDA!a");
			}
		}
	}
}