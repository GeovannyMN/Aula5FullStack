package br.ufg.inf.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufg.inf.ctrl.exception.OfertaException;
import br.ufg.inf.model.entities.Oferta;

public class OfertaDAO {

	EntityManager em = DaoFactory.getEntityManager();

	public Oferta inserir(Oferta oferta) throws OfertaException {
		this.em.getTransaction().begin();
		this.em.persist(oferta);
		this.em.getTransaction().commit();
		return oferta;
	}

	public List<Oferta> buscaTodos() throws OfertaException {
		return this.em.createQuery("from Oferta", Oferta.class).getResultList();
	}

	public Oferta buscaPorId(Integer id) throws OfertaException {
		return this.em.find(Oferta.class, id);
	}

	public Oferta alterar(Oferta oferta) throws OfertaException {
		this.em.getTransaction().begin();
		this.em.persist(oferta);
		this.em.getTransaction().commit();
		return oferta;
	}

	public void excluir(Integer id) throws OfertaException {
		this.em.remove(this.buscaPorId(id));
	}

}
