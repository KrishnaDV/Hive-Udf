package com.hlc.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class MyZigZag extends UDF {

	public MyZigZag() {

	}

	public String evaluate(String input) {

		StringBuffer sb = new StringBuffer();

		// Break the String into individual characters

		for (int i = 0; i < input.length(); i++) {

			// Converting String to char

			char ch = input.charAt(i);

			// finding the first char in string to perform desired function

			int index = (int) ch;

			if (index >= 65 && index <= 90) {

				String upper = upperFirst(input);

				sb.append(upper);

				break;

			}

			else if (index >= 97 && index <= 122) {

				String lower = lowerFirst(input);

				sb.append(lower);

				break;
			}

		}

		return sb.toString();

	}

	private static String lowerFirst(String x) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < x.length(); i++) {

			if (i % 2 == 0) {

				char c = x.charAt(i);

				int n1 = (int) c;

				if (n1 >= 97 && n1 <= 122) {
					sb.append(c);
				}

				else if (n1 >= 65 && n1 <= 90) {

					char c1 = (char) (n1 + 32);

					sb.append(c1);
				} else {

					sb.append(c);
				}

			}

			else {

				char c3 = x.charAt(i);

				int n3 = (int) c3;

				if (n3 >= 65 && n3 <= 90) {
					sb.append(c3);

				}

				else if (n3 >= 97 && n3 <= 122) {

					char c2 = (char) (n3 - 32);

					sb.append(c2);
				} else {

					sb.append(c3);
				}
			}
		}

		return sb.toString();
	}

	private static String upperFirst(String y) {

		StringBuffer sb = new StringBuffer();

		char[] uf = y.toCharArray();

		for (int i = 0; i < uf.length; i++) {

			if (i % 2 == 0) {

				int first = (int) uf[i];

				char ch = (char) first;

				if (first >= 65 && first <= 90) {

					sb.append(ch);

				}

				else if (first >= 97 && first <= 122) {

					char ch1 = (char) (first - 32);

					sb.append(ch1);
				}

				else {
					sb.append(ch);
				}
			}

			else {

				int second = (int) uf[i];

				char ch2 = (char) second;

				if (second >= 97 && second <= 122) {

					sb.append(ch2);
				}

				else if (second >= 65 && second <= 90) {

					char ch4 = (char) (second + 32);

					sb.append(ch4);

				}

				else {

					sb.append(ch2);
				}

			}

		}

		return sb.toString();

	}

}
