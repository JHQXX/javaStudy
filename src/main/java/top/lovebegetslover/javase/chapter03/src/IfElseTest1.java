package top.lovebegetslover.javase.chapter03.src;

/*
��С���μ�Java���ԣ����͸�������Ⱥ��ɳ�ŵ��
�����
�ɼ�Ϊ100��ʱ������һ���ܳ���
�ɼ�Ϊ(80��99]ʱ������һ��ɽ�����г���
���ɼ�Ϊ[60,80]ʱ����������Ӱ��һ���Σ�
����ʱ������һ�١�

˵����Ĭ�ϳɼ�����[0,100]��Χ��

���ۣ�
1. �������������ʽ֮��û�н���������ǻ����ϵ�������ĸ��������ʽ���������棬�ĸ����������涼���ԡ�
   �������������ʽ֮���ǰ�����ϵ������Ҫ����ΧС���������ʽ�����ڷ�Χ����������ʽ�����档���򣬷�ΧС���������ʽ�����ܱ�ִ�С�


*/
class IfElseTest1 {
	public static void main(String[] args) {
		
		int score = 61;

		//��ʽ1��
		/*
		if(score == 100){
			System.out.println("����һ���ܳ�");
		}else if(score > 80 && score <= 99){
			System.out.println("����һ��ɽ�����г�");
		}else if(score >= 60 && score <= 80){
			System.out.println("��������Ӱ��һ����");
		}else{
			System.out.println("����һ��");
		}
		*/
		
		//��ʽ2��
		score = 88;

		if(score == 100){
			System.out.println("����һ���ܳ�");
		}else if(score > 80){
			System.out.println("����һ��ɽ�����г�");
		}else if(score >= 60){
			System.out.println("��������Ӱ��һ����");
		}else{
			System.out.println("����һ��");
		}

		//�ر�ģ�
		if(score == 100){
			System.out.println("����һ���ܳ�");
		}else if(score > 80){
			System.out.println("����һ��ɽ�����г�");
		}else if(score >= 60){
			System.out.println("��������Ӱ��һ����");
		}
		/*else{
			System.out.println("����һ��");
		}
		*/
		
	}
}
