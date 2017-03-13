import java.util.*;

public class ContiuedFraction{
	static int euclidean(int a , int b){
		int q ,r,total = 0;
		// ArrayList qq = new ArrayList();
		
		do{
			q = a/b;
			r = a-q*b;
			// qq.add(q);
			total +=q;//讓連分數的值相加總

			if(r==0) break;
			a = b;//輾轉相除
			b = r;
			
		}while (r!=0);

        return total;		
	}
	// public static void main(String[] args){
		
	// 	int a=86,b=6;
	// 	System.out.println(a +"/" + b + "的連分數" + euclidean(a,b));
	// }
}

