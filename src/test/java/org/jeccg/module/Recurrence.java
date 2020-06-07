package org.jeccg.module;

;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序算法
 *
 * @description:
 * @author: qiuy
 * @time: 2020/6/2 10:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Recurrence {
    public static void main(String[] args) {

    }
   /* 0 表示该点没有走过
    当为 1 表示墙 ；
    2 表示通路可以走 ；
    3 表示该点已经
    走过，但是走不通*/
    public static boolean setWay(int[][] map,int i,int j){
        if(map[i][j] == 2){
            return  true;
        }else{
            if(map[i][j] == 0){
                map[i][j] = 2;
                //一直向下走——>右——>上——>左
                if(setWay(map,i+1,j)){
                    return  true;
                }else  if(setWay(map,i,j+1)){
                    return true;
                }else  if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return  true;
                }else {
                    //死路,有false回溯原点，递归（结束递归）回溯原点
                    map[i][j] = 3;
                    return  false;
                }
            }
            //
            return false;
        }
    }
    //冒泡排序
    @Test
    public void bubbleSort(){
        int[] a = {1,3,5,2,4};
        //辅助变量
        int  b = 0;
        //是否有序
        Boolean flag = true;
        //只需要比较4次，最后一个不需要在进行比较了
        for(int i=0;i<a.length-1;i++){
            for (int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    flag = false;
                    b = a[j];
                    a[j] = a[j+1];
                    a[j+1] = b;
                }
            }
            //如果第一次变化都没有说明数组是有序的
            if(flag){
                break;
            }else {
                flag =true;
            }
        }
        String join = StringUtils.join(a,',');
        System.out.println(join);
    }
    @Test
    public void selectSort(){
        int[] a = {1,3,5,2,4};
        for(int i=0;i<a.length-1;i++){
            //默认的最小值
            int min = a[i];
            //最小值的下标,辅助
            int minIndex = i;
            for(int j = i+1;j<a.length;j++){
                if(min>a[j]){
                    min =a[j];
                    minIndex = j;
                }
            }
            //发生改变
            if(minIndex!=i){
                a[minIndex] = a[i];
                a[i] = min;
            }
        }
        System.out.println(ArrayUtils.toString(a));

    }
    @Test
    public void insertionSort(){
        int[] a = {1,3,5,2,4};
        //辅助值
        int insertVal = 0;
        //下标
        int insertIndex = 0;
        for(int i =1;i<a.length;i++){
            insertVal = a[i];
            insertIndex = i-1;
            while (insertIndex>=0&&insertVal<a[insertIndex]){
                a[insertIndex+1] = a[insertIndex];
                insertIndex --;
            }
            //是否发生变化
            if(insertIndex+1!=i){
                a[insertIndex+1] = insertVal;
            }
        }
        System.out.println(ArrayUtils.toString(a));
    }


    @Test
    public  void main() {
        StaticTest staticTest = new StaticTest();
        staticTest.min();
    }
    static  class StaticTest{
        private static  int a;
        private int b;
        {
            a = 3;
            b = 4;
        }
        public StaticTest(){
            System.out.println(a+b);
        }
        public static void min(){

        }
    }
    //快速排序
    @Test
    public void quickSort(){
        int[] arr = {-9,78,0,23,-567,70,-1,900,4561};
        quick(arr,0,arr.length-1);
        String s = ArrayUtils.toString(arr);
        System.out.println(s);

    }
    public void quick(int[] arr,int left,int right){
        int l = left;
        int r = right;
        //中间值
        int pivot = arr[(left+right)/2];
        //赋值变量
        int temp =0;
        while (l<r){
            while (arr[l]<pivot){
                l+=1;
            }
            while (arr[r]>pivot){
                r-=1;
            }
            if(l>=r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //字符串中，中间值有相同的情况,且多个,避免四循环
            if(arr[l] == pivot){
                r-=1;
            }
            if(arr[r] == pivot){
                l+=1;
            }
        }
        //中间的值不参加递归
        if(l==r){
            l+=1;
            r-=1;
        }
        //左递归
        if(r >left){
            quick(arr,left,r);
        }
        //右递归
        if(l < right){
            quick(arr,l,right);
        }
    }

    //归并排序
    @Test
    public void mergeSort(){

        int[] arr = {4,5,7,8,1,2,3,6};
        int[] temp = new  int[arr.length];
        long l = System.nanoTime();
        mergeSort(arr,0,arr.length-1,temp);
        long l1 = System.nanoTime();
        System.out.println("运行时间："+(l1-l)/Math.pow(10,6)+"ms");

        System.out.println(ArrayUtils.toString(arr));
    }
    public  void mergeSort(int[]arr,int left,int right,int[]temp){

        if(left<right){
            int mid=(left + right)/2;
            //中间索引
            // 向左递归进行分解，不递归到彻底分裂
            mergeSort(arr,left,mid,temp);
            //向右递归进行分解
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }

    }

    public void merge(int[] arr,int left,int mind,int right,int[] temp){
        int i = left;
        int j = mind+1;
        //temp数组索引
        int t =0;
        while (i<=mind&&j<=right){
            if(arr[i] < arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i<=mind){
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while (j<=right){
            temp[t]=arr[j];
            t++;
            j++;
        }
        //并不是每次都拷贝全部数据,每次进来的时候，对次进来对其左边和右边的数据内的数据进行一个排序
        t=0;
        int tempLeft=left;
        while(tempLeft<=right){
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }
    }
    //基数排序
    @Test
    public void redixSort() {
        int[] arr = {53, 3, 542, 748, 14, 214};
        redix(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void redix(int[] arr){
        //最大位数
        int max = arr[0];
        for(int k =0;k<arr.length;k++){
            if(max<arr[k]){
                max = arr[k];
            }
        }
        int maxLength = String.valueOf(max).length();
        //行表示桶（0-9）号，列表示一个桶最多存多少个
        int[][] bucket = new int[10][arr.length];
        //存储个位上相同的有几个。个位数为几，相同的有几个
        int[] bucketElementCounts = new int[10];
        for (int j = 0,n=1;j<maxLength;j++,n*=10) {
            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = arr[i] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }
           int index = 0;
            for(int x =0;x<bucketElementCounts.length;x++){
                    //从低到高
                if(bucketElementCounts[x]!=0){
                        for(int l=0;l<bucketElementCounts[x];l++){
                            //取出元素放入到 arr
                            arr[index++]=bucket[x][l]; }

                        }

                bucketElementCounts[x]=0;

            }
            System.out.println(Arrays.toString(arr));
        }
    }

}
