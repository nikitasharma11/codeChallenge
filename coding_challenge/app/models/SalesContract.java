/**
 * 
 */
package models;

import java.util.Date;



/**
 *  The class defines the model for entity for Sales Contract
 * declares entity features customer_reference id,contract id,contract start date
 * contract type and revenue generated per month
 * defines default and parameterized constructors
 * defines access methods
 * defines mutator methods
 * @author nikita
 *
 */
public class SalesContract  {
	
	int contract_id;
	int customer_ref_id;
	Date contract_start_date;
	String contract_type;
	Double revenue_per_month;
	
	public SalesContract()
	{
		
	}
	
	public SalesContract(int id,int ref_id, Date start_date,String type,Double revenue)
	{
		contract_id = id;
		customer_ref_id = ref_id;
		contract_start_date = start_date;
		contract_type = type;
		revenue_per_month = revenue;
	}
	
	 public int getContractID() {
	        return this.contract_id ;
	    }
	 
	 public void setContractID(int id) {
	       this.contract_id = id;
	    }

	 public int getCustomer_ref_id() {
	        return this.customer_ref_id ;
	    }
	 
	 public void setCustomer_ref_id(int id) {
	       this.customer_ref_id = id;
	    }
	 public Date getContract_start_date() {
	        return this.contract_start_date ;
	    }
	 
	 public void setContract_start_date(Date date) {
	       this.contract_start_date = date;
	    }
	 public String getContract_type() {
	        return this.contract_type ;
	    }
	 
	 public void setContractID(String type) {
	       this.contract_type = type;
	    }
	 public Double getRevenue() {
	        return this.revenue_per_month ;
	    }
	 
	 public void setRevenue(Double revenue) {
	       this.revenue_per_month = revenue;
	    }

}
