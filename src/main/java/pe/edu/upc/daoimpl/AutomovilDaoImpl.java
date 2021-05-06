package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IAutomovilDao;
import pe.edu.upc.entity.Automovil;

public class AutomovilDaoImpl implements IAutomovilDao, Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "b")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Automovil automovil) {
		try {
			em.persist(automovil);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Automovil> listar() {
		List<Automovil> lista = new ArrayList<Automovil>();
		try {
			Query q = em.createQuery("select a from Automovil a"); 
			lista = (List<Automovil>) q.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idAutomovil) {
		Automovil a = new Automovil();
		try {
			a = em.getReference(Automovil.class,idAutomovil); 
			em.remove(a);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
}
