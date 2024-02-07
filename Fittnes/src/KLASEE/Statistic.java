package KLASEE;

public class Statistic {
	public int distanca;
	public int time;
	public int cal;
	public Statistic(int distanca, int time, int cal) {
		super();
		this.distanca = distanca;
		this.time = time;
		this.cal = cal;
	}
	@Override
	public String toString() {
		return "Statistic [distanca=" + distanca + ", time=" + time + ", cal=" + cal + "]";
	}
	
	
}
