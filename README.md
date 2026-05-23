# Store Web Service

API RESTful pour un backend de boutique en ligne. Fournit des endpoints CRUD pour les produits, categories, clients et commandes. Persistance via PostgreSQL.

## Stack technique

- Java 11
- Jakarta EE 10 / Jersey (JAX-RS)
- EclipseLink (JPA)
- PostgreSQL

## Etat d'avancement

MVP -- les ressources CRUD de base sont implementees.

## Demarrage

```bash
mvn clean package
```
Deployer le fichier `.war` genere sur un serveur compatible Jakarta EE 10 (GlassFish, Payara).
