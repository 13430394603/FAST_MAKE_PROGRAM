package com.gui.util;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
/**
 * <b>提供颜色</b>
 * <p>
 * 描述:<br>
 * 
 * @author 威 
 * <br>2018年5月24日 下午12:49:49 
 * @see
 * @since 1.0
 */
public class ColorUtil {
	public final static Map<String, Color> colorMap;
	static {
		colorMap = new HashMap<String, Color>();
		colorMap.put("white", Color.WHITE);
		colorMap.put("gray", Color.gray);
		colorMap.put("green", Color.green);
		colorMap.put("black", Color.black);
		colorMap.put("blue", Color.blue);
		colorMap.put("cyan", Color.cyan);
		colorMap.put("pink", Color.pink);
		colorMap.put("red", Color.red);
		colorMap.put("orange", Color.orange);
		colorMap.put("yellow", Color.yellow);
		colorMap.put("lightGray", Color.lightGray);
	}
}
