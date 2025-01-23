package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import PatternSingleton.DatabaseConnection;
import observablePattern.ViennoiseriePublisher;
import patternFactory.Factory;

public class Viennoiserie implements Factory {

    @Override
    public void insert(String nomViennoiserie, int foId, float prix, int ventes) {
        String insertSQL = "INSERT INTO vanoiserie (NOM_VANOISE, FO_ID, PRIX, VENTES) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, nomViennoiserie);
            pstmt.setInt(2, foId);
            pstmt.setFloat(3, prix);
            pstmt.setInt(4, ventes);
            pstmt.executeUpdate();
            ViennoiseriePublisher.getInstance().notifyObservers("La viennoiserie ' "+nomViennoiserie+" ' a été ajoutée avec succés ");
            System.out.println("models.Viennoiserie insérée avec succès : " + nomViennoiserie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getInfo(String nomViennoiserie) {
        String selectSQL = "SELECT * FROM vanoiserie WHERE NOM_VANOISE = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setString(1, nomViennoiserie);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Nom de la viennoiserie: " + rs.getString("NOM_VANOISE"));
                System.out.println("FO_ID: " + rs.getInt("FO_ID"));
                System.out.println("Prix: " + rs.getFloat("PRIX"));
                System.out.println("Ventes: " + rs.getInt("VENTES"));
            } else {
                System.out.println("models.Viennoiserie non trouvée: " + nomViennoiserie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Viennoiserie> getAll() {
        List<Viennoiserie> viennoiseries = new ArrayList<>();
        String selectSQL = "SELECT * FROM vanoiserie";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectSQL);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Viennoiserie viennoiserie = new Viennoiserie();
                viennoiserie.setNom(rs.getString("NOM_VANOISE"));
                viennoiserie.setFoId(rs.getInt("FO_ID"));
                viennoiserie.setPrix(rs.getFloat("PRIX"));
                viennoiserie.setVentes(rs.getInt("VENTES"));
                viennoiseries.add(viennoiserie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viennoiseries;
    }

    public void supprimer(String nomVan) {
        String deleteSQL = "DELETE FROM vanoiserie WHERE NOM_VANOISE = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setString(1, nomVan);
            int rowsAffected = pstmt.executeUpdate();
            ViennoiseriePublisher.getInstance().notifyObservers("La viennoiserie ' "+nomVan+" ' a été supprimée avec succés");

            if (rowsAffected > 0) {
                System.out.println("Viennoiserie supprimé avec succès : " + nomVan);
            } else {
                System.out.println("Aucun Viennoiserie trouvé avec ce nom : " + nomVan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Attributs et getters/setters
    private String nom;
    private int foId;
    private float prix;
    private int ventes;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getFoId() {
        return foId;
    }

    public void setFoId(int foId) {
        this.foId = foId;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getVentes() {
        return ventes;
    }

    public void setVentes(int ventes) {
        this.ventes = ventes;
    }
}
