package com.liusuizhu.page.util;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/**
 * MD5验证工具
 * 
 * @author ZWXIN
 * @version $Id: MD5Util.java, v 0.1 2016-08-28 下午5:39:11 ZWXIN Exp $
 */
public class MD5Util {


	public static String signMd5(Map<String, Object> map) {
		Map<String, String> treeMap = new TreeMap<String, String>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			treeMap.put(entry.getKey(), entry.getValue().toString());
		}
		int num = 0;
		StringBuffer strb = new StringBuffer();
		for (Map.Entry<String, String> m : treeMap.entrySet()) {
			if (!StringUtils.isEmpty(m.getValue())) {
				// 去掉最后一个 &
				if (num > 0) {
					strb.append("&");
				}
				strb.append(m.getKey());
				strb.append("=");
				strb.append(m.getValue());
			}
			num++;
		}
		strb.append("79fed117bcad6e616b8de5af8489b6dc");
		return MD5Util.MD5Encode(strb.toString(), "UTF-8");
	}
	
	/**
	 * 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符,apache校验下载的文件的正确性用的就是默认的这个组合
	 */
	protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	protected static MessageDigest messagedigest = null;

	static {
		try {
			// 生成散列码,getInstance系列静态函初始化
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description: 文件MD5输出
	 * @param file
	 * @return
	 * @throws IOException
	 *             String
	 * @author zwxin
	 * @date:2015年8月28日
	 */
	public static String getFileMD5String(File file) throws IOException {
		InputStream fis;
		fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int numRead = 0;
		while ((numRead = fis.read(buffer)) > 0) {
			messagedigest.update(buffer, 0, numRead);
		}
		fis.close();
		return bufferToHex(messagedigest.digest());
	}

	/**
	 * 
	 * @Description: 字符MD5输出
	 * @param fis
	 * @return
	 * @throws IOException
	 *             String
	 * @author zwxin
	 * @date:2015年8月28日
	 */
	public static String getFileMD5StringByInputStream(InputStream fis) throws IOException {
		byte[] buffer = new byte[1024];
		int numRead = 0;
		while ((numRead = fis.read(buffer)) > 0) {
			messagedigest.update(buffer, 0, numRead);
		}
		fis.close();
		return bufferToHex(messagedigest.digest());
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = hexDigits[(bt & 0xf0) >> 4];// 取字节中高 4 位的数字转换
		// 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同
		char c1 = hexDigits[bt & 0xf];// 取字节中低 4 位的数字转换
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	/**
	 * 调用该方法进行MD5加密
	 */
	public static String GetMD5Code(String strObj) {
		return bufferToHex(messagedigest.digest(strObj.getBytes()));
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(messagedigest.digest(resultString.getBytes()));
			else
				resultString = byteArrayToHexString(messagedigest.digest(resultString.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return String.valueOf(hexDigits[d1]) + String.valueOf(hexDigits[d2]);
	}
}