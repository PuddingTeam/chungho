package Music.model;

public class Dj {
private int dj_no;
private String dj_code;
private String dj_list;
public Dj() {
	super();
}
public int getDj_no() {
	return dj_no;
}
public void setDj_no(int dj_no) {
	this.dj_no = dj_no;
}
public String getDj_code() {
	return dj_code;
}
public void setDj_code(String dj_code) {
	this.dj_code = dj_code;
}
public String getDj_list() {
	return dj_list;
}
public void setDj_list(String dj_list) {
	this.dj_list = dj_list;
}
public Dj(int dj_no, String dj_code, String dj_list) {
	super();
	this.dj_no = dj_no;
	this.dj_code = dj_code;
	this.dj_list = dj_list;
}


}