package com.demo.mybatis.utils;

import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

import java.util.List;

/**
 * context标签的targetRuntime属性默认为MyBatis3，这个类扩展MyBatis3，实现在映射文件里多生成一个带表名的字段列表
 * 用法：在generatorConfig.xml的context标签的targetRuntime属性里配置这个类的全限定类名
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public class MyIntrospectedTableMyBatis3Impl extends IntrospectedTableMyBatis3Impl {
	@Override
	protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator, List<String> warnings, ProgressCallback progressCallback) {
		//使用扩展的XML映射生成器，这里限定了javaClientGenerator的类型必须为XMLMAPPER
		xmlMapperGenerator = new MyXmlMapperGenerator();
		initializeAbstractGenerator(xmlMapperGenerator, warnings, progressCallback);

	}
}
