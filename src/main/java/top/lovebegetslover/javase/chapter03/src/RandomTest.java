package top.lovebegetslover.javase.chapter03.src;

/*
��λ�ȡһ�������?

1. ����ʹ��Java�ṩ��API:Math���random() 
2. random()�����Ժ󣬻᷵��һ��[0.0,1.0)��Χ��double�͵������

3. ����1����ȡһ��[0,100]��Χ�����������
   ����2����ȡһ��[1,100]��Χ�����������

4. ���󣺻�ȡһ��[a,b]��Χ�����������
   (int)(Math.random() * (b - a + 1)) + a
*/
class RandomTest {
	public static void main(String[] args) {
		
		double d1 = Math.random();

		System.out.println("d1 = " + d1);


		int num1 = (int)(Math.random() * 101);  //[0.0,1.0) --> [0.0,101.0) --->[0,100]
		System.out.println("num1 = " + num1);

		int num2 = (int)(Math.random() * 100) + 1; //[0.0,1.0) --> [0.0,100.0) --->[0,99] ---> [1,100]


	}
}
