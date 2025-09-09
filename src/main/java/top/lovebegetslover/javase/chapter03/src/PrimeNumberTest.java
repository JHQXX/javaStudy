package top.lovebegetslover.javase.chapter03.src;

/*
��Ŀ���ҳ�100�������е���������������100000���ڵ��أ�

������ֻ�ܱ�1����������������Ȼ�������磺2,3,5,7,11,13,17,19,23,....
   
   ---> ���仰˵����2��ʼ�������Ȼ��-1Ϊֹ�������ڴ���Ȼ����Լ����


*/
class PrimeNumberTest {
	public static void main(String[] args) {
		
		/*
		��ʽ1��
		for(int i = 2;i <= 100;i++){ //����100���ڵ���Ȼ��

			int number = 0; //��¼i��Լ���ĸ�������2��ʼ����i-1Ϊֹ��
			
			//�ж�i�Ƿ�������
			for(int j = 2;j < i;j++){
				
				if(i % j == 0){
					number++;
				}
			
			}

			if(number == 0){
				System.out.println(i);
			}
		
		
		}
		*/

		//��ʽ2��
		boolean isFlag = true;

		for(int i = 2;i <= 100;i++){ //����100���ڵ���Ȼ��
			
			
			//�ж�i�Ƿ�������
			for(int j = 2;j < i;j++){
				
				if(i % j == 0){
					isFlag = false;
				}
			
			}

			if(isFlag){//if(isFlag == true){
				System.out.println(i);
			}
			
			//����isFlag
			isFlag = true;
		}

	}
}
