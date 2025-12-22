<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Réussi</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 700px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        .success {
            background-color: #d4edda;
            border: 1px solid #c3e6cb;
            color: #155724;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        h1 {
            color: #28a745;
            text-align: center;
        }
        .info-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .info-table th,
        .info-table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .info-table th {
            background-color: #f8f9fa;
            font-weight: bold;
            color: #333;
            width: 30%;
        }
        .back-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .back-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>✅ Upload Réussi !</h1>
        
        <div class="success">
            <strong>Succès!</strong> Votre fichier a été uploadé avec succès.
        </div>

        <table class="info-table">
            <tr>
                <th>Titre:</th>
                <td>${titre}</td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>${description}</td>
            </tr>
            <tr>
                <th>Catégorie:</th>
                <td>${categorie}</td>
            </tr>
            <tr>
                <th>Nom du fichier:</th>
                <td>${fileName}</td>
            </tr>
            <tr>
                <th>Type:</th>
                <td>${fileType}</td>
            </tr>
            <tr>
                <th>Taille:</th>
                <td>${fileSize} octets</td>
            </tr>
            <% if (request.getAttribute("savedPath") != null) { %>
            <tr>
                <th>📁 Sauvegardé (projet source):</th>
                <td><code style="font-size: 11px;">${savedPath}</code></td>
            </tr>
            <% } %>
            <% if (request.getAttribute("deployedPath") != null) { %>
            <tr>
                <th>🌐 Sauvegardé (déployé):</th>
                <td><code style="font-size: 11px;">${deployedPath}</code></td>
            </tr>
            <% } %>
            <% if (request.getAttribute("saveError") != null) { %>
            <tr>
                <th>❌ Erreur:</th>
                <td style="color: red;">${saveError}</td>
            </tr>
            <% } %>
            <tr>
                <th>Message:</th>
                <td><strong>${message}</strong></td>
            </tr>
        </table>

        <a href="upload.html" class="back-btn">⬅ Retour au formulaire</a>
    </div>
</body>
</html>
