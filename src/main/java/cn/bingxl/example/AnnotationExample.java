package cn.bingxl.example;

/**
 * 注解相关案列 注解主要用于编译时检查错误
 * 
 * @author bingxl <bingxl@outlook.com>
 * @date 2021/08/30
 */
public class AnnotationExample {
    // @SuppressWarnings({ "" })
    /**
     * @SuppressWarnings({""}) 压制警告信息
     * 
     * @param args
     */
    public static void main(String[] args) {
        Student stu = (new AnnotationExample()).new Student();
        stu.connect();
        stu.noUse();
    }

    class Person {
        public void connect() {
            Util.print("-------Person connect---------");
        }

        @Deprecated // 弃用方法
        public void noUse() {
            Util.print("this method is deprecated");
        }
    }

    class Student extends Person {
        @Override // 明确该方法为覆写父类方法，帮助编译过程中的错误， 如果不符合复写则编译时报错
        @Deprecated
        public void connect() {
            Util.print("---------child connect --------- ");
        }
    }
}
