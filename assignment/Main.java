package day15;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ParcelTracker obj = new ParcelTracker();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter starting date in YYYY-MM-DD : ");
		String startDate = sc.next();	//="2021-03-14"; 
		System.out.println("Enter starting time in HH:MM:SS : ");
		String startTime = sc.next();	//="06:00:00";  
		System.out.println("Enter source : ");
		String source = sc.next();	// = "Pollachi";
		System.out.println("Enter destination : ");
		String destination = sc.next(); 		//= "Delhi";
		System.out.println("Enter travel distance in KM : ");
		double distance = sc.nextDouble(); 		//= 2574;
		System.out.println("Enter travel speed in KMPH: ");
		double speed = sc.nextDouble();	// = 100;
		System.out.println("Enter travel break in HH:MM:SS : ");
		String travelBreak = sc.next();	//= "06:00:00";
		
		obj.setStartDate(startDate);
		obj.setsTime(startTime);
		obj.setSource(source);
		obj.setDestination(destination);
		obj.setDist(distance);
		obj.setSpeed(speed);
		obj.setTravelBreak(travelBreak);
		
		LocalDateTime endDateTime = Container.getDeliveryDateTime(obj);
		
		System.out.println(endDateTime);
		
		sc.close();
	}
}

class Container {
	 static LocalDateTime getDeliveryDateTime(ParcelTracker obj) { 
		LocalTime breakTime = LocalTime.parse(obj.getTravelBreak());
		String str = obj.getStartDate()+" "+obj.getStartTime(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		LocalDateTime endDateTime = LocalDateTime.parse(str, formatter);
		
		int totalTime = obj.calculateTotalTime(obj.getDist(), obj.getSpeed(), breakTime);
		endDateTime = obj.calculateBusinessDays(totalTime, endDateTime);
		endDateTime = obj.addTimeToBusinessDays(totalTime, endDateTime);
		return endDateTime;
	}
}    