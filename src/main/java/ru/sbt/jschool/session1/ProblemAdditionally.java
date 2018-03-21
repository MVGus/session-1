package ru.sbt.jschool.session1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class ProblemAdditionally {
    public static void main(String[] args) {
        String b1 = "10111";
        String b2 = "111000111";
        ProblemAdditionally probAdd = new ProblemAdditionally();

        System.out.println("Сумма двух чисел "+b1+" + "+ b2 + " = "+probAdd.binaryToDec(b1)+
                " + " + probAdd.binaryToDec(b2) + " = " + (probAdd.binaryToDec(b1)+probAdd.binaryToDec(b2)));

        System.out.println("Сумма в двоичной системе: " +b1+" + "+ b2 + " = "+ probAdd.sumOfBinary(b1,b2)+
                " = " + probAdd.binaryToDec(probAdd.sumOfBinary(b1,b2)));


        long[] arr1 = new long[50];
        long[] arr2 = new long[100];

        // Заполнение созданных масивов случайными числами в диапозоне от 0 до 99
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = new Random().nextInt(100);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = new Random().nextInt(100);
        }
        //Вывод значений всех совпавших элементов созданных массивов
        System.out.println(Arrays.toString(probAdd.intersection(arr1,arr2)));

    }


    public long binaryToDec(String binary){
        //var1:
        return Long.parseLong(binary,2);

        //var2:
       /* long a = 0;
        for (int i = 0; i < binary.length(); i++) {
            try{a+=Integer.parseInt(""+binary.charAt(binary.length()-i-1))*Math.pow(2,i);}
            catch (NumberFormatException e){
                System.out.println("Переданное число некорректно");
            }
        }
        return a;*/
    }

    public String sumOfBinary(String b1,String b2){
        //var1:
        return Long.toBinaryString(Long.parseLong(b1,2)+Long.parseLong(b2,2));

        //var2:
        /*
        StringBuilder sb = new StringBuilder();
        int n = b1.length()<b2.length() ? b1.length() : b2.length();
        int max = b1.length()> b2.length() ? b1.length() : b2.length();
        for (int i = 0; i <= max; i++) {
            sb.append('0');
        }
        for (int i = 0; i < n; i++) {
            char c1 = b1.charAt(b1.length()-i-1);
            char c2 = b2.charAt(b2.length()-i-1);

            if((c1!='0'&&c1!='1')||(c2!='0'&&c2!='1')){
                System.out.println("Введенные числа некорректны");
                return null;
            }
            if(c1==c2){
                if(c1=='1'){
                    for (int j = sb.length()-i-2; j >= 0; j--) {
                        if(sb.charAt(j)=='0'){
                            sb.setCharAt(j,'1');
                            break;
                        }else {
                            sb.setCharAt(j,'0');
                        }
                    }
                }
            }
            else{
                for (int j = sb.length()-i-1; j >= 0; j--) {
                    if(sb.charAt(j)=='0'){
                        sb.setCharAt(j,'1');
                        break;
                    }
                    else {
                        sb.setCharAt(j,'0');
                    }
                }
            }
        }
        String b3 = b1.length()>b2.length() ? b1 : b2;
        for (int i = n; i < max; i++) {
            char c3 = b3.charAt(b3.length()-i-1);
            if(c3!='0'&&c3!='1'){
                System.out.println("Введенные числа некорректны");
                return null;
            }
            if(c3=='1'){
                for (int j = sb.length()-i-1; j >= 0; j--) {
                    if(sb.charAt(j)=='0'){
                        sb.setCharAt(j,'1');
                        break;
                    }
                    else {
                        sb.setCharAt(j,'0');
                    }
                }
            }
        }

        return sb.toString();*/
    }


    public long[] intersection(long[] arr1,long[] arr2){
        HashSet<Long> setResult = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i]==arr2[j]){
                    setResult.add(arr1[i]);
                    break;
                }
            }
        }
        long[] result = new long[setResult.size()];
        int i = 0;
        for (Long a : setResult){
            result[i]=a;
            i++;
        }

        return result;
    }
}
