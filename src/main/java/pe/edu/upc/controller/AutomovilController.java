package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Automovil;
import pe.edu.upc.entity.Propietario;

import pe.edu.upc.service.IAutomovilService;
import pe.edu.upc.service.IPropietarioService;

@Named
@RequestScoped
public class AutomovilController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAutomovilService mService;
	
	@Inject
	private IPropietarioService pService;
	
	private Automovil automovil;
	private Propietario propietario;
	
	List<Automovil> listaAutomoviles;
	List<Propietario> listaPropietarios;
	
	@PostConstruct
	public void init() {
		this.listaPropietarios = new ArrayList<Propietario>();
		this.listaAutomoviles = new ArrayList<Automovil>();
		this.automovil= new Automovil();
		this.propietario = new Propietario();
		this.listar();
		this.listarPropietario();
	}
	
	public String nuevoAutomovil() {
		this.setAutomovil(new Automovil());
		return "automovil.xhtml";
	}
	
	public void insertar() {
		try {
			mService.insertar(automovil);
			limpiarAutomovil();
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listar() {
		try {
			listaAutomoviles = mService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void listarPropietario() {
		try {
			listaPropietarios = pService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	public void limpiarAutomovil() {
		this.init();
	}
	
	public void eliminar(Automovil a) {
		try {
			mService.eliminar(a.getIdAutomovil());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public Automovil getAutomovil() {
		return automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

	public List<Automovil> getListaAutomoviles() {
		return listaAutomoviles;
	}

	public void setListaAutomoviles(List<Automovil> listaAutomoviles) {
		this.listaAutomoviles = listaAutomoviles;
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
