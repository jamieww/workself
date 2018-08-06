package com.demo.mybatis.utils;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.BaseColumnListElementGenerator;

import java.util.Iterator;

/**
 * 扩展BaseColumnListElementGenerator，多生成一个带表名的字段列表
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public class MyBaseColumnListElementGenerator extends BaseColumnListElementGenerator {

	public MyBaseColumnListElementGenerator() {
		super();
	}

	@Override
	public void addElements(XmlElement parentElement) {
		super.addElements(parentElement);

		//再生成一个带表名的字段列表
		XmlElement answer = new XmlElement("sql");

		answer.addAttribute(new Attribute("id",
				"Table_Base_Column_List"));

		context.getCommentGenerator().addComment(answer);

		StringBuilder sb = new StringBuilder();
		Iterator<IntrospectedColumn> iter = introspectedTable
				.getNonBLOBColumns().iterator();
		while (iter.hasNext()) {
			sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
			sb.append('.');

			sb.append(MyBatis3FormattingUtilities.getSelectListPhrase(iter
					.next()));

			if (iter.hasNext()) {
				sb.append(", ");
			}

			if (sb.length() > 80) {
				answer.addElement(new TextElement(sb.toString()));
				sb.setLength(0);
			}
		}

		if (sb.length() > 0) {
			answer.addElement(new TextElement(sb.toString()));
		}

		if (context.getPlugins().sqlMapBaseColumnListElementGenerated(
				answer, introspectedTable)) {
			parentElement.addElement(answer);
		}
	}
}
