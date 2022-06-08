package cn.bingxl.example;

/**
 * @author bingxl<scarecrowlxb@qq.com>
 * @desc java基础类型
 * byte short int long 整数
 * float double 浮点数
 * char
 * boolean
 * 
 * 运算符
 * + - * / %
 */
import java.math.*;

public class BasicType<T> {
    public static void main(String[] args) {

        // string 单行注释
        String name = "bingxl";
        System.out.println(name);

        /**
         * 块注释
         */
        short age = 24;
        System.out.println(age);

        // Boolean
        boolean isAduit = true;
        isAduit = false;
        System.out.println(isAduit);

        int salary = 2000;
        int workMonth = 10;
        System.out.println(salary * workMonth);

        System.out.println(0x1ae23);

        System.out.println(Math.pow((double) 2, 3.0));
        System.out.println(stringBuild());

        bigNumber();

        // A 的码点是65， a是97
        // 打印码点为0-96的所有字符
        int charStart = 0;
        int charEnd = 96;
        System.out.println("--------码点字符------");
        for (int i = charStart; i <= charEnd; i++) {
            System.out.print(((char) i) + " ");
        }
        System.out.print("\n");
    }

    public static String stringBuild() {
        StringBuilder builder = new StringBuilder();
        int end = 100;
        for (int i = 0; i < end; i++) {
            builder.append(i);
        }
        return builder.toString();
    }

    public static void bigNumber() {
        BigDecimal b = BigDecimal.valueOf(100, 100);
        System.out.println(b);
    }

    // public static void statement() {
    // enum HorseColor{RED,WHITE,BLANK};
    // int a = 10;
    // int b = a;

    // if (a + b > 20) {

    // } else if (a + b > 10) {

    // } else {

    // }

    // HorseColor myHorseColor = HorseColor.RED;
    // switch (myHorseColor) {
    // case RED: {

    // break;
    // }
    // case WHITE: {

    // break;
    // }
    // default: {

    // }
    // }

    // }

}