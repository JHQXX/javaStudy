package top.lovebegetslover.javase.chapter03.src;/*
�������Ӽ��̶��������ȷ�������������ж϶���������͸����ĸ���������Ϊ0ʱ��������

*/
import java.util.Scanner;
class ForWhileTest1 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int positiveCount = 0;//��¼�����ĸ���
		int negativeCount = 0;//��¼�����ĸ���
		
		for(;;){//while(true){
			System.out.print("������һ������(����Ϊ0ʱ��������)��");
			int num = scan.nextInt(); //��ȡ�û����������

			if(num > 0){ //����
				positiveCount++;
			}else if(num < 0){ //����
				negativeCount++;
			}else{ //��
				System.out.println("�������");
				break;
			}
		
		
		}
		
		System.out.println("�����ĸ���Ϊ��" + positiveCount);
		System.out.println("�����ĸ���Ϊ��" + negativeCount);


		scan.close();
	}
}
