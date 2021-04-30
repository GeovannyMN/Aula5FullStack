package br.ufg.inf.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufg.inf.ctrl.exception.ProfessorException;
import br.ufg.inf.model.entities.Professor;

public class ProfessorDAO {

	EntityManager em = DaoFactory.getEntityManager();

	// CREATE
	public Professor inserir(Professor professor) throws ProfessorException {

		this.em.getTransaction().begin();
		this.em.persist(professor);
		this.em.getTransaction().commit();

		return professor;
	}

	// READ
	public List<Professor> buscaTodos() throws ProfessorException {
		return this.em.createQuery("from Professor", Professor.class).getResultList();
	}

	public Professor buscaPorId(Integer id) throws ProfessorException {
		return this.em.find(Professor.class, id);
	}

	// UPDATE

	public Professor alterar(Professor professor) throws ProfessorException {

		this.em.getTransaction().begin();
		this.em.persist(professor);
		this.em.getTransaction().commit();

		return professor;
	}

	// DELETE

	public void excluir(Integer id) throws ProfessorException {
		this.em.remove(this.buscaPorId(id));
	}
	
	
	public List<Professor> buscarPorNome(String str){
		String sql = "from Professor d where d.nmProfessor like :str";
		TypedQuery<Professor> query = em.createQuery(sql, Professor.class);
		query.setParameter("str", "%"+str+"%");
		return query.getResultList();
	}
}
