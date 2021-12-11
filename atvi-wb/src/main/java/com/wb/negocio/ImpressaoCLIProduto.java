package com.wb.negocio;

import com.wb.modelo.Produto;

public class ImpressaoCLIProduto implements ImpressaoCLI {
    Produto produto;

    public ImpressaoCLIProduto(Produto produto) {
        this.produto = produto;
    }

    public void imprimir() {
        System.out.println("\n" + produto.tipo + ": " + produto.nome);
        System.out.println("Pre�o: R$ " + produto.preco);
        System.out.println("Categoria: " + produto.categoria);
        System.out.println("C�digo: " + produto.codigo);
    }
    
}
