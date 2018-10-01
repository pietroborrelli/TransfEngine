package it.polimi.domain.enumeration;

public enum Ordering {

	ASCENDING("asc"),
	DESCENDING("desc");
	
	private String value;
	
	Ordering(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
