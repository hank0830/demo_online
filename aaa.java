
// package demo_local;
import java.util.*;
import java.util.Scanner;

class aaa{
	public static void main(String[] args){
		// System.out.println("輸入隨便幾個值");
		// Scanner input = new Scanner(System.in);
		// int a = input.nextInt();
		int[] a ={3,2,1};
		int x = 0,modnumber = 0,mon = 1,montotal = 1,upon = 1;
		int[] b = new int[11];//每個成員正確權杖
		int [] num = new int [11];//存每個成員為何
		int [] key = new int [11];//存每個成員所輸入的權杖
		int [] ans = new int [11];//存每個成員計算後的值
		// ArrayList<Integer> kkk = new ArrayList<Integer>();	
		int sum = 0;
		int totalMember,xxx = 1; 
		//totalMember : 共來幾個成員    
		//sum ：來的成員所用它秘密權杖計算完後的加總
		// Test test = new test();
		// int num1,key1,num2,key2,num3,key3;
		// int first,second,third,total;
		test.Poly(a);//把係數帶入多項式細算

		Scanner scn = new Scanner(System.in);

		// Scanner scn = new Scanner(System.in);
		// x = scn.nextInt();
		// System.out.print("帶入後的值為");

		System.out.println("f(x)=  3X^2 + 2x +1 ");
		System.out.println("請選擇一個質數");
		modnumber = scn.nextInt();

		System.out.println("若有十位成員，十位成員的身份為");
		for(int i = 1;i<=10;i++){
			System.out.println("第"+ i + "位成員");
			System.out.print("秘密權杖為：");
			System.out.println(test.eval(i)%modnumber);
			b[i] = test.eval(i)%modnumber;
			// System.out.println("int[]b  第"+ i + "格存" + b[i]);
		}

		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("請問來了幾位參與者？");
		totalMember = scn.nextInt();
		System.out.println("請輸入他們的身份與密鑰");
		//連分數宣告不治
		// ContiuedFraction con = new ContiuedFraction();//處理連分數  新增一個物件
		ModInverse[] inv = new ModInverse[totalMember+1];
		int[] qq = new int[totalMember+1];
		//處理負數  mod 
		for(int i = 1 ;i <=totalMember ;i++){//enter everyone's key
			System.out.println("輸入第" + i + "位身份");
			num[i] = scn.nextInt();
			System.out.println("輸入第" + i + "秘密權杖");
			key[i] = scn.nextInt();
		}
        for(int i = 1 ; i<=totalMember ; i++){//i 會等於totalmember，代表知道有幾個成員
            for (int j=1;j<=totalMember;j++){//j要計算除了本身以外的運算 ，j代表儲存了位址並非成員的編號
	        	if(j==i){
            		continue;
	            }
				if(j!=i){
					mon = (num[i] - num[j]);
					// 分母
					upon = upon * (-num[j]);
	                // 計算分子
					
					montotal = montotal * mon;
					// 連成分母
					
				}	
			}
			if(montotal<0){
				while(montotal<0){
						montotal = montotal + modnumber;
				//如果分母為負，則變成正
					}
			}
			if((montotal%modnumber)==0){
				montotal = 1;
			}
			// System.out.println("印出inv : " + inv[i].solve(montotal,modnumber));
			// System.out.println("print:"+xxx);
			inv[i] = new ModInverse();
			qq[i] = inv[i].solve(montotal,modnumber);//qq為存反元素
			if(qq[i]==0){
				qq[i] +=1;
			}
 			xxx = upon * qq[i];
 			// System.out.println("計算結果realse的值" + xxx);

			ans[i] = (key[i] * xxx)% modnumber;

			System.out.println("第" + i + "個使用者送出的值：" + ans[i]);
			xxx = 1;
			upon = 1;
			montotal = 1;
			mon = 1;

			sum = sum + ans[i];

			//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
			//索引值超出陣列範圍
		}

		sum = sum % modnumber;

		//萬一sum為負數，做以下處理
		if(sum < 0){
			sum += modnumber;
		}

        System.out.println("加密後我們所要求的s'為："+sum);
	}
}

