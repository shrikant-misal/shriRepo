package com.usa.state.ed.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * this class is used to specify the incoming request format
 * @author shrikant
 *
 */
@Data
@XmlRootElement(name ="Ind-Info")
@XmlAccessorType(XmlAccessType.FIELD)
public class IndvInfoRequest {
		int personId;
		int ssnNo;
		String personName;
		int		age;	
		String marritialStatus;
		int noOfKids;
		double income;
		String planName;
		
}
