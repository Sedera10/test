package controller;

import myframework.annotation.MyMapping;
import myframework.fw.ModelView;
import myframework.annotation.GET;
import myframework.annotation.POST;
import myframework.annotation.Json;
import myframework.annotation.MyController;
import myframework.annotation.RequestParam;
import myframework.annotation.Session;

import model.Employe;

import java.util.List;
import java.util.Map;

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
    
    @Json
    @MyMapping("/employes")
    public List<Employe> getEmploye() {
        Employe emp = new Employe("Naina", "Developpeur");
        Employe emp2 = new Employe("Raja", "Manager");
        List<Employe> emps = List.of(emp, emp2);
        return emps;
    }

    // ========== EXEMPLES D'UTILISATION DE @SESSION ==========

    /**
     * Exemple 1 : Login - Ajouter un utilisateur dans la session
     */
    @POST
    @MyMapping("/login-traite")
    public String login(@Session Map<String, Object> session, 
                       @RequestParam("username") String username,
                       @RequestParam("password") String password) {
        
        // Vérification simple (à remplacer par une vraie authentification)
        if ("sedera.10".equals(username) && "sedera07".equals(password)) {
            // Ajouter l'utilisateur dans la session
            session.put("user", username);
            session.put("role", "admin");
            session.put("loginTime", System.currentTimeMillis());
            
            return "✅ Connexion réussie ! Bienvenue " + username;
        } else {
            return "❌ Identifiants incorrects";
        }
    }

    /**
     * Exemple 2 : Vérifier si l'utilisateur est connecté
     */
    @GET
    @MyMapping("/check-session")
    public String checkSession(@Session Map<String, Object> session) {
        // Lire depuis la session
        String user = (String) session.get("user");
        String role = (String) session.get("role");
        
        if (user != null) {
            Long loginTime = (Long) session.get("loginTime");
            return "👤 Utilisateur connecté : " + user + " | Rôle : " + role + " | Login : " + loginTime;
        } else {
            return "❌ Aucun utilisateur connecté";
        }
    }

    /**
     * Exemple 3 : Modifier des données de session
     */
    @POST
    @MyMapping("/update-role")
    public String updateRole(@Session Map<String, Object> session,
                            @RequestParam("newRole") String newRole) {
        
        String user = (String) session.get("user");
        if (user == null) {
            return "❌ Vous devez être connecté pour modifier le rôle";
        }
        
        // Modifier une valeur dans la session
        session.put("role", newRole);
        
        return "✅ Rôle mis à jour : " + newRole;
    }

    /**
     * Exemple 4 : Panier d'achat (ajouter un produit)
     */
    @POST
    @MyMapping("/add-to-cart")
    public String addToCart(@Session Map<String, Object> session,
                           @RequestParam("product") String product) {
        
        // Récupérer le panier existant ou créer un nouveau
        @SuppressWarnings("unchecked")
        List<String> cart = (List<String>) session.get("cart");
        
        if (cart == null) {
            cart = new java.util.ArrayList<>();
        }
        
        cart.add(product);
        session.put("cart", cart);
        
        return "✅ Produit ajouté au panier : " + product + " | Total articles : " + cart.size();
    }

    /**
     * Exemple 5 : Voir le panier
     */
    @GET
    @MyMapping("/view-cart")
    public String viewCart(@Session Map<String, Object> session) {
        @SuppressWarnings("unchecked")
        List<String> cart = (List<String>) session.get("cart");
        
        if (cart == null || cart.isEmpty()) {
            return "🛒 Panier vide";
        }
        
        return "🛒 Votre panier : " + String.join(", ", cart) + " | Total : " + cart.size() + " article(s)";
    }

    /**
     * Exemple 6 : Vider le panier (supprimer un attribut)
     */
    @POST
    @MyMapping("/clear-cart")   
    public String clearCart(@Session Map<String, Object> session) {
        // Supprimer un attribut de la session
        session.remove("cart");
        
        return "✅ Panier vidé";
    }

    /**
     * Exemple 7 : Logout - Supprimer toutes les données de session
     */
    @POST
    @MyMapping("/logout")
    public String logout(@Session Map<String, Object> session) {
        // Vider complètement la session
        session.clear();
        
        return "✅ Déconnexion réussie";
    }

    /**
     * Exemple 8 : Compteur de visites
     */
    @GET
    @MyMapping("/visit-count")
    public String visitCount(@Session Map<String, Object> session) {
        Integer count = (Integer) session.get("visitCount");
        
        if (count == null) {
            count = 0;
        }
        
        count++;
        session.put("visitCount", count);
        
        return "👁️ Nombre de visites : " + count;
    }

    /**
     * Exemple 9 : Page protégée nécessitant une session
     */
    @GET
    @MyMapping("/protected")
    public String protectedPage(@Session Map<String, Object> session) {
        String user = (String) session.get("user");
        
        if (user == null) {
            return "🔒 Accès refusé ! Veuillez vous connecter d'abord via /login";
        }
        
        return "🔓 Bienvenue sur la page protégée, " + user + " !";
    }

}
