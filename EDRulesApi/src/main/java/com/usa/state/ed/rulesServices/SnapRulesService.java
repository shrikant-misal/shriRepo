package com.usa.state.ed.rulesServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.usa.state.ed.constants.EdRulesConstants;
import com.usa.state.ed.request.IndvInfoRequest;
import com.usa.state.ed.response.PlanInfoResponse;

public class SnapRulesService implements IRulesService {
	Logger			logger			=		LoggerFactory.getLogger(SnapRulesService.class);
	PlanInfoResponse			response		=		new PlanInfoResponse();
	/** this method is used to check the eligibility for plan
	 *@return PlanInfoResponse
	 */
	@Override
	public PlanInfoResponse executeRules(IndvInfoRequest request) {
		logger.debug("SnapRulesService.executeRules() method has execution started..........");
		if(request.getIncome()<1000) {
			logger.debug("SnapRulesService.executeRules():plan got approved");
			//set All the parameter for plan approval response object
			response.setPId(request.getPersonId());
			response.setPlanApprovalStatus(EdRulesConstants.PLAN_APPROVED);
			response.setPlanName(request.getPlanName());
			response.setBenifitedAmt(EdRulesConstants.SNAP_BENIFITEDAMT);
			response.setPlanStartDate(setPlanStartDate());
			response.setPlanExpiryDate(setPlanExpiryDate(45));
		}
		else {
			logger.debug("SnapRulesService.executeRules():plan got rejected");
			//set All the parameter for plan Rejection response object
			response.setPId(request.getPersonId());
			response.setPlanApprovalStatus(EdRulesConstants.PLAN_REJECTED);
			response.setPlanName(request.getPlanName());
			response.setPlanRejectionReason(EdRulesConstants.SNAP_PLANREJECTIONREASON);
		}
		logger.debug("SnapRulesService.executeRules(): plan execution finished");
		logger.info("SnapRulesService.executeRules(): plan execution successfully completed");
	return response;
	}

}
