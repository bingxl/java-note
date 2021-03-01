
/**
 * @author bingxl<scarecrowlxb@qq.com>
 * @desc java基础类型
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
        System.out.println(isAduit);

        int salary = 2000;
        int workMonth = 10;
        System.out.println(salary * workMonth);

        System.out.println(0x1ae23);

        System.out.println(Math.pow((double) 2, 3.0));
        System.out.println(stringBuild());

        bigNumber();

    }

    public static String stringBuild() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            builder.append(i);
        }
        return builder.toString();
    }

    public static void bigNumber() {
        BigDecimal b = BigDecimal.valueOf(100, 100);
        System.out.println(b);
    }

    public static void statement() {
        int a = 10;
        int b = a;

        if (a + b > 20) {

        } else if (a + b > 10) {

        } else {

        }

        enum
        HorseColor{RED,WHITE,BLANK}
        ;
        HorseColor myHorseColor = HorseColor.RED;
        switch (myHorseColor) {
            case RED: {

                break;
            }
            case WHITE: {

                break;
            }
            default: {

            }
        }

    }
}