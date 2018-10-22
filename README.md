# vehiclesAPI
Below, you can find the actions that each endpoint can do on this REST API, as well as some examples.

FULL URL (for a local server):  http://localhost:8080/vehiclesAPI/vehicles/

You can test this API with Postman: https://www.getpostman.com/apps

To run the Unit Tests, just Right Click on the TestCases.java file and select: Run As > JUnit Test

GET Methods:
- URI: /vehicles
  Description: This method retrieves all Vehicles created by POST method. Each Vehicle Type will show its own different properties.
  If empty, it will return an Object (ResponseEntity) with an exception Message as a property, as well as a HTTP Status 404.
  · Response examples:
    - No vehicles (Status 404)
    {
      "status": 404,
      "message": "Vehicles not found"
    }
    - With vehicles (Status 200)
  [
    {
        "id": 1,
        "type": "CAR",
        "make": "Ford",
        "year": 2014,
        "color": "Red",
        "capacity": 5,
        "wheels": 4,
        "maxDriveSpeed": 150
    },
    ...
    {
        "id": 6,
        "type": "AMPHIBIOUS",
        "make": "CAMI",
        "year": 2019,
        "color": "Green",
        "capacity": 5,
        "wheels": 4,
        "canDive": true
    }
  ]

- URI: /vehicles/car
  Description: This method retrieves all Vehicles of type Car. If there is not match, it will return an Exception and a 404.
  · Response example:
  [
    {
        "id": 1,
        "type": "CAR",
        "make": "Ford",
        "year": 2014,
        "color": "Red",
        "capacity": 5,
        "wheels": 4,
        "maxDriveSpeed": 150
    }
  ]

- URI: /vehicles/truck
  Description: This method retrieves all Vehicles of type Truck. If there is not match, it will return an Exception and a 404.
  · Response example:
  [
    {
        "id": 2,
        "type": "TRUCK",
        "make": "Lobo",
        "year": 2013,
        "color": "Black",
        "capacity": 5,
        "wheels": 4,
        "maxCarryWeight": 500,
        "maxDriveSpeed": 120
    }
  ]

- URI: /vehicles/airplane
  Description: This method retrieves all Vehicles of type Airplane. If there is not match, it will return an Exception and a 404.
  · Response example:
  [
    {
        "id": 3,
        "type": "AIRPLANE",
        "make": "Delta",
        "year": 2018,
        "color": "White",
        "capacity": 100,
        "wheels": 10,
        "maxFlightHeight": 50000,
        "maxFlightSpeed": 900,
        "private": true
    }
  ]

- URI: /vehicles/drone
  Description: This method retrieves all Vehicles of type Drone. If there is not match, it will return an Exception and a 404.
  · Response example:
  [
    {
        "id": 4,
        "type": "DRONE",
        "make": "Boeing",
        "year": 2018,
        "color": "Gray",
        "capacity": 0,
        "wheels": 0,
        "maxFlightHeight": 600,
        "hasCamera": true
    }
  ]

- URI: /vehicles/boat
  Description: This method retrieves all Vehicles of type Boat. If there is not match, it will return an Exception and a 404.
  · Response example:
  [
    {
        "id": 5,
        "type": "BOAT",
        "make": "Lund",
        "year": 2010,
        "color": "White",
        "capacity": 8,
        "wheels": 0,
        "hasEngine": true,
        "hasSails": false
    }
  ]

- URI: /vehicles/amph
  Description: This method retrieves all Vehicles of type Amphibious. If there is not match, it will return an Exception and a 404.
  · Response example:
  [
    {
        "id": 6,
        "type": "AMPHIBIOUS",
        "make": "CAMI",
        "year": 2019,
        "color": "Green",
        "capacity": 5,
        "wheels": 4,
        "canDive": true
    }
  ]

- URI: /vehicles/{id}
  Description: This method retrieves one Vehicle with the given ID. If there is not match, it will return an Exception and a 404.
  · Response example:
    (/vehicles/1)
    - If vehicle's ID found (status 200)
    {
      "id": 1,
      "type": "CAR",
      "make": "Ford",
      "year": 2014,
      "color": "Red",
      "capacity": 5,
      "wheels": 4,
      "maxDriveSpeed": 150
    }
    (/vehicles/99)
    - If ID not found (Status 404)
    {
      "status": 404,
      "message": "Vehicle not found"
    }

- URI: /vehicles/search?make=X[&year=Y&type=Z]
  Description: This method receives a Make, Year or Type, value(s) as RequestParam(s) (GET Parameter) to retrieve all Vehicles that match these values. 
  If there is not match, it will return an Exception and a 404.
  · Response examples:
    - search?make=Ford
    [
      {
          "id": 1,
          "type": "CAR",
          "make": "Ford",
          "year": 2014,
          "color": "Red",
          "capacity": 5,
          "wheels": 4,
          "maxDriveSpeed": 160
      }
    ]
    - search?year=2013&type=TRUCK
    [
      {
          "id": 2,
          "type": "TRUCK",
          "make": "Lobo",
          "year": 2013,
          "color": "Black",
          "capacity": 5,
          "wheels": 4,
          "maxCarryWeight": 500,
          "maxDriveSpeed": 120
      }
    ]

- URI: /vehicles/last
  Description: This method retrieves the last Vehicle created. If there is none, it will return an Exception and a 404.
  · Response example:
  {
      "id": 6,
      "type": "AMPHIBIOUS",
      "make": "CAMI",
      "year": 2019,
      "color": "Green",
      "capacity": 5,
      "wheels": 4,
      "canDive": true
  }

