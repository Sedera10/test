<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sprint 8 | Formulaire Complet</title>
</head>
<body>
    <h3>Formulaire Pour le test Sprint 8</h3>

    <div>
        <form action="employe/save" method="post">

            <label>Nom :</label>
            <input type="text" name="nom" value="RANDRIANANTENAINA" required>
            <br><br>

            <label>Prenom :</label>
            <input type="text" name="prenom" value="Sedera Valisoa">
            <br><br>

            <label>Poste :</label>
            <input type="text" name="poste" value="Developpeur Java">
            <br><br>

            <label>Date de naissance :</label>
            <input type="date" name="dtn" value="2004-09-07">
            <br><br>

            <!-- SEXE (ajouté pour correspondre à ton objet) -->
            <label>Sexe :</label><br>
            <input type="radio" name="sexe" value="H"> Homme <br>
            <input type="radio" name="sexe" value="F"> Femme <br><br>

            <!-- ACTIF -->
            <label>Status :</label><br>
            <input type="radio" name="actif" value="true"> Actif<br>
            <input type="radio" name="actif" value="false"> Inactif<br><br>

            <h4>Département</h4>

            <label>Nom département :</label>
            <input type="text" name="departement.nom" value="Informatique">

            <label>Code département :</label>
            <input type="number" name="departement.code" value="101">
            <br><br>

            <h4>Compétences (List<String>)</h4>

            <input type="text" name="competences" value="Java"><br>
            <input type="text" name="competences" value="Spring"><br>
            <input type="text" name="competences" value="SQL"><br><br>

            <button type="submit">Add +</button>

        </form>
    </div>

</body>
</html>
