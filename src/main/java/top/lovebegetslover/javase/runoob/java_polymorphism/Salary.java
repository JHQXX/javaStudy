package top.lovebegetslover.javase.runoob.java_polymorphism;

/* 文件名 : Salary.java */
public class Salary extends Employee
{
    private double salary; // 全年工资
    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }
    public void mailCheck() {
        System.out.println("Salary 类的 mailCheck 方法 ");
        System.out.println("邮寄支票给：" + super.getName()
                + " ，工资为：" + salary);
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double newSalary) {
        if(newSalary >= 0.0) {
            this.salary = newSalary;
        }
    }
    public double computePay() {
        System.out.println("计算工资，付给：" + super.getName());
        return salary/52;
    }

    public String getName(){
        System.out.println("你好");
        return "info";
    }

    public void isTure(){
        System.out.println("我自己的方法");
        super.isTure();
    }
}