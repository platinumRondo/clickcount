package com.github.platinumrondo.clickcount;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.github.platinumrondo.clickcount.model.CountModel;
import com.github.platinumrondo.clickcount.model.SingleIncrementCountModel;
import com.github.platinumrondo.clickcount.view.CountView;

public class Main {

    public static void main(String[] args) {
        long value = CountPreffer.get();
        CountModel count = new SingleIncrementCountModel(value);
        WindowListener wl = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                CountPreffer.put(count.get());
            }

        };
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new CountView(count);
            frame.addWindowListener(wl);
            frame.setVisible(true);
        });
    }

}
