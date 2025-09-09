package top.lovebegetslover.javase.chapter03.src;

/*
��Ŀ��������е�ˮ�ɻ�������νˮ�ɻ�����ָһ��3λ���������λ�����������͵����䱾��
���磺 153 = 1*1*1 + 3*3*3 + 5*5*5
*/
class ForTest1 {
	public static void main(String[] args) {
		
		//�������е�3λ��
		for(int i = 100;i <= 999;i++){
			
			//�����ÿһ����λ��i����ȡ�����λ����ֵ
			int ge = i % 10;
			int shi = i / 10 % 10;  //�� int shi = i % 100 / 10
			int bai = i / 100;

			//�ж��Ƿ�����ˮ�ɻ����Ĺ���
			if(i == ge * ge * ge + shi * shi * shi + bai * bai * bai){
				System.out.println(i);
			}

		}
	}
}
