package com.hd.algorithms;

/**
 * @author Chunyun
 *         编写一个简单的命令行参数解析函数，命令行的参数名用“-”加英文或数字组成，例如“-name”，后面跟着的部分是具体的值，命令行参数之间
 *         ，参数与值之间用一个或多个连续的空格分隔
 *         。双引号中的内容作为一个整体看待，不进行解析。返回结果是被分割开的一个个参数和值。假定命令行的内容只会包含英文，数字，空格，双引号和减号。
 *         例如，参数为： -name Lily -age 21 -school "University of Oxford" 返回结果为：
 *         ［-name:Lily，-age:21，-school:"University of Oxford"］
 */
public class ParseCommand {
	public static void main(String[] args) {

		String test = "-name Lily -age 21 -school "
				+ "\"University of Oxford\"";
		System.out.println(parseCMD(test).toString());
	}

	public static StringBuilder parseCMD(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		String[] arr = s.split("-");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].length() > 1) {
				String[] a3 = arr[i].split("\"");// 表示存在“  ”的情况
				// System.out.println(a3);
				if (a3.length > 1) {
					sb.append(a3[0].trim());
					sb.append(":");
					sb.append("\"");
					sb.append(a3[1].trim());
					sb.append("\"");
					sb.append(",");
				} else {
					String[] a2 = arr[i].trim().split(" ");
					sb.append("-");
					sb.append(a2[0]);
					sb.append(":");
					sb.append(a2[1]);
					sb.append(",");
				}

			}
		}
		sb.deleteCharAt(sb.length() - 1);// 删除最后的“,”
		sb.append("]");
		return sb;
	}
}
