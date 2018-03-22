package ru.sbt.jschool.session1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JavaHomework1 implements PropertyHelper{


    String[] args = null;
    String path = null;
    Properties prop = null;


    public JavaHomework1(String[] args, String path) {
        this.args = args;
        this.path = path;
        if(path!=null) {
            prop = new Properties();
            try {
                prop.load(new FileInputStream(new File(path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
    }


    @Override
    public String stringValue(String name) {
        String value = null;
        // Поиск в аргументах
        if(args!=null)
            for (String arg : args){
                if(arg.startsWith(name+"=")){
                    String count = arg.substring(arg.indexOf("=")+1);
                    if(count.length()!=0){
                        value=count;
                        return value;
                    }
                }
            }

        //Поиск в системных настройках

            Properties properties = System.getProperties();
            String n = properties.getProperty(name);
            if(n!=null){
                value = n;
                return value;
            }


        //Поиск в переменных окружения
            String m = System.getenv(name);
            if(m!=null) {
                value = m;
                return value;
            }


        //Поиск в файле
        if(prop!=null) {
            String k = prop.getProperty(name);
            if(k!=null){
                value = k;
                return value;
            }
        }

        return value;
    }

    @Override
    public Integer integerValue(String name) {
        String value = stringValue(name);
        if(value==null){
            return null;
        }
        int n = 0;
        try{
            n=Integer.parseInt(value);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public Double doubleValue(String name) {
        String value = stringValue(name);
        if(value==null){
            return null;
        }
        double n = 0;
        try{
            n = Double.parseDouble(value);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return n;
    }
}
