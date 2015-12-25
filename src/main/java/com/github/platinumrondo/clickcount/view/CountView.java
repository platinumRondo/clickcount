package com.github.platinumrondo.clickcount.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.github.platinumrondo.clickcount.model.CountModel;

public class CountView extends JFrame {
    private static final long serialVersionUID = 1L;
    private CountModel model;
    private JLabel label;
    private JButton click, reset;

    public CountView(CountModel model) {
        super();
        if (model == null)
            throw new NullPointerException("model is null!");
        this.model = model;
        initComponents();
        setSize(400, 200);
        setTitle("clickCount");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        label = new JLabel(Long.toString(model.get()));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 26));
        add(label);
        JPanel buttonPanel = new JPanel(new GridLayout(2,1));
        click = new JButton("click");
        click.addActionListener((e) -> {
            model.increment();
            updateLabel();
        });
        buttonPanel.add(click);
        reset = new JButton("reset");
        reset.addActionListener((e) -> {
            model.reset();
            updateLabel();
        });
        buttonPanel.add(reset);
        add(buttonPanel, BorderLayout.EAST);
    }
    
    private void updateLabel() {
        label.setText(Long.toString(model.get()));
    }

}