POST Methods: (receive RequestBody)
- URI: /vehicles/car
  Description: This method creates a vehicle of type CAR into the Database, by receiving an Object (RequestBody) of Car.
  · Request example:
  {
    "make": "Ford",
    "year": 2015,
    "color": "Blue",
    "capacity": 5,
    "wheels": 4,
    "maxDriveSpeed": 150
  }
  · Response examples:
    - If New Vehicle (status 201)
    {
      "id": 1,
      "type": "CAR",
      "make": "Ford",
      "year": 2015,
      "color": "Blue",
      "capacity": 5,
      "wheels": 4,
      "maxDriveSpeed": 150
    }
    - If unique Model+Year already exists (Status 409)
    {
      "status": 409,
      "message": "Car already exists"
    }

- URI: /vehicles/truck
  Description: This method creates a vehicle of type TRUCK into the Database, by receiving an Object (RequestBody) of Truck.
  · Request example:
  {
    "make": "Lobo",
    "year": 2013,
    "color": "Black",
    "capacity": 5,
    "wheels": 4,
    "maxDriveSpeed": 120,
    "maxCarryWeight": 500
  }
  · Response example: (status 201)
  {
    "id": 2,
    "type": "TRUCK",
    "make": "Lobo",
    "year": 2013,
    "color": "Black",
    "capacity": 5,
    "wheels": 4,
    "maxCarryWeight": 500,
    "maxDriveSpeed": 120
  }

- URI: /vehicles/airplane
  Description: This method creates a vehicle of type AIRPLANE into the Database, by receiving an Object (RequestBody) of Airplane.
  · Request example:
  {
    "make": "Delta",
    "year": 2018,
    "color": "White",
    "capacity": 100,
    "wheels": 10,
    "maxFlightHeight": 50000,
    "maxFlightSpeed": 900,
    "private": false
  }
  · Response example: (status 201)
  {
    "id": 3,
    "type": "AIRPLANE",
    "make": "Delta",
    "year": 2018,
    "color": "White",
    "capacity": 100,
    "wheels": 10,
    "maxFlightHeight": 50000,
    "maxFlightSpeed": 900,
    "private": false
  }

- URI: /vehicles/drone
  Description: This method creates a vehicle of type DRONE into the Database, by receiving an Object (RequestBody) of Drone.
  · Request example:
  {
    "make": "Boeing",
    "year": 2018,
    "color": "Gray",
    "maxFlightHeight": 600,
    "hasCamera": true
  }
  · Response example: (status 201)
  {
    "id": 4,
    "type": "DRONE",
    "make": "Boeing",
    "year": 2018,
    "color": "Gray",
    "capacity": 0,
    "wheels": 0,
    "maxFlightHeight": 600,
    "hasCamera": true
  }

- URI: /vehicles/boat
  Description: This method creates a vehicle of type BOAT into the Database, by receiving an Object (RequestBody) of Boat.
  · Request example:
  {
    "make": "Lund",
    "year": 2010,
    "color": "White",
    "capacity": 8,
    "hasEngine": true,
    "hasSails": false
  }
  · Response example: (status 201)
  {
    "id": 5,
    "type": "BOAT",
    "make": "Lund",
    "year": 2010,
    "color": "White",
    "capacity": 8,
    "wheels": 0,
    "hasEngine": true,
    "hasSails": false
  }

- URI: /vehicles/amph
  Description: This method creates a vehicle of type AMPHIBIOUS into the Database, by receiving an Object (RequestBody) of Amphibious.
  · Request example:
  {
    "make": "CAMI",
    "year": 2019,
    "color": "Green",
    "capacity": 5,
    "wheels": 4,
    "canDive": true
  }
  · Response example: (status 201)
  {
    "id": 6,
    "type": "AMPHIBIOUS",
    "make": "CAMI",
    "year": 2019,
    "color": "Green",
    "capacity": 5,
    "wheels": 4,
    "canDive": true
  }

PUT Methods: (receive RequestBody)
- URI: /vehicles/{id}
  Description: This methods receives an ID of vehicle from the URI, as well as a Vehicle Object through RequestBody, 
  to update properties on an existing Vehicle with the ID given. If there is no Vehicle with a matching ID, 
  a new Vehicle would be created based on its type property.
  · Request example:
  {
    "make": "Ford",
    "year": 2014,
    "color": "Red",
    "capacity": 5,
    "wheels": 4
  }
  · Response examples:
    (/vehicles/1)
    - If vehicle's ID found (status 200)
    {
      "id": 1,
      "type": "CAR",
      "make": "Ford",
      "year": 2014,
      "color": "Red",
      "capacity": 5,
      "wheels": 4,
      "maxDriveSpeed": 150
    }
    (/vehicles/99)
    - If ID not found (Status 404)
    {
      "status": 404,
      "message": "Vehicle not found"
    }

DELETE Methods:
- URI: /vehicles/{id}
  Description: This method deletes one Vehicle matching the given ID. If there is not match, it will still return a 204 (No Content).
  · Response:
  Don't expect a body response, but expect a 204.

- URI: /vehicles/last
  Description: Without receiving any parameter, the last Vehicle saved in the Database will be deleted, no matter the type of the Vehicle.
  Even if there are no vehicles, it will still return a 204 (No Content).
  · Response:
  Don't expect a body response, but expect a 204.
