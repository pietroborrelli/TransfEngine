package it.polimi.domain.abstractmodel;

import java.util.List;

import it.polimi.domain.key.PrimaryKey;

public class Block {

	private PrimaryKey key;
	private List<Entry> entries;
	
	public Block() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrimaryKey getKey() {
		return key;
	}
//mettere un to string per convertire la chiave!!
	public void setKey(PrimaryKey key) {
		this.key = key;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	@Override
	public String toString() {
		return "Block [key=" + key + ", entries=" + entries + "]";
	}
	

	
}
