package management.model;

public class User {
	
	protected int pid;
	protected String pname;
	protected String pprice;
	protected String pquantity;
	protected String pdiscount;
	
	
	public User(int pid, String pname, String pprice, String pquantity, String pdiscount) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pquantity = pquantity;
		this.pdiscount = pdiscount;
	}
	
	public User(String pname, String pprice, String pquantity, String pdiscount) {
		super();
		this.pname = pname;
		this.pprice = pprice;
		this.pquantity = pquantity;
		this.pdiscount = pdiscount;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public String getPquantity() {
		return pquantity;
	}
	public void setPquantity(String pquantity) {
		this.pquantity = pquantity;
	}
	public String getPdiscount() {
		return pdiscount;
	}
	public void setPdiscount(String pdiscount) {
		this.pdiscount = pdiscount;
	}

}
