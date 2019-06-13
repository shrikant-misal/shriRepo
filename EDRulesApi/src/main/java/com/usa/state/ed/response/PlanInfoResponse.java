package com.usa.state.ed.response;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * This class is used to specify the response format
 * @author shrikant
 *
 */
@Data
@XmlRootElement(name ="Ind-Info")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanInfoResponse {
		int          pId;
		String    planName;
		String    planApprovalStatus;
		String    planRejectionReason;
		double	benifitedAmt;
		String     planStartDate;
		String     planExpiryDate;
}
