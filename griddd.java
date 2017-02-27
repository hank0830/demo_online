import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;
class griddd extends JFrame{
	public static void main(String[] args){
		griddd jbox = new griddd();
	}
	JLabel jlb1;
	JTextArea jlb2,jlb3;
	JPanel jp1,jp2,jp3,jp4;
	JButton jb1;
	public griddd(){
        this.setLayout(new GridBagLayout());
        this.setTitle("同步t,m,n群組認證機制∑");
		this.setSize(650,550);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // this.setResizable(false);

        // jp1 = new JPanel();
        
		JLabel n0 = new JLabel("同步驗證機制原理 ");

        GridBagConstraints c0 = new GridBagConstraints();
        c0.gridx = 0;
        c0.gridy = 0;
        //c0.gridwidth = 0;
        c0.gridheight = 1;
        c0.weightx = 0;
        c0.weighty = 0;
        c0.fill = GridBagConstraints.NONE;
        c0.anchor = GridBagConstraints.CENTER;
        // jp1.add(n0);
        this.add(n0,c0);

        JLabel n1 = new JLabel("<html>X<sup>2</sup>+2x+1</html>");
        c0.gridx = 0;
        c0.gridy = 0;
        //c0.gridwidth = 0;
        c0.gridheight = 1;
        c0.weightx = 0;
        c0.weighty = 0;
        c0.insets = new Insets(1,1,1,1);
        c0.fill = GridBagConstraints.NONE;
        c0.anchor = GridBagConstraints.WEST;
        // jp1.add(n0);
        this.add(n1,c0);

		jlb2 = new JTextArea("1.用來驗證在同一個群組(Group)中所有用戶，不再是針對一個一個用戶來檢驗他們的身份。 \n2.同步(t,m,n)GAS機制: \n    t：為機制的一個門檻，代表每一次認證至少要有t個以上的成員參與認證 \n    m：為該次參與認證的成員數 \n    n：表示在這一群組的所有用戶數量測試 \n 測試 \n 測試 \n 測試 \n 測試 \n 測試 \n 測試 \n 測試 \n 測試 \n 測試 \n ");
        jlb2.setLineWrap(true);    
        jlb2.setSize(575,450);
        jlb2.setLineWrap(true); //換行
        jlb2.setEditable(false); //不可編輯文字
        jlb2.setWrapStyleWord(true);

        
        jp2=new JPanel();
        jp2.add(jlb2);
        jp2.setBorder(BorderFactory.createTitledBorder("原理"));
        
        ScrollPane scroll = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        scroll.add(jp2);


        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 1;
        // c1.gridwidth = 11;
        // c1.gridheight = 1;
        c1.weightx = 1;
        c1.weighty = 1;
        c1.insets = new Insets(1,1,1,1);
        c1.fill = GridBagConstraints.BOTH;
        c1.anchor = GridBagConstraints.CENTER;
        this.add(scroll, c1);


		jlb3 = new JTextArea("測試 \n 測試 \n用來驗證在同一個群組(Group)中所有用戶，專門設計給群測試 \n測試 \n測試 \n測試 \n測試 \n測試 \n測試 \n");
        jlb3.setLineWrap(true);    
        jlb3.setSize(575,450);
        jlb3.setLineWrap(true); //換行
        jlb3.setEditable(false); //不可編輯文字
        jlb3.setWrapStyleWord(true);

        jp3 = new JPanel();
        jp3.add(jlb3);
        jp3.setBorder(BorderFactory.createTitledBorder("弱點"));

        ScrollPane scroll1 = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        scroll1.add(jp3);
         
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 0;
        c2.gridy = 2;
        // c2.gridwidth = 11;
        // c2.gridheight = 1;
        c2.weightx = 1;
        c2.weighty = 1;
        c2.insets = new Insets(1,1,1,1);
        c2.fill = GridBagConstraints.BOTH;
        c2.anchor = GridBagConstraints.CENTER;
        this.add(scroll1,c2);



		jb1=new JButton("確認");
		jb1.addActionListener(new Listen());

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 3;
        // c3.gridwidth = 1;
        c3.gridheight = 0;
        c3.weightx = 1;
        c3.weighty = 1;
        c3.fill = GridBagConstraints.NONE;
        c3.anchor = GridBagConstraints.CENTER;
        this.add(jb1, c3);
		//確認鈕

		this.setVisible(true);

	}
	class Listen extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SwingUtilities.windowForComponent(jb1).dispose();
        }
    }
	
}