package br.ufg.inf.ctrl.negocio;

import java.util.List;

import br.ufg.inf.ctrl.exception.OfertaException;
import br.ufg.inf.model.dao.OfertaDAO;
import br.ufg.inf.model.entities.Oferta;

public class OfertaNegocio {


		OfertaDAO dao = new OfertaDAO();
		ProfessorNegocio professorNegocio = new ProfessorNegocio();
		DisciplinaNegocio disciplinaNegocio = new DisciplinaNegocio();
	
		public Oferta inserir(Oferta oferta) throws OfertaException {
			this.validarOferta(oferta);
			return dao.inserir(oferta);
		}
		
		public List<Oferta> buscaTodos() throws OfertaException{
			return dao.buscaTodos();
		}
		
		public Oferta buscaPorId(Integer id) throws OfertaException  {
			return dao.buscaPorId(id);
		}
		

		public Oferta alterar(Oferta oferta) throws OfertaException {		
			this.validarOferta(oferta);
			return dao.alterar(oferta);
		}
		
		public void excluir(Integer id) throws OfertaException {
			dao.excluir(id);
		}
		
		private void validarOferta(Oferta oferta) throws OfertaException {
			if(oferta.getDtInicio().after(oferta.getDtFim()))
				throw new OfertaException("A data de ínicio da oferta, deve ser anterior ou igual, a data de final da oferta");
		}
}
