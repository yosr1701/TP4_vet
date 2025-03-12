package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Vetement;
import util.JPAutil;

public class VetementDaoImpl implements IVetementDao {
	private EntityManager entityManager = JPAutil.getEntityManager("ProjVET");

	@Override
	public Vetement save(Vetement v) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(v);
		tx.commit();
		return v;
	}

	@Override
	public List<Vetement> vetementsParMC(String mc) {
		return entityManager.createQuery("SELECT v FROM Vetement v WHERE v.nomVet LIKE :mc", Vetement.class)
				.setParameter("mc", "%" + mc + "%").getResultList();
	}

	@Override
	public Vetement getVetement(Long id) {
		return entityManager.find(Vetement.class, id);
	}

	@Override
	public Vetement updateVetement(Vetement v) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		v = entityManager.merge(v);
		tx.commit();
		return v;
	}

	@Override
	public void deleteVetement(Long id) {
		Vetement vetement = entityManager.find(Vetement.class, id);
		if (vetement != null) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(vetement);
			tx.commit();
		}
	}
}
