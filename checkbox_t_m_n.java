import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;
class checkbox_t_m_n extends JFrame{
	public static void main(String[] args){
		checkbox_t_m_n jbox = new checkbox_t_m_n();
	}

    public checkbox_t_m_n() {
        init();
        this.setTitle("同步t,m,n群組認證機制練習");
        this.setSize(600,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // this.setResizable(false);  //設定是否能調整視窗大小      

    }
    JLabel jlb1;
    JTextArea jlb2,jlb3;
    JPanel jp1,jp2,jp3,jp4;
    JButton jb1,jb2;
    public void init(){

        //this.setLayout(new GridBagLayout());


        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        jlb2 = new JTextArea("。......我們假設群最共有5名成員(n)\n。每次至少要有3位成員參與驗證(t)\n。該次參加驗證成員為3位(m)\n"); 
        // jlb2.setSize(550,350);
        jlb2.setLineWrap(true); //自動換行
        jlb2.setEditable(false); //不可編輯文字
        jlb2.setWrapStyleWord(true);
        ScrollPane scroll = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        scroll.add(jlb2);

        jlb3 = new JTextArea("。我們假設群最共有5名成員(n)\n。每次至少要有3位成員參與驗證(t)\n。該次參加驗證成員為3位(m)\n。我們假設群最共有5名成員(n)\n。每次至少要有3位成員參與驗證(t)\n。該次參加驗證成員為3位(m)\n。我們假設群最共有5名成員(n)\n。每次至少要有3位成員參與驗證(t)\n。該次參加驗證成員為3位(m)\n。我們假設群最共有5名成員(n)\n。每次至少要有3位成員參與驗證(t)\n。該次參加驗證成員為3位(m)\n");
        // jlb3.setSize(550,350);
        jlb3.setLineWrap(true); //換行
        jlb3.setEditable(false); //不可編輯文字
        jlb3.setWrapStyleWord(true);//斷行不斷字
        ScrollPane scroll1 = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);

        scroll1.add(jlb3);


        jb1=new JButton("確認");
        jb1.addActionListener(new Listen());

        jb2= new JButton("test(計算)");



        this.add(scroll);
        this.add(scroll1);
        this.add(jb1);
        this.add(jb2);

        GridBagConstraints s = new GridBagConstraints();
        // s.fill = GridBagConstraints.BOTH;

        s.gridx = 0;
        s.gridy = 0;
        // s.gridwidth = 0;
        // s.gridheight = 5;
        s.weightx = 1;
        s.weighty = 1;
        s.fill = GridBagConstraints.BOTH;
        layout.setConstraints(scroll, s);

        s.gridx = 0;
        s.gridy = 1;
        // s.gridwidth = 1;
        // s.gridheight = 1;
        s.weightx = 1;
        s.weighty = 1;
        s.fill = GridBagConstraints.BOTH;
        layout.setConstraints(scroll1,s);




        s.gridx = 0;
        s.gridy = 2;
        s.weightx = 0;
        s.weighty = 0;
        // s.gridwidth = 0;
        // s.gridheight = 0;
        s.fill=GridBagConstraints.NONE;
        s.anchor = GridBagConstraints.WEST;
        layout.setConstraints(jb1,s);

        s.gridx = 0;
        s.gridy = 2;
        s.weightx = 0;
        s.weighty = 0;
        // s.gridwidth = 0;
        // s.gridheight = 0;
        s.fill=GridBagConstraints.NONE;        
        s.anchor = GridBagConstraints.CENTER;
        layout.setConstraints(jb2,s);




        this.setVisible(true);

    }
    class Listen extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SwingUtilities.windowForComponent(jb1).dispose();
        }
    }

}