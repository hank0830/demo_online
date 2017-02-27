import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.*;

class checkbox_t_m_n_prt extends JFrame{
	public static void main(String[] args){
		checkbox_t_m_n_prt jbox = new checkbox_t_m_n_prt();
	}
	JLabel jlb1,jlb2,jlb3,jlb4;
	JRadioButton jrbtn1,jfbtn2,jrbtn3;
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2,jb3;
	JTextField m_text,n_text;
	public checkbox_t_m_n_prt(){

		jlb1=new JLabel("練習");
		jlb2=new JLabel("決定門檻數 t =");
		jlb3=new JLabel("決定每次認證至少該來幾位成員 m =");
		m_text = new JTextField();
		m_text.setSize(50,50);
		jlb4 = new JLabel("該群組總人數共為 n =");
		n_text = new JTextField();

		jb1=new JButton("試算");
		jb2=new JButton("重置");
		jb3=new JButton("完成");

		JRadioButton jrbtn1=new JRadioButton("2");
		JRadioButton jrbtn2=new JRadioButton("3");
		JRadioButton jrbtn3=new JRadioButton("4");

		ButtonGroup bgroup=new ButtonGroup();
		//設定觸擊按鈕
        jb1.addActionListener(new Listen1());
        jb2.addActionListener(new Listen2());
        jb3.addActionListener(new Listen3());


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
		bgroup.add(jrbtn3);
		jp2.add(jrbtn1);
		jp2.add(jrbtn2);
		jp2.add(jrbtn3);
		jp2.add(jlb3);
		jp2.add(m_text);
		jp2.add(jlb4);
		jp2.add(n_text);
		this.add(jp2);
//第三行
		jp3=new JPanel();
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		this.add(jp3);

		this.setTitle("同步t,m,n群組驗證練習");
		this.setSize(700,600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	class Listen1 extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SwingUtilities.windowForComponent(jb1).dispose();
        }
    }
	class Listen2 extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SwingUtilities.windowForComponent(jb2).dispose();
        }
    }
	class Listen3 extends JFrame implements ActionListener{
        public void actionPerformed(ActionEvent e){
            SwingUtilities.windowForComponent(jb3).dispose();
        }
    }        

}