package com.icici.los.utility;

public interface ValidationUtility {
	
	public static boolean isBlank(String value){
		if(value!=null && value.trim().length()>0){
			return false;
		}
		else{
			return true;
		}
	}

}
