package day15;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.IntFunction;

interface Tracker {
	public int calculateTotalTime(double dist, double speed, LocalTime breakTime);
	public LocalDateTime calculateBusinessDays(int totalTime, LocalDateTime endDateTime);
	public LocalDateTime addTimeToBusinessDays(int totalTime, LocalDateTime endDateTime);
}

class ParcelTracker implements Tracker {
	private String startDate;	
	private String startTime;	
	private String source;	
	private String destination; 		
	private double distance; 		
	private double speed;	
	private String travelBreak;	
		
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String sDate) {
		this.startDate = sDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setsTime(String startTime) {
		this.startTime = startTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getDist() {
		return distance;
	}

	public void setDist(double distance) {
		this.distance = distance;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getTravelBreak() {
		return travelBreak;
	}

	public void setTravelBreak(String travelBreak) {
		this.travelBreak = travelBreak;
	}

	@Override
	public LocalDateTime addTimeToBusinessDays(int totalTime, LocalDateTime endDateTime) {
		endDateTime = endDateTime.plusMinutes(totalTime);
		return endDateTime;
	}
	
	@Override
	public LocalDateTime calculateBusinessDays(int totalTime, LocalDateTime endDateTime) {
		Duration d = Duration.ofMinutes(totalTime);
        long day = d.toDays();
			    
	    IntFunction<TemporalAdjuster> addBusinessDays = days -> TemporalAdjusters.ofDateAdjuster(
        	    date -> {
        	      LocalDate baseDate =
        	          days > 0 ? date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
        	              : days < 0 ? date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)) : date;
        	      int businessDays = days + Math.min(Math.max(baseDate.until(date).getDays(), -4), 4);
        	      return baseDate.plusWeeks(businessDays / 5).plusDays(businessDays % 5);
        	    });
	    
	    if((endDateTime.toLocalDate()).equals(LocalDate.of(endDateTime.getYear(), 1, 1))
	    		|| (endDateTime.toLocalDate()).equals(LocalDate.of(endDateTime.getYear(), 1, 26))
	    		|| (endDateTime.toLocalDate()).equals(LocalDate.of(endDateTime.getYear(), 8, 15))
	    		|| (endDateTime.toLocalDate()).equals(LocalDate.of(endDateTime.getYear(), 10, 2))) {
	    	//endDateTime.withDayOfMonth(1);
	    	day+=1;
	    } 
		    
	    endDateTime = endDateTime.with(addBusinessDays.apply((int)day));
	    return endDateTime;
	}
	
	@Override
	public int calculateTotalTime(double dist, double speed, LocalTime breakTime) {
		int hourSum=0, minSum=0, secs=0;
		double time = (dist/speed)*60; //value in minutes
		int hrs=0, mts=0, sec=0;
		
		if(time > 59) { 
			hrs = (int)(time/60);
			mts = (int)(time%60);
			if(mts > 59) {
				minSum = (int)(mts/60);
				sec = (int)(mts%60);
			}
			if(minSum > 59) {
				mts += (minSum/60);
				sec += (minSum%60);
			}
			hourSum = breakTime.getHour()+hrs;
			minSum = breakTime.getMinute()+mts;
			secs = breakTime.getSecond()+sec;
			System.out.println("time....."+hourSum+":"+minSum+":"+secs);
		} else {
			minSum = breakTime.getMinute()+(int)time;
			if(minSum > 59) {
				mts += (minSum/60);
				sec += (minSum%60);
			}
		}
		return (hourSum*60)+minSum+(secs/60);	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		temp = Double.doubleToLongBits(speed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((travelBreak == null) ? 0 : travelBreak.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParcelTracker other = (ParcelTracker) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (travelBreak == null) {
			if (other.travelBreak != null)
				return false;
		} else if (!travelBreak.equals(other.travelBreak))
			return false;
		return true;
	}

}
