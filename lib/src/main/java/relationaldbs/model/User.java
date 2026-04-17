package relationaldbs.model;

public class User {
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubscription() {
		return subscription;
	}
	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}
	//fields 
	private long id;
	private String name;
	private String surname;
	private int age;
	private String gender;
	private int phonenumber;
	private String email;
	private String subscription;
	
	
	//constructors
	public User(long id, String name, String surname, int age, String gender, int phonenumber, String email, String subscription) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.email = email;
		this.subscription = subscription;
		
		
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isVIP() {
		// TODO Auto-generated method stub
		return false;
	}
	public double getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
	


