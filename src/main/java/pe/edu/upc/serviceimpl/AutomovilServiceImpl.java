package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IAutomovilDao;
import pe.edu.upc.entity.Automovil;
import pe.edu.upc.service.IAutomovilService;

@Named
@RequestScoped
public class AutomovilServiceImpl implements IAutomovilService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAutomovilDao mD;
	
	@Override
	public void insertar(Automovil automovil) {
		mD.insertar(automovil);
	}
	
	@Override
	public List<Automovil> listar() {
		return mD.listar();
	}
	
	@Override
	public void eliminar(int idAutomovil) {
		mD.eliminar(idAutomovil);
	}
}
