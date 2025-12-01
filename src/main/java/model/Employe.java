package model;

import java.util.Date;
import java.util.List;

public class Employe {
    private String nom;
    private String prenom;
    private Date dtn;
    private String sexe;
    private String poste;
    private boolean actif = true;
    private Departement departement;
    private List<String> competences;

    public Employe() {}

    public Employe(String nom, String poste) {
        this.nom = nom;
        this.poste = poste;
    }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getPoste() { return poste; }

    public void setPoste(String poste) { this.poste = poste; }

    public String getPrenom() { return prenom; }   

    public void setPrenom(String prenom) { this.prenom = prenom; }

    public Date getDtn() { return dtn; }

    public void setDtn(Date dtn) { this.dtn = dtn; }

    public String getSexe() { return sexe; }

    public void setSexe(String sexe) { this.sexe = sexe; }   

    public boolean isActif() { return actif; }
    public void setActif(boolean actif) { this.actif = actif; }

    public Departement getDepartement() { return departement; }

    public void setDepartement(Departement departement) { this.departement = departement; }

    public List<String> getCompetences() { return competences; }

    public void setCompetences(List<String> competences) { this.competences = competences; }

    public int getAge(){ return 20;}

}