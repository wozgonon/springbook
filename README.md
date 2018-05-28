# Springbook

A simple example of a server providing a [REST API](https://en.wikipedia.org/wiki/Representational_state_transfer)
implemented using [Springboot](https://projects.spring.io/spring-boot/).

## Build

```
mvn package
```

## Run

```
java -jar target/springbook-0.0.1-SNAPSHOT.jar
```

## REST API

Create a booking:

```
http://localhost:1235/booking/create?user=jb&note=Note1&date=Date1
=>
{"key":"397e4a9e-ee50-4ab8-b789-329875de37cc","user":"jb","date":"Date1","note":"Note1"}
```

List a user's bookings:
```
http://localhost:1235/booking/list?user=jb
```

Delete a user's bookings:
```
http://localhost:1235/booking/delete?bookingId=397e4a9e-ee50-4ab8-b789-329875de37cc
```

## UI

The user interface is currently minimal allowing the creation and listing
of bookings:  <a href="screenshot1.png">A screenshot</a>.

