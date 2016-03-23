/*package com.gwc.cktest.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class CkFinderUtil {
	public static void setUserDir(String path, String userId) {
		File inputXml = new File(path);
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputXml);
			Element root = document.getRootElement();
			for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
				Element element = (Element) i.next();
				// System.out.println(element.getName() + "----" + element.getText());
				
				 * if (element.getName().equals("baseDir")) {
				 * element.setText("d:/DOC_SERVER/UserFiles/" + userId + "/"); }
				 
				if (element.getName().equals("baseURL")) {
					element.setText("http://127.0.0.1:8080/ckdemo/assets/CKFinderJava/userfiles/" + userId + "/");
				}
			}
			XMLWriter writer = new XMLWriter(new FileWriter(new File(path)));
			writer.write(document);
			writer.close();
		} catch (DocumentException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
*/