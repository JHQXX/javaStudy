package top.lovebegetslover.javase.chapter03.src;

/*
��������������������m��n���������Լ������С��������

���磺12��20�����Լ����4����С��������60��

Լ����12Ϊ����Լ����1,2,3,4,6,12
      20Ϊ����Լ����1,2,4,5,10,20

������12Ϊ����������12,24,36,48,60,72,....
      20Ϊ����������20,40,60,80,....


˵����
1. ���ǿ�����ѭ���ṹ��ʹ��break��һ��ִ��break�������������������ǰѭ���ṹ��
2. ��ν���һ��ѭ���ṹ��
	��ʽ1��ѭ�����������㡣����ѭ������ִ�����Ժ���false��
	��ʽ2����ѭ������ִ����break

*/
class ForTest2 {
	public static void main(String[] args) {

		int m = 12;
		int n = 20;

		//��ȡm��n�еĽ�Сֵ
		int min = (m < n)? m : n;

		//����1�����Լ��
		//��ʽ1��
		int result = 1;
		for(int i = 1;i <= min;i++){
			if(m % i == 0 && n % i == 0){
				//System.out.println(i);
				result = i;
			}

		}

		System.out.println(result);

		//��ʽ2���Ƽ�
		for(int i = min;i >= 1;i--){
			if(m % i == 0 && n % i == 0){
				System.out.println("���Լ��Ϊ��" + i);
				break;//һ��ִ�У���������ǰѭ���ṹ��
			}
		}

		//����2����С������
		int max = (m > n)? m : n;
		for(int i = max;i <= m * n;i++){
			if(i % m == 0 && i % n == 0){
				System.out.println("��С������Ϊ��" + i);
				break;
			}
		}
	}
}
