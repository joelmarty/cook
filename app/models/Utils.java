package models;

import java.lang.StringBuilder;

public class Utils {

    public static String getHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length*2);
        for (byte b : bytes) {
            sb.append( String.format("%x", b) );
        }
        return sb.toString();
    }
}
