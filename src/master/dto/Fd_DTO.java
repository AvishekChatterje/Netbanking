package master.dto;

public class Fd_DTO 
{
	String cid;
	String fd_acc_no;
	int duration;
	double fd_pay;
	double fd_recieve;
	String start;
	String end;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getFd_acc_no() {
		return fd_acc_no;
	}
	public void setFd_acc_no(String fd_acc_no) {
		this.fd_acc_no = fd_acc_no;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getFd_pay() {
		return fd_pay;
	}
	public void setFd_pay(double fd_pay) {
		this.fd_pay = fd_pay;
	}
	public double getFd_recieve() {
		return fd_recieve;
	}
	public void setFd_recieve(double fd_recieve) {
		this.fd_recieve = fd_recieve;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	
}
