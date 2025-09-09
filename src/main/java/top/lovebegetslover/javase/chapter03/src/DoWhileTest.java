package top.lovebegetslover.javase.chapter03.src;

/*
ѭ���ṹ֮һ��do-whileѭ��


1. ����ѭ���ṹ����һ������4��Ҫ�أ�
�� ��ʼ������
�� ѭ������ ---> һ����boolean���͵ı�������ʽ
�� ѭ����
�� ��������

2. do-while�ĸ�ʽ

��
do{
	��
	��
}while(��);

ִ�й��̣��� - �� - �� - �� - �� - �� - .... - ��

3. ˵����
1) do-whileѭ������ִ��һ��ѭ���塣
2) for��while��do-whileѭ������֮���ǿ����໥ת���ġ�
3) do-whileѭ���ṹ���ڿ����У������for��whileѭ��������ʹ�õĽ��١�

*/
class DoWhileTest {
	public static void main(String[] args) {
		
		//���󣺱���100���ڵ�ż���������ż���ĸ������ܺ�
		int i = 1;
		int count = 0;//��¼ż���ĸ���
		int sum = 0;//��¼ż�����ܺ�

		do{
			if(i % 2 == 0){
				System.out.println(i);
				count++;
				sum += i;
			}

			i++;

		}while(i <= 100);
		
		System.out.println("ż���ĸ���Ϊ��" + count);
		System.out.println("ż�����ܺ�Ϊ��" + sum);

		//***************************
		int num1 = 10;
		while(num1 > 10){
			System.out.println("while:hello");
			num1--;
		}

		int num2 = 10;
		do{
			System.out.println("do-while:hello");
			num2--;
		}while(num2 > 10);
	}
}
