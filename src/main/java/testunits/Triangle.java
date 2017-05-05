package testunits;

public class Triangle {
	double a;
	double b;
	private double c;
	private int type = 0;    //0表示不是三角形，十位数是：1表示等边、2表示等腰、3表示非等腰，个位数是：1表示直角三角形、2表示钝角、3表示锐角。
	
	public Triangle(double a2, double b2, double c2) {       //构造函数
		a = a2;
		b = b2;
		c = c2;
		
		// TODO Auto-generated constructor stub
	}
	public int getType(){
		return type;
	}
	public void sort() {             //给三边按大小排序，a最小，c最大
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
	
	public void judge() throws Exception{                  //判断函数
		sort();
		
			if (a+b < c || b+c < a || a+c <b) {
				System.out.println("此三边无法构成三角形");
				type = 0;
			}else {
				if (a == b && b == c) {
					System.out.println("此三角形是 等边三角形");
					type = 10;
				}else {
					if (a == b || b == c || a == c) {
						System.out.println("此三角形是 等腰三角形");
						type = 20;
					}else {
						System.out.println("此三角形是 非等腰三角形");
						type = 30;
					}
				}
				if (a*a+b*b == c*c) {
					System.out.println("且是 直角三角形");
					type = type+1;
				}else {
					if (a*a+b*b < c*c) {
						System.out.println("且是 钝角三角形");
						type = type+2;
					} else {
						System.out.println("且是 锐角三角形");
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