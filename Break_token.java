import java.util.*;
import java.util.Scanner;

class Break_token {
	public static void main(String[] args){
		int w=0,x=0,y=0,z=0,ww=0,xx=0;
		int ttt = 0,nnn = 0,jjj = 0;//jjj是要管理print出來的未知數A、B
		Scanner check = new Scanner(System.in);
		ArrayList<MyData> list = new ArrayList<MyData>();
		ArrayList listOfc1 = new ArrayList();
		ArrayList listOfc2 = new ArrayList();
		Object[][] user1 = new Object[2][2];//建立每一個user的破解矩陣
		Object[][] user2 = new Object[2][2];
		Object[][] user3 = new Object[2][2];
		Object[][] user4 = new Object[2][2];
		Object[][] user5 = new Object[2][2];
		Object[][] user6 = new Object[2][2];
		Object[][] user7 = new Object[2][2];
		Object[][] user8 = new Object[2][2];
		Object[][] user9 = new Object[2][2];
		Object[][] user10 = new Object[2][2];
		int[] secret_token_1= new int[3];//存每個成員釋出的Ci
		int[] secret_token_2= new int[3];
		int[] secret_token_3= new int[3];
		int[] secret_token_4= new int[3];
		int[] secret_token_5= new int[3];
		int[] secret_token_6= new int[3];
		int[] secret_token_7= new int[3];
		int[] secret_token_8= new int[3];
		int[] secret_token_9= new int[3];
		int[] secret_token_10= new int[3];

		String n,s;
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
			int[] guess_1 = new int[11];//存沒有加f(x)權杖的值<---破解用
			int[] guess_2 = new int[11];

			test.Poly(a);//計算F1方程式結果
			test1.Poly(b);//計算F2方程式結果
			Scanner scn = new Scanner(System.in);//輸入
			System.out.println("我們選擇k=2，兩條方程式為：");
			System.out.println("第一條方程式：f(x)=  3X^2 + 2x + 1 ");
			System.out.println("第二條方程式：f(x)=  4X^2 - 5x + 3 ");
			System.out.println("每條方程式選擇兩個正整數:w1=6 ; w2=7 ;d1=1 ; d2=12");//目前固定兩個方程式的正整數
			System.out.println("請選擇一個質數");
			modnumber = scn.nextInt();

			do{	




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
	            		if(upon_1==0){
	            			upon_1+=1;
	            		}
		                // 第一條方程式 計算分子  (wj-xr)

	            		upon_2 = upon_2 * (w2-num[j]);
	            		if(upon_2==0){
	            			upon_2+=1;
	            		}

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

	 			guess_1[i] = (d1* ooo)% modnumber;//這邊運算不加權杖
	 			guess_2[i] = (d2* xxx)% modnumber;//這邊運算不加權杖
	 			listOfc1.add(guess_1[i]);//存入每個成員所計算的Ci_1
				listOfc2.add(guess_2[i]);//存入每個成員所計算的Ci_2

				// System.out.println("arraylist_1 = "+listOfc1.get(i-1));
	 		// 	System.out.println("第" + i + "個使用者第一條方程式的值：" + guess_1[i]);
	 		// 	System.out.println("第" + i + "個使用者第二條方程式的值：" + guess_2[i]);
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
				if(secret_token[i]<0){
					secret_token[i]+=modnumber;
				}


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
	        	break;
	        }
	        else{
	        	System.out.println("驗證失敗");
	        }

	        System.out.println("是否繼續參與認證：");
	        System.out.println("按 y 繼續 ，任意鍵跳脫：");
	        s = check.next();
	        if(s.equals("y")){
	        	for(int i = 1 ; i <= totalMember ; i++) {
	        		switch( num[i]) {
	        			case 1 :
	        			user1[0][0] = guess_1[i];
	        			user1[0][1] = guess_2[i]; 
		            	secret_token_1[1]=secret_token[i];//存每個成員釋出的Ci
		            	break;
		            	case 2 :
		            	user2[0][0] = guess_1[i];
		            	user2[0][1] = guess_2[i];
      		      		secret_token_2[1]=secret_token[i];//存每個成員釋出的Ci 
      		      		break;
      		      		case 3 :
      		      		user3[0][0] = guess_1[i];
      		      		user3[0][1] = guess_2[i]; 
          				secret_token_3[1]=secret_token[i];//存每個成員釋出的Ci
          				break;
          				case 4 :
          				user4[0][0] = guess_1[i];
          				user4[0][1] = guess_2[i]; 
            			secret_token_4[1]=secret_token[i];//存每個成員釋出的Ci
            			break;
            			case 5 :
            			user5[0][0] = guess_1[i];
            			user5[0][1] = guess_2[i]; 
        	    		secret_token_5[1]=secret_token[i];//存每個成員釋出的Ci
        	    		break;
        	    		case 6 :
        	    		user6[0][0] = guess_1[i];
        	    		user6[0][1] = guess_2[i]; 
            			secret_token_6[1]=secret_token[i];//存每個成員釋出的Ci
            			break;
            			case 7 :
            			user7[0][0] = guess_1[i];
            			user7[0][1] = guess_2[i]; 
            			secret_token_7[1]=secret_token[i];//存每個成員釋出的Ci
            			break;
            			case 8 :
            			user8[0][0] = guess_1[i];
            			user8[0][1] = guess_2[i]; 
            			secret_token_8[1]=secret_token[i];//存每個成員釋出的Ci
            			break;
            			case 9 :
            			user9[0][0] = guess_1[i];
            			user9[0][1] = guess_2[i];
            			secret_token_9[1]=secret_token[i];//存每個成員釋出的Ci 
            			break;
            			case 10 :
            			user10[0][0] = guess_1[i];
            			user10[0][1] = guess_2[i]; 
            			secret_token_10[1]=secret_token[i];//存每個成員釋出的Ci
            			break;
            			default:
            			System.out.println("error, input");
            			continue;
            		}
            	}


	        // for(int i = 1;i<=totalMember;i++){
	        // nnn = num[i];
	      	// ttt = secret_token[i];
	   		////System.out.println(nnn);
	   		////System.out.println(ttt);
			//// MyData breakdata = new MyData(nnn,ttt);
			// list.add(new MyData(nnn,ttt));
			// }
			// for(int i = 0;i<list.size();i++){
			// System.out.println("Person at index" + i);
			// MyData data = list.get(i);
			// System.out.println("USERID =" + data.getUserID());
			// System.out.println("UserRealse = " + data.getSentValue());
			// System.out.println("------------------------------");
			// }
			//// for(int i = 1;i<=totalMember;i++){
			//// 	System.out.println("User" + (i) + "=C11 + C12 = 成員送出的Ci-->" + guess_1[i] + "+" + guess_2[i]);
			//// }


			// for(int i = 0 ;i<list.size();i++){
			// 	MyData data = list.get(i);
			// 	System.out.println("第" + data.getUserID()+"成員算式為："+ listOfc1.get(i) + "+" + listOfc2.get(i)+ "=" + data.getSentValue());
			// }
            }
        }while(s.equals("y"));

