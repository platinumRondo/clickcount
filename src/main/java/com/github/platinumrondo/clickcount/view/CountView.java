package com.github.platinumrondo.clickcount.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        setLayout(new GridLayout());
        label = new JLabel(Long.toString(model.get()));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
        click = new JButton("click");
        click.addActionListener((e) -> {
            model.increment();
            updateLabel();
        });
        add(click);
        reset = new JButton("reset");
        reset.addActionListener((e) -> {
            model.reset();
            updateLabel();
        });
        add(reset);
    }
    
    private void updateLabel() {
        label.setText(Long.toString(model.get()));
    }

}
