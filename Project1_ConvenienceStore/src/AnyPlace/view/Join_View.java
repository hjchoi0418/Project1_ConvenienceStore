package AnyPlace.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


import AnyPlace.controller.*;

public class Join_View extends JFrame{

   public Join_View(){
      JFrame join_frame = new JFrame();
      join_frame.setTitle("Join_view");
      join_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Container c = join_frame.getContentPane();
      c.setLayout(null); 
      Color frame_color = new Color(22,56,81); //frame
      Color panel_color = new Color(69,96,117); //label
      JTextField name = new JTextField("NAME");
      JTextField id = new JTextField("ID");
      JButton create_btn = new JButton("CREATE ACCOUNT");
      c.setBackground(frame_color);

      join_frame.setSize(1200,700);
      join_frame.setVisible(true);

      JPanel panel = new JPanel();
      panel.setLayout(null);
      panel.setBackground(panel_color);
      panel.setSize(c.getWidth()/2,c.getHeight()/2);
      panel.setLocation(c.getWidth()/4, c.getHeight()/4);
      name.setBounds(panel.getWidth()/10*2, panel.getHeight()/10*2, panel.getWidth()/10*6, (int)(panel.getHeight()/10*1.3));
      id.setBounds(panel.getWidth()/10*2, panel.getHeight()/10*3+20, panel.getWidth()/10*6, (int)(panel.getHeight()/10*1.3));
      create_btn.setBounds(panel.getWidth()/10*2, panel.getHeight()/10*4+40, panel.getWidth()/10*6, (int)(panel.getHeight()/10*1.3));

      create_btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            String n = name.getText();
            String i = name.getText();
            Join.setNew_employee_id(i);
            Join.setNew_employee_name(n);
            Join.main(null);

            if(Join.isSuccess()) {
               Employee_Join_Success_View sv = new Employee_Join_Success_View();
               join_frame.dispose();
            }
            else {
               Error_View ev = new Error_View();
               join_frame.dispose();
            }
         }
      });

      panel.add(create_btn);
      panel.add(id);
      panel.add(name);
      c.add(panel);

   }
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Join_View jv = new Join_View();
   }
}