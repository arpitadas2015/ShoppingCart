package com.example.service;

import java.text.ParseException;

public interface SubscriptionService {
	
	public  String generateInvoive(String invoiceCharge, 
			String subsType, String period, String startDate, 
			String endDate) throws Exception,ParseException;

}
