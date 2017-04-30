public class ModInverse{
	 public int[] c;
	 // static int c[] ={1,0};
	 public ModInverse () {
	 	c = new int[2];
	 	c[0] = 1;
	 	c[1] = 0;
	 }
	 public int solve(int a ,int b){
	 // static int solve(int a ,int b){
		int q=a/b,r=a-b*q;
		int cc = c[1];
		c[1] = -q * c[1] + c[0];
		c[0] = cc;
		if(r!=0){
			return solve(b,r);
		}
		else{
			if(b!=1) throw
				new ArithmeticException("未取得其他成員之權杖資訊");
			return(c[0]>0)?c[0]:c[0]+c[1];
		}
	}
	// public static void main(String[] args){

	// 	int a = 10,b=13;
		
	// 	ModInverse pp = new ModInverse();
	// 	// pp = new ModInverse();
	// 	System.out.println(pp.solve(a,b));
	// }
}