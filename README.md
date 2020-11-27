




<!-- ABOUT THE PROJECT -->
## About The Project

[]()
  
* The task is to write an application to find out which bus lines that have the most bus
stops on their route, and to present the top 10 bus lines in a nice and formatted way
in a web browser.

* The web page should show the names of every bus stop for each of the bus lines in
the top 10 list.
* There are no requirements how the bus stops are sorted.
* To accomplish the task please use the Trafiklab’s open API
(https://www.trafiklab.se/). You can find more information about the specific API on
the documentation page: https://www.trafiklab.se/api/sl-hallplatser-och-linjer-2.
You can register your own account at Trafiklab.
* The data should be automatically gathered from API for each run of the application.


### Built With
* BACKEND: Java.15:SpringBoot. 
* FRONTEND: 'vanilla' JS using webpack as a bundeler and jasmine for testing.

* [Java](https://www.java.com/sv/)
* [Spring](https://spring.io/)
* [JS:WebComponents](hthttps://www.javascript.com/)



<!-- GETTING STARTED -->
## Getting Started

## Rquirements:
* Java: 15^
* Node: <14
* Docker: 1^

The easiest way to get get application running is by executing the setup script (if you have docker installed).
* shell windows
  ```sh
  ./setup.sh
  ```
* mac
  ```sh
  bash ./setup.sh
  ```
And browse to http://localhost:9090 (frontend) http://localhost:8080 (backend)

## Tests <WebComponents>
You can run the frontend unit tests by executing:
* shell
  ```sh
  cd client && yarn test
  ```
And the backend tests
* shell 
  ```sh
  cd server && ./mvnw test
  ```


## Local Development (Frontend)
* For developing locally you can run this script for live reloading
   ```sh
    cd client && yarn start
  ```
