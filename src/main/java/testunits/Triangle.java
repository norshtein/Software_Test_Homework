package testunits;

public class Triangle {
	double a;
	double b;
	private double c;
	private int type = 0;    //0��ʾ���������Σ�ʮλ���ǣ�1��ʾ�ȱߡ�2��ʾ������3��ʾ�ǵ�������λ���ǣ�1��ʾֱ�������Ρ�2��ʾ�۽ǡ�3��ʾ��ǡ�
	
	public Triangle(double a2, double b2, double c2) {       //���캯��
		a = a2;
		b = b2;
		c = c2;
		
		// TODO Auto-generated constructor stub
	}
	public int getType(){
		return type;
	}
	public void sort() {             //�����߰���С����a��С��c���
		double d;
		if (a > b) {
			d = a;
			a = b;
			b = d;
		}
		if (c < a) {
			d = c;
			c = b;
			b = a;
			a = d;
		}else {
			if (c < b) {
				d = c;
				c = b;
				b = d;
			}
		}
	}
	
	public void judge() throws Exception{                  //�жϺ���
		sort();
		
			if (a+b < c || b+c < a || a+c <b) {
				System.out.println("�������޷�����������");
				type = 0;
			}else {
				if (a == b && b == c) {
					System.out.println("���������� �ȱ�������");
					type = 10;
				}else {
					if (a == b || b == c || a == c) {
						System.out.println("���������� ����������");
						type = 20;
					}else {
						System.out.println("���������� �ǵ���������");
						type = 30;
					}
				}
				if (a*a+b*b == c*c) {
					System.out.println("���� ֱ��������");
					type = type+1;
				}else {
					if (a*a+b*b < c*c) {
						System.out.println("���� �۽�������");
						type = type+2;
					} else {
						System.out.println("���� ���������");
						type = type+3;
					}
				}
			}
	}
	
	/*public static void main(String[] args) {
		Triangle main = new Triangle(3,4,5);
		main.sort();
		main.judge();
		
		try{
			new exc();
		}catch(Exception e){
			System.out.println();
		}
	}*/
}