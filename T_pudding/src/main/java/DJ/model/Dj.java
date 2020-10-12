package DJ.model;

public class Dj {
private int Dj_no;
private String Dj_code;
private String Dj_list;
public Dj() {
	super();
}
public int getDj_no() {
	return Dj_no;
}
public void setDj_no(int dj_no) {
	Dj_no = dj_no;
}
public String getDj_code() {
	return Dj_code;
}
public void setDj_code(String dj_code) {
	Dj_code = dj_code;
}
public String getDj_list() {
	return Dj_list;
}
public void setDj_list(String dj_list) {
	Dj_list = dj_list;
}
public Dj(int dj_no, String dj_code, String dj_list) {
	super();
	Dj_no = dj_no;
	Dj_code = dj_code;
	Dj_list = dj_list;
}

}