        for(int i = 1 ; i <= totalMember ; i++) {
        	switch( num[i]) {
        		case 1 :
        		user1[1][0] = guess_1[i];
        		user1[1][1] = guess_2[i]; 
		        secret_token_1[2]=secret_token[i];//存每個成員釋出的Ci
		        break;
		        case 2 :
		        user2[1][0] = guess_1[i];
		        user2[1][1] = guess_2[i];
      		    secret_token_2[2]=secret_token[i];//存每個成員釋出的Ci 
      		    break;
      		    case 3 :
      		    user3[1][0] = guess_1[i];
      		    user3[1][1] = guess_2[i]; 
          		secret_token_3[2]=secret_token[i];//存每個成員釋出的Ci
          		break;
          		case 4 :
          		user4[1][0] = guess_1[i];
          		user4[1][1] = guess_2[i]; 
            	secret_token_4[2]=secret_token[i];//存每個成員釋出的Ci
            	break;
            	case 5 :
            	user5[1][0] = guess_1[i];
            	user5[1][1] = guess_2[i]; 
        	    secret_token_5[2]=secret_token[i];//存每個成員釋出的Ci
        	    break;
        	    case 6 :
        	    user6[1][0] = guess_1[i];
        	    user6[1][1] = guess_2[i]; 
            	secret_token_6[2]=secret_token[i];//存每個成員釋出的Ci
            	break;
            	case 7 :
            	user7[1][0] = guess_1[i];
            	user7[1][1] = guess_2[i]; 
            	secret_token_7[2]=secret_token[i];//存每個成員釋出的Ci
            	break;
            	case 8 :
            	user8[1][0] = guess_1[i];
            	user8[1][1] = guess_2[i]; 
            	secret_token_8[2]=secret_token[i];//存每個成員釋出的Ci
            	break;
            	case 9 :
            	user9[1][0] = guess_1[i];
            	user9[1][1] = guess_2[i];
            	secret_token_9[2]=secret_token[i];//存每個成員釋出的Ci 
            	break;
            	case 10 :
            	user10[1][0] = guess_1[i];
            	user10[1][1] = guess_2[i]; 
            	secret_token_10[2]=secret_token[i];//存每個成員釋出的Ci
            	break;
            	default:
            	System.out.println("error, input");
            	continue;
            }
        }

