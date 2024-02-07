package KLASEE;

public class History {
	public String naziv;
	public int vreme;
	public Datee datum;
	public int cal;
	public History(String naziv, int vreme, Datee datum,int cal) {
		super();
		this.naziv = naziv;
		this.vreme = vreme;
		this.datum = datum;
		this.cal=cal;
	}
	@Override
	public String toString() {
		return ""+naziv+"\t"+vreme+"\t"+cal+"\t"+datum;
	}

}
