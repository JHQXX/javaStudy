package top.lovebegetslover.javase.chapter03.src;

/*
��֧�ṹ֮switch-case��ʹ��

1. �﷨��ʽ

switch(���ʽ){
	
	case ����1:
		//ִ�����1
		//break;
	case ����2:
		//ִ�����2
		//break;
	...
	default:
		//ִ�����2
		//break;
}

2.ִ�й��̣�
���ݱ��ʽ�е�ֵ������ƥ��case��䡣һ����ĳһ��case�еĳ�����ȣ���ô��ִ�д�case�е�ִ����䡣
ִ�����ִ�����֮��
		���1������break����ִ��break��������ǰ��switch-case�ṹ
		���2��û������break�������ִ������case�е�ִ����䡣 ---> case ��͸
				...
			   ֱ������break����ִ�������е�case��default�е���䣬�˳���ǰ��switch-case�ṹ

3. ˵����
�� switch�еı��ʽֻ�����ض����������͡����£�byte \ short \ char \ int \ ö��(JDK5.0����) \ String(JDK7.0����)
�� case ���Ǹ��ĳ�����ʹ�ñ��ʽ����Щ��������ȵ��жϣ����ܽ��з�Χ���жϡ�
�� �����У�ʹ��switch-caseʱ��ͨ��caseƥ�����������ޡ�
�� break:����ʹ����switch-case�С�һ��ִ�д�break�ؼ��֣���������ǰ��switch-case�ṹ
�� default��������if-else�е�else�ṹ��
           default�ǿ�ѡ�ģ�����λ�������ġ�

4. switch-case ��if-else֮���ת��
�� �����з��ǿ���ʹ��switch-case�ṹ�ĳ����������Ը�дΪif-else����֮��������
�� �����У����һ����������ȿ���ʹ��switch-case���ֿ���ʹ��if-else��ʱ���Ƽ�ʹ��switch-case��
  Ϊʲô��switch-case�����if-elseЧ���Ըߡ�

*/
class SwitchCaseTest{
	public static void main(String[] args){
		
		int num = 1;
		switch(num){
			
			case 0:
				System.out.println("zero");
				break; 
			case 1:
				System.out.println("one");
				break; //������ǰ��switch-case�ṹ
			case 2:
				System.out.println("two");
				break; 
			case 3:
				System.out.println("three");
				break; 
			default:
				System.out.println("other");
				//break; 
		}

		//������
		String season = "summer";
        switch (season) {
            case "spring":
                System.out.println("��ů����");
                break;
            case "summer":
                System.out.println("��������");
                break;
            case "autumn":
                System.out.println("�����ˬ");
                break;
            case "winter":
                System.out.println("��ѩ����");
                break;
            /*default:
                System.out.println("������������");
                break;
			*/
        }

		//��������ӣ����벻ͨ��
		/*
		int number = 20;
		switch(number){
			case number > 0:
				System.out.println("����");
                break;
			case number < 0:
				System.out.println("����");
                break;
			default:
				System.out.println("��");
                break;
		}
		*/
	}
}