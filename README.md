Documentation – Intégration de la Librairie check-common-lib-client

🎯 Objectif
Le projet client utilise la librairie partagée check-common-lib pour ajouter des fonctionnalités transverses comme :

L’audit des méthodes via l'annotation @Audit
La mesure du temps d'exécution via @LogExecutionTime
Le mécanisme de retry automatique via @RetryOnFailure

📦 Dépendance Maven

Assurez-vous d’avoir installé la librairie dans le dépôt local avec la commande suivante dans le projet check-common-lib :
mvn clean install

Ajoutez ensuite cette dépendance dans le pom.xml du projet client :

<dependency>
  <groupId>com.tonorganisation</groupId>
  <artifactId>check-common-lib</artifactId>
  <version>1.0.0</version>
</dependency>

⚙️ Configuration (application.yml)

Ajoutez les propriétés suivantes dans le application.yml de l’application cliente :

spring:
  application:
    name: check-common-lib-client

check-common:
  audit-enabled: true            # Active les logs d’audit
  log-execution-time: true       # Active la mesure du temps d'exécution
  retry:
    enabled: true                # Active la logique de retry
    default-max-attempts: 3      # Nombre de tentatives par défaut
    default-delay-ms: 500        # Délai entre les tentatives (en ms)
