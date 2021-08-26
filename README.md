![example workflow](https://github.com/opt-nc/opt-temps-attente-agences-sdk/actions/workflows/maven.yml/badge.svg)


# tempsattente-sdk

Java SDK pour le temps d'attente dans les agences OPT de Nouvelle-Calédonie

## Utiliser

### Dépendance

```xml
<dependency>
  <groupId>com.github.adriens</groupId>
  <artifactId>opt-temps-attente-agences-sdk</artifactId>
  <version>${opt-temps-attente-agences-sdk.version}</version>
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
