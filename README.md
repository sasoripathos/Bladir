# Bladir

Bladir means "Blood Analysis, Diagnosis, Results". It is a cloud platform which connects blood analyst, doctor and patient, speed up the result delivery, data visualization and data analysis.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Angular 6, Java 8, Mysql, Maven
```

### Installing

```
1.Open a terminal console
2.cd path\to\BLADIR\bladir-front-end
3.npm install
Running the website: ng serve --aot
Deployment the website: ng build --aot
4. cd ..\bladir_backend
5. run create.sql script in src/main/resources/create.sql to create a MySQL database.
6. change applicatino.properties in line 7-8 by your own sql server username and password.
7. maven clean install
8. run backend with: java -jar target/bladir_backend-0.0.1-SNAPSHOT.jar
```


## Built With

* [Spring](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Angular 6](https://angular.io/) - TypeScript-based open-source front-end web application platform
* [Mysql](https://www.mysql.com/) - MySQL is an open-source relational database management system.

## Authors

See the list of [contributors](https://github.com/sasoripathos/Bladir/graphs/contributors) who participated in this project.

## License

This project is licensed under the GNU General Public License v3.0 LICENSE- see the [LICENSE](LICENSE) file for details
