/**
 * 
 */
package services;

import java.util.ArrayList;

import models.*;

/**
 * Defines abstract methods for service layer functionalities
 * @author nikita
 *
 */
public interface CustomerService {
	
	 int addCustomer(int customerID,String full_name,String email);
	 
	 Customer fetchCustomer(int customerID);
	 
	 ArrayList<SalesContract> FetchCustomerContracts(int customerID);
	 
	 Double FetchCustomerRevenue(int customerID);
	 
	 Double FetchContractTypeRevenue(String contractType);
	 
	 int addContract(int contractID,int customerID,String contractType,Double revenue);
	//public double generate_revenue();

}
