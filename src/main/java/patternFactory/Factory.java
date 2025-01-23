package patternFactory;

import java.sql.SQLException;
import java.util.List;

public interface Factory {
    void insert(String nom, int foId, float prix, int ventes);
    void getInfo(String nom);
    List getAll() ;
    void supprimer(String nomCafe) ;

}
