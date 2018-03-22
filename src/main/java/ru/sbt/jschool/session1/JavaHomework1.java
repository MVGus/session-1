package ru.sbt.jschool.session1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JavaHomework1 implements PropertyHelper{

    public boolean flag = false;
    String[] args = null;
    String path = null;

    public JavaHomework1(String[] args, String path) {
        this.args = args;
        this.path = path;
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
                        flag=true;}
                }
            }

        //Поиск в системных настройках
        if(!flag) {
            Properties properties = System.getProperties();
            String n = properties.getProperty(name);

            if(n!=null){
                value = n;
                flag = true;
            }
        }

        //Поиск в переменных окружения
        if(!flag){
            String m = System.getenv(name);
            if(m!=null) {
                value = m;
                flag = true;
            }
        }

        //Поиск в файле
        if(!flag&&path!=null) {
            Properties prop = new Properties();
            try {
                prop.load(new FileInputStream(new File(path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String k = prop.getProperty(name);
            if(k!=null){
                value = k;
                flag = true;
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
