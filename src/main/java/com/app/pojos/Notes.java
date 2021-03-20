package com.app.pojos;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Notes")
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;

	  private String type;

	  @Lob
	  private byte[] data;
	  
	  @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id",nullable = false)// to specify name of FK column n adds NOT NULL constraint
	private Subjects selectedNotes;

	  
	  
	public Notes(Integer id, String name, String type, byte[] data) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Subjects getSelectedNotes() {
		return selectedNotes;
	}

	public void setSelectedNotes(Subjects selectedNotes) {
		this.selectedNotes = selectedNotes;
	}

	@Override
	public String toString() {
		return "Notes [id=" + id + ", name=" + name + ", type=" + type + ", data=" + Arrays.toString(data)
				+ ", selectedNotes=" + selectedNotes + "]";
	}
	  

	  
	  
}
