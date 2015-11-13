package com.hd.algorithms;

/**
 * @author Chunyun
 *         ��дһ���򵥵������в������������������еĲ������á�-����Ӣ�Ļ�������ɣ����硰-name����������ŵĲ����Ǿ����ֵ�������в���֮��
 *         ��������ֵ֮����һ�����������Ŀո�ָ�
 *         ��˫�����е�������Ϊһ�����忴���������н��������ؽ���Ǳ��ָ��һ����������ֵ���ٶ������е�����ֻ�����Ӣ�ģ����֣��ո�˫���źͼ��š�
 *         ���磬����Ϊ�� -name Lily -age 21 -school "University of Oxford" ���ؽ��Ϊ��
 *         ��-name:Lily��-age:21��-school:"University of Oxford"��
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
				String[] a3 = arr[i].split("\"");// ��ʾ���ڡ�  �������
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
		sb.deleteCharAt(sb.length() - 1);// ɾ�����ġ�,��
		sb.append("]");
		return sb;
	}
}
