package com.dw.weixin.sdk;

import com.dw.weixin.sdk.exception.WeixinSDKRuleException;

/**
 * 请求参数基础验证
 * 
 * */
public class RequestCheckUtils {
	public static final String ERROR_CODE_ARGUMENTS_MISS = "40";
	public static final String ERROR_CODE_ARGUMENTS_INVALID = "41";

	public static void checkNotEmpty(Object value, String fieldName)
			throws WeixinSDKRuleException {
		if (value == null) {
			throw new WeixinSDKRuleException("40",
					"client-error:Missing Required Arguments:" + fieldName + "");
		}
		if ((!(value instanceof String))
				|| (((String) value).trim().length() != 0))
			return;
		throw new WeixinSDKRuleException("40",
				"client-error:Missing Required Arguments:" + fieldName + "");
	}

	public static void checkMaxLength(String value, int maxLength,
			String fieldName) throws WeixinSDKRuleException {
		if ((value == null) || (value.length() <= maxLength))
			return;
		throw new WeixinSDKRuleException("41",
				"client-error:Invalid Arguments:the length of " + fieldName
						+ " can not be larger than " + maxLength + ".");
	}


	public static void checkMaxListSize(String value, int maxSize,
			String fieldName) throws WeixinSDKRuleException {
		if (value != null) {
			String[] list = value.split(",");
			if ((list != null) && (list.length > maxSize))
				throw new WeixinSDKRuleException("41",
						"client-error:Invalid Arguments:the listsize(the string split by \",\") of "
								+ fieldName + " must be less than " + maxSize
								+ ".");
		}
	}

	public static void checkMaxValue(Long value, long maxValue, String fieldName)
			throws WeixinSDKRuleException {
		if ((value == null) || (value.longValue() <= maxValue))
			return;
		throw new WeixinSDKRuleException("41",
				"client-error:Invalid Arguments:the value of " + fieldName
						+ " can not be larger than " + maxValue + ".");
	}

	public static void checkMinValue(Long value, long minValue, String fieldName)
			throws WeixinSDKRuleException {
		if ((value == null) || (value.longValue() >= minValue))
			return;
		throw new WeixinSDKRuleException("41",
				"client-error:Invalid Arguments:the value of " + fieldName
						+ " can not be less than " + minValue + ".");
	}
}