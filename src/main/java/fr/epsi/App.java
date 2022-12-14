package fr.epsi;

import java.util.List;
import java.util.Optional;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.service.ActorService;
import fr.epsi.actor.service.MyActorService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        // On instancie manuellement un Service
        // Pour le moment, le service a la connaissance du Repository qu'il doit utiliser...
        ActorService service = new MyActorService();

        // Lister tous les acteurs depuis le service
        List<Actor> actorList = service.listerTousLesActeurs();
        for (Actor actor : actorList) {
            System.out.println(actor);
        }

        // Rechercher un acteur en fonction de son id depuis le service
        int id = 13;
        Optional<Actor> actor = service.getById(id);
        if (actor.isPresent()) {
            System.out.println("Acteur d'identifiant " + id + " : " + actor.get());
        } else {
            System.out.println("Il n'existe pas d'acteur d'identifiant " + id);
        }

    }
}
