package com.awt.anlyxml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.awt.domain.Navig;
import com.awt.exception.AnalyXMLException;
import com.stream.Exception.ResourceNullException;
import com.stream.Stream.Resource;

/**
 * <b>解析配置文件的抽象方法</b>
 * <p>
 * 描述:
 * <p>
 * @author 威 
 * <br>2018年4月13日 下午10:56:13 
 * @see
 * @since 1.0
 */
public class AbstractAnalyXML {
	protected Document doc = null;
	protected Navig navig;
	public Navig getNavig() {
		return navig;
	}
	public void setNavig(Navig navig) {
		this.navig = navig;
	}
	
	/**
	 * 使用类路径加载配置文件 
	 * <p>	 
	 * @param confPath 	类相对路径
	 * @throws Exception
	 * void
	 * @see #init(File)
	 * @since 1.0
	 */
	public void configureOfClassPath(String confPath) throws Exception{
		if(confPath == null || confPath.equals(""))
			throw new AnalyXMLException("解析 xml文件时配置文件路径不能为null或者empty: " + confPath);
		init(new File(getClass().getClassLoader().getResource(confPath).toURI()));
	}
	/**
	 * 根据文件路径获取配置文件 使用相对路径
	 * <p>	 
	 * @param filePath	文件系统相对路径数组格式，‘/’为分隔符
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws ResourceNullException
	 * void
	 * @see #init(File)
	 * @since 1.0
	 */
	public void ConfigureOfFileSystem(String... filePath) throws ParserConfigurationException, SAXException, IOException, ResourceNullException {
		init(Resource.getResource(filePath));
	}
	/**
	 * 初始化
	 * <p>	
	 * 生成DocumentBuilder对象
	 * 获取 Navig导航对象
	 * @param fileXml						配置文件对象
	 * @throws ParserConfigurationException	
	 * @throws SAXException
	 * @throws IOException
	 * void
	 * @see	#ConfigureOfFileSystem(String...)
	 * @see #configureOfClassPath(String)
	 * @since 1.0
	 */
	protected void init(File fileXml) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		builder = dbFactory.newDocumentBuilder();
		doc = builder.parse(fileXml); 
		CreateNavig c = new CreateNavig();
		try {
			c.configureOfClassPath(fileXml);
			if(navig == null)
				navig =  (Navig) c.createNavig(0)[1];
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
