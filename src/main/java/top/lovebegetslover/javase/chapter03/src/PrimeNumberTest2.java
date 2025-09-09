package top.lovebegetslover.javase.chapter03.src;

/*
����100000���ڵ����е���������᲻ͬ���㷨ʵ�֣������ܵĲ��

��PrimeNumberTest2.java�Ƿ�ʽ2�������PrimeNumberTest1.java���㷨���Ż�
*/
class PrimeNumberTest2 {
	public static void main(String[] args) {

		//��ȡϵͳ��ǰ��ʱ�䣺
		long start = System.currentTimeMillis();
		
		boolean isFlag = true;

		int count = 0;//��¼�����ĸ���

		for(int i = 2;i <= 100000;i++){ //����100000���ڵ���Ȼ��
			
			
			//�ж�i�Ƿ�������
			for(int j = 2;j <= Math.sqrt(i);j++){
				
				if(i % j == 0){
					isFlag = false;
					break;//����ڷ�������Ч����
				}
			
			}

			if(isFlag){
				count++;
			}
			
			//����isFlag
			isFlag = true;
		}

		//��ȡϵͳ��ǰ��ʱ�䣺
		long end = System.currentTimeMillis();

		System.out.println("�������ܸ���Ϊ��" + count); //9592
		System.out.println("���ѵ�ʱ��Ϊ��" + (end - start)); //7209 -->����break:659 -->����Math.sqrt():6

	}
}