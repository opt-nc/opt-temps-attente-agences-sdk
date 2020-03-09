# tempsattente-sdk
SDK pour le temps d'attente dans les agences de Nouvelle-Calédonie

## Utiliser

### Code snippet

```java
Agences noumea = new Agences(Agences.getAgences(Commune.NOUMEA));
System.out.println("<" + noumea.getAgences().size() + "> agences trouvées pour <" + Commune.NOUMEA.name() + ">");
System.out.println(noumea.getAgences());
Agences all = new Agences(Agences.getAgences());
System.out.println("<" + all.agences().size() + "> agences trouvées");
System.out.println(all.getAgences());
System.exit(0);
```
