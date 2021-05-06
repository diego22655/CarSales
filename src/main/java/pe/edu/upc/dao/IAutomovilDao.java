package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Automovil;

public interface IAutomovilDao {
	public void insertar(Automovil automovil);
	public List<Automovil> listar();
	public void eliminar(int idAutomovil);
}
