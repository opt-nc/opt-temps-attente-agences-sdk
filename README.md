# tempsattente-sdk
SDK pour le temps d'attente dans les agences de Nouvelle-Calédonie

## Utiliser

### Code snippet

```java
System.out.println("<" + Agences.getAgences().size() + "> agences trouvées");
System.out.println(Agences.getAgences());
System.out.println("<" + Agences.getAgences(Commune.NOUMEA).size() + "> agences trouvées pour <" + Commune.NOUMEA.name() + ">");
System.out.println(Agences.getAgences(Commune.NOUMEA));
System.exit(0);
```
