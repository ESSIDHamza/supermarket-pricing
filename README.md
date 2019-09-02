# Supermarket Pricing

![Use Case diagram](https://raw.githubusercontent.com/ESSIDHamza/supermarket-pricing/master/uml-designing/Use%20Case%20Model.png)

![Class diagram](https://raw.githubusercontent.com/ESSIDHamza/supermarket-pricing/master/uml-designing/Class%20Model.png)

To resolve this kata, I resorted to the Strategy design pattern. It is a behavioural pattern that makes business logic algorithms easily interchangeable.

On the one hand, it respects the 'S' of the SOLID principle insofar as each type of algorithm is encapsulated within an independent class.
On the other hand, it respects the 'O' of the SOLID principle as our solution is open for extension and closed for modification (in case the admin wants to add a new pricing strategy, all we have to do is just to implement the ProductPricingStrategy interface without modifying our existing source code).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

```
* Apache Maven.
* Java 8 or higher.
```

### Installing

```
* mkdir destination-project-folder
* cd destination-project-folder
* git init
* git pull https://github.com/ESSIDHamza/supermarket-pricing.git
```

## Running the tests

```
mvn test
```

## Version

0.0.1-release

## Author

**Hamza ESSID**
