package controller;

import myframework.annotation.MyMapping;
import myframework.fw.ModelView;
import myframework.annotation.GET;
import myframework.annotation.POST;
import myframework.annotation.MyController;
import myframework.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import model.Employe;

@MyController
public class FormController {

    @POST
    @MyMapping("/form/save")
    public String chercher(Map<String, Object> formData) {

        System.out.println("== Données reçues ==");
        for (String key : formData.keySet()) {
            System.out.println(key + " = " + formData.get(key));
        }

        return "OK";
    }

    @POST
    @MyMapping("/employe/save")
    public String save(Employe employe) {
        System.out.println("====== EMPLOYE RECU ======");
        System.out.println("Nom : " + employe.getNom());
        System.out.println("Prenom : " + employe.getPrenom());
        System.out.println("Poste : " + employe.getPoste());
        System.out.println("Dtn : " + employe.getDtn());
        System.out.println("Sexe : " + employe.getSexe());
        System.out.println("Actif : " + employe.isActif());
        System.out.println("Departement : " + employe.getDepartement().getNom());
        return "OK";
    }


}
