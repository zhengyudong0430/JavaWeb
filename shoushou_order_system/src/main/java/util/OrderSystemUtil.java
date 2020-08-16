package util;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class OrderSystemUtil {
    public static  String readBody(HttpServletRequest request) throws UnsupportedEncodingException {
        int len = request.getContentLength();
        byte []buffer = new byte[len];
        try {
            InputStream inputStream = request.getInputStream();
            inputStream.read(buffer,0,len);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new String(buffer,"UTF-8");
    }
}
