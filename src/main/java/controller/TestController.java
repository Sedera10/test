package controller;

import myframework.annotation.MyMapping;
import myframework.fw.ModelView;
import myframework.annotation.GET;
import myframework.annotation.POST;
import myframework.annotation.MyController;
import myframework.annotation.RequestParam;

import java.util.List;

@MyController
public class TestController {

    @MyMapping("/bonjour")
    public void direBonjour() {
        System.out.println("Bonjour depuis TestController !");
    }

    @MyMapping("/aurevoir")
    public void direAurevoir() {
        System.out.println("Au revoir !");
    }

    @MyMapping("/ecrire")
    public String ecrireChose() {
        String message = "Voici une chose écrite par TestController. (Vita sprint 4)";
        return message;
    }

    // Cas 1 
    @MyMapping("/etudiant/{id}")
    public String getEtudiant(int id) {
        return "Étudiant avec path variable : " + id;
    }

    // Cas 2 : sans {..}
    @GET
    @MyMapping("/chercher")
    public String chercher(@RequestParam("nom") String ident) {
        return "Bonjour et bienvenue : " + ident;
    }

    // Cas 3 : path variable + requestParam avec nom different 
    @MyMapping("/classe/{id}")
    public String etuClasse(int id, @RequestParam("niveau") int niveau) {
        return "ID path = " + id + " | niveau param = " + niveau;
    }

    // Cas 4 : Path variable + RequestParam avec le même nom
    @MyMapping("/verif/{id}")
    public String verif(@RequestParam("id") int ident, int id) {
        return "PATH id = " + id + " | REQUEST id = " + ident;
    }
    //Cas 5 : RequestParam non obligatoire
}
