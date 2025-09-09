package top.lovebegetslover.javase.chapter03.src;

/*
1. break��continue�ؼ��ֵ�ʹ��

				ʹ�÷�Χ			��ѭ���ṹ�е�����					��ͬ��
break:			switch-case
				ѭ���ṹ��			����������������ǰѭ���ṹ			�ڴ˹ؼ��ֵĺ��治������ִ����䡣

continue:		ѭ���ṹ��			������������������ѭ��				�ڴ˹ؼ��ֵĺ��治������ִ����䡣

		
2. �˽����ǩ��break��continue��ʹ��

3. �����У�break��ʹ��Ƶ��ҪԶ����continue��
*/
class BreakContinueTest{
	public static void main(String[] args){
		
		for(int i = 1;i <= 10;i++){

			if(i % 4 == 0){
				//break;
				continue;
				
				//���벻ͨ��
				//System.out.println("�����ϵ����Ȱ�ҪԼ�ң�");
			}
			
			System.out.print(i);
		
		}
		
		System.out.println();

		//*****************************
		label:for(int j = 1;j <= 4;j++){
		
			for(int i = 1;i <= 10;i++){

				if(i % 4 == 0){
					//break;
					//continue;	

					//�˽�
					//break label;
					//continue label;
				}
				
				System.out.print(i);			
			}
			System.out.println();
		
		}
	
	}
}