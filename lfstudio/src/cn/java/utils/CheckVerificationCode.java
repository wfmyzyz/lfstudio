package cn.java.utils;

public class CheckVerificationCode {
	
	public boolean check(String args0,String args1) {
		if(args0.toLowerCase().equals(args1.toLowerCase())) {
			return true;
		}
		return false;
	}
}