	    // for(int i = 1;i<=totalMember;i++){
	    // nnn = num[i];
	    // ttt = secret_token[i];
	    // list.add(new MyData(nnn,ttt));
	    //// System.out.println(nnn);
	    //// System.out.println(ttt);
		//// MyData breakdata = new MyData(nnn,ttt);	  
		// }

		// for(int i = 0;i<list.size();i++){
		// 	System.out.println("Person at index" + i);
		// 	MyData data = list.get(i);
		// 	System.out.println("USERID =" + data.getUserID());
		// 	System.out.println("UserRealse = " + data.getSentValue());
		// 	System.out.println("------------------------------");
		// }

		//// for(int i = 0;i<totalMember;i++){
		//// 	System.out.println("User"+(i+1) + "=C11 + C12 = 成員送出的Ci-->" +listOfc1.get(i) + "+" + listOfc2.get(i));
		//// }
		// int list1size=0,list2size=0;
		// for(int i = 0 ;i<list.size();i++){
		// 	MyData data = list.get(i);
		// 	System.out.println("第" + data.getUserID()+"成員算式為："+ listOfc1.get(i) + "+" + listOfc2.get(i)+ "=" + data.getSentValue());
		// 	list1size += 1;//find array size
		// 	list2size += 1;//find array size
		// 	}



        // GaussMatrix[] obj =new GaussMatrix[totalMember+1];

