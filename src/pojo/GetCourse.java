package pojo;


public class GetCourse {
	
	private String instructor;
	private String url;
	private String services;
	private Courses courses;
	private String expertise;
	private String linkedIn;
	
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
//	public pojo.Courses getCourses() {
//		return courses;
//	}
//	public void setCourses(pojo.Courses courses) {
//		this.courses = courses;
//	}
	
	public Courses getCourses() {
		return courses;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	

}
