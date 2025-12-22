package controller;

import myframework.annotation.MyMapping;
import myframework.fw.ModelView;
import myframework.fw.FileUpload;
import myframework.annotation.GET;
import myframework.annotation.POST;
import myframework.annotation.Json;
import myframework.annotation.MyController;
import myframework.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@MyController
public class HomeController {

    @Json
    @POST
    @MyMapping("/form")
    public ModelView toForm() {
        ModelView mv = new ModelView();
        mv.addAttribute("message", "Teste du Sprint 9 !");
        mv.setView("pages/form.jsp");
        return mv;
    }

    @Json
    @MyMapping("/hello")
    public ModelView toHello() {
        ModelView mv = new ModelView();
        mv.addAttribute("message", "Finalisation du Sprint 5 framework Java ");
        mv.addAttribute("nombre", 42);
        mv.addAttribute("produits", List.of("PC", "Souris", "Clavier"));
        mv.setView("hello.jsp");
        return mv;
    }

    @MyMapping("/upload-form")
    public ModelView uploadForm() {
        ModelView mv = new ModelView();
        mv.setView("upload.jsp");
        return mv;
    }

    @POST
    @MyMapping("/upload")
    public ModelView uploadFile(Map<String, Object> formData, @RequestParam("titre") String titre) {
        ModelView mv = new ModelView();
        
        // Récupération des données du formulaire
        String description = (String) formData.get("description");
        String categorie = (String) formData.get("categorie");
        
        // Récupération du fichier uploadé
        FileUpload fichier = (FileUpload) formData.get("fichier");
        
        if (fichier != null) {
            String fileName = fichier.getFileName();
            String fileType = fichier.getContentType();
            int fileSize = fichier.getSize();
            byte[] fileBytes = fichier.getFileBytes();
            
            // Log pour debug
            System.out.println("=== UPLOAD REÇU ===");
            System.out.println("Titre: " + titre);
            System.out.println("Description: " + description);
            System.out.println("Catégorie: " + categorie);
            System.out.println("Nom fichier: " + fileName);
            System.out.println("Type: " + fileType);
            System.out.println("Taille: " + fileSize + " octets");
            System.out.println("Bytes reçus: " + (fileBytes != null ? "OUI" : "NON"));
            
            // sauvegarde du fichier
            try {
                String projectPath = "D:/ITU/S5/Naina/Framework/Sprint/test/src/main/webapp/upload";
                String savedPath = fichier.saveToAbsolutePath(projectPath);
                System.out.println("✅ Fichier sauvegardé (projet source): " + savedPath);
                String deployedPath = fichier.saveTo("upload");
                System.out.println("✅ Fichier sauvegardé (déployé): " + deployedPath);
                mv.addAttribute("savedPath", savedPath);
                mv.addAttribute("deployedPath", deployedPath);
                
            } catch (Exception e) {
                System.err.println("❌ Erreur de sauvegarde: " + e.getMessage());
                mv.addAttribute("saveError", e.getMessage());
            }
            
            // Ajout des informations à la vue
            mv.addAttribute("titre", titre);
            mv.addAttribute("description", description);
            mv.addAttribute("categorie", categorie);
            mv.addAttribute("fileName", fileName);
            mv.addAttribute("fileType", fileType);
            mv.addAttribute("fileSize", fileSize);
            mv.addAttribute("message", "Fichier uploadé avec succès ! (" + fileSize + " octets)");
        } else {
            mv.addAttribute("message", "Aucun fichier reçu !");
        }
        
        mv.setView("pages/upload-result.jsp");
        return mv;
    }
}
