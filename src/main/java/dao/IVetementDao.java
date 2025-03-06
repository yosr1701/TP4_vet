package dao;

import java.util.List;
import metier.entities.Vetement;

public interface IVetementDao {
	
    public Vetement save(Vetement v);
    public List<Vetement> vetementsParMC(String mc);
    public Vetement getVetement(Long id);
    public Vetement updateVetement(Vetement v);
    public void deleteVetement(Long id);
    
}
