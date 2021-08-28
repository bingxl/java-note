package cn.bingxl.example;

/**
 * 类定义： [public,final, abstract] class ClassName {}
 */

/**
 * 类相关例子
 * 
 * @author bingxl<bingxl@outlook.com>
 * @date 2021/08/27
 */
class ClassExample {

    /**
     * 构造器定义 [public, private, protected] ClassName(args...){}
     */
    public static void main(String[] args) {
        ClassExample example = new ClassExample();
        Student zhangsan = example.new Student();
        zhangsan.name = "张三";
        Util.print(zhangsan);
        Util.print(Person.school);
    }

    public ClassExample() {
        System.out.println("classExample 类初始化");
    }

    /**
     * 可变参数
     * 
     * @param param
     */
    public void mutableParam(Object... param) {
        Util.print(param.length);
    }

    /**
     * method 定义 [public, protected, private] [static] [abstract, final] returnType
     * methodName(args){}
     * 
     * @param msg
     */
    public static void print(Object msg) {
        System.out.println(msg);
    }

    class Person {
        /**
         * 类field定义 [public, protected, private] [static, final] fieldType fieldName [=
         * defaultValue];
         */
        public String name;
        public byte age;
        public static String school = "xdu";
    }

    class Student extends Person {
        public int studentId;
        public String academy;
        public int grade;
        public int classId;
    }

    class Teacher extends Person {
        public String className;
        public int teacherId;
    }

    class Account extends Person {
        public String countName;
        protected String password;
        public String status;
    }
}
