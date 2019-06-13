package com.usa.state.ed.rulesServices;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.usa.state.ed.constants.EdRulesConstants;
import com.usa.state.ed.request.IndvInfoRequest;
import com.usa.state.ed.response.PlanInfoResponse;

/**
 * this interface is used to declare rules method and common method which are useful in sub classes
 * @author shrikant
 *
 */
public interface IRulesService {
	public PlanInfoResponse	executeRules(IndvInfoRequest request);
	SimpleDateFormat sdf = new SimpleDateFormat(EdRulesConstants.USDATEFORMAT);
	Calendar cal = Calendar.getInstance();
		/**
		 * this method is used to defined  start date of the plan
		 * @return date
		 */
		public default String setPlanStartDate() {
			String 	planStartDate		=	null;
			//setting the current date
			planStartDate		=	sdf.format(cal.getTime());
			//return the current date
			return planStartDate;
		}
		/**
		 * this method is used to set the Expiry date for the plan
		 * @param totalPlanDays
		 * @return date in string format
		 */
		public default String setPlanExpiryDate(int totalPlanDays) {
			//Number of Days to add
	        cal.add(Calendar.DAY_OF_MONTH, totalPlanDays);  
	        //Date after adding the days to the current date
	        String expiryDate = sdf.format(cal.getTime());  
	        	return expiryDate;	
		}
		
}
