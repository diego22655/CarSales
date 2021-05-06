package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "propietario")
public class Propietario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPropietario;
	
	@Column(name="nombreCompleto", nullable = false, length=50)
	private String nombreCompleto;

	public Propietario() {
		super();
	}

	public Propietario(int idPropietario, String nombreCompleto) {
		super();
		this.idPropietario = idPropietario;
		this.nombreCompleto = nombreCompleto;
	}

	public int getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPropietario;
		result = prime * result + ((nombreCompleto == null) ? 0 : nombreCompleto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propietario other = (Propietario) obj;
		if (idPropietario != other.idPropietario)
			return false;
		if (nombreCompleto == null) {
			if (other.nombreCompleto != null)
				return false;
		} else if (!nombreCompleto.equals(other.nombreCompleto))
			return false;
		return true;
	}
	
}
