[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)
![Build](https://github.com/opt-nc/opt-temps-attente-agences-sdk/actions/workflows/maven.yml/badge.svg)
[![](https://jitpack.io/v/opt-nc/opt-temps-attente-agences-sdk.svg)](https://jitpack.io/#opt-nc/opt-temps-attente-agences-sdk)

# ❔A propos

Java SDK pour récupérer aisément le temps d'attente dans les agences OPT de Nouvelle-Calédonie.

Les temps d'attente sont ceux affichés sur le [site officiel de l'OPT-NC](https://www.opt.nc/service/l-opt-pres-de-chez-moi-trouver-une-agence).

# 🔖Liens connexes

Ce SDK a permis la création de  :

- [L'API REST des temps d'attente](https://github.com/opt-nc/opt-temps-attente-agences-api)
- L'image docker [optnc/opt-temps-attente-agences-api](https://hub.docker.com/r/optnc/opt-temps-attente-agences-api)


## 👉Utiliser

### depuis le repo Jitpack

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

### Depuis le repo Maven de GitHub 

Ajouter le dépôt:

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/opt-nc/opt-temps-attente-agences-sdk</url>
  </repository>
</repositories>
```

Puis la dépendance:

```xml
<dependency>
  <groupId>nc.opt.tempsattente</groupId>
  <artifactId>opt-temps-attente-agences-sdk</artifactId>
  <version>Tag</version>
</dependency>
```

### 🚀Exemple

```java
System.out.println("<" + Agences.getAgences().size() + "> agences trouvées");
System.out.println(Agences.getAgences());
System.out.println("<" + Agences.getAgences(Commune.NOUMEA).size() + "> agences trouvées pour <" + Commune.NOUMEA + ">");
System.out.println(Agences.getAgences(Commune.NOUMEA));
System.out.println("Correspondance trouvée pour l'ID 4177 : " + Agence.getAgence("4177").toString());  
System.exit(0);
```
