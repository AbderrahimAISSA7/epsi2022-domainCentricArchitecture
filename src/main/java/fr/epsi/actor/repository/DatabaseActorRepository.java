package fr.epsi.actor.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.actor.model.Actor;

public class DatabaseActorRepository implements ActorRepository {

    private static final String url = "jdbc:postgresql://epsi.simplearetenir.com:5432/sakila";

    @Override
    public List<Actor> listActor() {

        List<Actor> actorList = new ArrayList<>();

        java.util.Properties props = new java.util.Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "epsi");

        try {
            // Obtention d'une connexion à la base de données
            Connection conn = DriverManager.getConnection(url, props);

            // Exécution de la requête
            String query = "select * from actor";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // Itération sur les résultats
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                Integer id = rs.getInt("actor_id");
                // Pour chaque ligne de résultat, on crée un objet
                // Actor et on l'ajoute à la liste
                Actor actor = new Actor(last_name, first_name, id);
                actorList.add(actor);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return actorList;
    }

}
