package com.usa.state.ed.service;

import com.usa.state.ed.request.IndvInfoRequest;
import com.usa.state.ed.response.PlanInfoResponse;

public interface EdService {
	public PlanInfoResponse	checkEligibilityForPlan(IndvInfoRequest request)throws Exception;
}
