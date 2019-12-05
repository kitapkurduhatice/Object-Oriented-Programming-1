public class Person 
{
	
	
	private String name;
	private String surname;
	private int birthDay;
	private char gender;
	
        Person()
        {
            
        }
	public Person(String name, String surname, int birthDay, char gender) 
	{
		this.name = name;
		this.surname = surname;
		this.birthDay = birthDay;
		this.gender = gender;
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
	public int getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}