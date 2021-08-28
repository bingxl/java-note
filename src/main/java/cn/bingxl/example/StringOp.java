package cn.bingxl.example;

/**
 * @author bingxl
 */
public class StringOp {
    public static void main(String[] args) {
        // stringSplit();
        // stringReplace();
        stringSub();
        format();
    }

    public static void stringSplit() {
        String ip = "192.168.1.1";
        String[] sp = ip.split("\\.", 3);
        for (String x : sp) {
            System.out.println(x);
        }
    }

    public static void stringReplace() {
        String str = "hello world";
        System.out.print(str.replaceAll("l", "R"));
    }

    public static void stringSub() {
        String str = "无处安放的青春啊";
        System.out.println(str.substring(2, 7));
    }

    static void format() {
        String str = "bingxl";
        int age = 20;
        System.out.println(String.format("name: %s, age: %d", str, age));
    }
}
