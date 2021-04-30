package br.ufg.inf.ctrl;

import java.util.List;

import br.ufg.inf.ctrl.exception.MatriculaException;
import br.ufg.inf.ctrl.negocio.MatriculaNegocio;
import br.ufg.inf.model.entities.Matricula;

public class MatriculaCtrl {

	MatriculaNegocio negocio = new MatriculaNegocio();

	public Matricula inserir(Matricula matricula) {
		try {
			matricula = negocio.inserir(matricula);
			System.out.println("Matricula cadastrada com sucesso: " + matricula);
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar cadastrar matricula.");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public List<Matricula> buscaTodos() {
		List<Matricula> matriculas = null;
		try {
			matriculas = negocio.buscaTodos();
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar buscar as matriculas cadastradas.");
			System.out.println(e.getMessage());
		}
		return matriculas;
	}

	public List<Matricula> buscaPorNome(String str) {
		List<Matricula> matriculas = null;

		matriculas = negocio.buscarPorNome(str);

		return matriculas;
	}

	public Matricula buscaPorId(Integer id) {
		Matricula matricula = null;
		try {
			matricula = negocio.buscaPorId(id);
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar buscar matricula do ID: " + id + ".");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public Matricula alterar(Matricula matricula) {
		try {
			if (negocio.buscaPorId(matricula.getIdMatricula()) == null) {
				throw new MatriculaException("Erro ao consultar Matricula no BD");
			}else {
				matricula = negocio.alterar(matricula);
				System.out.println("Matricula alterada com sucesso: " + matricula);
			}
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar alterar matricula com ID: " + matricula.getIdMatricula() + ".");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public void excluir(Integer id) {
		try {
			if (negocio.buscaPorId(id) == null) {
				throw new MatriculaException("Erro ao consultar Matricula no BD");
			}else {
				negocio.excluir(id);
				System.out.println("Matricula excluída com sucesso.");
			}
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar excluir a matricula");
			System.out.println(e.getMessage());
		}
	}
}