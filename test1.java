// package demo_local;
import java.util.*;
import java.util.Scanner;
public class test1{

	private static List<Integer> coeff = new ArrayList<Integer>();//係數(coefficient)陣列
	private static int order;    //最高次方，其值為 coeff.length -1; 

	public static void Poly(int[] c){
	order = c.length - 1;
	// coeff = new int[c.length];
	for (int i = 0 ; i <= order ; i++)
		coeff.add(c[i]);
	}

	public static int eval(int x) {  //帶入 x 求值
		int result=0;
		for (int i = 0; i <= order ; i++)
			result = result * x + coeff.get(i);
		return result; 
	}

}
