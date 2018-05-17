package com.awt.util;

public class Util {
	public static boolean isNumber(String number){
		number = number.trim();
		int len = number.length();
		for(int i = 0; i < len; i++){
			if (!Character.isDigit(number.charAt(i))) 
				return false;
		}
		return true;
	}
	public static boolean isChiness(char c){
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c) ;
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
            return true ;
        }  
        return false ;
	}
}
