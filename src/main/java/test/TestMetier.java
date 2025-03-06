package test;

import java.util.List;
import dao.VetementDaoImpl;
import metier.entities.Vetement;

public class TestMetier {
    public static void main(String[] args) {
        VetementDaoImpl vdao = new VetementDaoImpl();
        Vetement v = vdao.save(new Vetement("Veste en cuir", "M", 120.0));
        System.out.println("Vêtement ajouté: " + v);  
        
        List<Vetement> vetements = vdao.vetementsParMC("veste");
        
        
        System.out.println("Vêtements trouvés:");
        for (Vetement vt : vetements) {
            System.out.println(vt);  
        }
    }
}
