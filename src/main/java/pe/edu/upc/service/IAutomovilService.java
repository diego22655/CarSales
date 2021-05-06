package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Automovil;

public interface IAutomovilService {
	public void insertar(Automovil automovil);
	public List<Automovil> listar();
	public void eliminar(int idAutomovil);
}
