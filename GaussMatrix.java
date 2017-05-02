import java.util.*;
public class GaussMatrix
{
    // INSTANCE VARIABLES
    private int[][] m;    // MATRIX OF CO-EFFICIENTS 矩陣
    private int[] constants; // VECTOR OF CONSTANT TERMS ax+by+c的“解”
    private int[] solution; // SOLUTION SET 解決的陣列
    private int numEq;      // NUMBER OF EQUATIONS
    static Scanner sc=new Scanner(System.in);
    
    public GaussMatrix(int equations)   
    {
        numEq=equations;
        m=new int[numEq][numEq];
        constants=new int[numEq+1];
        solution=new int[numEq];
    }//初始化、建構子

	// public void fillMatrix(int aaa,int bbb,int ccc,int ddd){
    public void fillMatrix(Object aaa,int iii,int jjj){

        // for(int i=0;i<tmp;i++){
        //     for(int j=0;j<tmp;j++){
                m[iii][jjj]=(int)aaa;
            // }//這邊再輸入每一個x,y,z的常數項
        // }
    }

    public void constants(int eee,int fff){

        constants[0]=eee;
        constants[1]=fff;

    	// for(int i = 0;i<2;i++){
    	// 	constants[i]=eee[i];
    	// }	
    }//這邊輸入第x條常數的過增矩陣(方程式的解)
    
    // public void fillMatrix()
    // {
    //     for(int i=0;i<numEq;i++){
    //         System.out.println("輸入第 "+(i+1)+" 方程式的係數個別為:");
    //         for(int j=0;j<numEq;j++){
    //             System.out.println("輸入第 "+(j+1)+" 項係數： ");
    //             m[i][j]=sc.nextInt();
    //         }//這邊再輸入每一個x,y,z的常數項
    //         System.out.println("輸入第 : " + (i+1) + "方程式的解：");
    //         constants[i]=sc.nextInt();
    //     }//這邊輸入第x條常數的過增矩陣(方程式的解)
    // }
    
    public void printSolution()
    {
        // System.out.println("\nSolution Set is : ");
        for(int i=0;i<numEq;i++){
        	System.out.println("第"+ (i+1)+ "條方程式的秘密權杖 = " + solution[i]);
            // System.out.println((char)('A'+i)+" = "+solution[i]);
    	}
    }//印出解答//這邊用char是要抓ascii code
    
    public void printMatrix()   
    {// FOR DEBUGGING PURPOSE  因為要測試所以印出
        for(int i=0;i<numEq;i++){
            for(int j=0;j<numEq;j++){
                if(m[i][j]>=0)
                    System.out.print("+ "+m[i][j]+((char)('A'+j))+" ");
                else if(m[i][j]<0)
                    System.out.print(" "+m[i][j]+((char)('A'+j))+" ");
            }
            System.out.println(" = "+constants[i]);
        }
    }
    
    public void swapRows(int row1,int row2)
    {
        int temp;
        for(int j=0;j<numEq;j++){   // SWAPPING CO-EFFICIENT ROWS
            temp=m[row1][j];
            m[row1][j]=m[row2][j];
            m[row2][j]=temp;
        }
        temp=constants[row1];   // SWAPPING CONSTANTS VECTOR
        constants[row1]=constants[row2];
        constants[row2]=temp;
    }//交換行
    
    public void eliminate()
    {//消除
        ModInverse[] inv_3 = new ModInverse[numEq+1];//建構物件陣列計算每個分母的反元素
        int[] ss = new int[numEq+1];//存反元素後的值           
        int i,j,k,l;
        for(i=0;i<numEq;i++){   // i -> ROW ; MATRIX ORDER DECREASES DURING ELIMINATION
            // FIND LARGEST CO-EFFICIENTSOF THE CURRENT COLUMN MOVING ROW-WISE
            int largest=Math.abs(m[i][i]);
            int index=i;
            for(j=i+1;j<numEq;j++){
                if(Math.abs(m[j][i])>largest){
                    largest=m[j][i];
                    index=j;
                }
            }
            swapRows(i,index);  // SWAPPING i-th ROW to index-th ROW
            for(k=i+1;k<numEq;k++){
                if(m[i][i]<0){
                    while(m[i][i]<0){
                        m[i][i]+=13;
                    }
                }
                inv_3[i] = new ModInverse();
                ss[i] = inv_3[i].solve(m[i][i],13);//qq為存反元素
                if(ss[i]==0){
                    ss[i] +=1;
                }
                // PROCESSING COLUMN WISE
                int factor=m[k][i] * ss[i];
                for(l=i;l<numEq;l++){
                    m[k][l]-=factor*m[i][l];
                }
                constants[k]-=factor*constants[i];  // PROCESSING CONSTANTS
            }
        }
    }
    
    public void solve()
    {
        ModInverse[] inv_4 = new ModInverse[numEq+1];
        int[] tt = new int[numEq+1];
        for(int i=numEq-1;i>=0;i--){
            solution[i]=constants[i];   // COPY
            for(int j=numEq-1;j>i;j--){
                solution[i]-=m[i][j]*solution[j];
            }
            if(m[i][i]<0){
                while(m[i][i]<0){
                    m[i][i]+=13;
                }
            }
            inv_4[i] = new ModInverse();
            tt[i] = inv_4[i].solve(m[i][i],13);//kk為存反元素
                
            if(tt[i]==0){
                tt[i] +=1;
             }
            solution[i]=solution[i]*tt[i];
            solution[i] =solution[i] % 13;
            if(solution[i]<0){
                solution[i]+=13;
            }
        }
        return;
    }
    
    // public static void main(String args[])
    // {
    //     System.out.print("Enter the Number of Terms : ");
    //     GaussMatrix obj=new GaussMatrix(2);
    //     obj.fillMatrix();
    //     System.out.println("\fYou Have Entered The Following Equations :");
    //     obj.printMatrix();
    //     obj.eliminate();
    //     obj.solve();
    //     obj.printSolution();
    // }
}