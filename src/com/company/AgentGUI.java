package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AgentGUI extends JFrame {

    private Main myAgent;
    private JTextField Textx1, Textx2, Textx3, Textx4, Textx5;

    AgentGUI(Main a) {
        super(a.getLocalName());

        myAgent = a;

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(10, 1));
        p.add(new JLabel("LR Multiple"));
        Textx1 = new JTextField(5);
        p.add(new JLabel("X1"));
        p.add(Textx1);
        Textx2 = new JTextField(5);
        p.add(new JLabel("X2"));
        p.add(Textx2);
        Textx4 = new JTextField(5);
        p.add(new JLabel("X3"));
        p.add(Textx4);
        p.add(new JLabel("LR Simple"));
        Textx3 = new JTextField(5);
        p.add(new JLabel("X1"));
        p.add(Textx3);
        Textx5 = new JTextField(5);
        p.add(new JLabel("X1"));
        p.add(Textx5);

        getContentPane().add(p, BorderLayout.CENTER);


        JButton addButton = new JButton("LR Multiple");
        addButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    double [] x = new double[3];
                    x[0] = Double.parseDouble(Textx1.getText());
                    x[1] = Double.parseDouble(Textx2.getText());
                    x[2] = Double.parseDouble(Textx4.getText());
                    myAgent.getMultiple(x);

                    Textx1.setText("");
                    Textx2.setText("");
                    Textx4.setText("");
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(AgentGUI.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } );
        JButton addButton2 = new JButton("LR Simple");
        addButton2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    double [] y = new double[2];
                    y[0] = Double.parseDouble((Textx3.getText()));
                    y[1] = Double.parseDouble((Textx5.getText()));

                    myAgent.getSimple(y);
                    Textx3.setText("");
                    Textx5.setText("");

                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(AgentGUI.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } );

        p = new JPanel();
        p.add(addButton);
        p.add(addButton2);
        getContentPane().add(p, BorderLayout.SOUTH);


        addWindowListener(new    WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                myAgent.doDelete();
            }
        } );

    }

    public void showGui() {
        pack();
        this.setSize(new Dimension(390,315));
        setLocationRelativeTo(null);

        super.setVisible(true);
    }


}
