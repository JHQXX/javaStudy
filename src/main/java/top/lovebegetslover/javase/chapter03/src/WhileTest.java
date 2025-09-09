package top.lovebegetslover.javase.chapter03.src;

/*
ѭ���ṹ֮һ��whileѭ��


1. ����ѭ���ṹ����һ������4��Ҫ�أ�
�� ��ʼ������
�� ѭ������ ---> һ����boolean���͵ı�������ʽ
�� ѭ����
�� ��������

2.while�ĸ�ʽ

��
while(��){
	��
	��
}

3.ִ�й��̣��� - �� - �� - �� - �� - �� - �� - ... - ��

4. forѭ����whileѭ�������໥ת����

5. forѭ����whileѭ����С���𣺳�ʼ��������������Χ��ͬ��whileѭ���еĳ�ʼ��������whileѭ����������Ȼ��Ч��
*/
class WhileTest {
	public static void main(String[] args) {
		
		//����1������50��HelloWorld
		int i = 1;
		while(i <= 50){
			System.out.println("HelloWorld");
			i++;//һ��ҪС�ģ���Ҫ����
		}

		//����2������1-100���ڵ�ż��������ȡż���ĸ�������ȡ���е�ż���ĺ�
		int j = 1;

		int count = 0;//��¼ż���ĸ���
		int sum = 0;//��¼ż�����ܺ�
		while(j <= 100){
			if(j % 2 == 0){
				System.out.println(j);
				count++;
				sum += j;
			}
			j++;
		}

		System.out.println("ż���ĸ���Ϊ��" + count);
		System.out.println("ż�����ܺ�Ϊ��" + sum);
	}
}
