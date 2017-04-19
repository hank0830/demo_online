import java.util.*;
import java.util.Scanner;

class Break1 {

	public static void main(String[] args){
		Scanner check = new Scanner(System.in);
		String n,s;
		do{
		int w1 = 6, w2 = 7,d1 = 1,d2 = 12;//輸入的兩個正整數
		int modnumber = 0;//選擇的質數
		int num_ans = 0;
		int totalMember = 0;//總共來幾位成員
		int mon = 1,upon_1 = 1,upon_2 = 1,montotal=1,ooo = 1,xxx=1;
		//mon:分母   upon:分子   montotal:分母的連乘 ooo:分子*乘法反元素(第一條)  xxx:分子*乘法反元素(第二條)
		int sum1 = 0,sum2= 0,sumtotal=0;//sum1為c1的加總   sum2為c2的加總
		int auth = 0;//驗證成員總和的加總
		int s1 = 0;//第一個s得值
		int s2 = 0;//第二個s得值
		int s0 = 0;//s加總
		int secret_token_total = 0;
		int[] secret_token = new int[11];//把正確s'=∑ ci相加
		int[] a = {3,2,1};//第一條方程式
		int[] b = {4,-5,3};//第二條方程式
		int[] a_ans = new int[11];//第一條方程式正確權杖(存f(x))(程式自己算)
		int[] b_ans = new int[11];//第二條方程式正確權杖(存f(x))(程式自己算)
		int[] num = new int[11];//認證成員
		int[] key0 = new int[11];//key1+key2
		int[] key1 = new int [11];//認證成員第一條方程式的key(存演算法的Ci)
		int[] key2 = new int [11];//認證成員第二條方程式的key(存演算法的Ci)

		test.Poly(a);//計算F1方程式結果
		test1.Poly(b);//計算F2方程式結果
		Scanner scn = new Scanner(System.in);//輸入
		System.out.println("我們選擇k=2，兩條方程式為：");
		System.out.println("第一條方程式：f(x)=  3X^2 + 2x + 1 ");
		System.out.println("第二條方程式：f(x)=  4X^2 - 5x + 3 ");
		System.out.println("每條方程式選擇兩個正整數:w1=6 ; w2=7 ;d1=1 ; d2=12");//目前固定兩個方程式的正整數
		System.out.println("請選擇一個質數");
		modnumber = scn.nextInt();

		// System.out.println("若有十位成員，十位成員的身份為");
		for(int i = 1;i<=10;i++){
			// System.out.println("第"+ i + "位成員的第一條方程式權杖");
			// System.out.print("秘密權杖為：");
			// System.out.println(test.eval(i)%modnumber);
			a_ans[i] = test.eval(i)%modnumber;
			// System.out.println("第"+ i + "位成員的第二條方程式權杖");
			// System.out.println(test1.eval(i)%modnumber);
			b_ans[i] = test1.eval(i)%modnumber;
		}

		/*開始驗證*/
		System.out.println("請問一共有幾位成員參與驗證？");
		totalMember = scn.nextInt();//輸入本次參與人數
		System.out.println("請問該次參與其他成員為？");

		for(int i = 1 ;i <= (totalMember-1) ;i++){//跑輸入的成員與他的權杖
			System.out.print(" 第" + i + "位身份： ");
			num[i] = scn.nextInt();
		}

		System.out.println("您的身份為：");
		num[totalMember] = scn.nextInt();

		ModInverse[] inv_1 = new ModInverse[totalMember+1];//建構物件陣列計算每個分母的反元素
		ModInverse[] inv_2 = new ModInverse[totalMember+1];
		int[] qq = new int[totalMember+1];//存反元素後的值
		int[] kk = new int[totalMember+1];//存反元素後的值	

		/*群組管理者計算驗證的s = ∑j=1~k，djfj(wj) mod p*/
		System.out.println("/******************************/");		
		System.out.println("這邊是計算s=djfj(wj)的總和");
		s1 = d1 *test.eval(w1); 
			// System.out.println("第一條Ci : "+ s1);
		s2 = d2 *test1.eval(w2);
			// System.out.println("第二條Ci : " + s2);

		s0 = s1 + s2;
		System.out.println("祕鑰s為 :" + (s0%modnumber));
		System.out.println("/******************************/");		
		
		/*以下是c1演算*/
        for(int i = 1 ; i <=totalMember ; i++){//i 會等於totalmember，代表知道有幾個成員
            for (int j= 1 ; j <=totalMember ; j++){//j要計算除了本身以外的運算 ，j代表儲存了位址並非成員的編號
            	if(j==i){
            		continue;
            	}
            	if(j!=i){
            		mon = (num[i] - num[j]);
					// 分母
            		upon_1 = upon_1 * (w1-num[j]);
	                // 第一條方程式 計算分子  (wj-xr)

            		upon_2 = upon_2 * (w2-num[j]);

            		montotal = montotal * mon;
					// System.out.println("montotal ="+montotal );
					// 連成分母	
            	}	
			}//迴圈內層結束
			if(montotal<0){
				while(montotal<0){
					montotal = montotal + modnumber;
				//如果分母為負，則變成正
				}
			}
			if((montotal%modnumber)==0){
				montotal = 1;
			}

			inv_1[i] = new ModInverse();
			qq[i] = inv_1[i].solve(montotal,modnumber);//qq為存反元素
			if(qq[i]==0){
				qq[i] +=1;
			}
			inv_2[i] = new ModInverse();
			kk[i] = inv_2[i].solve(montotal,modnumber);//kk為存反元素
			
			if(kk[i]==0){
				kk[i] +=1;
			}
			num_ans = num[i];//這個是在抓每個成員的編號
	 		ooo = upon_1 * qq[i];	//第一條Ci的分子乘反元素qq[i]
 			xxx = upon_2 * kk[i];//第二條Ci計算

 			key1[i] = d1*(a_ans[num_ans] * ooo) % modnumber;
 			key2[i] = d2*(b_ans[num_ans] * xxx)% modnumber;

			// System.out.println("第" + i + "個使用者第一條方程式的值：" + key1[i]);
			// System.out.println("第" + i + "個使用者第二條方程式的值：" + key2[i]);

 			secret_token[i] = key1[i] + key2[i];

 			if(secret_token[i]>modnumber){
 				secret_token[i]= secret_token[i] - modnumber;
 			}
 			ooo = 1;
 			xxx = 1;
 			upon_1 = 1;
 			upon_2 = 1;
 			montotal = 1;
 			mon = 1;
 			sum1 = sum1 + key1[i];
 			sum2 = sum2 + key2[i];
 			secret_token[i] = secret_token[i] % modnumber;

		}//迴圈外層結束


		sum1 = sum1 % modnumber;
		sum2 = sum2 % modnumber;

		for(int i = 1;i<=(totalMember-1);i++){
			System.out.println("第" + i + "個使用者送出的Ci值：" + secret_token[i]);
		}

		System.out.println("輸入您所釋出的Ci值：");
		secret_token[totalMember] = scn.nextInt();


		System.out.println("/******************************/");
		System.out.println("這邊是我們把驗證成員輸入的ci值做加總");
		for(int i = 1 ; i <= totalMember ; i++ ){
			auth = auth + secret_token[i];
			auth = auth % modnumber;
		}

		//萬一sum為負數，做以下處理
		if(sum1 < 0){
			sum1 += modnumber;
		}
		if(sum2 < 0){
			sum2 += modnumber;
		}

		if(auth<0){
			while(auth<0){
				auth += modnumber;
			}
		}
		System.out.println("驗證成員的總和" + auth);//目的是來看驗證成員的s'總合是否一樣

		System.out.println("/******************************/");


		for(int i =1;i<= totalMember;i++){
			if(secret_token[i]<0){
				secret_token[i] += modnumber;
			}
		}
		/*以上是c1演算*/

        if(auth ==(s0%modnumber)){//auth為參與驗證成員所輸入的秘密值加總
        	System.out.println("驗證成功");
        }
        else{
        	System.out.println("驗證失敗");
        }

        System.out.println("是否繼續參與認證：");
        System.out.println("按 y 繼續 ，任意鍵跳脫：");
        s = check.next();
    }while(s.equals("y"));

}
}