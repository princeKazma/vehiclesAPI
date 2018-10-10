# vehiclesAPI
Below, you can find the actions that each endpoint can do on this REST API, as well as some examples

GET Methods:
- URI: /vehicles
  Description: This method retrieves all Vehicles created by POST method. Each Vehicle Type will show its own different properties.
  If empty, it will return an Object (ResponseEntity) with an exception Message as a property, as well as a HTTP Status 404.

- URI: /vehicles/car
  Description: This method retrieves all Vehicles of type Car. If there is not match, it will return an Exception and a 404.

- URI: /vehicles/truck
  Description: This method retrieves all Vehicles of type Truck. If there is not match, it will return an Exception and a 404.

- URI: /vehicles/airplane
  Description: This method retrieves all Vehicles of type Airplane. If there is not match, it will return an Exception and a 404.

- URI: /vehicles/drone
  Description: This method retrieves all Vehicles of type Drone. If there is not match, it will return an Exception and a 404.

- URI: /vehicles/boat
  Description: This method retrieves all Vehicles of type Boat. If there is not match, it will return an Exception and a 404.

- URI: /vehicles/amph
  Description: This method retrieves all Vehicles of type Amphibious. If there is not match, it will return an Exception and a 404.

- URI: /vehicles/{id}
  Description: This method retrieves one Vehicle with the given ID. If there is not match, it will return an Exception and a 404.

- URI: /vehicles/search?make=X
  Description: This method receives a Make value as a RequestParam (GET Parameter) to retrieve all Vehicles that match this Make value. 
  If there is not match, it will return an Exception and a 404.

- URI: /vehicles/last
  Description: This method retrieves the last Vehicle created. If there is none, it will return an Exception and a 404.

POST Methods: (receive RequestBody)
- URI: /vehicles/car
  Description: This method creates a vehicle of type CAR into the Database, by receiving an Object (RequestBody) of Car.

- URI: /vehicles/truck
  Description: This method creates a vehicle of type TRUCK into the Database, by receiving an Object (RequestBody) of Truck.

- URI: /vehicles/airplane
  Description: This method creates a vehicle of type AIRPLANE into the Database, by receiving an Object (RequestBody) of Airplane.

- URI: /vehicles/drone
  Description: This method creates a vehicle of type DRONE into the Database, by receiving an Object (RequestBody) of Drone.

- URI: /vehicles/boat
  Description: This method creates a vehicle of type BOAT into the Database, by receiving an Object (RequestBody) of Boat.

- URI: /vehicles/amph
  Description: This method creates a vehicle of type AMPHIBIOUS into the Database, by receiving an Object (RequestBody) of Amphibious.

PUT Methods: (receive RequestBody)
- URI: /vehicles/{id}
  Description: This methods receives an ID of vehicle from the URI, as well as a Vehicle Object through RequestBody, 
  to update properties on an existing Vehicle with the ID given. If there is no Vehicle with a matching ID, 
  an Exception, and a 404, will be returned in a ResponseEntity.

DELETE Methods:
- URI: /vehicles/{id}
  Description: This method deletes one Vehicle matching the given ID. If there is not match, it will return an Exception and a 404.

- URI: /vehicles/last
  Description: Without receiving any parameter, the last Vehicle saved in the Database will be deleted, no matter the type of the Vehicle.
