package br.com.sitedoph.uniph.infraestrutura.persistencia.util;


import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.List;

public class PersistenciaTest {

    @Test
    public void deveCriarOEntityManagerFactoryEEntityManager() {

        EntityManager em = JPAUtil.getEntityManager();
        em.close();

    }

    @Test
    public void devePersistirUmAluno() {

        EntityManager em = JPAUtil.getEntityManager();

        Aluno ze = new Aluno();

        ze.setNomeCompleto("Jos� Roberto");
        ze.setCpf("006.186.111-18");
        ze.setDataDeCadastro(Calendar.getInstance());
        ze.setEmail("ze@ze.com");
        ze.setRg("81818181");
        ze.setTelefone("61 81818181");

        em.getTransaction().begin();
        em.persist(ze);
        em.getTransaction().commit();

        // HQL
        Query query = em.createQuery("SELECT a FROM Aluno a");

        List<Aluno> list = query.getResultList();

        for (Aluno a : list) {
            System.out.println(a.getNomeCompleto());
        }

        em.close();

    }

}