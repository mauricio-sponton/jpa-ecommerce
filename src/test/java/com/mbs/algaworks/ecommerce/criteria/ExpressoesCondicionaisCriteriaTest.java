package com.mbs.algaworks.ecommerce.criteria;

import com.mbs.algaworks.ecommerce.EntityManagerTest;
import com.mbs.algaworks.ecommerce.model.Cliente;
import com.mbs.algaworks.ecommerce.model.Cliente_;
import com.mbs.algaworks.ecommerce.model.Produto;
import com.mbs.algaworks.ecommerce.model.Produto_;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ExpressoesCondicionaisCriteriaTest extends EntityManagerTest {

    @Test
    public void usarExpressaoIsEmpty(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> criteriaQuery = criteriaBuilder.createQuery(Produto.class);
        Root<Produto> root = criteriaQuery.from(Produto.class);

        criteriaQuery.select(root);

        criteriaQuery.where(criteriaBuilder.isEmpty(root.get(Produto_.categorias)));

        TypedQuery<Produto> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Produto> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

    }

    @Test
    public void usarExpressaoIsNull(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> criteriaQuery = criteriaBuilder.createQuery(Produto.class);
        Root<Produto> root = criteriaQuery.from(Produto.class);

        criteriaQuery.select(root);

        //criteriaQuery.where(root.get(Produto_.foto).isNull());
        //criteriaQuery.where(criteriaBuilder.isNotNull(root.get(Produto_.foto)));
        criteriaQuery.where(criteriaBuilder.isNull(root.get(Produto_.foto)));

        TypedQuery<Produto> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Produto> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

    }

    @Test
    public void usarExpressaoCondicionalLike(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);

        criteriaQuery.select(root);

        criteriaQuery.where(criteriaBuilder.like(root.get(Cliente_.nome), "%a%"));

        TypedQuery<Cliente> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Cliente> lista = typedQuery.getResultList();
        Assert.assertFalse(lista.isEmpty());

        lista.forEach(cliente -> System.out.println(cliente.getNome()));
    }
}
