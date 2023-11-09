package smart_city_simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Vehicle {
	private String vehicleType, regsnum;
	private double cSpeed;

	public Vehicle(String vehicleType, String regsnum) {
		this.vehicleType = vehicleType;
		this.regsnum = regsnum;
	}

	public void move(double speed) {
		cSpeed = speed;
	}

	public double getcSpeed() {
		return cSpeed;
	}

	@Override
	public String toString() {
		return "Vehicle: " + "vehicleType='" + vehicleType + '\'' + ", registrationNumber='" + regsnum + '\''
				+ ", currentSpeed=" + cSpeed;
	}
}

class Sensor {
	private String type;
	private double cValue;

	public Sensor(String type) {
		this.type = type;
	}

	public void measure() {
		Random r = new Random();
		switch (type) {
		case "Quality of Air" -> cValue = r.nextDouble() * 100;
		case "Temperature" -> cValue = r.nextDouble() * 150;
		case "Noise Level" -> cValue = r.nextDouble() * 40 - 10;
		}
	}

	public double getcValue() {
		return cValue;
	}

	@Override
	public String toString() {
		return "Sensor: " + "sensorType='" + type + '\'' + ", currentValue=" + cValue;
	}
}

class TrafficManagement implements Runnable {
	private ArrayList<Vehicle> vs = new ArrayList<>(Arrays.asList(new Vehicle("Car", "XXX123"),
			new Vehicle("Truck", "XYX789"), new Vehicle("Motorcycle", "01BG55")));

	@Override
	public void run() {
		while (true) {
			vs.forEach(vehicle -> vehicle.move(Math.random() * 100));
			System.out.println("Traffic Management: " + vs);
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
}

class SmartLighting implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println("Smart Lighting: Automatically adjusting brightness based on the time of day.");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
}

class EnvironmentalMonitoring implements Runnable {
	private List<Sensor> sensors = Arrays.asList(new Sensor("Quality of Air"), new Sensor("Temperature"),
			new Sensor("Noise Level"));

	@Override
	public void run() {
		while (true) {
			sensors.forEach(Sensor::measure);
			System.out.println("Environmental Monitoring: " + sensors);
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
}

public class SmartCitySimulation {
	public static void main(String[] args) {
		TrafficManagement trafficManagement = new TrafficManagement();
		SmartLighting smartLighting = new SmartLighting();
		EnvironmentalMonitoring environmentalMonitoring = new EnvironmentalMonitoring();
		startThread(trafficManagement);
		startThread(smartLighting);
		startThread(environmentalMonitoring);
	}

	private static void startThread(Runnable runnable) {
		new Thread(runnable).start();
	}

	private static void sleep(int seconds) {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}
}
