package com.edvantis.jt.case14.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.edvantis.jt.case14.dao.OrderDAOabstract;
import com.edvantis.jt.case14.dao.WorkerDAOabstract;
import com.edvantis.jt.case14.dao.factory.OrderDAOFactory;
import com.edvantis.jt.case14.dao.factory.WorkerDAOFactory;
import com.edvantis.jt.case14.dao.hibernate.OrderDAOHibernate;
import com.edvantis.jt.case14.exceptions.OrderException;
import com.edvantis.jt.case14.exceptions.WorkerExceptions;
import com.edvantis.jt.case14.model.data.*;
import com.edvantis.jt.case14.model.workers.*;
import com.edvantis.jt.case14.validator.OrderValidator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



/*
 * Controller for /taxiservice 
 */
@Path("/taxiservice")			// for url - http://127.0.0.1:8080/taxi2/rest/taxiservice/status
public class TaxiService {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("status")
	public Response getStatus(){
		return Response.ok("{\"status\":\"Service Taxi is running...\"}").build();
	}
	
	
	// WORKS---
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("orders")
	public Response getOrders2(){
		System.out.println("***Command from UI to read orders.");
		String response ;
		try{
		OrdersDB ordersDB0 = OrdersDB.getReference();	// instance of OrdersDB class in ram
		OrderDAOabstract ordersDAO = OrderDAOFactory.getOrdersDbDAO(); 		// instance of OrderDAO class for CRUD operations with MySQL
		
		// +Here I read all data from ordersDB table of database
		ordersDAO.readAllordersDB();
		System.out.println("*** OrdersDB0.size()= "+ordersDB0.getOrdersDBSize());
		response = toJSONString(ordersDB0);
		
		}catch(Exception e){
			response = " Status: 401. \nDeveloper message in getOrders: "+e.getMessage();
			return Response.status(401).entity(response).build();
		}
		return Response.ok(response).build();
	}
	
	
	
	// WORKS+
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("orders")
	public Response getOrders(){
		String response ;
		try{
		OrdersDB ordersDB0 = OrdersDB.getReference();	// instance of OrdersDB class in ram
		OrderDAOabstract ordersDAO = OrderDAOFactory.getOrdersDbDAO(); 		// instance of OrderDAO class for CRUD operations with MySQL
		
		// +Here I read all data from ordersDB table of database
		ordersDAO.readAllordersDB();
		System.out.println("*** OrdersDB0.size()= "+ordersDB0.getOrdersDBSize());
		response = toJSONString(ordersDB0);
		
		}catch(Exception e){
			response = " Status: 401. \nDeveloper message in getOrders: "+e.getMessage();
			return Response.status(401).entity(response).build();
		}
		return Response.ok(response).build();
	}
	
	
	// WORKS+
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("order/{id}")
	public Response getOrder(@PathParam("id") String id){
		String response ;
		int iid;
		try{
		OrderDAOabstract ordersDAO = OrderDAOFactory.getOrdersDbDAO(); 		// instance of OrderDAO class for CRUD operations with MySQL
		
		// +Here I read all data from ordersDB table of database
		iid=Integer.parseInt(id);
		ordersDAO.findById(iid);
		
		response = toJSONString(ordersDAO.findById(iid));
		}catch(Exception e){
			response = " Status: 401. \nDeveloper message in getOrder: "+e+"\n"+e.getMessage();
			return Response.status(401).entity(response).build();
		}
		return Response.ok(response).build();
	}
	
	

	// WORKS++
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("orderc")
	public Response createOrder(String wdata) {
		System.out.println("***Command from UI to create order: " + wdata);
	/*
	 *  get Order object parsed from JSON string		
	 *  "{"id":1011,"dateAndTime":"Jun 23, 2015 12:01:45 PM","addr1":"From: Volodymyra 666","addr2":"To: Chernivetska 60","distance":995.0,"orderCost":361.0,"customerPhone":"5016046","carNumber":"BC90900AA","carDriver":"Vasil_19","isDone":true}";
	 */
		Order order = new Order();
		String responce = "Order created !";
		try {
			OrderDAOabstract ordersDAO = OrderDAOFactory.getOrdersDbDAO(); 		// instance of OrderDAO class for CRUD operations with MySQL
			order = FromJson.from(wdata);
			OrderValidator.orderDataIsValid(order);
			ordersDAO.addToOrdersDB(order);
			return Response.ok(responce).build();
			
		} catch (Exception e) {
			responce = "Order not created \nDeveloper message: " + e.getMessage();
			System.out.println(e.getMessage()+ "\n"+e);
			return Response.status(500).entity(responce).build();
		}
		
	}
	

	// WORKS ++
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("orderd")
	public Response delOrder(String id){
		System.out.println("*** Command from UI to delite order ID:" + id +".");
		String response ;
		int iid;
		try{
		OrderDAOabstract ordersDAO = OrderDAOFactory.getOrdersDbDAO(); 		// instance of OrderDAO class for CRUD operations with MySQL
		
		iid=Integer.parseInt(id);
		ordersDAO.delOrder(iid);
		
		response = " Order "+id+" was deleted from DB.";
		}
		catch(NumberFormatException e){
			response = "Ok";
		}
		catch(Exception e){
			response = " Order Not deleted\nDeveloper message: "+e+"\n"+e.getMessage();
			return Response.status(500).entity(response).build();
		}
		return Response.ok(response).build();
	}	
	
	
	
	 // WORKS
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		@Path("orderu")
		public Response updeteOrder(String wdata) {
			System.out.println("*** Update command from UI" + wdata);

			String response = "Order updated !";
			Order order = new Order();
			
			try {
				OrderDAOabstract ordersDAO = OrderDAOFactory.getOrdersDbDAO(); 		// instance of OrderDAO class for CRUD operations with MySQL
				order = FromJson.from(wdata);
				OrderValidator.orderDataIsValid(order);				
				ordersDAO.updateOrder(order);
				return Response.ok(response).build();
				
			} catch (Exception e) {
				System.out.println("*** Update faile! Exception occures: "+e);
				response = "Order not updated \nDeveloper message: " + e.getMessage();
				return Response.status(500).entity(response).build();
			}
			
		}
	
		

		
	public String toJSONString(Object object){
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		return gson.toJson(object);
	}
	
}
