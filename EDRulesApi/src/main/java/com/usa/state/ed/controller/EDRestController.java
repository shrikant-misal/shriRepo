package com.usa.state.ed.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.usa.state.ed.request.IndvInfoRequest;
import com.usa.state.ed.response.PlanInfoResponse;
import com.usa.state.ed.service.EdService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This is used to handle the all the request which are coming from the other
 * application
 * 
 * @author shrikant
 */
@RestController
@Api(value = "EDRulesApi", description = "Rest API for EDRulesApi", tags = "EDRules Api")
public class EDRestController {

	Logger logger = LoggerFactory.getLogger(EDRestController.class);
	@Autowired
	EdService service;

	/**
	 * this method is used to check the eligibility of US Citizen for plan
	 * 
	 * @param request
	 * @return PlanInfoResponse
	 */
	@RequestMapping(value = "/getPlanEligibility", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	@ApiOperation(value = "Check the Rules of plan and send response", response = PlanInfoResponse.class)
	public ResponseEntity<PlanInfoResponse> getPlanEligibility(@RequestBody IndvInfoRequest request) {
		logger.debug("EDRestController.getPlanEligibility() method has started");
		PlanInfoResponse response = null;
		try {
			logger.debug(
					"EDRestController.getPlanEligibility():method has invoked service.checkEligibilityForPlan(request) ");
			// Invoke the Service Method for checking the eligibility for the plan
			response = service.checkEligibilityForPlan(request);
			logger.debug("EDRestController.getPlanEligibility(): method has been successfully got response");
		} catch (Exception e) {
			logger.debug("EDRestController.getPlanEligibility():->service.checkEligibilityForPlan request has issue::"
					+ e.getMessage());
		}
		logger.debug("EDRestController.getPlanEligibility() method has been completed");
		logger.info("EDRestController.getPlanEligibility() method successfully completed.........");
		// return the response to the caller
		return new ResponseEntity<PlanInfoResponse>(response, HttpStatus.OK);
	}

}
