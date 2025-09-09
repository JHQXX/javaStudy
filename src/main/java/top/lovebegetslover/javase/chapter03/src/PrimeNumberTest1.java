package top.lovebegetslover.javase.chapter03.src;

/*
����100000���ڵ����е���������᲻ͬ���㷨ʵ�֣������ܵĲ��

��PrimeNumberTest1.java��ʵ�ַ�ʽ1
*/
class PrimeNumberTest1 {
	public static void main(String[] args) {

		//��ȡϵͳ��ǰ��ʱ�䣺
		long start = System.currentTimeMillis();
		
		boolean isFlag = true;

		int count = 0;//��¼�����ĸ���

		for(int i = 2;i <= 100000;i++){ //����100000���ڵ���Ȼ��
			
			
			//�ж�i�Ƿ�������
			for(int j = 2;j < i;j++){
				
				if(i % j == 0){
					isFlag = false;
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
		System.out.println("���ѵ�ʱ��Ϊ��" + (end - start)); //7209

	}
}
