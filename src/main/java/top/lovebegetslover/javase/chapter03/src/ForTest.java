package top.lovebegetslover.javase.chapter03.src;

/*
ѭ���ṹ֮һ��forѭ��

1. Java�й淶��3��ѭ���ṹ��for��while��do-while
2. ����ѭ���ṹ����һ������4��Ҫ�أ�
�� ��ʼ������
�� ѭ������ ---> һ����boolean���͵ı�������ʽ
�� ѭ����
�� ��������

3. forѭ���ĸ�ʽ

for(��;��;��){
	��
}

ִ�й��̣��� - �� - �� - �� - �� - �� - �� - ... - ��

*/
class ForTest {
	public static void main(String[] args) {
		//����1����Ŀ�����5��HelloWorld
		/*
		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
		*/

		for(int i = 1;i <= 50;i++){
			System.out.println("HelloWorld");
		}
		
		//��ʱ���벻ͨ������Ϊi�Ѿ�������������Χ��
		//System.out.println(i);

		//����2��
		int num = 1;
        for(System.out.print("a");num < 3;System.out.print("c"),num++){
            System.out.print("b");

        }

		//��������abcbc

		System.out.println();//����

		//����3������1-100���ڵ�ż��������ȡż���ĸ�������ȡ���е�ż���ĺ�
		int count = 0;//��¼ż���ĸ���

		int sum = 0;//��¼����ż���ĺ�

		for(int i = 1;i <= 100;i++){

			if(i % 2 == 0){
				System.out.println(i);
				count++;
				sum += i; //sum = sum + i;
			}	
		}

		System.out.println("ż���ĸ���Ϊ��" + count);
		System.out.println("ż�����ܺ�Ϊ��" + sum);
		
	}
}
