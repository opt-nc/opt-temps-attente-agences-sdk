![Build](https://github.com/opt-nc/opt-temps-attente-agences-sdk/actions/workflows/maven.yml/badge.svg)

# tempsattente-sdk

Java SDK pour le temps d'attente dans les agences OPT de Nouvelle-Calédonie

## Utiliser

### Dépendance

```xml
<dependency>
  <groupId>nc.opt.tempsattente</groupId>
  <artifactId>tempsattente-sdk</artifactId>
  <version>${opt-tempsattente-sdk.version}</version>
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
