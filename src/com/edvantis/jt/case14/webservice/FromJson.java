package com.edvantis.jt.case14.webservice;

import java.sql.Timestamp;

import com.edvantis.jt.case14.exceptions.OrderException;
import com.edvantis.jt.case14.model.data.Order;


public class FromJson {

	private static String json="";
	
	public static Order from(String json2) throws Exception{
		json=json2;
		Order order = new Order();
		
		try{order.setId(Integer.parseInt(data("id")));}catch(NumberFormatException e){order.setId(null);};
//		order.setDateAndTime(Timestamp.valueOf(data("dateAndTime")));
		order.setAddr1(data("addr1"));
		order.setAddr2(data("addr2"));
		order.setAddr34(data("addr34"));
		order.setCustomerPhone(data("customerPhone"));
		order.setCustomerName(data("customerName"));
		order.setCarNumber(data("carNumber"));
		order.setCarDriver(data("carDriver"));
		order.setIsDone(Boolean.valueOf(data("isDone")));
		
		
		try{order.setDistance(Float.parseFloat(data("distance")));}
		catch(Exception e){throw new Exception("ERROR. Please enter correct value of distance!");}
		
		try{
		order.setOrderCost(Float.parseFloat(data("orderCost")));
		}catch (Exception e){ throw new Exception(" ERROR. Please enter correct value of Order cost!");
			
		}
		
		return order;
	}
	
	
	
	
	private static String data(String str){
		String dat="";
		int begin, end;
		
		if(json.indexOf(str)==-1) return dat="0";
		
		begin =json.indexOf(str)+ str.length()+3;
		end = json.indexOf("\"", begin) ;
		dat=json.substring(begin, end);
//		if (str.contains("id")) dat=null;
		if(dat=="undefined") dat=null;
		
		System.out.println("*FromJson* "+str+"\t ==="+ dat+"===");
		
		return dat;
	}
	
	
}
