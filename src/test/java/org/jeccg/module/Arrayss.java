package org.jeccg.module;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Arrayss {

    @Test
    public void  Array(){
        Integer a[] ={3,1,2};
        Integer b[] = {4,5};
        Integer[] ab= new Integer[2];
        List<Integer> list = new ArrayList();
        list.addAll(Arrays.asList(a));
        list.addAll(Arrays.asList(b));
        List<Integer> list1 = new ArrayList();
        list1.addAll(Arrays.asList(b));
        //集合转数组
        Object[] c = list.toArray();
        //数组转字符串
        System.out.println(Arrays.toString(c));
        //判断数组中是否包含某个字符串
        System.out.println("list是否包含5:"+list.contains(5));
        //判断数组是否相等
        System.out.println("两个数组是否相等："+Arrays.equals(a,b));
        //数组填充
        Arrays.fill(ab,2);
        //数组获取最大和最小值
        int min = (int) Collections.min(Arrays.asList(a));
        int max = (int) Collections.max(Arrays.asList(a));
        System.out.println("最小值: " + min);
        System.out.println("最大值: " + max);
        // 数组转化从集合 Arrays.asList(a)
        //数组反转
        Collections.reverse(list);
        //数组扩容
        Integer[] extended = new Integer[5];
        extended[3]=4;
        extended[4]=5;
        System.arraycopy(a,0,extended,0,a.length);
        System.out.println(Arrays.toString(extended));
        //数据交集,集合list和集合list1的公共部分。
        list.retainAll(list1);
        System.out.println(list);
    }
    //java时间处理
    //时间戳转时间
    @Test
    public void time(){
        Long timeStamp = System.currentTimeMillis();
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //方法一
        String sd = sdf.format(timeStamp);
        //方法二
        String te = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        System.out.println(sd);
    }
    //instanceof关键字，判断左边的对象是否是它右边的类的实例
    @Test
    public void displayObjectClass(){
        Object testObject = new ArrayList();
        displayObjectClass(testObject);
    }
    public static void displayObjectClass(Object o) {
        if (o instanceof Vector)
            System.out.println("对象是 java.util.Vector 类的实例");
        else if (o instanceof ArrayList)
            System.out.println("对象是 java.util.ArrayList 类的实例");
        else
            System.out.println("对象是 " + o.getClass() + " 类的实例");
    }
}
