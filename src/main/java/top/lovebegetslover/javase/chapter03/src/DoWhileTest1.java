package top.lovebegetslover.javase.chapter03.src;/*
��Ŀ��ģ��ATMȡ��

��������balance����ʼ��Ϊ0�����Ա�ʾ�����˻���������ͨ��ATM������ʵ�ִ�ȡ��ȹ��ܡ�

=========ATM========
   1�����
   2��ȡ��
   3����ʾ���
   4���˳�
��ѡ��(1-4)��
*/
import java.util.Scanner;
class DoWhileTest1 {
	public static void main(String[] args) {
		
		//1. ����balance�ı�������¼�˻����
		double balance = 0.0;

		boolean flag = true; //����ѭ���Ľ���

		Scanner scan = new Scanner(System.in);//ʵ����Scanner

		do{
			//2. ����ATMȡ��Ľ���
			System.out.println("=========ATM========");
			System.out.println("   1�����");
			System.out.println("   2��ȡ��");
			System.out.println("   3����ʾ���");
			System.out.println("   4���˳�");
			System.out.print("��ѡ��(1-4)��");

			//3. ʹ��Scanner��ȡ�û���ѡ��
			
			int selection = scan.nextInt();
			switch(selection){
				//4. �����û���ѡ�񣬾���ִ�д�ȡ���ʾ���˳��Ĳ���
				case 1:
					System.out.print("��������Ľ�");
					double money1 = scan.nextDouble();
					if(money1 > 0){
						balance += money1;
					}
					break;
				case 2:
					System.out.print("������ȡ��Ľ�");
					double money2 = scan.nextDouble();
					
					if(money2 > 0 && money2 <= balance){
						balance -= money2;
					}else{
						System.out.println("������������������");
					}


					break;
				case 3:
					System.out.println("�˻����Ϊ��" + balance);
					break;
				case 4 :
					flag = false;
					System.out.println("��лʹ�ã���ӭ�´ι���^_^");
					break;
				default:
					System.out.println("������������������");
					//break;
			
			}
		
		
		}while(flag);

		
		//�ر���Դ
		scan.close();

		

	}
}
