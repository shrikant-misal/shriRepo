package com.usa.state.ed.rulesServices;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usa.state.ed.constants.EdRulesConstants;
import com.usa.state.ed.request.IndvInfoRequest;
import com.usa.state.ed.response.PlanInfoResponse;

/**
 * THis class contain the all CCAP Business Rules according to that its gives plan approval details
 * @author shrikant
 *
 */
public class CcapRulesService implements IRulesService {
	Logger  logger		=	LoggerFactory.getLogger(CcapRulesService.class);
	PlanInfoResponse			response		=		new PlanInfoResponse();
	/** this Method is used to check the eligibility for plan
	 *@return  PlanInfoResponse
	 */
	@Override
	public PlanInfoResponse executeRules(IndvInfoRequest request) {
		logger.debug("CcapRulesService.executeRules() method has been started........");
		if(request.getIncome()<1000&&request.getNoOfKids()>0) {
				logger.info("CcapRulesService.executeRules():: plan got approved");
				//set All the parameter for plan approval response object
				response.setPId(request.getPersonId());
				response.setPlanApprovalStatus(EdRulesConstants.PLAN_APPROVED);
				response.setPlanName(request.getPlanName());
				response.setBenifitedAmt(EdRulesConstants.CCAP_BENIFITEDAMT);
				response.setPlanStartDate(setPlanStartDate());
				response.setPlanExpiryDate(setPlanExpiryDate(30));
			}
			else {
				logger.info("CcapRulesService.executeRules():: plan got Rejected");
				//set All the parameter for plan Rejection response object
				response.setPId(request.getPersonId());
				response.setPlanApprovalStatus(EdRulesConstants.PLAN_REJECTED);
				response.setPlanName(request.getPlanName());
				response.setPlanRejectionReason(EdRulesConstants.CCAPPLANREJECTIONREASON);
			}
		logger.debug("CcapRulesService.executeRules() method excution completed");
		logger.info("CcapRulesService.executeRules() successfully completed");
		return response;
	}

}
