package fr.epsi.actor.web;

import java.util.List;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.service.ActorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Il s'agit de notre Controller au sein du pattern MVC
 * Il doit implémenter la méthode handleRequestInternal
 * qui retourne View et Model à utiliser pour construire la réponse HTTP
 */
public class ActorWebController extends AbstractController {

    private ActorService service;

    @Override
    @Nullable
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // On récupère la liste des acteurs qui sera notre Model
        List<Actor> actors = service.listerTousLesActeurs();
        // On crée un mapper objet Java vers JSON qui sera notre VieW
        var view = new MappingJackson2JsonView();
        view.setPrettyPrint(true); // pour plus de lisibilité
        // la propriété suivante est nécessaire pour un maping JSON
        // direct de la donnée (liste d'Actor) et non une encapsulation avec la racine "actors"
        view.setExtractValueFromSingleKeyModel(true);

        return new ModelAndView(view, "actors", actors);
    }

    // Constructeur qui impose la dépendance avec un ActorService
    public ActorWebController(ActorService service) {
        this.service = service;
    }

}