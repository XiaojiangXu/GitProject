package com.tfkj;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class XmlUtils {
	

	public static int rowsCount () {
		try {
			SAXBuilder builder = new SAXBuilder();
			File file = new File("./src/main/resources/xmlPojo.xml");

			Document doc = builder.build(new File(file.getAbsolutePath()));

// 获取根节点

			Element root = doc.getRootElement();
			Element rows = root.getChild("rows");
			//System.out.println("rows:" + rows.getName());

// 获取根节点下所有的子节点， 也可以根据标签名称获取指定的直接点

			List<Element> list = rows.getChildren();

			list.stream().forEach(e -> {
				//System.out.println("" + e.getName());
			});
			System.out.println("list总数" + list.size());
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
		
		
	}
}
