package day19;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

interface OrderTracker {
	public void trackOrder(int invNo);
}

public class TrackerDemo implements OrderTracker {
	public void trackOrder(int invNo) {
		InvoiceMasterDAOImpl invoiceDAO = new InvoiceMasterDAOImpl();
		InvoiceMasterDTO invoiceDTO = 	invoiceDAO.getInvoiceMaster(invNo);
		int custNo = invoiceDTO.getCustomerno();
		
		CustomerMasterDAOImpl custDAO = new CustomerMasterDAOImpl();
		CustomerMasterDTO custDTO = custDAO.getCustomerMaster(custNo);
		String address = custDTO.getCustAddress();
		
		ParcelTracker obj = new ParcelTracker();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter starting date in YYYY-MM-DD : "); 
		LocalDate date = LocalDate.now();
		String startDate = String.valueOf(date);	//="2021-03-14"; 
//		System.out.println("Enter starting time in HH:MM:SS : "); 
//		String time = 
		String startTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);	//="06:00:00";  
//		System.out.println("Enter source : "); 
		String source = "Coimbatore";	// = "Pollachi"; 
//		System.out.println("Enter destination : "); 
		String destination = address;		//= "Delhi";
		System.out.println("Enter travel distance in KM : ");
		double distance=0;
		double speed=0;
		String travelBreak="";
		
		try {
			distance = Float.parseFloat(br.readLine()); //= 2574;
			System.out.println("Enter travel speed in KMPH: "); 	
			speed =Float.parseFloat(br.readLine());  // = 100;
			System.out.println("Enter travel break in HH:MM:SS : ");
			travelBreak = br.readLine(); //= "06:00:00";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  		
			
		obj.setStartDate(startDate);
		obj.setsTime(startTime);
		obj.setSource(source);
		obj.setDestination(destination);
		obj.setDist(distance);
		obj.setSpeed(speed);
		obj.setTravelBreak(travelBreak);
				
		LocalDateTime endDateTime = Container.getDeliveryDateTime(obj);
		
		System.out.println(endDateTime);
	}
}

class Container {
	 static LocalDateTime getDeliveryDateTime(ParcelTracker obj) { 
		LocalTime breakTime = LocalTime.parse(obj.getTravelBreak());
		String str = obj.getStartDate()+" "+obj.getStartTime(); 
//		System.out.println("str"+str);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime endDateTime = LocalDateTime.parse(str, formatter);
		
		int totalTime = obj.calculateTotalTime(obj.getDist(), obj.getSpeed(), breakTime);
		endDateTime = obj.calculateBusinessDays(totalTime, endDateTime);
		endDateTime = obj.addTimeToBusinessDays(totalTime, endDateTime);
		return endDateTime;
	}
}    