package controller;

import myframework.annotation.MyMapping;
import myframework.fw.ModelView;
import myframework.annotation.MyController;
import myframework.annotation.RequestParam;

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
    
    // Cas 1 
    @MyMapping(path="/etudiant/{id}")
    public String getEtudiant(int id) {
        return "Étudiant avec path variable : " + id;
    }

    // Cas 2 : sans {..}
    @MyMapping(url="/chercher")
    public String chercher(@RequestParam("age") int ident) {
        return "RequestParam ident = " + ident;
    }

    // Cas 3 : path variable + requestParam avec nom different 
    @MyMapping(path="/classe/{id}")
    public String etuClasse(int id, @RequestParam("niveau") int niveau) {
        return "ID path = " + id + " | niveau param = " + niveau;
    }

    // Cas 4 : Path variable + RequestParam avec le même nom
    @MyMapping(path="/verif/{id}")
    public String verif(@RequestParam("id") int ident, int id) {
        return "PATH id = " + id + " | REQUEST id = " + ident;
    }

    @MyMapping(path="/classe/{id}/niveau/{niveau}")
    public String etClasse(int id, @RequestParam("niveau") int niveau) {
        return "ID path = " + id + " | niveau param = " + niveau;
    }
}
