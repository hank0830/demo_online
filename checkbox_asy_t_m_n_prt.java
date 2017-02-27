import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.*;

class checkbox_asy_t_m_n_prt extends JFrame{
	public static void main(String[] args){
		checkbox_asy_t_m_n_prt jbox = new checkbox_asy_t_m_n_prt();
	}
	JLabel jlb1,jlb2;
	JRadioButton jrbtn1,jfbtn2;
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2,jb3;
	public checkbox_asy_t_m_n_prt(){

		jlb1=new JLabel("練習");
		jlb2=new JLabel("最高次項為");

		jb1=new JButton("試算");
		jb2=new JButton("重置");
		jb3=new JButton("完成");

		JRadioButton jrbtn1=new JRadioButton("兩次項");
		JRadioButton jrbtn2=new JRadioButton("三次項");
		ButtonGroup bgroup=new ButtonGroup();
		//設定觸擊按鈕
        jb1.addActionListener(new Listen11());
        jb2.addActionListener(new Listen22());
        jb3.addActionListener(new Listen33());


//設置為流式佈局
		this.setLayout(new GridLayout(3,1));

		jp1=new JPanel();
		jp1.add(jlb1);

		this.add(jp1);
//第二行
		jp2=new JPanel();
		jp2.add(jlb2);
		bgroup.add(jrbtn1);
		bgroup.add(jrbtn2);
		jp2.add(jrbtn1);
		jp2.add(jrbtn2);
		this.add(jp2);
//第三行
		jp3=new JPanel();
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		this.add(jp3);

		this.setTitle("非同步同步t,m,n群組驗證練習");
		this.setSize(700,600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	class Listen11 extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SwingUtilities.windowForComponent(jb1).dispose();
        }
    }
	class Listen22 extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SwingUtilities.windowForComponent(jb2).dispose();
        }
    }
	class Listen33 extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SwingUtilities.windowForComponent(jb3).dispose();
        }
    }        

}