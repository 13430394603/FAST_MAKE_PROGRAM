package com.awt.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.awt.annotation.Control;
import com.awt.control.AbstractControl_Basi;
import com.awt.domain.ControlDomain;
import com.awt.util.Print;
import com.filter_resource.core.FilterResourceCore;
/**
 * <b>核心启动类</b>
 * <p>
 * 描述:<br>
 * @author 威 
 * <br>2018年4月20日 下午7:22:56 
 * @since 1.0
 */
public class Core {
	public static void main(String[] args)
			throws Exception {
		Print.ALLOW_PRINT  = false;
		new Core().doStart();
	}
	/**
	 * 启动有关的控制类
	 * <p>	 
	 * 1、筛选符合的类集合 
	 * 2、
	 * void
	 * @see #sortStrategy(Object[])
	 * @see #getResource(File)
	 * @since 1.0
	 */
	public void doStart(){
		List<ControlDomain> list = getResource(
				new File(System.getProperty("user.dir")+
					File.separator+
					"bin"));
		int len = list.size();
		if(len == 0)
			return;
		else if(len == 1)
			newInstance(list.get(0).getClazz());
		else if(len > 1){
			Object[] origArr = list.toArray();
			for(int j = len; j > 1; j--){
				ControlDomain temp = null;
				ControlDomain pre = (ControlDomain) origArr[0];
				for(int i = 1; i > j; i++){
					temp = (ControlDomain) origArr[i];
					if(pre.getPriority() > temp.getPriority()){
						origArr[i] = pre;
						origArr[i-1] = temp;
					}
					pre = (ControlDomain) origArr[i];
				}
			}
			sortStrategy(origArr);
		}
	}
	/**
	 * 初始化
	 * <p>
	 * 初始化FilterResourceCore
	 * void
	 * @since 1.0
	 */
	@SuppressWarnings("static-access")
	public void initCore(){
		FilterResourceCore startObject = new FilterResourceCore();
		startObject.startOfClassPath("resource.xml");
	}
	/**
	 * 对排好序的数组中的Control对象进行实例化
	 * <p>
	 * @param arr	排序好的Control数组对象
	 * void
	 * @see #newInstance(Class)
	 * @since 1.0
	 */
	private void sortStrategy(Object[] arr){
		int len = arr.length;
		for(int i = 0; i < len; i++)
			newInstance(((ControlDomain) arr[i]).getClazz());
	}
	/**
	 * 实例化
	 * <p>
	 * @param clazz	目标类对象
	 * void
	 * @since 1.0
	 */
	private void newInstance(Class<?> clazz){
		try {
			clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 筛选符合的类集合
	 * <p>	 
	 * @param dir	起始目录
	 * @return
	 * Map<Integer,String>
	 * @see #getResource0(File)
	 * @see #getResource1(Map, String)
	 * @since 1.0
	 */
	private List<ControlDomain> getResource(File dir){
		List<ControlDomain> list = new ArrayList<ControlDomain>();
		File[] files = dir.listFiles();
		for(File file : files){
			if(file.isDirectory())
				list.addAll(getResource(file));
			else if(file.getName().endsWith(".class")) 
				getResource1(list, getResource0(file));
		}
		return list;
	}
	/**
	 * 获筛选出符合指定接口和指定标注的类
	 * <p>
	 * @param list			筛选出来的类集合
	 * @param className		当前操作的类名称
	 * void
	 * @see
	 * @since 1.0
	 */
	private void getResource1(List<ControlDomain> list, String className) {
		try {
			Class<?> clazz = Core.class.getClassLoader().loadClass(className);
			if(clazz.isAnnotationPresent(Control.class)){
				if(AbstractControl_Basi.class.isAssignableFrom(clazz)){
					Control c = clazz.getDeclaredAnnotation(Control.class);
					ControlDomain domain = new ControlDomain();
					domain.setPriority(c.priority());
					domain.setClazz(clazz);
					list.add(domain);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 对file路径的处理，反回标准的类名称
	 * <p>	 
	 * @param file	搜索到的class文件
	 * @return
	 * String
	 * @since 1.0
	 */
	private String getResource0(File file) {
		String fileString = file.getPath();
		String className = fileString.substring(fileString.indexOf("bin")+4,
				fileString.length());
		className = className.replace(".class", "").replace("\\", ".");
		return className;
	}	
}
