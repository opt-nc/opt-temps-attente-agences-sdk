![Build](https://github.com/opt-nc/opt-temps-attente-agences-sdk/actions/workflows/maven.yml/badge.svg)
[![](https://jitpack.io/v/opt-nc/opt-temps-attente-agences-sdk.svg)](https://jitpack.io/#opt-nc/opt-temps-attente-agences-sdk)

# tempsattente-sdk

Java SDK pour le temps d'attente dans les agences OPT de Nouvelle-Calédonie

## Utiliser

### Dépendance

Ajouter le dépôt:

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

Puis la dépendance:

```xml
<dependency>
  <groupId>com.github.opt-nc</groupId>
  <artifactId>opt-temps-attente-agences-sdk</artifactId>
  <version>Tag</version>
</dependency>
```

### Code snippet

```java
System.out.println("<" + Agences.getAgences().size() + "> agences trouvées");
System.out.println(Agences.getAgences());
System.out.println("<" + Agences.getAgences(Commune.NOUMEA).size() + "> agences trouvées pour <" + Commune.NOUMEA + ">");
System.out.println(Agences.getAgences(Commune.NOUMEA));
System.out.println("Correspondance trouvée pour l'ID 4177 : " + Agence.getAgence("4177").toString());  
System.exit(0);
```
