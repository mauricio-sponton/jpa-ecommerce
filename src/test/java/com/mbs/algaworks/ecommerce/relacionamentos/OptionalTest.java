package com.mbs.algaworks.ecommerce.relacionamentos;

import com.mbs.algaworks.ecommerce.EntityManagerTest;
import com.mbs.algaworks.ecommerce.model.Pedido;
import org.junit.Test;

import java.util.List;

public class OptionalTest extends EntityManagerTest {

    @Test
    public void verficarComportamento() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

    }
}