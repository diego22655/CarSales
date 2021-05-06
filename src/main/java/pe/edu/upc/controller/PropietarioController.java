package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Propietario;
import pe.edu.upc.service.IPropietarioService;

@Named
@RequestScoped
public class PropietarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPropietarioService mService;
	private Propietario propietario;
	List<Propietario> listaPropietarios;
	
	@PostConstruct
	public void init() {
		this.listaPropietarios = new ArrayList<Propietario>();
		this.propietario= new Propietario();
		this.listar();
	}
	
	public String nuevoPropietario() {
		this.setPropietario(new Propietario());
		return "propietario.xhtml";
	}
	
	public void insertar() {
		try {
			mService.insertar(propietario);
			limpiarPropietario();
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listar() {
		try {
			listaPropietarios = mService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void limpiarPropietario() {
		this.init();
	}
	
	public void eliminar(Propietario p) {
		try {
			mService.eliminar(p.getIdPropietario());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public List<Propietario> getListaPropietarios() {
		return listaPropietarios;
	}

	public void setListaPropietarios(List<Propietario> listaPropietarios) {
		this.listaPropietarios = listaPropietarios;
	}

	
}
