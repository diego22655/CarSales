package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "automovil")
public class Automovil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAutomovil;
	
	@Column(name="placaAutomovil", nullable = false, length=50)
	private String placaAutomovil;

	@ManyToOne
	@JoinColumn(name="idPropietario")
	private Propietario propietario;

	public Automovil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Automovil(int idAutomovil, String placaAutomovil, Propietario propietario) {
		super();
		this.idAutomovil = idAutomovil;
		this.placaAutomovil = placaAutomovil;
		this.propietario = propietario;
	}

	public int getIdAutomovil() {
		return idAutomovil;
	}

	public void setIdAutomovil(int idAutomovil) {
		this.idAutomovil = idAutomovil;
	}

	public String getPlacaAutomovil() {
		return placaAutomovil;
	}

	public void setPlacaAutomovil(String placaAutomovil) {
		this.placaAutomovil = placaAutomovil;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
}
