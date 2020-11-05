/**
 * 
 */
package com.tfkj;

/**
 * @Author FrankXu
 * @Description 
 * @Date 2020年10月29日下午4:39:43
 * @return void
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @Author FrankXu
 * @Description
 * @LastUpdate 2020年10月29日下午4:39:43
 */

public class DomTest {

	public static void main(String[] args) {
		List<XmlPojo> list = new DomTest().parseXmlPojo();
		// 打印读取的结果。
		for (XmlPojo p : list) {
			System.out.println(p);
		}

	}

		// 解析xml文件，并把结果封装至XmlPojo的集合中返回
	private List<XmlPojo> parseXmlPojo(){
			List<XmlPojo> xmlPojoList = null;
			try {
				// 获得dom制造工厂
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				// 获得dom解析器
				DocumentBuilder builder = factory.newDocumentBuilder();
				// 获得xml文件的输入流
				InputStream inStream = DomTest.class.getClassLoader().getResourceAsStream("xmlPojo.xml");
				// 通过解析器得到Document对象
				Document document = builder.parse(inStream);
				// 得到要获取的所有item 结点，通过每个结点，获取每个item的内容数据。
				NodeList list = document.getElementsByTagName("row");
				xmlPojoList = new ArrayList<XmlPojo>();
				XmlPojo xmlPojo = null;
				// 遍历person集合，将数据封装于xmlPojo对象中
				for (int i = 0, fsize = list.getLength(); i < fsize; i++) {
					xmlPojo = new XmlPojo();
					// 得到<person>结点
					Element e = (Element) list.item(i);
					NodeList chileList = e.getChildNodes();
					// 遍历所有孩子结点，以便获得其余数据。
					for (int j = 0, csize = chileList.getLength(); j < csize; j++) {
						Node node = chileList.item(j);
						switch (node.getNodeName()) {
						case "id":
							// 当结点为<id>时，获取内容，并给xmlPojo赋值
							String id = node.getTextContent();
							xmlPojo.setId(id);
							break;
						case "module":
							// 当结点为<name>时，获取内容，并给xmlPojo赋值
							String module = node.getTextContent();
							xmlPojo.setModule(module);
							break;
						case "story":
							// 当结点为<story>时，获取内容，并给xmlPojo赋值
							String story = node.getTextContent();
							xmlPojo.setStory(story);
							break;
						case "title":
							// 当结点为<title>时，获取内容，并给xmlPojo赋值
							String title = node.getTextContent();
							xmlPojo.setTitle(title);
							break;
						case "precondition":
							// 当结点为<precondition>时，获取内容，并给xmlPojo赋值
							String precondition = node.getTextContent();
							xmlPojo.setPrecondition(precondition);
							break;
						case "stepDesc":
							// 当结点为<stepDesc>时，获取内容，并给xmlPojo赋值
							String stepDesc = node.getTextContent();
							xmlPojo.setStepDesc(stepDesc);
							break;
						case "stepExpect":
							// 当结点为<stepExpect>时，获取内容，并给xmlPojo赋值
							String stepExpect = node.getTextContent();
							xmlPojo.setStepExpect(stepExpect);
							break;
						case "real":
							// 当结点为<real>时，获取内容，并给xmlPojo赋值
							String real = node.getTextContent();
							xmlPojo.setReal(real);
							break;
						case "pri":
							// 当结点为<pri>时，获取内容，并给xmlPojo赋值
							String pri = node.getTextContent();
							xmlPojo.setPri(pri);
							break;
						case "lastRunResult":
							// 当结点为<lastRunResult>时，获取内容，并给xmlPojo赋值
							String lastRunResult = node.getTextContent();
							xmlPojo.setLastRunResult(lastRunResult);
							break;
						}
					}
					// 完成一个<xmlPojo>结点的遍历，将xmlPojo对象加入集合中。
					xmlPojoList.add(xmlPojo);
					// 清空xmlPojo对象的数据。
					xmlPojo = null;
				}

			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 返回最终得到的数据。
			return xmlPojoList;
		}
	
	
}
