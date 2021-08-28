package cn.bingxl.example;

/**
 * 多态案列 Java引用变量有两种类型，申明变量时使用的类型决定编译时类型，实际赋给改变量的类型为运行时类型 当编译时类型和运行时类型不同时就是多态。
 * 只有类的method存在多态， field没有多态
 * 
 * @author bingxl<bingxl@outlook.com>
 * @date 2021/08/28
 */

class PolymorphismExample {
    public static void main(String[] args) {
        PolymorphismExample ins = new PolymorphismExample();

        Base base = ins.new Base();
        Util.print(base.book);
        base.test();

        Sub sub = ins.new Sub();
        Util.print(sub.book);

        /**
         * poly 编译时为Base类型， 运行时是Sub类型 发生了类型转换，poly指向的堆地址和sub已不同
         */
        Base poly = sub;

        // 打印的是10 而不是Sub类中的字符串，即类的field没有多态性
        Util.print(poly.book);
        // 调用的是子类Sub的方法。 类的method具有多态性
        poly.test();

        // poly.fnOnlyInSub(); Base中无此方法，所以编译时出错
    }

    class Base {
        int book = 10;

        public void test() {
            System.out.println("test function in base calss");
        }
    }

    class Sub extends Base {
        String book = "book name";

        public void test() {
            System.out.println("test function in Sub class");
        }

        public void fnOnlyInSub() {
            System.out.println("function that only in sub class");
        }
    }
}
