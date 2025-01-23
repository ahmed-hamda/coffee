package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import PatternSingleton.DatabaseConnection;
import observablePattern.CafePublisher;
import patternFactory.Factory;

public class Cafe implements Factory {
    @Override
    public void insert(String nomCafe, int foId, float prix, int ventes) {
        String insertSQL = "INSERT INTO CAFES (NOM_CAFE, FO_ID, PRIX, VENTES) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, nomCafe);
            pstmt.setInt(2, foId);
            pstmt.setFloat(3, prix);
            pstmt.setInt(4, ventes);
            pstmt.executeUpdate();
            CafePublisher.getInstance().notifyObservers("La cafes ' "+ nomCafe +" ' a ajouter avec succ�es");
            System.out.println("Cafe inserer avec succees : " + nomCafe);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getInfo(String nomCafe) {
        String selectSQL = "SELECT * FROM CAFES WHERE NOM_CAFE = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setString(1, nomCafe);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Nom du cafes: " + rs.getString("NOM_CAFE"));
                System.out.println("FO_ID: " + rs.getInt("FO_ID"));
                System.out.println("Prix: " + rs.getFloat("PRIX"));
                System.out.println("Ventes: " + rs.getInt("VENTES"));
            } else {
                System.out.println("Cafes non trouvee: " + nomCafe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Cafe> getAll() {
        List<Cafe> cafes = new ArrayList<>();
        String selectSQL = "SELECT * FROM CAFES";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectSQL);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Cafe cafe = new Cafe();
                cafe.setNom(rs.getString("NOM_CAFE"));
                cafe.setFoId(rs.getInt("FO_ID"));
                cafe.setPrix(rs.getFloat("PRIX"));
                cafe.setVentes(rs.getInt("VENTES"));
                cafes.add(cafe);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cafes;
    }



    public void supprimer(String nomCafe) {
        String deleteSQL = "DELETE FROM CAFES WHERE NOM_CAFE = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setString(1, nomCafe);
            int rowsAffected = pstmt.executeUpdate();
            CafePublisher.getInstance().notifyObservers("La café ' "+ nomCafe +" ' a été supprimé avec succés");
            if (rowsAffected > 0) {
                System.out.println("Café supprimé avec succès : " + nomCafe);

            } else {
                System.out.println("Aucun café trouvé avec ce nom : " + nomCafe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Ajoutez des getters et setters pour les attributs de la classe
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
