import java.util.LinkedList;

public class ContiuedFraction{
	static LinkedList<Integer> euclidean(int a , int b){
		int q ,r;
		LinkedList<Integer> qq = new LinkedList<Integer>();
		do{
			q = a/b;
			r = a-q*b;
			qq.addLast(q);
			if(r==0) break;
			a = b;//輾轉相除
			b = r;
		}while (r!=0);
		return qq;
	}
	public static void main(String[] args){
		int a=86,b=6;
		System.out.println(a +"/" + b + "的連分數" + euclidean(a,b));
	}
}