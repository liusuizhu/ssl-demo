package com.liusuizhu.page.util;

import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.TreeMap;

public class JsonToken {
    public synchronized static boolean signCheck(TreeMap<String, String> map, String sign) {
        if (StringUtils.isEmpty(sign)) {
			return false;
		}
    	int num = 0;
        StringBuffer strb = new StringBuffer();
        for (Map.Entry<String, String> m : map.entrySet()) {
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
        String md5 = MD5Util.MD5Encode(strb.toString(), "UTF-8");
        if (sign.equals(md5)) {
            return true;
        } else {
            return false;
        }
    }
}
