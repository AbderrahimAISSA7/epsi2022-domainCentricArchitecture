package fr.epsi.actor.repository.database;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.repository.ActorRepository;

public class DatabaseActorRepository implements ActorRepository {

    // Le JDBCTemplate configuré dans le context.xml
    // il contient une référence à la DataSource vers PostgreSQL
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Actor> listActor() {

        // Cet appel prend en paramètre la requête SQL
        // ainsi qu'une fonction lambda déterminant comment
        // doit être construit le retour de chaque
        // ligne de résultat (RowMapper)
        return jdbcTemplate.query(
                "select * from actor",
                (ResultSet rs, int rowNum) -> new Actor(
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getInt("actor_id")));
    }

    // Constructeur qui impose la dépendance à un JDBCTemplate
    public DatabaseActorRepository(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }
}
