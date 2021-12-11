package com.wb.negocio;

import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;
import com.wb.modelo.RG;
import com.wb.modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private List<Telefone> telefones;
	private List<RG> rgs;
	private CPF cpf;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("\n-----CADASTRO DE CLIENTE-----");
		
		System.out.print("\nNome: ");
		String nome = entrada.receberTexto();
		System.out.print("\nNome Social: ");
		String nomeSocial = entrada.receberTexto();
		String g = "";

		boolean exec = true;
		while (exec) {
			System.out.println("\nGENÊRO ");
			System.out.print("\nM - Masculino\nF - Feminino");
			System.out.print("\nDigite a operação desejada: ");
			String operacao = entrada.receberTexto();
			
			switch (operacao) {
				case "M":
					g = "Masculino";
					exec = false;
					break;
				case "m":
					g = "Masculino";
					exec = false;
					break;
				case "F":
					g = "Feminino";
					exec = false;
					break;
				case "f":
					g = "Feminino";
					exec = false;
					break;
				default:
					System.out.println("\nOPERAÇÃO INVÁLIDA!");
					break;
			}
		}
		String genero = g;

		Cliente cliente = new Cliente(nome, nomeSocial, genero, cpf, telefones, rgs);

		Cadastro cadastroCpf = new CadastroCpf(cliente);
		cadastroCpf.cadastrar();

		Cadastro cadastroRg = new CadastroRg(cliente.getRgs());
		cadastroRg.cadastrar();
		
		Cadastro cadastroTelefone = new CadastroTelefone(cliente.getTelefones());
		cadastroTelefone.cadastrar();
		

		
		this.clientes.add(cliente);
		System.out.println("\n-----Cliente cadastrado com sucesso!-----");
	}
}