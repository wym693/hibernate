package bean;

import java.sql.Blob;

/**
 * Bigobject entity. @author MyEclipse Persistence Tools
 */

public class Bigobject_1 implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tclob;
	private byte[] tblob;

	// Constructors

	/** default constructor */
	public Bigobject_1() {
	}

	/** minimal constructor */
	public Bigobject_1(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTclob() {
		return tclob;
	}

	public void setTclob(String tclob) {
		this.tclob = tclob;
	}

	public byte[] getTblob() {
		return tblob;
	}

	public void setTblob(byte[] tblob) {
		this.tblob = tblob;
	}


}