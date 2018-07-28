package com.awt.anlyxml;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;


import com.awt.domain.Navig;
import com.awt.exception.NavigError;
import com.stream.Exception.ResourceNullException;
import com.stream.Stream.CharStream;
import com.stream.Stream.Resource;

/**
 * <b>扫描xml文件生成导航对象</b>
 * <p>
 * 描述:
 * <p>
 * 自动扫描xml文件生成导航对象
 * @author 威 
 * <br>2018年4月10日 下午8:12:38  
 * @see com.awt.anlyxml.TextXML
 * @see com.awt.exception.NavigError
 * @since 1.0
 */
public class CreateNavig {
	private StringBuilder xmlStringBuilder = new StringBuilder();
	/**
	 * 加载配置文件
	 * <p>	 
	 * @param args	相对路径数组对象，此‘/’符为数组分隔符
	 * @throws ResourceNullException	
	 * void
	 * @see #dealXml(File)
	 * @since 1.0
	 */
	public void configureOfFileSystem(String... args) throws ResourceNullException{
		dealXml(Resource.getResource(args));
	}
	/**
	 * 加载配置文件
	 * <p>	 
	 * @param xmlFile 	xml文件对象
	 * @throws ResourceNullException
	 * void
	 * @see #dealXml(File)
	 * @since 1.0
	 */
	public void configureOfFileSystem(File xmlFile) throws ResourceNullException{
		dealXml(xmlFile);
	}
	/**
	 * 加载配置文件
	 * <p>	 
	 * @param string
	 * @throws URISyntaxException
	 * void
	 * @see #dealXml(File)
	 * @since 1.0
	 */
	public void configureOfClassPath(String string) throws URISyntaxException{
		dealXml(new File(CreateNavig.class.getClassLoader().getResource(string).toURI()));
	}
	/**
	 * 加载配置文件
	 * <p>	 
	 * @param xmlFile	xml文件对象
	 * @throws URISyntaxException
	 * void
	 * @see #dealXml(File)
	 * @since 1.0
	 */
	public void configureOfClassPath(File xmlFile) throws URISyntaxException{
		dealXml(xmlFile);
	}
	/**
	 * 预先处理xml文本字符
	 * <p>	 
	 * @param xmlFile 配置文件
	 * void
	 * @see #configureOfFileSystem(String...)
	 * @see #configureOfClassPath(String)
	 * @see #configureOfClassPath(File)
	 * @see #configureOfFileSystem(File)
	 * @since 1.0
	 */
	private void dealXml(File xmlFile){
		BufferedReader br = null;
		try {
			br = CharStream.getRead(xmlFile);
			String line = "";
			while((line = br.readLine()) != null)
				xmlStringBuilder.append(line.trim());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CharStream.free(br);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//删除 <?xml version="1.0" encoding="UTF-8"?> 无用行
		if(xmlStringBuilder.indexOf("<?xml") != -1){
			int index = xmlStringBuilder.indexOf(">") + 1;
			xmlStringBuilder.delete(0, index);
		}
		com.awt.util.Print.out(this, "dealXml", xmlStringBuilder);
	}
	
	/**
	 * 创建navig导航对象
	 * <p>	 
	 * @param index  开始位置
	 * @return
	 * Object[]
	 * @see
	 * @since 1.0
	 */
	public Object[] createNavig(Integer index){
		try {
			return createNavig(null, index);
		} catch (NavigError e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 创建navig导航对象
	 * <p>	 
	 * @param parentNavig
	 * @param index 开始位置
	 * @return
	 * @throws NavigError	获取导航对象时，xml文本可能错误
	 * Object[] 返回参数为数组格式，共有两个参数 ： 1.结束位置，2.导航对象
	 * @see #findStart(Integer)
	 * @see #findEnd(Integer)
	 */
	public Object[] createNavig(Navig parentNavig, Integer index) throws NavigError{
		String tagName = "";
		//Object[] args = new Object[2]; // 第一个参数是标签结束的位置 ， 第二个参数是导航对象 没有为空
		Object[] args1 = findStart(parentNavig, index);
		tagName = (String) args1[2];
		index = (Integer) args1[0];
		
		Navig nowNavig = null;
		Navig childNavig = null;
		if(parentNavig != null)
			childNavig = parentNavig.getChildNode(tagName);
		nowNavig = childNavig != null 
			? childNavig 
			: new Navig(tagName);
		
		Object[] args2;
		do {
			args2 = findEnd(nowNavig, index);
			index = (Integer) args2[0];
		}
		while(args2[2] == null);//不是结束标签 继续循环找
		if(tagName.equals(args2[2])){
			if(parentNavig != null){
				Navig nowChildNavig = parentNavig.getChildNode(tagName);
				if(nowChildNavig == null)
					parentNavig.next.add(nowNavig);	
			}
			return new Object[]{index, nowNavig};
		}
		else
			throw new NavigError("开始标签和结束标签不对应： " + tagName + " - " + args2[2]);
	}
	/**
	 * 找开始标签
	 * <p>
	 * 返回开始标签结束的位置
	 * <p>
	 * 要求：一开始扫描文档必须是一个开始标签 否则异常
	 * @param index 开始位置
	 * @return
	 * @throws NavigError	获取导航对象时，xml文本可能错误
	 * Object[]	返回参数为数组格式，共有3个参数 ： 1.结束位置，2.闭标签导航对象，3.开始标签名
	 * @since 1.0
	 */
	protected Object[] findStart(Navig parentNavig, Integer index) throws NavigError{
		if(xmlStringBuilder.indexOf("<!--", index) == index)
			index = xmlStringBuilder.indexOf("-->", index) + 3;
		int startIndex = xmlStringBuilder.indexOf("<", index);
		int endIndex = xmlStringBuilder.indexOf(">", index);
		int sepIndex = xmlStringBuilder.indexOf("/", index);
		int spaceIndex = xmlStringBuilder.indexOf(" ", index);
		Object[] args = new Object[3]; // 第一个参数是标签结束的位置 ， 第二个参数是闭标签的导航对象没有为空 , 第三个参数为开始标签名
		args[0] = endIndex + 1;
		String tagName = null;

		tagName = xmlStringBuilder.substring(startIndex + 1,
				(spaceIndex != -1 && spaceIndex < endIndex) ? spaceIndex : endIndex).trim();
		
		args[2] = tagName;
		if(sepIndex == startIndex + 1)			//结束标签
			throw new NavigError("查找开始标签时xml文件可能错误不规范，标签名： " +
					xmlStringBuilder.substring(startIndex + 1, endIndex).trim());
		// 第一个参数是标签结束的位置 ， 第二个参数是闭标签的导航对象没有为空 , 第三个参数为开始标签名
		return args;
	}
	
	/**
	 * 找结束
	 * <p>	 
	 * @param index 开始位置
	 * @return
	 * @throws NavigError	获取导航对象时，xml文本可能错误
	 * Object[]	返回参数为数组格式，共有3个参数 ： 1.结束位置，2.闭标签的导航对象/或者是正常的子导航对象，3.结束标签的标签名称
	 * @see #createNavig(Integer)
	 * @since 1.0
	 */
	protected Object[] findEnd(Navig parentNavig, Integer index) throws NavigError{
		if(xmlStringBuilder.indexOf("<!--", index) == index)
			index = xmlStringBuilder.indexOf("-->", index) + 3;
		int startIndex = xmlStringBuilder.indexOf("<", index);
		int endIndex = xmlStringBuilder.indexOf(">", index);
		int sepIndex = xmlStringBuilder.indexOf("/", index);
		
		Object[] args = new Object[3]; 		// 第一个参数是结束标签结束的位置 ， 第二个参数是闭标签的导航对象没有为空 , 第三个参数为结束标签的标签名称
		args[0] = endIndex + 1;
		if(sepIndex == startIndex + 1)		//结束标签
			args[2] = xmlStringBuilder.substring(startIndex + 2, endIndex).trim();
		else if (sepIndex == endIndex - 1) {	//闭标签
			int spaceIndex = xmlStringBuilder.indexOf(" ", index);
			String tagName = xmlStringBuilder.substring(startIndex + 1, 
					(spaceIndex != -1 && spaceIndex < endIndex) 
					? spaceIndex 
					: endIndex - 1).trim();
			if(parentNavig != null){
				Navig nowChildNavig = parentNavig.getChildNode(tagName);
				if(nowChildNavig == null)
					parentNavig.next.add(new Navig(tagName, null));	
			}
		} else {	//开始标签
			args[0] = createNavig(parentNavig, index)[0];
		}

		// 第一个参数是结束标签结束的位置 ， 第二个参数是闭标签的导航对象/或者是正常的子导航对象 没有为空 , 第三个参数为结束标签的标签名称
		return args;
	}
	
	/*public static void main(String[] args) throws URISyntaxException, NavigError{
		CreateNavig c = new CreateNavig();
		c.configureOfClassPath("context.xml");
		Navig n = (Navig) c.createNavig(0)[1];
		System.out.println(n);
	}*/
}
