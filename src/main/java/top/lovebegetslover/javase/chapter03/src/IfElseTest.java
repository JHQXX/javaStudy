package top.lovebegetslover.javase.chapter03.src;

/*
��֧�ṹ1��if-else�����жϽṹ

1. ��ʽ
��ʽ1��
if(�������ʽ)��
  	����;
��

��ʽ2��"��ѡһ"
if(�������ʽ) { 
  	����1;
}else{
  	����2;
}

��ʽ3��"��ѡһ"
if (�������ʽ1) {
  	����1;
} else if (�������ʽ2) {
  	����2;
}
...
}else if (�������ʽn) {
 	����n;
} else {
  	����n+1;
}


*/
class IfElseTest {
	public static void main(String[] args) {
		
		/*
		����1�����������ʵ�������Χ��ÿ����60-100�Ρ����ʱ��
		������ʲ��ڴ˷�Χ�ڣ�����ʾ��Ҫ����һ���ļ�顣
		*/
		int heartBeats = 89;
		//�����д����if(60 <= heartBeats <= 100){

		if(heartBeats < 60 || heartBeats > 100){
			System.out.println("����Ҫ����һ���ļ��");
		}

		System.out.println("������");

		//**********************************
		/*
		����2������һ���������ж���ż����������    
		*/
		int num = 13;
		if(num % 2 == 0){
			System.out.println(num + "��ż��");
		}else{
			System.out.println(num + "������");
		}
	}
}
