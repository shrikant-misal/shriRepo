package com.usa.state.ed.service;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.usa.state.ed.request.IndvInfoRequest;
import com.usa.state.ed.response.PlanInfoResponse;
import com.usa.state.ed.rulesServices.IRulesService;

@Service
public class EdServiceImpl implements EdService {
	Logger logger = LoggerFactory.getLogger(EdServiceImpl.class);

	/**
	 * This method is used to used reflection API and call respective plan service
	 * method
	 * 
	 * @return planInfoResponse
	 */
	@Override
	public PlanInfoResponse checkEligibilityForPlan(IndvInfoRequest request) throws Exception {
		logger.debug("EdServiceImpl.checkEligibilityForPlan():: Method Execution started......");
		PlanInfoResponse response = null;
		Class<IRulesService> clazz = (Class<IRulesService>) Class
				.forName("com.usa.state.ed.rulesServices." + request.getPlanName() + "RulesService");
		IRulesService iRuleService = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("executeRules", IndvInfoRequest.class);
		response = (PlanInfoResponse) method.invoke(iRuleService, request);
		logger.debug("EdServiceImpl.checkEligibilityForPlan():: Method Execution finished......");
		logger.debug("EdServiceImpl.checkEligibilityForPlan():: method execution successfully completed.....");
		return response;
	}

}
