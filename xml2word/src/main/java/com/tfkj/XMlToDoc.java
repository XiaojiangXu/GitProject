package com.tfkj;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class XMlToDoc {

	// //模版存储路径，项目里我就放在resource下
	private static final String basePath = "./src/main/resources/template/";

	public static void main(String[] args) throws Exception {

		makeWord();
		//makePdfByXcode();

	}

	/**
	 * 生成docx
	 * 
	 * @throws Exception
	 */
	static void makeWord() throws Exception {
		/** 初始化配置文件 **/
		@SuppressWarnings("deprecation")
		Configuration configuration = new Configuration();
		String fileDirectory = basePath;
		/** 加载文件 **/
		configuration.setDirectoryForTemplateLoading(new File(fileDirectory));
		/** 加载模板 **/
		Template template = configuration.getTemplate("document.ftl");
		/** 准备数据 **/
		List<XmlPojo> xmlPojo = new ArrayList<XmlPojo>();
		
		try {
			SAXBuilder builder = new SAXBuilder();
			File file = new File("./src/main/resources/ygsxxmlPojo.xml");
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
			int index = list.size();
			//index = 10;
			for(int i =0;i<index;i++) {
				XmlPojo xmlpojo = new XmlPojo();
				xmlpojo.setId(DomUtils.parseXmlList().get(i).id);
				xmlpojo.setTitle(DomUtils.parseXmlList().get(i).title);
				xmlpojo.setModule(DomUtils.parseXmlList().get(i).module);
				xmlpojo.setStory(DomUtils.parseXmlList().get(i).story);
				xmlpojo.setTitle(DomUtils.parseXmlList().get(i).title);
				xmlpojo.setPri(DomUtils.parseXmlList().get(i).pri);
				xmlpojo.setPrecondition(DomUtils.parseXmlList().get(i).precondition);
				xmlpojo.setStepDesc(DomUtils.parseXmlList().get(i).stepDesc);
				xmlpojo.setStepExpect(DomUtils.parseXmlList().get(i).stepExpect);
				xmlpojo.setLastRunResult(DomUtils.parseXmlList().get(i).lastRunResult);
				xmlPojo.add(xmlpojo);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, List<XmlPojo>> root = new HashMap<String, List<XmlPojo>>();
		root.put("xmlPojo", xmlPojo);
		/** 指定输出word文件的路径 **/
		String outFilePath = basePath + "data.xml";
		File docFile = new File(outFilePath);
		FileOutputStream fos = new FileOutputStream(docFile);
		Writer out = new BufferedWriter(new OutputStreamWriter(fos), 10240);
		template.process(root, out);
		if (out != null) {
			out.close();
		}
		try {
			ZipInputStream zipInputStream = ZipUtils
					.wrapZipInputStream(new FileInputStream(new File(basePath + "casesuite.zip")));
			ZipOutputStream zipOutputStream = ZipUtils
					.wrapZipOutputStream(new FileOutputStream(new File(basePath + "casesuite.docx")));
			String itemname = "word/document.xml";
			ZipUtils.replaceItem(zipInputStream, zipOutputStream, itemname,
					new FileInputStream(new File(basePath + "data.xml")));
			System.out.println("success");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	/**
	 * 生成pdf
	 */
	/*static void makePdfByXcode() {
		long startTime = System.currentTimeMillis();
		try {
			// XWPFDocument document=new XWPFDocument(new FileInputStream(new
			// File(basePath+"test.docx")));
			XWPFDocument document = new XWPFDocument(new FileInputStream(new File(basePath + "casesuite.docx")));
			// document.setParagraph(new Pa );
			// File outFile=new File(basePath+"test.pdf");
			File outFile = new File(basePath + "casesuite.pdf");
			outFile.getParentFile().mkdirs();
			OutputStream out = new FileOutputStream(outFile);
			// IFontProvider fontProvider = new AbstractFontRegistry();
			PdfOptions options = PdfOptions.create(); // gb2312
			PdfConverter.getInstance().convert(document, out, options);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Generate ooxml.pdf with " + (System.currentTimeMillis() - startTime) + " ms.");
	}*/

}
