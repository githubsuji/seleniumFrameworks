package com.calibroz.page.landing.registration;

public class RegistrationData {
	private String Phoneormobile;
	private String emailid;
	private String fullName;
	private String password;
	private String confirmpassword;
	private String caseType; // VALID_SIGN_UP , INVALID_SIGN_UP
	private String caseSubType;
	private String expectedResult;
	
	
	
	public RegistrationData() {
	}
	public RegistrationData(String phoneormobile, String emailid, String fullName, String password,
			String confirmpassword, String caseType, String caseSubType, String expectedResult) {
		
		Phoneormobile = phoneormobile;
		this.emailid = emailid;
		this.fullName = fullName;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.caseType = caseType;
		this.caseSubType = caseSubType;
		this.expectedResult = expectedResult;
	}
	
	public String getPhoneormobile() {
		return Phoneormobile;
	}
	public void setPhoneormobile(String phoneormobile) {
		Phoneormobile = phoneormobile;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getCaseSubType() {
		return caseSubType;
	}
	public void setCaseSubType(String caseSubType) {
		this.caseSubType = caseSubType;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Phoneormobile == null) ? 0 : Phoneormobile.hashCode());
		result = prime * result + ((caseSubType == null) ? 0 : caseSubType.hashCode());
		result = prime * result + ((caseType == null) ? 0 : caseType.hashCode());
		result = prime * result + ((confirmpassword == null) ? 0 : confirmpassword.hashCode());
		result = prime * result + ((emailid == null) ? 0 : emailid.hashCode());
		result = prime * result + ((expectedResult == null) ? 0 : expectedResult.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationData other = (RegistrationData) obj;
		if (Phoneormobile == null) {
			if (other.Phoneormobile != null)
				return false;
		} else if (!Phoneormobile.equals(other.Phoneormobile))
			return false;
		if (caseSubType == null) {
			if (other.caseSubType != null)
				return false;
		} else if (!caseSubType.equals(other.caseSubType))
			return false;
		if (caseType == null) {
			if (other.caseType != null)
				return false;
		} else if (!caseType.equals(other.caseType))
			return false;
		if (confirmpassword == null) {
			if (other.confirmpassword != null)
				return false;
		} else if (!confirmpassword.equals(other.confirmpassword))
			return false;
		if (emailid == null) {
			if (other.emailid != null)
				return false;
		} else if (!emailid.equals(other.emailid))
			return false;
		if (expectedResult == null) {
			if (other.expectedResult != null)
				return false;
		} else if (!expectedResult.equals(other.expectedResult))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RegistrationData [Phoneormobile=" + Phoneormobile + ", emailid=" + emailid + ", fullName=" + fullName
				+ ", password=" + password + ", confirmpassword=" + confirmpassword + ", caseType=" + caseType
				+ ", caseSubType=" + caseSubType + ", expectedResult=" + expectedResult + "]";
	}
	
}
