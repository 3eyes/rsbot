package org.chaos.scripts.runecrafter.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import org.chaos.scripts.runecrafter.data.Altar;

public class Gui extends JFrame {

        private Altar altar;
        private boolean start = false;

        public Gui() {
                super("RuneScape");
                initComponents();
                setVisible(true);
        }

        private void initComponents() {
                headerPanel = new JPanel();
                label1 = new JLabel();
                label2 = new JLabel();
                label3 = new JLabel();
                mainTabbedPane = new JTabbedPane();
                statsPanel = new JPanel();
                timerLabel = new JLabel();
                essLabel = new JLabel();
                runesLabel = new JLabel();
                tripsLabel = new JLabel();
                expLabel = new JLabel();
                ttlLabel = new JLabel();
                statusLabel = new JLabel();
                settingsPanel = new JPanel();
                tallyCheckBox = new JCheckBox();
                altarComboBox = new JComboBox(Altar.values());
                startButton = new JButton();

                jLabels = new JLabel[]{
                                          timerLabel, essLabel, runesLabel, tripsLabel,
                                          expLabel, ttlLabel, statusLabel
                };

                //======== this ========
                Container contentPane = getContentPane();
                contentPane.setLayout(new FormLayout(
                                                        "40dlu, $lcgap, 80dlu, $lcgap, 30dlu",
                                                        "default, $lgap, 55dlu, $lgap, 53dlu"));

                //======== headerPanel ========
                {
                        headerPanel.setLayout(new FormLayout(
                                                                "40dlu, $lcgap, 70dlu, $lcgap, 30dlu",
                                                                "default"));

                        //---- label1 ----
                        label1.setText("`chaos`");
                        label1.setFont(new Font("Consolas", Font.BOLD, 14));
                        headerPanel.add(label1, CC.xy(1, 1));

                        //---- label2 ----
                        label2.setText("E3Runecraft");
                        label2.setFont(new Font("Consolas", Font.BOLD, 16));
                        headerPanel.add(label2, CC.xy(3, 1));

                        //---- label3 ----
                        label3.setText("v0.1a");
                        label3.setFont(new Font("Consolas", Font.BOLD, 14));
                        headerPanel.add(label3, CC.xy(5, 1));
                }
                contentPane.add(headerPanel, CC.xywh(1, 1, 5, 1));

                //======== mainTabbedPane ========
                {
                        mainTabbedPane.setFont(new Font("Consolas", Font.BOLD, 14));

                        //======== statsPanel ========
                        {
                                statsPanel.setLayout(new FormLayout(
                                                                       "$rgap, default, $lcgap, default",
                                                                       "6*(default, $lgap), default"));

                                //---- timerLabel ----
                                timerLabel.setText("Timer: 00:00:00");
                                timerLabel.setFont(new Font("Consolas", Font.BOLD, 14));
                                statsPanel.add(timerLabel, CC.xy(2, 1));

                                //---- essLabel ----
                                essLabel.setText("Essence: 0000 (0000/hr)");
                                essLabel.setFont(new Font("Consolas", Font.BOLD, 12));
                                statsPanel.add(essLabel, CC.xy(2, 3));

                                //---- runesLabel ----
                                runesLabel.setText("Runes: 0000 (0000/hr)");
                                runesLabel.setFont(new Font("Consolas", Font.BOLD, 12));
                                statsPanel.add(runesLabel, CC.xy(2, 5));

                                //---- tripsLabel ----
                                tripsLabel.setText("Trips: 000 (000/hr)");
                                tripsLabel.setFont(new Font("Consolas", Font.BOLD, 12));
                                statsPanel.add(tripsLabel, CC.xy(2, 7));

                                //---- expLabel ----
                                expLabel.setText("Exp: 0000 (0000/hr)");
                                expLabel.setFont(new Font("Consolas", Font.BOLD, 12));
                                statsPanel.add(expLabel, CC.xy(2, 9));

                                //---- ttlLabel ----
                                ttlLabel.setText("TTL: 00:00:00 [00 +0]");
                                ttlLabel.setFont(new Font("Consolas", Font.BOLD, 12));
                                statsPanel.add(ttlLabel, CC.xy(2, 11));

                                //---- statusLabel ----
                                statusLabel.setText("Status: None");
                                statusLabel.setFont(new Font("Consolas", Font.BOLD, 14));
                                statsPanel.add(statusLabel, CC.xy(2, 13));
                        }
                        mainTabbedPane.addTab("Stats", statsPanel);

                        //======== settingsPanel ========
                        {
                                settingsPanel.setLayout(new FormLayout(
                                                                          "25dlu, default",
                                                                          "10dlu, 3*($lgap, default)"));

                                //---- tallyCheckBox ----
                                tallyCheckBox.setText("Using talisman?");
                                tallyCheckBox.setFont(new Font("Consolas", Font.BOLD, 14));
                                settingsPanel.add(tallyCheckBox, CC.xy(2, 3));

                                //---- altarComboBox ----
                                altarComboBox.setFont(new Font("Consolas", Font.BOLD, 14));
                                settingsPanel.add(altarComboBox, CC.xy(2, 5));

                                //---- startButton ----
                                startButton.setText("Start Script");
                                startButton.setFont(new Font("Consolas", Font.BOLD, 14));
                                startButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                                altar = (Altar) altarComboBox.getSelectedItem();
                                                start = true;
                                        }
                                });
                                settingsPanel.add(startButton, CC.xy(2, 7));
                        }
                        mainTabbedPane.addTab("Settings", settingsPanel);
                }
                contentPane.add(mainTabbedPane, CC.xywh(1, 3, 5, 3));
                pack();
                setLocationRelativeTo(getOwner());
        }

        private JPanel headerPanel;
        private JLabel label1;
        private JLabel label2;
        private JLabel label3;
        private JTabbedPane mainTabbedPane;
        private JPanel statsPanel;
        private JLabel timerLabel;
        private JLabel essLabel;
        private JLabel runesLabel;
        private JLabel tripsLabel;
        private JLabel expLabel;
        private JLabel ttlLabel;
        private JLabel statusLabel;
        private JPanel settingsPanel;
        private JCheckBox tallyCheckBox;
        private JComboBox altarComboBox;
        private JButton startButton;

        private JLabel[] jLabels;

        public JLabel[] getJLabels() {
                return jLabels;
        }

        public boolean start() {
                return start;
        }

        public Altar getAltar() {
                return altar;
        }

}