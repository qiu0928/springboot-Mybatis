package org.jeccg.module;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;

/**
 * @description:
 * @author: qiuy
 * @time: 2020/5/28 12:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FileTest
{
    @Test
    public void FileTest() throws IOException {
        File file = new File("D:\\client\\map.data");
        FileWriter out = new FileWriter(file);
        int a[][] = new int[3][3];
        a[0][1] = 2;
        a[0][2] = 4;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<3;j++){
                out.write(a[i][j]+"\t");
            }
            out.write("\r\n");
            //   out.write("\n");
        }
        out.close();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int b[][] = new int[3][3];
        int i =0;
        String len ;
        // 循环读取
        while ((len =reader.readLine())!=null){
            for(int j =0;j<3;j++){
                String[] s = len.split("\t");
                b[i][j]  = Integer.valueOf(s[j]);
            }
            i++;
            System.out.println(len);
            System.out.println(b[0][1]);
        }
        // 关闭资源
        reader.close();
    }

}
