package com.greatlearning.services;

public class OTPGenerator {

	public int generateOTP(){
//		return Math.random();
		return (int)(Math.random()*9000)+999;
//		12344567792
//		1342
	}
}
