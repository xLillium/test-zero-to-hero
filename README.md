# 🌹 Gilded Rose Refactoring Kata

[![Build Status](https://img.shields.io/jenkins/build?jobUrl=http%3A%2F%2Fexample.com%2Fjenkins%2Fjob%2FGildedRose%2F)](https://example.com/jenkins/job/GildedRose/)
[![Test Coverage](https://img.shields.io/badge/coverage-100%25-brightgreen)](https://example.com/coverage)
[![Java Version](https://img.shields.io/badge/java-21-orange)](https://openjdk.java.net/projects/jdk/21/)

A Java implementation of the famous Gilded Rose refactoring kata with full testing suite. 

🎤 Origin
This repository was created as educational material to accompany a technical presentation delivered at [Olympp](https://olympp.fr/), a leading French Software Engineering Consultancy. The project serves as a practical demonstration of testing methodologies and refactoring techniques for professional software developers.

## 📜 Gilded Rose Requirements Specification
Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a prominent city ran by a friendly innkeeper named Allison. We also buy and sell only the finest goods. Unfortunately, our goods are constantly degrading in Quality as they approach their sell by date.

We have a system in place that updates our inventory for us. It was developed by a no-nonsense type named Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that we can begin selling a new category of items. First an introduction to our system:

All items have a SellIn value which denotes the number of days we have to sell the items
All items have a Quality value which denotes how valuable the item is
At the end of each day our system lowers both values for every item
Pretty simple, right? Well this is where it gets interesting:

Once the sell by date has passed, Quality degrades twice as fast
The Quality of an item is never negative
"Aged Brie" actually increases in Quality the older it gets
The Quality of an item is never more than 50
"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
"Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
Quality drops to 0 after the concert
We have recently signed a supplier of conjured items. This requires an update to our system:

"Conjured" items degrade in Quality twice as fast as normal items
Feel free to make any changes to the UpdateQuality method and add any new code as long as everything still works correctly. However, do not alter the Item class or Items property as those belong to the goblin in the corner who will insta-rage and one-shot you as he doesn't believe in shared code ownership (you can make the UpdateQuality method and Items property static if you like, we'll cover for you).

Just for clarification, an item can never have its Quality increase above 50, however "Sulfuras" is a legendary item and as such its Quality is 80 and it never alters.

## 🚀 Getting Started

### Prerequisites

- Java 21
- Maven 3.8+

### Installation

Clone the repository:

```bash
git clone https://github.com/your-username/gilded-rose.git
cd gilded-rose
```

Build the project:

```bash
mvn clean package
```

### Running Tests

Run unit tests:

```bash
mvn test
```

Run BDD tests (Cucumber):

```bash
mvn test -Pcucumber
```

## 📊 Test Results

Test reports are available in:
- Unit tests: `target/surefire-reports/`
- BDD tests: `target/cucumber-reports/`

## 🏗️ CI/CD Pipeline

This project includes a Jenkins pipeline that automates:
- Building the application
- Running unit and integration tests

## 🧪 Testing Approach

### Unit Testing

The project uses JUnit 4 with AssertJ for readable assertions, testing all item types and edge cases.

### BDD Testing

Cucumber is used for behavior-driven development tests, with features written in Gherkin to describe expected behavior in plain language.

### Golden Master Testing

To ensure backwards compatibility during refactoring, this project uses the Golden Master testing technique.

## 📁 Project Structure

```
.
├── src/
│   ├── main/java/fr/olympp/techtalk/
│   │   ├── Constants.java       # Constants used across the application
│   │   ├── GildedRose.java      # Main implementation (refactored)
│   │   ├── GildedRoseGoldenMaster.java # Original implementation for comparison
│   │   └── Item.java            # Item class (DO NOT MODIFY)
│   │
│   └── test/
│       ├── java/fr/olympp/techtalk/
│       │   ├── cucumber/        # Cucumber test setup
│       │   ├── GildedRoseTest.java  # Unit tests
│       │   └── TestData.java    # Test data setup
│       │
│       └── resources/
│           └── features/        # Cucumber feature files
├── pom.xml                      # Maven configuration
├── Jenkinsfile                  # CI/CD pipeline definition
└── README.md                    # This file
```

## 🔄 Refactoring Focus

The main goal of this kata is to practice refactoring techniques:
- Improved the existing code structure
- Added support for "Conjured" items 
- Maintained full backward compatibility
- Achieved 100% test coverage


## 🙏 Acknowledgements

- Original Gilded Rose kata by Terry Hughes
- Refactoring techniques inspired by Martin Fowler's book "Refactoring: Improving the Design of Existing Code"

---
# French specifications
## Spécification de la Rose dorée (Gilded Rose)

Bonjour et bienvenue dans l'équipe de la Rose dorée.

Comme vous le savez, notre petite taverne située à proximité d'une cité importante est dirigée par l'aubergiste amicale Allison.

Nous achetons et vendons uniquement les meilleurs produits.
Malheureusement, la qualité de nos marchandises se dégrade constamment à l'approche de leur date de péremption.

Un système a été mis en place pour mettre à jour notre inventaire.
Il a été développé par Leeroy, une personne pleine de bon sens qui est partie pour de nouvelles aventures.

Votre mission est d'ajouter une nouvelle fonctionnalité à notre système pour que nous puissions commencer à vendre un nouveau type de produits.

Mais d'abord, laissez-moi vous présenter notre système :

- Tous les éléments ont une valeur `sellIn` qui désigne le nombre de jours restant pour vendre l'article.
- Tous les articles ont une valeur `quality` qui dénote combien l'article est précieux.
- À la fin de chaque journée, notre système diminue ces deux valeurs pour chaque produit.

Plutôt simple, non ?

Attendez, ça devient intéressant :

- Une fois que la date de péremption est passée, la qualité se dégrade deux fois plus rapidement.
- La qualité (`quality`) d'un produit ne peut jamais être négative.
- "Aged Brie" augmente sa qualité (`quality`) plus le temps passe.
- La qualité d'un produit n'est jamais de plus de 50.
- "Sulfuras", étant un objet légendaire, n'a pas de date de péremption et ne perd jamais en qualité (`quality`)
- "Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.

Nous avons récemment signé un partenariat avec un fournisseur de produit invoqué ("Conjured").
Cela nécessite une mise à jour de notre système :

- les éléments "Conjured" voient leur qualité se dégrader de deux fois plus vite que les objets normaux.

Vous pouvez faire les changements que vous voulez à la méthode `updateQuality` et ajouter autant de code que vous voulez, tant que tout fonctionne correctement.
Cependant, nous devons vous prévenir, vous ne devez en aucun cas modifier la classe `Item` ou ses propriétés car cette classe appartient au gobelin à l'étage qui entrerait dans une rage instantanée et vous tuerait sans délai : il ne croit pas au partage du code.
(Vous pouvez rendre la méthode `updateQuality` statique, ainsi que des propriétés dans la classe `Item` si vous voulez, nous vous couvrirons)

Juste une précision, un produit ne peut jamais voir sa qualité augmenter au-dessus de 50, cependant "Sulfuras" est un objet légendaire et comme tel sa qualité est de 80 et elle ne change jamais.
