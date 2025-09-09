package top.lovebegetslover.javase.chapter03.src;

import java.util.Scanner;
class ScannerExer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("�����������ߣ�(cm)");
		int height = scan.nextInt();

		System.out.println("��������ĲƸ���(��ǧ��Ϊ��λ)");
		double wealth = scan.nextDouble();

		//�����Ƿ�˧���⣬����ʹ��String���ͽ���
		System.out.println("˧��(��/��)");
		String isHandsome = scan.next();
		
		//�ж�
		if(height >= 180 && wealth >= 1.0 && isHandsome.equals("��")){  //֪ʶ�㣺�ж������ַ����Ƿ���ȣ�ʹ��String��equals()
			System.out.println("��һ��Ҫ�޸���!!!");
		}else if(height >= 180 || wealth >= 1.0 || isHandsome.equals("��")){
			System.out.println("�ްɣ����ϲ��㣬�������ࡣ");
		}else{
			System.out.println("����");
		}

		//�ر���Դ
		scan.close();
	}
}
