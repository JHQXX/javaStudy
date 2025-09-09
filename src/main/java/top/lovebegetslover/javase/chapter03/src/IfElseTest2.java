package top.lovebegetslover.javase.chapter03.src;

/*
����if-else��Ƕ��ʹ��

������
�ɼ����������������ֱ�������num1��num2��num3�������ǽ�������(ʹ�� if-else if-else)�����Ҵ�С���������

��չ������ʵ�ִӴ�С˳���������

1. �ӿ��������Ͻ���û��д�����������Ƕ��if-else�ṹ��
2. ���if-else�е�ִ��������ֻ��һ��ִ����䣬���ִ��������ڵ�һ��{}����ʡ�ԡ����ǣ�������ʡ��
*/
class IfElseTest2 {
	public static void main(String[] args) {
		
		int num1 = 30;
		int num2 = 21;
		int num3 = 44;

		//int num1 = 30,num2 = 21,num3 = 44;

		if(num1 >= num2){
			if(num3 >= num1)
				System.out.println(num2 + "," + num1 + "," + num3);
			else if(num3 <= num2)
				System.out.println(num3 + "," + num2 + "," + num1);
			else
				System.out.println(num2 + "," + num3 + "," + num1);	
				//System.out.println(num2 + "," + num3 + "," + num1);	
				
		}else{ // num1 < num2
			if(num3 >= num2){
				System.out.println(num1 + "," + num2 + "," + num3);
			}else if(num3 <= num1){
				System.out.println(num3 + "," + num1 + "," + num2);
			}else{
				System.out.println(num1 + "," + num3 + "," + num2);
			}
		}

	}
}
