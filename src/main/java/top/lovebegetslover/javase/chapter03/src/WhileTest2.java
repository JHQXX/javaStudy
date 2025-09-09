package top.lovebegetslover.javase.chapter03.src;

/*
�������ɽ������������壬���ĸ߶���8848.86�ף���������һ���㹻���ֽ�����ĺ����0.1���ס�
���ʣ����۵����ٴΣ������۳����������ĸ߶�?

*/
class WhileTest2 {
	public static void main(String[] args) {
		
		//1. �������ĸ߶ȡ�ֽ��Ĭ�Ϻ��
		double paper = 0.1;//��λ������
		double zf = 8848860;//��λ������
		

		//2. ����һ����������¼��ֽ�Ĵ���
		int count = 0;


		//3. ͨ��ѭ���ṹ�����ϵ���ֽ�ĺ�� ����ֽ�ĺ�ȳ������߶�ʱ��ֹͣѭ����
		while(paper <= zf){
			
			paper *= 2;
			count++;

		}
		
		System.out.println("paper�ĸ߶�Ϊ:" + (paper / 1000) + ",���������ĸ߶�" + (zf/1000));
		System.out.println("����ֽ" + count + "��");


	}
}
