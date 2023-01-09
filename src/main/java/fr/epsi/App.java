package fr.epsi;

import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.service.ActorService;
import fr.epsi.context.CustomContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        // Le Service n'est plus instancié directement, mais géré par un Contexte
        ActorService service;

        // 1 - Solution Custom
        // On obtient ici l'instance du Context (patern Simgleton) avant de lui demander le Servcice
        CustomContext customContext = CustomContext.getInstance();
        service = customContext.getActorService();

        // 2- Solution avancée avec le Framework Spring (Context générique)
        // On crée ici un Context Spring à partir du fichier descripteur context.xml 
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
