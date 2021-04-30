package br.ufg.inf.app;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;

import br.ufg.inf.ctrl.AlunoCtrl;
import br.ufg.inf.ctrl.CursoCtrl;
import br.ufg.inf.model.entities.Aluno;
import br.ufg.inf.model.entities.Curso;
import br.ufg.inf.model.entities.Disciplina;
import br.ufg.inf.model.entities.Matricula;
import br.ufg.inf.model.entities.Oferta;
import br.ufg.inf.model.entities.Pessoa;
import br.ufg.inf.model.entities.Professor;

public class Testes {
	public static void Aluno()
	{
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
			EntityManager em = emf.createEntityManager();
			
			SimpleDateFormat formatada = new SimpleDateFormat("dd/MM/yyyy"); 
			
			Pessoa p = new Pessoa (null, "Alfa", (long) 7777777, formatada.parse("23/11/1995"));
			Pessoa q = new Pessoa (null, "Beta", (long) 8888888, formatada.parse("13/10/2005"));
			Pessoa r = new Pessoa (null, "Gama", (long) 9999999, formatada.parse("03/09/2015"));
			Curso k = new Curso (null, "Inesquecivel");
			
			em.getTransaction().begin();
			em.persist(p);
			em.persist(q);
			em.persist(r);
			em.persist(k);
			em.getTransaction().commit();
			
			Aluno a = new Aluno (null, formatada.parse("23/11/2015"), true, p, k);
			Aluno b = new Aluno (null, formatada.parse("13/10/2020"), true, q, k);
			Aluno c = new Aluno (null, formatada.parse("03/01/2025"), false, r, k);
			
			em.getTransaction().begin();
			em.persist(a);
			em.persist(b);
			em.persist(c);
			em.getTransaction().commit();
			
			AlunoCtrl AlunoVer = new AlunoCtrl();
			System.out.println( AlunoVer.buscaTodos());
			System.out.println( AlunoVer.buscaPorNome("Medio"));
			System.out.println(  AlunoVer.buscaPorId(1));
			System.out.println( AlunoVer.alterar(c));
			AlunoVer.excluir(7);
			AlunoVer.buscaTodos();
		}catch (PersistenceException e ) {
			System.out.println("Erro ao conectar Aluno com o BD");
			System.out.println(e.getMessage());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void Curso ()
	{
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
			EntityManager em = emf.createEntityManager();
			
			Curso a = new Curso(null, "Basico");
			Curso b = new Curso(null, "Medio");
			Curso c = new Curso(null, "Avancado");
			
			em.getTransaction().begin();
			em.persist(a);
			em.persist(b);
			em.persist(c);
			em.getTransaction().commit();
			
			Curso d = new Curso(null, "Apagavel");
			em.getTransaction().begin();
			em.persist(d);
			em.getTransaction().commit();
			
			CursoCtrl cursoVer = new CursoCtrl();
			System.out.println(cursoVer.buscaTodos());
			System.out.println(cursoVer.buscaPorNome("Medio"));
			/*
			System.out.println(cursoVer.buscaPorId(1));
			System.out.println(cursoVer.alterar(d));
			cursoVer.excluir(7);
			cursoVer.buscaTodos();*/
		}catch (PersistenceException e) {
			System.out.println("Erro ao conectar Curso com o BD");
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public static void Matricula ()
	{
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
			EntityManager em = emf.createEntityManager();

			SimpleDateFormat formatada = new SimpleDateFormat("dd/MM/yyyy"); 
			
			Pessoa pes1 = new Pessoa ();
			Pessoa pes2 = new Pessoa ();
			pes1.setNmPessoa("Adalto");
			pes2.setNmPessoa("Barreiras");
			
			Aluno alu1 = new Aluno();
			Aluno alu2 = new Aluno();
			
			Professor prof1 = new Professor();
			Disciplina disc1 = new Disciplina();
			
			Oferta o = new Oferta ();
			
			Matricula a = new Matricula(null, alu1, o);
			Matricula b = new Matricula(null, alu2, o);
			
			em.getTransaction().begin();
			em.persist(a);
			em.persist(b);
			em.getTransaction().commit();
			
			CursoCtrl matriculaVer = new CursoCtrl();
			System.out.println(matriculaVer.buscaTodos());
			System.out.println(matriculaVer.buscaPorId(a.getIdMatricula()));
			matriculaVer.excluir(b.getIdMatricula());
			matriculaVer.buscaTodos();
		}catch (PersistenceException e) {
			System.out.println("Erro ao conectar Matricula com o BD");
			System.out.println(e.getMessage());
		}
		
	}
}
