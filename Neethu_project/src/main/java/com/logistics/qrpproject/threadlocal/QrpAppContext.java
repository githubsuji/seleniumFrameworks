package com.logistics.qrpproject.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class QrpAppContext {
	
	private  final Map<String, Object> contextData = new HashMap<>();

	public Map<String, Object> getContextData() {
		return contextData;
	}
}
