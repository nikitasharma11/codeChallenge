/**
 * The class defines structure of json result
 * contract type and revenue generated per month
 * defines default and parameterized constructor
 * @author nikita
 *
 */

package utils;

public class JSON_Result {

    public int statusCode;
	 public String success = "true";
    public String statusMessage;
    public Object value;

    
    public JSON_Result() {
   	 
    }
    
    public JSON_Result(int statusCode, String statusMessage, Object value) {
   	 this.statusCode = statusCode;
   	 this.statusMessage = statusMessage;
   	 this.value = value;
    }
	 
    public JSON_Result(int p_statusCode, String p_statusMessage, Object p_value, String p_success) {
		 this.success = p_success;
   	 this.statusCode = p_statusCode;
   	 this.statusMessage = p_statusMessage;
   	 this.value = p_value;
    }
}
