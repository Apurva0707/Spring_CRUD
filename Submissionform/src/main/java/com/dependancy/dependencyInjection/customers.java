package com.dependancy.dependencyInjection;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class customers {
		@Id
private int custid;
private String custname;
private String custemail;

public int getCustid() {
	return custid;
}
public void setCustid(int custid) {
	this.custid = custid;
}
public String getCustname() {
	return custname;
}
public void setCustname(String custname) {
	this.custname = custname;
}
public String getCustemail() {
	return custemail;
}
public void setCustemail(String custemail) {
	this.custemail = custemail;
}
@Override
public String toString() {
	return "customers [custid=" + custid + ", custname=" + custname + ", custemail=" + custemail + "]";
}
}
