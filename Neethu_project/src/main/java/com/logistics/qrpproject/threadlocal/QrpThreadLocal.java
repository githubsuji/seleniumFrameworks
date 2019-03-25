package com.logistics.qrpproject.threadlocal;

public class QrpThreadLocal {

	
		public static final ThreadLocal<QrpAppContext> appThreadLocal = new ThreadLocal<QrpAppContext>();

		public static void set(QrpAppContext context) {
			
			
			appThreadLocal.set(context);
		}

		public static void unset() {
			appThreadLocal.remove();
		}

		public static QrpAppContext get() {
			return (QrpAppContext) appThreadLocal.get();
		}
	}

