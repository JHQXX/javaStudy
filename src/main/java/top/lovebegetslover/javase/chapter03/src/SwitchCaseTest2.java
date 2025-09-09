package top.lovebegetslover.javase.chapter03.src;/*
��������д���򣺴Ӽ���������2023��ġ�month���͡�day����Ҫ��ͨ������������������Ϊ2023��ĵڼ��졣
*/
import java.util.Scanner;

class SwitchCaseTest2 {
	public static void main(String[] args) {
		//1.ʹ��Scanner���Ӽ��̻�ȡ2023���month��day
		Scanner input = new Scanner(System.in);

		System.out.println("������2023����·ݣ�");
		int month = input.nextInt();//����ʽ����

		System.out.println("������2023����죺");
		int day = input.nextInt();

		//�����û�����������ǺϷ��ġ����������ڿ����У�ʹ��������ʽ����У�顣

		//2. ʹ��switch-caseʵ�ַ�֧�ṹ
		int sumDays = 0;//��¼������
		//��ʽ1�����Ƽ����������ݵ�����
		/*
		switch(month){
			case 1:
				sumDays = day;
				break;
			case 2:
				sumDays = 31 + day;
				break;
			case 3:
				sumDays = 31 + 28 + day;
				break;
			case 4:
				sumDays = 31 + 28 + 31 + day;
				break;
			//...
			case 12:
				sumDays = 31 + 28 + ... + 30 + day;
				break;
		
		}
		*/
		//��ʽ2��
		switch(month){
			case 12:
				sumDays += 30;
			case 11:
				sumDays += 31;
			case 10:
				sumDays += 30;
			case 9:
				sumDays += 31;
			case 8:
				sumDays += 31;
			case 7:
				sumDays += 30;
			case 6:
				sumDays += 31;
			case 5:
				sumDays += 30;
			case 4:
				sumDays += 31;
			case 3:
				sumDays += 28; //28:2�·ݵ�������
			case 2:
				sumDays += 31; //31:1�·ݵ�������
			case 1:
				sumDays += day;
				//break;
		}
		

		System.out.println("2023��" + month + "��" + day + "���ǵ�ǰ�ĵ�" + sumDays + "��");
		
		
		input.close();//Ϊ�˷�ֹ�ڴ�й©
	}
}
