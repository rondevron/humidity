# humidity

"humidity" includes a web service based on Spring Boot and a UI based on angular.
The following functions are supported:
- Calculation of the absolute humidity and the dew point
- Interface for storing humidity values of a sensor

Additionally, a simple UI application based on Angular is available to display the humidity values.

## humidity - web service

### Requires

- openJDK 11
- Maven

### Build, prepare and run

    # build and prepare
    mvn clean install
    
    # run
    mvn spring-boot:run

## UI

### Requires

- npm 8.5+

### Build, prepare and run
    
    # prepare
    npm install
    
    # build and run
    ng serve