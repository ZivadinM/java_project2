package KLASEE;

public class Datee {
	public int Year;
	public int Month;
	public int Day;
	public Datee(int day, int month, int year) {
		super();
		Year = year;
		Month = month;
		Day = day;
	}
	@Override
	public String toString() {
		return ""+Day+"."+Month+"."+Year+".";
		
	}
	
	
}
