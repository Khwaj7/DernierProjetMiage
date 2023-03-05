# Dernier Projet Miage
Le dernier projet de ces trois années de MIAGE !

# Lancement de Docker

- Conteneur MySQL : 
```powershell
docker run -d --name mysql-vamarcher -p 3306:3306 -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=azerty -e MYSQL_DATABASE=vamacherusers -e MYSQL_USER=VaMarcher_admin -e MYSQL_PASSWORD=azerty mysql
```

- Conteneur Mongodb : 
```powershell
docker run -d --name mongo-vamarcher -p 27017:27017 mongo
```

# Documentation APIs
  
## Micro-service : MembersAdmin
- **GET** ```:8080/api/vamarcher/1.0/membres``` : List\<Membre\>

- **GET** ```:8080/api/vamarcher/1.0/teamleaders``` : List\<TeamLeader\>

- **GET** ```:8080/api/vamarcher/1.0/membre``` : Membre
  - id : String

- **POST** (JSON Body)  ```:8080/api/vamarcher/1.0/membre/add``` : Membre
  - nomMembre : String
  - prenomMembre : String
  - mailMembre : String
  - login : String
  - encryptedPassword : String
  - numero : int
  - rue : String
  - ville : String
  - pays : String
  
  - **Retour** : 
    - nomMembre : String
    - prenomMembre : String
    - mailMembre : String
    - login : String
    - numLicence : int
    - niveau : int
    - encryptedPassword : hashcode (String)
    - adresse : Object : 
      - numero : int
      - rue : String
      - ville : String
      - pays : String
    - certificatMedical : String
  
   
- **POST** (JSON Body) ```:8080/api/vamarcher/1.0/membre/promote``` : "Promotion validée" | "KO"
  - userID : String

- **POST** ```:8080/api/vamarcher/1.0/membre/login``` : Membre | null
  - login : String
  - password : String
  
## Micro-service : RandoAdmin
- **GET** ```:8090/api/vamarcher/1.0/randos``` : List\<Rando\>

- **POST** ```:8090/api/vamarcher/1.0/rando/add``` : Rando
  - propositionsDates : List\<String\>
  - pointDepart : String
  - description : String
  - distance : String
  - duree : String
  - denivele : String
  - niveau : String
  - coutFixe : float
  - coutVariable : float
  
- **POST** ```:8090/api/vamarcher/1.0/rando/clotureVote``` : Rando
  - randoId : String
  
- **POST** ```:8090/api/vamarcher/1.0/rando/cloturerOrga``` : Rando
  - randoID : String
  
- **DELETE** ```:8090/api/vamarcher/1.0/rando/annulerRando``` : "Done" | "NOK"
  - randoId : String

- **POST** ```:8090/api/vamarcher/1.0/rando/vote``` : "vote OK" | "KO"
  - idRando : String
  - date : String
  - userID : Integer
  
- **POST** ```:8090/api/vamarcher/1.0/rando/inscription``` : "Inscription validée" | "KO"
  - idRando : String
  - userID : Integer
  
- **DELETE** ```:8090/api/vamarcher/1.0/rando/desinscription``` : "Désinscription confirmée" | "KO"
  - idRando : String
  - userID : String

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
