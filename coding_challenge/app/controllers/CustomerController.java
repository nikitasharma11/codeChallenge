/**
 * The package routes http requests to service class CustomerServiceImpl
 */
package controllers;

import javax.inject.Singleton;
import models.Customer;
import play.mvc.Controller;
import play.mvc.Result;
import services.CustomerServiceImpl;
import utils.JSON_Result;

/**
 * @author nikita
 *
 */
public class CustomerController {
	//singleton creates only one instance of the controller class
	//Required for creating one instance of CustomerServiceImpl which contains data storage
	//definitions
	@Singleton
	public class AsyncController extends Controller {
		CustomerServiceImpl customerserviceimplobj = new CustomerServiceImpl();
		
		
		public Result saveCustomer(String full_name, String email_id) {
			int customer_id = 0;
			
			customer_id = customerserviceimplobj.addCustomer(full_name, email_id);
			
			JSON_Result qr = null;
			
			if (customer_id!=0) {
				
				qr = new JSON_Result(200, "Successfull", customer_id);
			} else
				qr = new JSON_Result(400, "No customer added found.", "", "false");

			return ok(play.libs.Json.toJson(qr));
		}
		
		public Result saveContract(int customer_id, String contractType,Double revenue) {
			int contract_id = 0;
			
			contract_id = customerserviceimplobj.addContract(customer_id, contractType,revenue);
			
			JSON_Result qr = null;
			
			if (contract_id!=0) {
				
				qr = new JSON_Result(200, "Successfull", customer_id);
			} else
				qr = new JSON_Result(400, "No customer added found.", "", "false");

			return ok(play.libs.Json.toJson(qr));
		}
		
		public Result fetchRevenueByCustomer(int customer_id) {
			
			Double revenue = -1.1;
			revenue = customerserviceimplobj.FetchCustomerRevenue(customer_id);
			
			JSON_Result qr = null;
			
			if (revenue!=-1.1) {
				
				qr = new JSON_Result(200, "Successfull", revenue);
			} else
				qr = new JSON_Result(400, "no valid revenue found.", "", "false");

			return ok(play.libs.Json.toJson(qr));
		}
		public Result fetchRevenueByContractType(String contractType) {
			Double revenue = -1.1;
			revenue = customerserviceimplobj.FetchContractTypeRevenue(contractType);
			
			JSON_Result qr = null;
			
			if (revenue!=-1.1) {
				
				qr = new JSON_Result(200, "Successfull", revenue);
			} else
				qr = new JSON_Result(400, "no valid revenue found.", "", "false");

			return ok(play.libs.Json.toJson(qr));
		}
		public Result fetchCustomer(int customer_id) {
			Customer newCustomerObj = new Customer();
			
			newCustomerObj = customerserviceimplobj.fetchCustomer(customer_id);
			
			JSON_Result qr = null;
			
			if (!newCustomerObj.equals(null)) {
				
				qr = new JSON_Result(200, "Successfull", newCustomerObj);
			} else
				qr = new JSON_Result(400, "No customer added found.", "", "false");

			return ok(play.libs.Json.toJson(qr));
		}

}
}
