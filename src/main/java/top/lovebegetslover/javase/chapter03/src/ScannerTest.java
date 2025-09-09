package top.lovebegetslover.javase.chapter03.src;

/*
��δӼ��̻�ȡ��ͬ���ͣ������������͡�String���ͣ��ı�����ʹ��Scanner�ࡣ

1. ʹ��Scanner��ȡ��ͬ�������ݵĲ���
����1������ import java.util.Scanner;
����2���ṩ���򴴽���һ��Scanner���ʵ��
����3������Scanner���еķ�������ȡָ�����͵ı��� (nextXxx())
����4���ر���Դ������Scanner���close()

2. ������С��ע��ĳ������վ��Ҫ��¼����������Ϣ�����£�

���������������������䡢������ء����Ƿ�������Ա�������


3. Scanner�����ṩ�˻�ȡbyte \ short \ int \ long \float \double \boolean \ String���ͱ����ķ�����
   ע�⣬û���ṩ��ȡchar���ͱ����ķ�������Ҫʹ��next().charAt(0)
*/
//����1������ import java.util.Scanner;
import java.util.Scanner;
class ScannerTest {
	public static void main(String[] args) {
		
		//����2���ṩ���򴴽���һ��Scanner���ʵ��
		Scanner scan = new Scanner(System.in);
		
		System.out.println("��ӭ������������������");
		System.out.print("���������������");
		//����3������Scanner���еķ�������ȡָ�����͵ı���
		String name = scan.next();

		System.out.print("������������䣺");
		int age = scan.nextInt();

		System.out.print("������������أ�");	
		double weight = scan.nextDouble();


		System.out.print("���Ƿ�������true;������false����");
		boolean isSingle = scan.nextBoolean();

		System.out.print("����������Ա�(��\\Ů)��"); 
		char gender = scan.next().charAt(0);

		System.out.println("������" + name + ",����: " + age + ",���أ�" + weight + ",�Ƿ���" + isSingle + 
			",�Ա�" + gender);

		System.out.println("ע����ɣ���ӭ�����������飡");

		//����4���ر���Դ������Scanner���close()
		scan.close();
	}
}
