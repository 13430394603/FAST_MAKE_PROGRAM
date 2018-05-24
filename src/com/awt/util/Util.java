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
	/**
	 * 将复合属性解析成一个数组对象
	 * <p>	 
	 * 月界异常可能为属性值错误<br>
	 * java.lang.ArrayIndexOutOfBoundsException<br>
	 * @param fields
	 * @param len
	 * @return
	 * Object[]
	 * @see
	 * @since 1.0
	 */
	public static String[] getArrFields(String fields, Integer len){
		Integer start = 0;
		Integer index = 0;
		Integer i = 0;
		String[] arr = new String[len];
		while((index = fields.indexOf(" ", start)) != -1){
			arr[i++] = fields.substring(start, index);
			start = index + 1;
		}
		arr[i++] = fields.substring(start, fields.length());
		return arr;
	}
}
