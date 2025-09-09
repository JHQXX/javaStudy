package top.lovebegetslover.javase.chapter03.src;

/*
����3��ʹ��switch-caseʵ�֣���ѧ���ɼ�����60�ֵģ�������ϸ񡱡�����60�ֵģ���������ϸ񡱡�

*/
class SwitchCaseTest1 {
	public static void main(String[] args) {
		//����һ��ѧ���ɼ��ı���
		int score = 78;

		//�������󣬽��з�֧
		//��ʽ1��
		/*
		switch(score){
			case 0:
				System.out.println("������");
				break;
			case 1:
				System.out.println("������");
				break;
			//...
			
			case 100:
				System.out.println("����");
				break;
			default:
				System.out.println("�ɼ���������");
				break;
		
		}
		*/
		//��ʽ2�����case��͸
		switch(score / 10){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("������");
				break;
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				System.out.println("����");
				break;
			default:
				System.out.println("�ɼ���������");
				break;
		}

		//��ʽ3��
		switch(score / 60){
			case 0:
				System.out.println("������");
				break;
			case 1:
				System.out.println("����");
				break;
			default:
				System.out.println("�ɼ���������");
				break;
		}
	}
}
