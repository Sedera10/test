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
        <form action="form/save" method="post">

            <!-- Champ texte -->
            <label for="nom">Nom :</label>
            <input type="text" id="nom" name="nom" placeholder="Entrer votre nom" value="RANDRIANANTENAINA" required>
            <br><br>

            <!-- Champ numérique -->
            <label for="age">Âge :</label>
            <input type="number" id="age" name="age" value="20" min="0" max="120">
            <br><br>

            <!-- Champ email -->
            <label for="email">Email :</label>
            <input type="email" id="email" value="sese@gmail.com" name="email" placeholder="exemple@mail.com">
            <br><br>

            <!-- Password -->
            <label for="mdp">Mot de passe :</label>
            <input type="password" value="success" id="mdp" name="mdp">
            <br><br>

            <!-- Date -->
            <label for="dateN">Date de naissance :</label>
            <input type="date" value="2004-09-07" id="dateN" name="dateN">
            <br><br>

            <!-- Checkbox -->
            <label>Centres d'intérêt :</label><br>
            <input type="checkbox" name="hobby" value="sport"> Sport <br>
            <input type="checkbox" name="hobby" value="musique"> Musique <br>
            <input type="checkbox" name="hobby" value="lecture"> Lecture <br><br>

            <!-- Radio -->
            <label>Genre :</label><br>
            <input type="radio" name="genre" value="homme"> Homme<br>
            <input type="radio" name="genre" value="femme"> Femme<br>
            <input type="radio" name="genre" value="autre"> Autre<br><br>

            <!-- Select -->
            <label for="pays">Pays :</label>
            <select id="pays" name="pays">
                <option value="Madagascar">Madagascar</option>
                <option value="France">France</option>
                <option value="USA">USA</option>
            </select>
            <br><br>

            <button type="submit">Envoyer</button>

        </form>
    </div>

</body>
</html>
