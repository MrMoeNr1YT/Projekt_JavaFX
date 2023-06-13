package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Bemerkung {

	private  StringProperty datum; 
	private StringProperty bemerkung;
	
	public Bemerkung(String Datum, String Bemerkung) {
		this.datum = new SimpleStringProperty(Datum); 
		this.bemerkung = new SimpleStringProperty(Bemerkung);
		System.out.println("OK");
	}
	
	public StringProperty datumProperty() {
		if(this.datum == null) {
			this.datum = this.datum = new SimpleStringProperty("--/--/----"); 
		}
		return datum; 
	}

	public StringProperty bemerkungProperty() {
		if(this.bemerkung == null) {
			this.bemerkung = this.bemerkung = new SimpleStringProperty("-"); 
		}
		return bemerkung; 
	}
	
	
	public StringProperty getDatum() {
		return datum;
	}

	public void setDatum(StringProperty datum) {
		datum = datum;
	}

	public StringProperty getBemerkung() {
		return bemerkung;
	}

	public void setBemerkung(StringProperty bemerkung) {
		bemerkung = bemerkung;
	}
	
	
}
