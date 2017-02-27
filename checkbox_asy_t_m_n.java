import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;
class checkbox_asy_t_m_n extends JFrame{
	public static void main(String[] args){
		checkbox_asy_t_m_n jbox = new checkbox_asy_t_m_n();
	}
	JLabel jlb1;
	JTextArea jlb2;
	JPanel jp1,jp2,jp3;
	JButton jb1;
	public checkbox_asy_t_m_n(){
		//標題
		jlb1=new JLabel("非同步驗證機制原理");
		//中間文字部分
		jlb2 = new JTextArea("非同步方法，認證機制分成兩個認證角色：1) 群組管理者、2) 成員(被驗證者)。在該機制中，允許參加該次認證的 個成員，可以在非同步的情況下傳送每位群組成員所計算出的值。以下我們分成幾個步驟說明：Step 1: 群組管理者隨機產  個  多項式，產生權杖()給每位成員  ；為每一位成員的，。Step 2 : 群組管理者選擇正整數、，；群組管理者計算密鑰 ，  ，；公開一個雜湊值，目的為讓參與認證的成員計算完後可以進行比對[  ]。Step 3 : 若成員參與數，群組認證每一參與用戶 使用自己的權杖()計算並釋出  。每個成員收到其他成員釋出值，，計算，若，所有成員及認證成功，反之認證失敗。在非同步群組認證機制中擁有正確性(Correctness)：如果所有成員誠實釋出他們利用拉格朗日(Lagrange)權杖所計算出的值，則參與成員經過計算後可得正確 ，該密鑰可以成功重構。如果有非成員一同參與認證，因為無擁有有效權杖，在重新建構時因釋出計算值  為錯誤，則計算出不正確的密鑰，認證將會失敗。此機制具有高效率性；群組管理者只需要發送給每位成員  個權杖，成員只需計算一個  值，即可完成驗證。在此方法，可以一次驗證所有參與驗證的成員。由於成員權杖是由多項式產生，最高階為 次方，可以抵禦  個內部成員嘗試攻擊並重建多項式。對於其他外來攻擊者，無法透過釋放的計算值來還條多項式。若有 個成員參加群組認證，其中一為外部攻擊者參加該次認證，並是最後一個釋放權杖的成員，攻擊者獲得到 個計算值 ；由於此機制，外部攻擊者不能成功模仿成合法成員。攻擊者也不得重新建構成員私密權杖，因此可以防止攻擊者破解這個秘密多項式。不過在本研究發現，秘密多項式還未被重新建構(reconstruct)前，當有一位攻擊者與其他合法成員參與認證，認證過程中攻擊者可得到其他成員多項式之計算值；攻擊者再次假扮成另一成員，可再得到其他合法成員之多項式計算值。若在攻擊者參與認證中，有一合法成員參與次數大於等於  次，攻擊者利用多次參與，可得到滿足解出該成員權杖的聯立方程式，就有機會可成功破解該合法成員之秘密權杖。在下一節中，我們將詳細說明此機制之弱點。");
        jlb2.setLineWrap(true);    
        jlb2.setSize(650,550);
        jlb2.setLineWrap(true); //換行
        jlb2.setEditable(false); //不可編輯文字
        jlb2.setWrapStyleWord(true);	





		//確認鈕
		jb1=new JButton("確認");
		jb1.addActionListener(new Listen());
//設置為流式佈局
		this.setLayout(new GridLayout(3,1));

		jp1=new JPanel();
		jp1.add(jlb1);
		this.add(jp1);
//第二行
		jp2=new JPanel();
		jp2.add(jlb2);
		jp2.setBorder(BorderFactory.createTitledBorder("原理"));//邊框

		ScrollPane scroll = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		scroll.add(jp2);

		this.add(scroll);
//第三行
		jp3=new JPanel();
		jp3.add(jb1);
		this.add(jp3);

		this.setTitle("非同步t,m,n群組認證機制");
		this.setSize(700,600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	class Listen extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SwingUtilities.windowForComponent(jb1).dispose();
        }
    }
	
}