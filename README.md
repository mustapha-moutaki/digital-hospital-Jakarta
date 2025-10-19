Clinique Digitale - Gestion des Consultations
Contexte du projet

L’organisation souhaite digitaliser la gestion des activités d’une clinique privée. L’objectif est de fournir aux patients, aux docteurs et à l’administration un outil fiable, simple d’utilisation et sécurisé pour gérer les consultations, les plannings et les dossiers médicaux, tout en assurant une supervision complète des activités et des ressources de la clinique.

Vous êtes développeur Java EE chargé de concevoir et développer une application web JEE respectant les bonnes pratiques de programmation orientée objet et une architecture professionnelle en couches (MVC), permettant l’automatisation des processus métier et une gestion centralisée des données.

Objectifs / Fonctionnalités principales
Pour les patients

Créer et gérer leur compte patient.

Consulter la liste des docteurs disponibles par département (ex. cardiologie, dermatologie…).

Réserver un rendez-vous (consultation) avec un docteur :

Saisie : date, heure souhaitée, motif de consultation.

Le système crée la consultation avec le statut "Réservée" et bloque automatiquement le créneau de 30 minutes dans la salle correspondante.

Annuler ou modifier une réservation si nécessaire.

Consulter l'historique de leurs consultations et diagnostics.

Pour les docteurs

Consulter leur planning de consultations (réservations).

Valider ou refuser une réservation faite par un patient.

Réaliser une consultation : saisir le compte rendu médical (diagnostic, traitement).

Mettre à jour l'état d'une consultation (Réservée, Validée, Annulée, Terminée).

Accéder à l'historique médical des patients suivis.

Pour l'administration

Gérer les départements (ajout, modification, suppression).

Gérer les docteurs et leur rattachement aux départements.

Gérer les salles et optimiser l'occupation par créneaux :

Chaque salle peut accueillir une seule consultation par créneau de 30 minutes.

Vérification automatique de la disponibilité selon la date et l'heure souhaitée.

Superviser toutes les réservations et consultations.

Générer des statistiques globales : nombre de patients, consultations, taux d'occupation des salles…

Règles de gestion

Un patient peut avoir plusieurs consultations, mais une seule réservation par créneau.

Un docteur appartient à un seul département mais peut avoir plusieurs consultations.

Une consultation commence par une réservation (Réservée), qui doit être validée par le docteur (Validée), puis effectuée (Terminée) ou annulée (Annulée).

Une salle peut accueillir une seule consultation par créneau de 30 minutes.

Les consultations passées restent accessibles dans l'historique.

Modélisation des entités

Personne (abstraite) : nom, prénom, email, motDePasse.

Patient : idPatient, poids, taille, consultations.

Docteur : idDocteur, spécialité, département, planning (liste de consultations).

Département : idDepartement, nom, docteurs.

Salle : idSalle, nomSalle, capacité, créneaux occupés (liste des LocalDateTime correspondant aux réservations de 30 minutes).

Consultation : idConsultation, date, heure, statut (Enum : RESERVEE, VALIDEE, ANNULEE, TERMINEE), compteRendu, patient (association), docteur (association), salle (association).

Architecture technique et technologies
Backend

Architecture MVC (multi-couches) : Repository / Service / Controller / Vue.

Base de données relationnelle : MySQL ou PostgreSQL.

JPA/Hibernate pour la persistance des entités.

Java EE / Jakarta EE (Servlets, JSP).

Java Time API pour la gestion des dates et horaires des consultations.

Gestion des exceptions : réservation en double, salle non disponible, patient/docteur introuvable.

Frontend

JSP pour les vues dynamiques.

JSTL pour la logique de présentation :

<c:forEach> pour l'affichage de listes (docteurs, consultations, départements).

<c:if> et <c:choose> pour les conditions d'affichage.

<fmt:formatDate> pour le formatage des dates.

CSS / Bootstrap / Tailwind pour le style et la responsivité.

JavaScript (optionnel) pour la validation côté client et l'amélioration UX.

Gestion des Sessions (HttpSession)

session.setAttribute("userConnecte", user) : stocker l'utilisateur lors de la connexion.

session.getAttribute("userConnecte") : récupérer l'utilisateur connecté.

${sessionScope.userConnecte} : accès aux données de session dans les JSP avec EL.

Stockage du type d'utilisateur (PATIENT, DOCTEUR, ADMIN) pour la gestion des droits d'accès.

Filtres (Servlet Filters) pour la sécurité :

Rediriger vers la page de login si session.getAttribute("userConnecte") == null.

Contrôler les droits d'accès selon le rôle.

Déconnexion : session.invalidate() pour détruire la session.

User Stories
Patients

En tant que patient, je veux réserver un rendez-vous avec un docteur afin de consulter.

En tant que patient, je veux annuler ou modifier ma réservation.

En tant que patient, je veux consulter l'historique de mes consultations.

Docteurs

En tant que docteur, je veux consulter mon planning.

En tant que docteur, je veux valider ou refuser une réservation.

En tant que docteur, je veux saisir le compte rendu d'une consultation.

Admin

En tant qu'admin, je veux gérer les départements et docteurs.

En tant qu'admin, je veux gérer les salles pour optimiser l'occupation par créneaux de 30 minutes.

En tant qu'admin, je veux superviser toutes les consultations.
