package com.mbs.algaworks.ecommerce.service;

import com.mbs.algaworks.ecommerce.model.Pedido;

public class NotaFiscalService {

    public void gerar(Pedido pedido) {
        System.out.println("Gerando nota para o pedido " + pedido.getId() + ".");
    }
}