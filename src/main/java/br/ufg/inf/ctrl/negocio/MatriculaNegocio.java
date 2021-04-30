package br.ufg.inf.ctrl.negocio;

import java.util.List;

import br.ufg.inf.ctrl.exception.MatriculaException;
import br.ufg.inf.model.dao.MatriculaDAO;
import br.ufg.inf.model.entities.Matricula;

public class MatriculaNegocio {
	
	MatriculaDAO dao = new MatriculaDAO();
	
	public Matricula inserir(Matricula matricula) throws MatriculaException{
		this.validarMatricula(matricula);
		return dao.inserir(matricula);
	}
	
	public List<Matricula> buscaTodos() throws MatriculaException{
		return dao.buscaTodos();	
	}
	
	public Matricula buscaPorId(Integer id) throws MatriculaException {
		return dao.buscaPorId(id);
	}

	public Matricula alterar(Matricula pessoa) throws MatriculaException {		
		this.validarMatricula(pessoa);
		return dao.alterar(pessoa);
	}

	public void excluir(Integer id) throws MatriculaException {
		dao.excluir(id);
	}
	
	private void validarMatricula(Matricula matricula) throws MatriculaException{
		if(matricula.getIdMatricula().equals(null))
			throw new MatriculaException("O id da matrícula não pode ser nulo");
	}

	public List<Matricula> buscarPorNome(String str) {
		return dao.buscarPorNome(str);
	}
	
}
