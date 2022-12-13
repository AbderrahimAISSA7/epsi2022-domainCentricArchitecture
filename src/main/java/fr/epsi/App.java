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

        ActorService service = new MyActorService();
        List<Actor> actorList = service.listerTousLesActeurs();

        for (Actor actor : actorList) {
            System.out.println(actor);
        }

        int id = 13;
        Optional<Actor> actor = service.getById(id);
        if (actor.isPresent()) {
            System.out.println("Acteur d'identifiant " + id + " : " + actor.get());
        } else {
            System.out.println("Il n'existe pas d'acteur d'identifiant " + id);
        }

    }
}
