package com.mbs.algaworks.ecommerce.relacionamentos;

import com.mbs.algaworks.ecommerce.EntityManagerTest;
import com.mbs.algaworks.ecommerce.model.Pedido;
import org.junit.Assert;
import org.junit.Test;

public class EagerELazyTest extends EntityManagerTest {

    @Test
    public void verficarComportamento() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

//        pedido.getItens().isEmpty();
    }
}