        GaussMatrix obj = new GaussMatrix(2);
		// obj.fillMatrix(user1[][]);
		// obj.constants(secret_token_1[]);
        for(int i =1;i<=totalMember;i++){
        	int flag = 0;
        	switch(num[i]){
        		case 1 :
        		for(int k=1;k<=2;k++){
        			for(int l=1;l<=2;l++){
        				if(user1[k-1][l-1]!= null){

        					obj.fillMatrix(user1[k-1][l-1],(k-1),(l-1));
        					flag = 1;	   	 			
        				}
        				else {
        					break;
        				}
        			}
        		
        		}
        					if(flag ==1){
        					ww = secret_token_1[1];
        					xx = secret_token_1[2];
        					obj.constants(ww,xx);
        					obj.printMatrix();
        					obj.eliminate();
        					obj.solve();
        					System.out.println("成員 " + num[i] + " 秘密權杖個別為：");
        					obj.printSolution();    

        					}

        		break;
        		case 2 :
        		for(int k=1;k<=2;k++){
        			for(int l=1;l<=2;l++){
        				if(user2[k-1][l-1]!= null){

        					obj.fillMatrix(user2[k-1][l-1],(k-1),(l-1));
        					flag =1;
        				}
        				else{
        					break;
        				}
        			}
        		}
        		if(flag ==1){
        					ww = secret_token_2[1];
			        		xx = secret_token_2[2];
        					obj.constants(ww,xx);
        					obj.printMatrix();
        					obj.eliminate();
        					obj.solve();
        					System.out.println("成員 " + num[i] + " 秘密權杖個別為：");
        					obj.printSolution();

        		}


        		break;
        		case 3 :
        		for(int k=1;k<=2;k++){
        			for(int l=1;l<=2;l++){
        				if(user3[k-1][l-1]!= null){

        					obj.fillMatrix(user3[k-1][l-1],(k-1),(l-1));
        					flag = 1;

        				}
        				else{
        					break;
        				}
        			}
        		}
        		if(flag==1){
        					ww = secret_token_3[1];
			        		xx = secret_token_3[2];
        					obj.constants(ww,xx);
        					obj.printMatrix();
        					obj.eliminate();
        					obj.solve();
        					System.out.println("成員 " + num[i] + " 秘密權杖個別為：");
        					obj.printSolution();
        		}

        		break;
        		case 4 :
        		for(int k=1;k<=2;k++){
        			for(int l=1;l<=2;l++){
        				if(user4[k-1][l-1]!= null){     	   		 	

        					obj.fillMatrix(user4[k-1][l-1],(k-1),(l-1));
        					flag = 1;
  	        		
        				}
        				else{
        					break;
        				}
        			}
        		}   
        		if(flag ==1){
			        		ww = secret_token_4[1];
			        		xx = secret_token_4[2];
        					obj.constants(ww,xx);
        					obj.printMatrix();
        					obj.eliminate();
        					obj.solve();
        					System.out.println("成員 " + num[i] + " 秘密權杖個別為：");
        					obj.printSolution();   
        		}     	



        		break;

        		case 5 :
        		for(int k=1;k<=2;k++){
        			for(int l=1;l<=2;l++){
        				if(user5[k-1][l-1]!= null){    	

        					obj.fillMatrix(user5[k-1][l-1],(k-1),(l-1));
        					flag = 1;
        				}
        				else{
        					break;
        				}
        			}
        		}
        		if(flag ==1 ){
        					ww = secret_token_5[1];
			        		xx = secret_token_5[2];
        					obj.constants(ww,xx);
        					obj.printMatrix();
        					obj.eliminate();
        					obj.solve();
        					System.out.println("成員 " + num[i] + " 秘密權杖個別為：");
        					obj.printSolution();  
        		}
        		break;
        		case 6 :
        		for(int k=1;k<=2;k++){
        			for(int l=1;l<=2;l++){
        				if(user6[k-1][l-1]!= null){ 

        				obj.fillMatrix(user6[k-1][l-1],(k-1),(l-1));
        				flag = 1;
        				}
        				else{
        					break;
        				}
        			}
        		}
        			if(flag ==1){
        				ww = secret_token_6[1];
			        	xx = secret_token_6[2];
		        		obj.constants(ww,xx);
		        		obj.printMatrix();
		        		obj.eliminate();
		        		obj.solve();
		        		System.out.println("成員 " + num[i] + " 秘密權杖個別為：");
		        		obj.printSolution(); 
		        	}

       		
        		break;
        		case 7 :
        		for(int k=1;k<=2;k++){
        			for(int l=1;l<=2;l++){
        				if(user7[k-1][l-1]!= null){ 
        				obj.fillMatrix(user7[k-1][l-1],(k-1),(l-1));
        				flag = 1;  
        				}
        				else{
        					break;
        				}
        			}
        		}
        		if(flag ==1){
		        		ww = secret_token_7[1];
		        		xx = secret_token_7[2];
		        		obj.constants(ww,xx);
		        		obj.printMatrix();
		        		obj.eliminate();
		        		obj.solve();
		        		System.out.println("成員 " + num[i] + " 秘密權杖個別為：");
		        		obj.printSolution();   
        		}

   		
        		break;
        		case 8 :
        		for(int k=1;k<=2;k++){
        			for(int l=1;l<=2;l++){
        				if(user8[k-1][l-1]!= null){ 

        				obj.fillMatrix(user8[k-1][l-1],(k-1),(l-1));
        				flag = 1;
 
        				}
        				else{
        					break;
        				}
        			
        			}
        		}
        		if(flag ==1){
        			    ww = secret_token_8[1];
		        		xx = secret_token_8[2];
		        		obj.constants(ww,xx);
		        		obj.printMatrix();
		        		obj.eliminate();
		        		obj.solve();
		        		System.out.println("成員 " + num[i] + " 秘密權杖個別為：");
		        		obj.printSolution();    
        		}

        		break;
        		case 9 :
        		for(int k=1;k<=2;k++){
        			for(int l=1;l<=2;l++){
        				if(user9[k-1][l-1]!= null){ 

        				obj.fillMatrix(user7[k-1][l-1],(k-1),(l-1));
        				flag = 1;  
        				}
        				else{
        					break;
        				}
        			}
        		}
       			if(flag ==1){
						ww = secret_token_9[1];
        				xx = secret_token_9[2];
		        		obj.constants(ww,xx);
		        		obj.printMatrix();
		        		obj.eliminate();
		        		obj.solve();
		        		System.out.println("成員 " + num[i] + " 秘密權杖個別為：");
		        		obj.printSolution();   
       			}

        		break;


        		case 10 :
        		for(int k=1;k<=2;k++){
        			for(int l=1;l<=2;l++){
        				if(user10[k-1][l-1]!= null){ 

        				obj.fillMatrix(user7[k-1][l-1],(k-1),(l-1));
        				flag = 1;
 
        				}
        				else{
        					break;
        				}
        			}
        		}
        		if(flag ==1 ){
        			    ww = secret_token_10[1];
        				xx = secret_token_10[2];
		        		obj.constants(ww,xx);
		        		obj.printMatrix();
		        		obj.eliminate();
		        		obj.solve();
		        		System.out.println("成員 " + num[i] + " 秘密權杖個別為：");
		        		obj.printSolution();    
        		}
        		break;
        	}
        	// obj.fillMatrix(w,x,y,z);
        	// obj.constants(ww,xx);
        	// obj.printMatrix();
        	// obj.eliminate();
        	// obj.solve();
        	// System.out.println("成員 " + num[i] + " 秘密權杖個別為：");
        	// obj.printSolution();
        }
    }
}