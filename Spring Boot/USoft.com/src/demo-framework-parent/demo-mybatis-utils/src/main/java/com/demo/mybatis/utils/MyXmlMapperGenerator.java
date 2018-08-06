package com.demo.mybatis.utils;

import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

/**
 * 扩展XMLMapperGenerator
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public class MyXmlMapperGenerator extends XMLMapperGenerator {
	@Override
	protected void addBaseColumnListElement(XmlElement parentElement) {
		if (introspectedTable.getRules().generateBaseColumnList()) {
			//使用扩展的BaseColumnListElementGenerator
			AbstractXmlElementGenerator elementGenerator = new MyBaseColumnListElementGenerator();
			initializeAndExecuteGenerator(elementGenerator, parentElement);
		}
	}

	@Override
	protected void addBlobColumnListElement(XmlElement parentElement) {
		if (introspectedTable.getRules().generateBlobColumnList()) {
			//使用扩展的BlobColumnListElementGenerator
			AbstractXmlElementGenerator elementGenerator = new MyBlobColumnListElementGenerator();
			initializeAndExecuteGenerator(elementGenerator, parentElement);
		}
	}
}
