package br.ufg.inf.ctrl.negocio;

import java.util.Calendar;
import java.util.List;

import br.ufg.inf.ctrl.exception.PessoaException;
import br.ufg.inf.model.dao.PessoaDAO;
import br.ufg.inf.model.entities.Pessoa;

public class PessoaNegocio {

		PessoaDAO dao = new PessoaDAO();
	
		public Pessoa inserir(Pessoa pessoa) throws PessoaException {
			this.validarPessoa(pessoa);
			return dao.inserir(pessoa);
		}
		
		public List<Pessoa> buscaTodos() throws PessoaException{
			return dao.buscaTodos();	
		}
		
		public Pessoa buscaPorId(Integer id) throws PessoaException {
			return dao.buscaPorId(id);
		}

		public Pessoa alterar(Pessoa pessoa) throws PessoaException {		
			this.validarPessoa(pessoa);
			return dao.alterar(pessoa);
		}

		public void excluir(Integer id) throws PessoaException {
			dao.excluir(id);
		}
		
		private void validarPessoa(Pessoa pessoa) throws PessoaException {
			
			if (pessoa.getNmPessoa() == null || pessoa.getNmPessoa().length() == 0) {
				throw new PessoaException("Nome da pessoa é obrigatório.");
			}

			if (pessoa.getCpf().toString().length() != 11) {
				throw new PessoaException("CPF deve ter pelo menos 11 algarismos.");
			}
			
			Calendar calHoje = Calendar.getInstance();
			Calendar calNascimento = Calendar.getInstance();
			calNascimento.setTime(pessoa.getDtNascimento());
			
			if (calHoje.before(calNascimento)) {
				throw new PessoaException("Data de Nascimento deve ser maior que hoje.");
			}

		}
}
