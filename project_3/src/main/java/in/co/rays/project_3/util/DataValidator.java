package in.co.rays.project_3.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DataValidator class is used to validate the data entered by user
 * 
 * @author Dipanshi Mukati
 *
 */
public class DataValidator {
	
	
	   
       
       
	 public static boolean isNumerics(String str) {
	        for (char c : str.toCharArray()) {
	            if (!Character.isDigit(c)) {
	                return false;
	            }
	        }
	        return true;
	        
	    }

	 public static boolean isMobileNo(String val){
	    	
	    	String mobreg = "^[6-9][0-9]{9}$";
	    	
	    			if (isNotNull(val) && val.matches(mobreg)) {
						
							return true;
	    				}else{
	    					
	    					return false;
						}	
	    		}
	
	
	public static boolean isNamemaxlegntten(String name) {

		String namereg ="^.{0,30}$";

		// String sname = name.trim();

		if (isNotNull(name) && name.matches(namereg)) {

			return true;
		} else {
			return false;
		}
	}
	
	
	
	public static boolean isFloat(String val) {
		if (isNotNull(val)) {
			try {
				float i = Float.parseFloat(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else {
			return false;
		}
	}
	public static boolean isNamemaxlegntfifty(String name) {

		String namereg ="^.{0,200}$";

		// String sname = name.trim();

		if (isNotNull(name) && name.matches(namereg)) {

			return true;
		} else {
			return false;
		}
	}
	
	


	public static boolean isName(String name) {

		String namereg = "^[^-\\s][\\p{L} .']+$";

		// String sname = name.trim();

		if (isNotNull(name) && name.matches(namereg)) {

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if value of Password is in between 8 and 12 characters
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isPasswordLength(String val) {

		if (isNotNull(val) && val.length() >= 8 && val.length() <= 12) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * public static boolean isValidAge(String val) {
	 * 
	 * boolean pass = false; if (isDate(val)) { Date cdate = new Date(); try { Date
	 * userdate = DataUtility.formatter.parse(val); int age =
	 * cdate.getYear()-userdate.getYear(); System.out.println("final age  "+age);
	 * if(age>=18){ pass=true; } } catch (ParseException e) {
	 * 
	 * } }
	 * 
	 * return pass; }
	 */

	public static boolean isPassword(String pass) { // my method created

		System.out.println("validate pass");
		String passreg = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
		// String passreg="^[0-9a-zA-Z]{5}$";
		// String spass = pass.trim();
		// int checkIndex = spass.indexOf(" ");
		// checkIndex==-1
		if (isNotNull(pass) && pass.matches(passreg)) {
			System.out.println("true");
			return true;
		}

		else {
			return false;
		}
	}

	public static boolean isRollNo(String roll) { // my method created

		String rollreg = "[a-zA-Z]{2}[0-9]{3}";
		// String sroll = roll.trim();

		if (DataValidator.isNotNull(roll)) {

			boolean check = roll.matches(rollreg);
			System.out.println(check);
			return check;
		}

		else {

			return false;
		}
	}

	/**
	 * Ckeck if value is Null
	 * 
	 * @param val :val
	 * @return boolean
	 */

	public static boolean isNull(String val) {
		if (val == null || val.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * check if value is Not Null
	 * 
	 * @param val :value
	 * @return boolean
	 */

	public static boolean isNotNull(String val) {
		return !isNull(val);
	}

	/**
	 * check if an value is an Integer
	 * 
	 * @param val :value
	 * @return boolean
	 */
	public static boolean isInteger(String val) {
		if (isNotNull(val)) {
			try {
				Integer.parseInt(val);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * check if an value is an Long
	 * 
	 * @param val :value
	 * @return boolean
	 */
	public static boolean isLong(String val) {
		System.out.println("in datavalidator..........." + val);
		if (isNotNull(val)) {
			try {
				long l = Long.parseLong(val);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isValidAge(String val) {

		boolean pass = false;
		if (isDate(val)) {
			Date cdate = new Date();
			try {
				Date userdate = DataUtility.formatter.parse(val);
				int age = cdate.getYear() - userdate.getYear();
				System.out.println("final age  " + age);
				if (age >= 18) {
					pass = true;
				}
			} catch (ParseException e) {

			}
		}

		return pass;
	}

	

	/**
	 * Check if value is valid EmailId
	 * 
	 * @param val :val
	 * @return boolean
	 */
	public static boolean isEmail(String val) {
		String emailregex = "^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		if (isNotNull(val)) {
			try {
				return val.matches(emailregex);
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * check if value is date
	 * 
	 * @param val :val
	 * @return boolean
	 */
	public static boolean isDate(String val) {
		Date d = null;
//		    String s = val;
//			s = s.replace("-", "/");
		if (isNotNull(val)) {
			d = DataUtility.getDate(val);
		}
		return d != null;
	}

	/**
	 * Checks if value is valid Phone No.
	 * 
	 * @param val :val
	 * @return boolean
	 */
	public static boolean isPhoneNo(String val) {

		String phonereg = "^[6-9][0-9]{9}$";
		//String phonereg1 = "^[6-9]{10}$";

		if (isNotNull(val)) {
			try {
				return val.matches(phonereg);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}

	/**
	 * Checks if value of Mobile No is 10
	 * 
	 * @param val :value
	 * @return boolean
	 */
	public static boolean isPhoneLength(String val) {

		if (isNotNull(val) && val.length() == 10) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Test Above Methods
	 * 
	 * @param args :args
	 */
	public static void main(String[] args) {
//	  System.out.println(isNull("ssd"));
//	  System.out.println(isNotNull(""));//dought
//	  System.out.println(isInteger("2147483649"));
//	  System.out.println(isLong("50.5"));
//	  System.out.println(isEmail("rah@g.com"));
//	  System.out.println(isDate("18/11/1989"));
		System.out.println(isName("Ankur Agrawal"));
	}

	 public static boolean isAlphanumeric(String input) {
	        String pattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20})";
	        return input.matches(pattern);
	    }
	 
	 public static boolean isTooLong(String val, int maxLength) {
		    if (isNotNull(val)) {
		        return val.length() > maxLength;
		    } else {
		        return false;
		    }
		}
	 public boolean validateDates(HttpServletRequest request) {
	     boolean pass = true;

	     // Get the startDate and endDate from the request
	     String startDate = request.getParameter("startDate");
	     String endDate = request.getParameter("endDate");

	     // Check if the startDate and endDate are valid date strings (in the format yyyy-MM-dd)
	     if (isValidDate(startDate) && isValidDate(endDate)) {
	         Date start = parseDate(startDate);
	         Date end = parseDate(endDate);

	         // Check if the endDate is before the startDate
	         if (start != null && end != null && !end.after(start)) {
	             // If the endDate is not after the startDate
	             request.setAttribute("endDate", PropertyReader.getValue("error.endDateBeforeStart", "endDate"));
	             pass = false;
	         }
	     }

	     return pass;
	 }

	 // Method to check if a date is in valid format (e.g., yyyy-MM-dd)
	 public static boolean isValidDate(String dateStr) {
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     sdf.setLenient(false); // To ensure strict parsing
	     try {
	         sdf.parse(dateStr); // Try to parse the date
	         return true;
	     } catch (ParseException e) {
	         return false; // If parsing fails, it's an invalid date
	     }
	 }

	 // Method to parse the date into a Date object
	 private Date parseDate(String dateStr) {
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     try {
	         return sdf.parse(dateStr);
	     } catch (ParseException e) {
	         return null; // Return null if parsing fails
	     }
	 }

	 
	 
}
