package bean;

import java.sql.Blob;
import java.sql.Clob;

/**
 * Bigobject entity. @author MyEclipse Persistence Tools
 */

public class Bigobject_2 implements java.io.Serializable {

	// Fields

	private Integer id;
	private Clob tclob;
	private Blob tblob;

	// Constructors

	/** default constructor */
	public Bigobject_2() {
	}

	/** minimal constructor */
	public Bigobject_2(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Clob getTclob() {
		return tclob;
	}

	public void setTclob(Clob tclob) {
		this.tclob = tclob;
	}

	public Blob getTblob() {
		return tblob;
	}

	public void setTblob(Blob tblob) {
		this.tblob = tblob;
	}


}