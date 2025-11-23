<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello Page</title>
</head>
<body>
    <h1>${message}</h1>
    <p>Valeur : ${nombre}</p>

    <ul>
    <% 
       java.util.List produits = (java.util.List) request.getAttribute("produits");
       for(Object p : produits) { 
    %>
       <li><%= p %></li>
    <% } %>
    </ul>

    <br>

    <div>
        <form action="chercher" method="post">
            <label for="age">Age :</label>
            <input type="number" id="age" name="age" required>

            <button type="submit">Envoyer</button>
        </form>
    </div>

</body>
</html>
