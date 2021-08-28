package cn.bingxl.example;

/**
 * Student 类继承Person类
 * 
 * @author bingx
 *
 */
public class ExtendsOp {

	public static void main(String[] args) {
		ExtendsOp ins = new ExtendsOp();

		Student stu = ins.new Student("bingxl", 25, true);
		stu.info();
	}

	class Person {
		protected String name;
		protected int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}

	class Student extends Person {
		private boolean graduate;

		public Student(String name, int age, boolean graduate) {
			super(name, age);
			this.graduate = graduate;

		}

		public void info() {
			System.out.println(String.format("name: %s, age: %d, graduate: %b", this.name, this.age, this.graduate));
		}
	}

}
