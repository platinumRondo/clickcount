package com.github.platinumrondo.clickcount;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import com.github.platinumrondo.clickcount.model.CountModel;
import com.github.platinumrondo.clickcount.model.SingleIncrementCountModel;
import com.github.platinumrondo.clickcount.view.CountView;

public class Main {

    public static void main(String[] args) {
        changeLAF();
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

    private static void changeLAF() {
        // taken
        try {
            for (LookAndFeelInfo lafi : UIManager.getInstalledLookAndFeels()) {
                if (lafi.getClassName().equals("Nimbus")) {
                    UIManager.setLookAndFeel(lafi.getClassName());

                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("There was a problem setting the Nimbus theme.");
        }

    }

}
