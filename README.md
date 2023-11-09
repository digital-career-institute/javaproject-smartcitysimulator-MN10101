**Team work:**
- Mahmoud

- Gabriele



**Smart City Simulation**

This project simulates various components of a smart city, including traffic management, smart lighting, and environmental monitoring. The simulation consists of different threads representing each component, and it uses multithreading to run them concurrently.

**Components**

**1.Vehicle**
Represents a vehicle in the simulation.
Attributes: vehicleType (type of vehicle), regsnum (registration number), cSpeed (current speed).
Methods: move (updates the current speed), getcSpeed (returns the current speed).

**2.Sensor**
Represents a sensor used for environmental monitoring.
Attributes: type (type of sensor), cValue (current measured value).
Methods: measure (simulates measuring data), getcValue (returns the current measured value).

**3.TrafficManagement**
Simulates smart traffic management.
Uses a list of vehicles to represent traffic.
Periodically updates the speed of each vehicle and displays the current state.
Runs as a separate thread.

**4.SmartLighting**
Simulates smart lighting in the city.
Automatically adjusts brightness based on the time of day.
Runs as a separate thread.

**5.EnvironmentalMonitoring**
Simulates environmental monitoring, including air quality, temperature, and noise level.
Uses a list of sensors to represent environmental sensors.
Periodically updates sensor values and displays the current state.
Runs as a separate thread.

**6.SmartCitySimulation**
The main class that orchestrates the simulation.
Initializes instances of TrafficManagement, SmartLighting, and EnvironmentalMonitoring.
Starts each component as a separate thread.

**How to Run**
1-Ensure you have the necessary OpenCSV library added to your project.
2.Run the SmartCitySimulation class.
