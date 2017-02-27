import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI2 {
    public GUI2(){
        frame();
    }
    public void frame(){
        JFrame option = new JFrame();
        option.setSize(750,750);//框架大小
        option.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //縮小，關閉，放大
        //Container contentPane = frame.getContentPane();//新增一個pane容器  
        option.setLayout(new GridLayout(2,2));//切四格
        
        //第一格
        JPanel pn = new JPanel();

        pn.setBorder(BorderFactory.createTitledBorder("同步驗證試算"));//邊框
        JButton bt1 = new JButton("同步t,m,n驗證");
        JButton bt2 = new JButton("同步t,m,n實例");
        JButton bt3 = new JButton("非同步t,m,n驗證");
        JButton bt4 = new JButton("非同步t,m,n實例");
        //set button size
        bt1.setSize(50,30);
        bt2.setSize(30,30);
        bt3.setSize(50,30);
        bt4.setSize(30,30);

        pn.add(bt1);
        pn.add(bt2);
        pn.add(bt3);
        pn.add(bt4);
        //第二格
        JPanel pn1 = new JPanel();
        JTextArea text = new JTextArea("1.文字輸入測試\n2.文字輸入測試\n3.文字輸入測試\n4.文字輸入測試\n5.文字輸入測試\n6.文字輸入測試\n");
        Font x = new Font("Serif",0,18);
        text.setFont(x);
        text.setSize(350,350);
        text.setLineWrap(true); //換行
        text.setEditable(false); //不可編輯文字
        text.setWrapStyleWord(true);   
        pn1.setBorder(BorderFactory.createLoweredBevelBorder());//版面邊框
        pn1.add(text);
 

        bt1.addActionListener(new ActionListen1());
        bt2.addActionListener(new Pratice1());
        bt3.addActionListener(new ActionListen2());
        bt4.addActionListener(new Pratice2());


        //第三格
        JPanel pn3 = new JPanel();
        pn3.setBorder(BorderFactory.createTitledBorder("我們所選擇的機制"));
        JTextArea text1 = new JTextArea("      3.1 :群組認證機制 \n1.文字輸入測試\n2.文字輸入測試\n3.文字輸入測試\n4.文字輸入測試\n5.文字輸入測試\n6.文字輸入測試\n7.文字輸入測試\n8.文字輸入測試\n");
        text1.setFont(x);
        text1.setSize(350,350);
        text1.setLineWrap(true); //換行
        text1.setEditable(false); //不可編輯文字
        text1.setWrapStyleWord(true); 
        pn3.add(text1);
        ScrollPane scroll = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        scroll.add(pn3);

        //第四格
        JTextField textField = new JTextField();
        //textField.setLineWrap(true); //換行
        //textField.setWrapStyleWord(true);  //自動換行


        option.add(pn); //第一格
        option.add(pn1); //第二格
        option.add(scroll);  //第三格
        option.add(textField);  //第四格
        
        option.setVisible(true);

    }

    // public void t_m_n_frame(){
    //     checkbox_t_m_n jbox = new checkbox_t_m_n();
    // }
    // public void pratice1(){
    //     checkbox_t_m_n_prt jbox = new checkbox_t_m_n_prt();
    // }
    // public void asynchronous_t_m_n_frame(){
    //     checkbox_asy_t_m_n jbox = new checkbox_asy_t_m_n();
    // }
    // public void pratice2(){
    //     checkbox_asy_t_m_n_prt jbox = new checkbox_asy_t_m_n_prt();
    // }
 
    //傾聽tmn同步試算按鈕類別
    class ActionListen1 extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            griddd jbox = new griddd();
        }
    }
    //tmn練習：傾聽類別
    class Pratice1 extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            checkbox_t_m_n jbox = new checkbox_t_m_n();
        }
    }


    //傾聽非同步tmn試算按鈕類別
    class ActionListen2 extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            checkbox_asy_t_m_n jbox = new checkbox_asy_t_m_n();
        }
    }
    //tmn練習：傾聽類別asynchronous
    class Pratice2 extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            checkbox_asy_t_m_n_prt jbox = new checkbox_asy_t_m_n_prt();
        }
    }        

    public static void main(String[] args) { 
        new GUI2();
    
    }
}