# Dernier Projet Miage
Le dernier projet de ces trois années de souffrance...

# Lancement de Docker

- Conteneur MySQL : 
```powershell
docker run -d --name mysql-vamarcher -p 3306:3306 -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=azerty -e MYSQL_DATABASE=vamacherusers -e MYSQL_USER=VaMarcher_admin -e MYSQL_PASSWORD=azerty mysql
```

- Conteneur Mongodb : 
```powershell
docker run -d --name mongo-vamarcher -p 27017:27017 mongo
```

# Conception de l'application
Diagrammes à réaliser : 
- Use case global à l'application
- Un diagramme de séquence par cas dans le use case
- Un diagramme des classes
- La liste des beans Spring qui seront utilisés dans le back
- Les classes de configuration / fichiers de propriétés pour un projet Spring Boot (vraiment utile + késako ?)

# Développement d'une maquette de l'application
Une maquette de la solution envisagée sera développée.
Celle-ci devra donner une image fidèle de la solution réelle ensuite déployée. 
On s’attachera avant tout (IHM, traitement…) à rendre opérationnelles les interactions entre entités

Ce même jour, vous devez rendre le dossier de conception dans lequel vous rajouterez quelques éléments clés de programmation.
De plus, vous devrez fournir vos sources (BD comprises).  
 
Votre projet sera noté sur chaque partie en fonction des choix techniques que vous effectuerez, de la qualité de la conception, 
de la qualité technique du code produit, de son respect du sujet, de l’ergonomie de votre application et de son allure générale.
Les fonctionnalités supplémentaires que vous mettrez en œuvre seront aussi comptabilisées à la condition que tous les éléments 
du projet aient été correctement traités au préalable. 
