// package demo_local;
import java.util.*;
import java.util.Scanner;

class aaa_array{
	public static void main(String[] args){
		// System.out.println("輸入隨便幾個值");
		// Scanner input = new Scanner(System.in);
		// int a = input.nextInt();
		int[] a ={3,2,1};
		int x = 0,aa,bb,count,score = 0;  //aa:輸入scn身份   bb：輸入scn權杖
		ArrayList<Integer> kkk = new ArrayList<Integer>();

		ArrayList<Integer> memberKey = new ArrayList<Integer>();//每個成員正確權杖
		// int[] b = new int[11];//每個成員正確權杖
		ArrayList<Integer> member = new ArrayList<Integer>();////存每個成員為何
		// int [] num = new int [11];//存每個成員為何
		ArrayList<Integer> enterKey = new ArrayList<Integer>();//存每個成員所輸入的權杖
		// int [] enterKey = new int [11];//存每個成員所輸入的權杖
		ArrayList<Integer> calculateKey = new ArrayList<Integer>();//存每個成員計算後的值
		// int [] ans = new int [11];//存每個成員計算後的值
		int sum = 0;
		int totalMember,xxx = 1,ooo = 1,ppp = 1; 
		//totalMember : 共來幾個成員    
		//sum ：來的成員所用它秘密權杖計算完後的加總
		
		// int num1,key1,num2,key2,num3,key3;
		// int first,second,third,total;
		test.Poly(a);//把係數帶入多項式細算

		Scanner scn = new Scanner(System.in);

		// Scanner scn = new Scanner(System.in);
		// x = scn.nextInt();
		// System.out.print("帶入後的值為");

		System.out.println("f(x)=  3X^2 + 2x +1 ");
		System.out.println("若有十位成員，十位成員的身份為");
		for(int i = 1;i<=10;i++){
			System.out.println("第"+ i + "位成員");
			System.out.print("秘密權杖為：");
			System.out.println(test.eval(i));
			// count = test.eval(i);
			// memberKey.add(count);
			// System.out.println("int[]b  第"+ i + "格存" + memberKey.get(i));
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("請問來了幾位參與者？");
		totalMember = scn.nextInt();
		System.out.println("請輸入他們的身份與密鑰");

		ContiuedFraction con = new ContiuedFraction();//處理連分數  新增一個物件
		for(int i = 1 ;i <=totalMember ;i++){
			System.out.println("輸入第" + i + "位身份");

			aa = scn.nextInt();
			enterKey.add(aa);
			System.out.println("輸入第" + i + "秘密權杖");
			bb = scn.nextInt();
			enterKey.add(bb);
			aa = 0;
			bb = 0;
		}
		for(int i = 1 ; i<=totalMember ; i++){//i 會等於totalmember，代表知道有幾個成員
			for (int j=1;j<=totalMember;j++){//j要計算除了本身以外的運算 ，j代表儲存了位址並非成員的編號
				if(j!=i)
				kkk.add(con.euclidean(-member.get(j),(member.get(i)-member.get(j))));//call function

			}
	
			sum += calculateKey.get(i);	
			System.out.println("第" + i + "個使用者送出的值：" + calculateKey.get(i));
			xxx = 1;


			//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
			//索引值超出陣列範圍
			
			score += sum;

		}
        System.out.println("加密後我們所要求的s'為："+sum);
	}

}






