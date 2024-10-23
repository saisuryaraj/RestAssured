package day2;

public class POJO_post {
	String name;
	String mobile;
	String location;
	String coursesArr[];
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile=mobile;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location=location;
	}
	
	public String[] getCourses() {
		return coursesArr;
	}
	public void setCourses(String[] coursesArr) {
		this.coursesArr=coursesArr;
	}
}
