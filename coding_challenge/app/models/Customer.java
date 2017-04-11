
package models;

/**
 * The class defines the model for entity for customer
 * declares entity features customer_id,customer_name,customer_email
 * defines default and parameterized constructor
 * defines access methods
 * defines mutator methods
 * @author nikita
 *
 */
public class Customer  {
	
	int customer_id;
	String customer_name;
	String customer_email;
	
	public Customer()
	{
		
	}
	
	public Customer(int id,String name, String email)
	{
		customer_id = id;
		customer_name = name;
		customer_email = email;
	}
	
	 public int getcustomer_id() {
	        return this.customer_id ;
	    }
	 
	 public void setCustomer_id(int id) {
	       this.customer_id = id;
	    }
	 public String getCustomer_name() {
	        return this.customer_name ;
	    }
	 
	 public void setCustomer_name(String name) {
	       this.customer_name = name;
	    }
	 public String getEmailID() {
	        return this.customer_email ;
	    }
	 
	 public void setEmailID(String email) {
	       this.customer_email = email;
	    }

}
