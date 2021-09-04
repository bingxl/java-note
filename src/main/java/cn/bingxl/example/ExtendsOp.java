package cn.bingxl.example;

/**
 * Student 类继承Person类 继承关系 is-a 既子类属于父类的一种 组合关系，将类挂载到field上，属于 has-a
 * 关系，即挂载的类属于被挂载的类的一部分。
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

	/**
	 * 手臂
	 */
	class Arm {
		int len;
	}

	class Person {
		protected String name;
		protected int age;
		// Arm 作为Person的一部分，被挂载到对应的field上，属于组合行为
		Arm arm;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
			this.arm = new Arm();
		}
	}

	/**
	 * 学生是人的一种，is-a 类型 属于继承关系
	 */
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
