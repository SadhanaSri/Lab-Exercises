package manytomany;

import java.util.Set;

public class Student {
	private int sid;
	private String sname;
	private int marks;
	private Set<Training> trainings;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int sid, String sname, int marks, Set<Training> trainings) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.marks = marks;
		this.trainings = trainings;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Set<Training> getTrainings() {
		return trainings;
	}
	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + marks;
//		result = prime * result + sid;
//		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
//		result = prime * result + ((trainings == null) ? 0 : trainings.hashCode());
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (marks != other.marks)
//			return false;
//		if (sid != other.sid)
//			return false;
//		if (sname == null) {
//			if (other.sname != null)
//				return false;
//		} else if (!sname.equals(other.sname))
//			return false;
//		if (trainings == null) {
//			if (other.trainings != null)
//				return false;
//		} else if (!trainings.equals(other.trainings))
//			return false;
//		return true;
//	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", marks=" + marks + ", trainings=" + trainings + "]";
	}
	
}
