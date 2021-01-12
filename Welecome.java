/**
 * java 代码 test 文件
 * 
 * @author bingxl<scarecrowlxb@qq.com>
 */
public class Welecome {
    private static int age = 20;

    public static void main(String[] args) {

        System.out.println(age);
        System.out.println(Integer.SIZE);
        System.out.println(Long.SIZE);

        // System.out.println(factorial(60));

    }

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num + factorial(num - 1);
    }
}