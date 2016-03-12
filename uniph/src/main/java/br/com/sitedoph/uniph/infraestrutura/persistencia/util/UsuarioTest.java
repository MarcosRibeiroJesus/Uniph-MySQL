package br.com.sitedoph.uniph.infraestrutura.persistencia.util;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

public class UsuarioTest {

	@Test
	public void deveCriarOEntityManagerFactoryEEntityManager() {

		EntityManager em = JPAUtil.getEntityManager();
		em.close();

	}

	@Test
	public void devePersistirUmAluno() {

		EntityManager em = JPAUtil.getEntityManager();

		Usuario u = new Usuario();

		u.setNomeCompleto("Marcos Ribeiro de Jesus");
		u.setLogin("Master");
		u.setSenha("1234asdf");
		u.setEmail("mrj84@outlook.com");

		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();

		// HQL
		Query query = em.createQuery("SELECT a FROM Usuario a");

		List<Usuario> list = query.getResultList();

		for (Usuario a : list) {
			System.out.println(a.getNomeCompleto());
		}

		em.close();

	}

}