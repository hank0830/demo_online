
// package demo_local;
import java.util.*;
import java.util.Scanner;

class aaa_array{
	public static void main(String[] args){

		int[] a ={3,2,1};
		int x = 0,aa,bb,prime,count,score = 0;  //aa:輸入scn身份   bb：輸入scn權杖
		ArrayList<Integer> kkk = new ArrayList<Integer>();

		ArrayList<Integer> memberKey = new ArrayList<Integer>();//每個成員正確權杖
		// int[] b = new int[11];//每個成員正確權杖
		ArrayList<Integer> member = new ArrayList<Integer>();////存每個成員身份
		// int [] num = new int [11];//存每個成員為何
		ArrayList<Integer> enterKey = new ArrayList<Integer>();//存成員輸入的權杖
		// int [] enterKey = new int [11];//存每個成員所輸入的權杖
		ArrayList<Integer> calculateKey = new ArrayList<Integer>();//存每個成員計算後的值
		// int [] ans = new int [11];//存每個成員計算後的值
		int n=0,sum = 0,mon = 1,upon = 1,montotal = 1;
		int totalMember,xxx = 1,ooo = 0,ppp = 1; 
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
		System.out.println("輸入群組總成員數：");
		n = scn.nextInt();
		for(int i = 1;i<= n;i++){
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
		System.out.println("請輸入一個質數");
		prime = scn.nextInt();
		System.out.println("請問來了幾位參與者？");
		totalMember = scn.nextInt();
		System.out.println("請輸入他們的身份與密鑰");

		ModInverse[] inv = new ModInverse[totalMember+1];//處理連分數  新增一個物件
		int[] qq = new int[totalMember +1 ];
		for(int i = 1 ;i <=totalMember ;i++){
			System.out.println("輸入第" + i + "位身份");

			aa = scn.nextInt();
			member.add(aa);
			System.out.println("輸入第" + i + "秘密權杖");
			bb = scn.nextInt();
			enterKey.add(bb);

		}
		for(int i = 1 ; i<=totalMember ; i++){//i 會等於totalmember，代表知道有幾個成員
			for (int j= 1;j<=totalMember;j++){//j要計算除了本身以外的運算 ，j代表儲存了位址並非成員的編號
				if(j==i){
					continue;
				}
				if(j!=i){
					mon = member.get(i-1)-member.get(j-1);
					upon = upon * (-member.get(i-1));
					montotal = montotal * mon;
				}	

			}
			if(montotal<0){
				while(montotal<0){
					montotal = montotal + prime;
				}
			}
			if(montotal==0){
				montotal =1;
			}
			inv[i]= new ModInverse();
			qq[i] = inv[i].solve(montotal,prime);
			if(qq[i]==0){
				qq[i] +=1;
			}
			xxx = upon *qq[i];
			System.out.println("計算出xxx的值：" + xxx);

			ooo= (memberKey.get(i-1) * xxx) % prime;

			calculateKey.add(ooo);

			System.out.println("第" + i + "個使用者送出的值：" + calculateKey.get(i-1));
			xxx = 1;
			upon = 1;
			montotal = 1;
			mon = 1;
			
			sum += calculateKey.get(i-1);	
		}
			//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
			//索引值超出陣列範圍
			
			sum = sum % prime;

			if(sum<0){
				sum += prime;
			}
			

        System.out.println("加密後我們所要求的s'為："+sum);
	}

}


