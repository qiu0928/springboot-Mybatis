package org.jeccg.module;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: qiuy
 * @time: 2020/5/20 11:08
 */
public class RandomTest {
    @Test
    public void test() {
        Set<String> a = new HashSet<>();
        while(a.size()<=100){
            String getRandomString = GetRandomString(2);
            a.add(getRandomString);
            System.out.println(getRandomString);
        }

    }
    public static String GetRandomString(int Len) {

        String[] baseString={"0","1","2","3",
                "4","5","6","7","8","9",
                "a","b","c","d","e",
                "f","g","h","i","j",
                "k","l","m","n","o",
                "p","q","r","s","t",
                "u","v","w","x","y",
                "z","A","B","C","D",
                "E","F","G","H","I",
                "J","K","L","M","N",
                "O","P","Q","R","S",
                "T","U","V","W","X","Y","Z"};
        Random random = new Random();
        int length=baseString.length;
        String randomString="";
        for(int i=0;i<Len;i++){
            randomString+=baseString[random.nextInt(length)];
        }
        return randomString;
    }

}

