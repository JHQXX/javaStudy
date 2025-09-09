package top.lovebegetslover.javase.chapter03.src;

/*
Ƕ��ѭ����ʹ��

1. Ƕ��ѭ������ָһ��ѭ���ṹA��ѭ��������һ��ѭ���ṹB��
- ���ѭ����ѭ���ṹA
- �ڲ�ѭ����ѭ���ṹB

2. ˵����
1���ڲ�ѭ���䵱�����ѭ����ѭ���塣
2����������Ƕ��ѭ����˵�����ѭ�������������ڲ�ѭ������������
3�����������ѭ��ִ��m�Σ��ڲ�ѭ��ִ��n�Σ����ڲ�ѭ����ѭ���干ִ��m * n��
4��ʵ�ʿ����У����ǲ�������������ϵ�ѭ���ṹ�������ѭ���ṹ�����ټ���
*/
class ForForTest {
	public static void main(String[] args) {
		
		//******
		for(int i = 1;i <= 6;i++){
			System.out.print('*');
		}

		System.out.println("\n##################");
		
		/*

		******
		******
		******
		******
		******

		*/
		
		for(int j = 1;j <= 5;j++){

			for(int i = 1;i <= 6;i++){
				System.out.print('*');
			}

			System.out.println();
		}
		
		/*
						i(�ڼ���)		j(ÿһ����*�ĸ���)
		*				1				1
		**				2				2
		***				3				3
		****			4				4
		*****			5				5

		*/
		for(int i = 1;i <= 5;i++){
			
			for(int j = 1;j <= i;j++){
				System.out.print("*");
			}
			System.out.println();
		
		}

		/*
						i(�ڼ���)		j(ÿһ����*�ĸ���)		i + j = 7 --> j = 7 - i
		******			1				6
		*****			2				5
		****			3				4
		***				4				3
		**				5				2
		*				6				1
		
		*/

		for(int i = 1;i <= 6;i++){

			for(int j = 1;j <= 7 - i;j++){
				System.out.print("*");
			}
			
			System.out.println();
		}

	/*
						i(�ڼ���)		j(ÿһ����-�ĸ���)		k(ÿһ����*�ĸ���)    2*i + j = 10 --->j = 10 - 2*i
--------*				1				8						1                     k = 2 * i - 1
------* * *				2				6						3
----* * * * *			3				4						5
--* * * * * * *			4				2						7
* * * * * * * * *		5				0						9



  * * * * * * * 
    * * * * * 
      * * * 
        * 
		
	*/

	//�ϰ벿��
	for(int i = 1;i <= 5;i++){
		// -
		for(int j = 1;j <= 10 - 2*i;j++){
			System.out.print("-");
		}


		// *
		for(int k = 1;k <= 2 * i - 1;k++){
			System.out.print("* ");
		}

		System.out.println();
	}




		

		


	}
}
