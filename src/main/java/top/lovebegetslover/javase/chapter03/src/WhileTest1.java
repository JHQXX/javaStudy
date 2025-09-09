package top.lovebegetslover.javase.chapter03.src;/*
�������һ��100���ڵ����������������Ƕ��٣�

�Ӽ�����������������ˣ���ʾ���ˣ����С�ˣ���ʾС�ˣ�������ˣ��Ͳ��ٲ��ˣ���ͳ��һ�����˶��ٴΡ�

��ʾ������һ��[a,b] ��Χ��������ķ�ʽ��(int)(Math.random() * (b - a + 1) + a)
*/
import java.util.Scanner;
class WhileTest1 {
	public static void main(String[] args) {

		//1. ����һ��[1,100]��Χ���������
		int random = (int)(Math.random() * 100) + 1;

		//2. ʹ��Scanner���Ӽ��̻�ȡ����
		Scanner scan = new Scanner(System.in);
		System.out.print("������1-100��Χ��һ��������");
		int guess = scan.nextInt();

		//3.����һ����������¼�µĴ���
		int guessCount = 1;

		//4. ʹ��ѭ���ṹ�����ж��ѭ���ĶԱȺͻ�ȡ����
		while(random != guess){

			if(guess > random){
				System.out.println("����������ݴ���");
			}else if(guess < random){
				System.out.println("�����������С��");
			}//else{
			//	break;
			//}
			
			System.out.print("������1-100��Χ��һ��������");
			guess = scan.nextInt();
			guessCount++;

		}

		//�ܽ�������������ζ��random��guess�����
		System.out.println("��ϲ�㣡�¶��ˣ�");
		System.out.println("������" + guessCount + "��");
		
		
		scan.close();

	}
}
