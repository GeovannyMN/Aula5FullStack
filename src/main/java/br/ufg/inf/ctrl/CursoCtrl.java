package br.ufg.inf.ctrl;

import java.util.List;

import br.ufg.inf.ctrl.exception.CursoException;
import br.ufg.inf.ctrl.negocio.CursoNegocio;
import br.ufg.inf.model.entities.Curso;

public class CursoCtrl {

	CursoNegocio negocio = new CursoNegocio();

	public Curso inserir(Curso curso) {
		try {
			curso = negocio.inserir(curso);
			System.out.println("Curso cadastrado com sucesso: " + curso);
		} catch (CursoException e) {
			System.out.println("Erro ao tentar cadastrar curso.");
			System.out.println(e.getMessage());
		}
		return curso;
	}

	public List<Curso> buscaTodos() {
		List<Curso> cursos = null;
		try {
			cursos = negocio.buscaTodos();
		} catch (CursoException e) {
			System.out.println("Erro ao tentar buscar os cursos cadastrados.");
			System.out.println(e.getMessage());
		}
		return cursos;
	}

	public List<Curso> buscaPorNome(String str) {
		List<Curso> cursos = null;

		cursos = negocio.buscarPorNome(str);

		return cursos;
	}

	public Curso buscaPorId(Integer id) {
		Curso curso = null;
		try {
			curso = negocio.buscaPorId(id);
		} catch (CursoException e) {
			System.out.println("Erro ao tentar buscar curso do ID: " + id + ".");
			System.out.println(e.getMessage());
		}
		return curso;
	}

	public Curso alterar(Curso curso) {
		try {
			if (negocio.buscaPorId(curso.getIdCurso()) != null) {
				curso = negocio.alterar(curso);
				System.out.println("Curso alterado com sucesso: " + curso);
			}else {
				throw new CursoException("Curso com id inexistente!");
			}
			
		} catch (CursoException e) {
			System.out.println("Erro ao tentar alterar curso com ID: " + curso.getIdCurso() + ".");
			System.out.println(e.getMessage());
		}
		return curso;
	}

	public void excluir(Integer id) {
		try {
			if (negocio.buscaPorId(id) != null) {
				negocio.excluir(id);
				System.out.println("Curso excluído com sucesso.");
			}else {
				throw new CursoException("Curso com id inexistente!");
			}
		} catch (CursoException e) {
			System.out.println("Erro ao tentar excluir o curso");
			System.out.println(e.getMessage());
		}
	}
}