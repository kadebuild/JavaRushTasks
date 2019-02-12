package com.javarush.task.task32.task3211;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5Bytes = md.digest(byteArrayOutputStream.toByteArray());
        String hashedMD5 = HexBin.encode(md5Bytes).toLowerCase();
        if (hashedMD5.equals(md5)) {
            return true;
        }
        return false;
    }
}
