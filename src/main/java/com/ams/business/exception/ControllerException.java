package com.ams.business.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

    @Data
	@AllArgsConstructor
	public class ControllerException   {

		String errorCode;
		String message;

	}


