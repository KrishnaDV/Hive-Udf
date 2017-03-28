package com.hlc.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public final class MyUpperUDF extends UDF {

	public MyUpperUDF() {
		System.out.println("MyUpperUDF()");
	}

	public String evaluate(String data) {
		System.out.println("MyUpperUDF.evaluate(-) :"+hashCode());
		return data.toUpperCase();
	}
}
