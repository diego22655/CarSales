package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPropietarioDao;
import pe.edu.upc.entity.Propietario;

public class PropietarioDaoImpl implements IPropietarioDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Propietario propietario) {
		try {
			em.persist(propietario);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Propietario> listar() {
		List<Propietario> lista = new ArrayList<Propietario>();
		try {
			Query q = em.createQuery("select p from Propietario p"); 
			lista = (List<Propietario>) q.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idPropietario) {
		Propietario p = new Propietario();
		try {
			p = em.getReference(Propietario.class,idPropietario); 
			em.remove(p);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
}
