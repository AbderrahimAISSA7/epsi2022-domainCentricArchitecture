package fr.epsi;

import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.service.ActorService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        // Le Service n'est plus instancié directement, mais géré par un Contexte
        ActorService service;

        // On crée ici un Context Spring à partir du fichier descripteur context.xml 
        // le context permet de configurer nos objets (Beans) et leurs dépendances
        ApplicationContext springContext = new ClassPathXmlApplicationContext("context.xml");
        service = springContext.getBean(ActorService.class);

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
