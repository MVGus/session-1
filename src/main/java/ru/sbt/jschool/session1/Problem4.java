package ru.sbt.jschool.session1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Problem4 {

    public static boolean flag = false;

    public static void main(String[] args) {
        String parametr1 = "JSCHOOl1_COUNT";
        String parametr2 = "JSCHOOL1_PROPERTIES_FILE";
        Problem4 problem4 = new Problem4();

        // Поиск в аргументах
        for (String arg : args){
            if(arg.startsWith(parametr1)){
                String count = arg.substring(arg.indexOf("=")+1);
                problem4.printHW(count);
                if(flag) break;
            }
        }

        //Поиск в системных настройках
        if(!flag){
            Properties properties = System.getProperties();
            String n = properties.getProperty(parametr1);
            problem4.printHW(n);}

        //Поиск в переменных окружения
        if(!flag){
            String m = System.getenv(parametr1);
            problem4.printHW(m);}

        //Поиск в файле
        if(!flag) {
            Properties prop = new Properties();
            try {
                String fileName = System.getenv(parametr2);
                if (fileName != null) {
                    prop.load(new FileInputStream(new File(fileName)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            String k = prop.getProperty(parametr1);
            problem4.printHW(k);
        }

        if(!flag){
            System.out.println("Программа дает возможность вывести в консоль \"Hello, World!\" n раз, \n где колличество" +
                    " раз n можно задать через параметр: "+parametr1+", передав его:\n * через программмные аргументы," +
                    "\n * как системную настроку \n * как переменную окружения\n Так же имеется возможность " +
                    "опеределить переменную окружения: "+parametr2+",\n указав в ней путь к файлу со свойствами, в котором " +
                    "опредилить "+parametr1);
        }


    }

    public void printHW(String count){
        if(count==null){
            return;
        }
        int n = 0;
        try{
            n=Integer.parseInt(count);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Hello, World!");
            flag=true;
        }
    }

}
