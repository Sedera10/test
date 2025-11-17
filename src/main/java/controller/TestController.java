package controller;

import myframework.annotation.MyMapping;
import myframework.fw.ModelView;
import myframework.annotation.MyController;

import java.util.List;

@MyController
public class TestController {

    @MyMapping(url = "/bonjour")
    public void direBonjour() {
        System.out.println("Bonjour depuis TestController !");
    }

    @MyMapping(url = "/aurevoir")
    public void direAurevoir() {
        System.out.println("Au revoir !");
    }

    @MyMapping(url = "/ecrire")
    public String ecrireChose() {
        String message = "Voici une chose écrite par TestController. (Vita sprint 4)";
        return message;
    }
    @MyMapping(url = "/hello")
    public ModelView ouverturePage() {
        ModelView mv = new ModelView();
        mv.addAttribute("message", "Finalisation du Sprint 5 framework Java ");
        mv.addAttribute("nombre", 42);
        mv.addAttribute("produits", List.of("PC", "Souris", "Clavier"));
        mv.setView("hello.jsp");
        return mv;
    }

    @MyMapping(path="/etudiant/{id}")
    public String getEtudiant(int id) {
        return "Étudiant demandé : " + id;
    }

}
