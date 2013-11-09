package org.chaos.scripts.claysoftener.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import org.chaos.scripts.claysoftener.ClaySoftener;
import org.chaos.scripts.claysoftener.data.Location;

public class Gui extends JFrame implements Runnable {

    private final ClaySoftener script;

    private JLabel timerLabel;
    private JLabel nameLabel;
    private JLabel titleLabel;
    private JLabel versionLabel;
    private JTabbedPane mainTabbedPane;
    private JPanel statsPanel;
    private JLabel clayLabel;
    private JLabel clayHrLabel;
    private JLabel tripsLabel;
    private JLabel tripsHrLabel;
    private JLabel profitLabel;
    private JLabel profitHrLabel;
    private JLabel statusLabel;
    private JPanel settingsPanel;
    private JCheckBox minedCheckBox;
    private JComboBox<Location> locationComboBox;
    private JButton startButton;

    private JLabel[] jLabels;

    private Location location;
    private boolean start = false, mined = false;

    public Gui(ClaySoftener script) {
        super("RuneScape");
        this.script = script;
        timerLabel = new JLabel();
        nameLabel = new JLabel();
        titleLabel = new JLabel();
        versionLabel = new JLabel();
        mainTabbedPane = new JTabbedPane();
        statsPanel = new JPanel();
        clayLabel = new JLabel();
        clayHrLabel = new JLabel();
        tripsLabel = new JLabel();
        tripsHrLabel = new JLabel();
        profitLabel = new JLabel();
        profitHrLabel = new JLabel();
        statusLabel = new JLabel();
        settingsPanel = new JPanel();
        minedCheckBox = new JCheckBox();
        locationComboBox = new JComboBox<Location>(Location.values());
        startButton = new JButton();

        jLabels = new JLabel[] {
            timerLabel, clayLabel, clayHrLabel, tripsLabel,
            tripsHrLabel, profitLabel, profitHrLabel, statusLabel
        };

        initComponents();
        setVisible(true);
    }

    private ActionListener startScript = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            location = (Location) locationComboBox.getSelectedItem();
            mined = minedCheckBox.isSelected();
            start = true;
        }
    };

    public Location getLoc() {
        return location;
    }

    public boolean start() {
        return start;
    }

    public boolean getMined() {
        return mined;
    }

    private void initComponents() {
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "2*(default, $lcgap), default",
            "default, $lgap, 40dlu, $lgap, 45dlu"));

        //---- nameLabel ----
        nameLabel.setText("`chaos`");
        nameLabel.setFont(new Font("Consolas", Font.BOLD, 14));
        contentPane.add(nameLabel, CC.xy(1, 1));

        //---- titleLabel ----
        titleLabel.setText("E3ClaySoftener");
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 16));
        contentPane.add(titleLabel, CC.xy(3, 1));

        //---- versionLabel ----
        versionLabel.setText("v0.1a");
        versionLabel.setFont(new Font("Consolas", Font.BOLD, 14));
        contentPane.add(versionLabel, CC.xy(5, 1));

        //======== mainTabbedPane ========
        {
            mainTabbedPane.setFont(new Font("Consolas", Font.BOLD, 14));

            //======== statsPanel ========
            {
                statsPanel.setLayout(new FormLayout(
                    "70dlu, $lcgap, 80dlu",
                    "4*(default, $lgap), 15dlu"));

                //---- timerLabel ----
                timerLabel.setText("Timer: 00:00:00");
                timerLabel.setFont(new Font("Consolas", Font.BOLD, 14));
                statsPanel.add(timerLabel, CC.xywh(1, 1, 3, 1));

                //---- clayLabel ----
                clayLabel.setText("Clay: 1000");
                clayLabel.setFont(new Font("Consolas", Font.BOLD, 12));
                statsPanel.add(clayLabel, CC.xy(1, 3));

                //---- clayHrLabel ----
                clayHrLabel.setText("Clay/Hr: 1000");
                clayHrLabel.setFont(new Font("Consolas", Font.BOLD, 12));
                statsPanel.add(clayHrLabel, CC.xy(3, 3));

                //---- tripsLabel ----
                tripsLabel.setText("Trips: 1000");
                tripsLabel.setFont(new Font("Consolas", Font.BOLD, 12));
                statsPanel.add(tripsLabel, CC.xy(1, 5));

                //---- tripsHrLabel ----
                tripsHrLabel.setText("Trips/Hr: 1000");
                tripsHrLabel.setFont(new Font("Consolas", Font.BOLD, 12));
                statsPanel.add(tripsHrLabel, CC.xy(3, 5));

                //---- profitLabel ----
                profitLabel.setText("Profit: 128k");
                profitLabel.setFont(new Font("Consolas", Font.BOLD, 12));
                statsPanel.add(profitLabel, CC.xy(1, 7));

                //---- profitHrLabel ----
                profitHrLabel.setText("Profit/Hr: 128k");
                profitHrLabel.setFont(new Font("Consolas", Font.BOLD, 12));
                statsPanel.add(profitHrLabel, CC.xy(3, 7));

                //---- statusLabel ----
                statusLabel.setText("Status: Waiting to finish.");
                statusLabel.setFont(new Font("Consolas", Font.BOLD, 14));
                statsPanel.add(statusLabel, CC.xywh(1, 9, 3, 1));
            }
            mainTabbedPane.addTab("Stats", statsPanel);

            //======== settingsPanel ========
            {
                settingsPanel.setLayout(new FormLayout(
                    "25dlu, 2*($lcgap, 45dlu)",
                    "2*(default, $lgap), default"));

                //---- minedCheckBox ----
                minedCheckBox.setText("Mined Clay?");
                minedCheckBox.setFont(new Font("Consolas", Font.BOLD, 14));
                settingsPanel.add(minedCheckBox, CC.xywh(3, 1, 3, 1));

                //---- locationComboBox ----
                locationComboBox.setFont(new Font("Consolas", Font.BOLD, 12));
                settingsPanel.add(locationComboBox, CC.xywh(3, 1, 3, 1));

                //---- startButton ----
                startButton.setText("Start Script");
                startButton.setFont(new Font("Consolas", Font.BOLD, 14));
                startButton.addActionListener(startScript);
                settingsPanel.add(startButton, CC.xywh(3, 3, 3, 1));
            }
            mainTabbedPane.addTab("Settings", settingsPanel);
        }
        contentPane.add(mainTabbedPane, CC.xywh(1, 3, 5, 3));
        pack();
        setLocationRelativeTo(getOwner());
    }

    @Override
    public void run() {
        try {
            for (;;) {
                java.util.List<String> data = script.getData();
                for (int i = 0; i < jLabels.length; i++) {
                    JLabel j = jLabels[i];
                    String s = data.get(i);
                    j.setText(s);
                }
                Thread.sleep(120);
            }
        } catch (InterruptedException ie) {
            script.log.log(Level.SEVERE, "Gui process halted by exception", ie);
        }
    }

}
