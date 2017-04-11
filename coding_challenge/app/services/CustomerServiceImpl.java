/**
 * 
 * Implements the all the services associated with the application and described in the abstract class CustomerService
 * @param customerContractsMap  a hashmap that stores list of contracts associated with each customer where key is
 * is a unique customerId and value is a list of Contracts of type(models.SalesContract)  
   Hashmap is being used as a data storage structure and is beneficial for efficient retrieval.
 * @param customerDetailMap  a hashmap that stores customer details with customer_id as key and value as object
 *        of class type Customer.
 * @author nikita
 *
 */

package services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Singleton;

import models.Customer;
import models.SalesContract;


@Singleton   //creates only a single instance of the class. required to maintain hashmap with their data.
public class CustomerServiceImpl implements CustomerService  {
	public static HashMap<Integer,ArrayList<SalesContract>> customerContractsMap = new HashMap<Integer,ArrayList<SalesContract>>();
	public static HashMap<Integer,Customer> customerDetailMap = new HashMap<Integer,Customer>();
	private static AtomicInteger customer_counter = new AtomicInteger(0);
	private static AtomicInteger contract_counter = new AtomicInteger(0);


/*
 * (non-Javadoc)
 * @see services.CustomerService#addCustomer(int, java.lang.String, java.lang.String)
 * this function adds customer data to hashmap customerDetailMap
 */
	public int addCustomer(String name,String email)
	{   
		int customerID = customer_counter.incrementAndGet();

		Customer newCustomerObj = new Customer(customerID,name,email);
		
		if(!customerDetailMap.containsKey(customerID))
		{
			customerDetailMap.put(customerID, newCustomerObj);
		}
		
			
		return customerID;
	}
	
	/*
	 * (non-Javadoc)
	 * @see services.CustomerService#fetchCustomer(int)
	 * fetch customer details for a particular customer id
	 */
	public Customer fetchCustomer(int id)
	{   
		Customer newCustomerObj = new Customer();
		
		if(customerDetailMap.containsKey(id))
		{
			newCustomerObj = customerDetailMap.get(id);
		}
		
			
		return newCustomerObj;
	}
	
	/*
	 * (non-Javadoc)
	 * @see services.CustomerService#addContract(int, int, java.lang.String, java.lang.Double)
	 * Add contract details for a specific customer in customerContractsMap
	 */
	public int addContract(int customerID,String contractType,Double revenue)
	{   
	    
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		int contractID = customer_counter.incrementAndGet();
		
		SalesContract newContractObj = new SalesContract(contractID,customerID,date,contractType,revenue);
		ArrayList<SalesContract> contractList = new ArrayList<SalesContract>();
		
		if(customerContractsMap.containsKey(newContractObj.getCustomer_ref_id()))
				{
					contractList = customerContractsMap.get(newContractObj.getCustomer_ref_id());
				
				}
		contractList.add(newContractObj);
		customerContractsMap.put(newContractObj.getCustomer_ref_id(), contractList);
		
		
	/*	if(!contractDetailMap.containsKey(contractID))
		{
			contractDetailMap.put(contractID, newContractObj);
		}
		*/
		
			
		return contractID;
	}
	
	/*
	 * (non-Javadoc)
	 * @see services.CustomerService#FetchCustomerContracts(int)
	 * Fetch list of contracts for a particular customer
	 */
	
	public ArrayList<SalesContract> FetchCustomerContracts(int customerID)
	{   
		ArrayList<SalesContract> contractList = new ArrayList<SalesContract>();
		//SalesContract ContractObj = new SalesContract();
		
		contractList = customerContractsMap.get(customerID);
		
		/*for(Integer contractKey:contractDetailMap.keySet())
		{
			SalesContract contractObj = contractDetailMap.get(contractKey);
			if(contractObj.getCustomer_ref_id()==customerID)
			{
				contractList.add(contractObj);
			}
		}
		
			*/
			
		return contractList;
	}
	
	/*
	 * (non-Javadoc)
	 * @see services.CustomerService#FetchCustomerRevenue(int)
	 * Generates total revenue of a customer by adding up all revenues of his contracts
	 */
	
	public Double FetchCustomerRevenue(int customerID)
	{   
		ArrayList<SalesContract> contractList = new ArrayList<SalesContract>();
		//SalesContract ContractObj = new SalesContract();
		
		contractList = customerContractsMap.get(customerID);
		Double revenue = 0.0;
		for(SalesContract contractObj:contractList)
		{
			revenue = revenue + contractObj.getRevenue();
		}
		
			
			
		return revenue;
	}
	
	/*
	 * (non-Javadoc)
	 * @see services.CustomerService#FetchContractTypeRevenue(java.lang.String)
	 * Generates total contract revenue based on type of revenue
	 */
	
	public Double FetchContractTypeRevenue(String contractType)
	{   
		ArrayList<SalesContract> contractList = new ArrayList<SalesContract>();
		//SalesContract ContractObj = new SalesContract();
		
		Double revenue = 0.0;
		for(SalesContract contractObj:contractList)
		{   
			if(contractObj.getContract_type().equalsIgnoreCase(contractType))
					revenue = revenue + contractObj.getRevenue();
		}
		
			
			
		return revenue;
	}

}
