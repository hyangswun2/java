package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Main extends JFrame {
    private final List<DiceIndicator> objects;
    private final JLabel sumLabel;
    private int reValue;

    private static final int DICE_NUM_NEEDED = 8;
    private static final int DICE_SIZE = 95;
    private static final int DICE_GAP = 20;
    private static final int DICE_X = 15;

    public Main() {
        setTitle("Sound Controller for Random Dices");
        setSize(950, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        objects = new ArrayList<>();
        Random rand = new Random();
        int sum = 0;

        for (int i = 0; i < DICE_NUM_NEEDED; i++) {
            DiceIndicator o = newObject(c, DICE_X + (DICE_SIZE + DICE_GAP) * i, 0);
            int diceVal = rand.nextInt(6) + 1;
            sum += diceVal;
            o.setDiceValue(diceVal);
        }
        for (int i = 0; i < DICE_NUM_NEEDED; i++) {
            DiceIndicator o = newObject(c, DICE_X + (DICE_SIZE + DICE_GAP) * i, 130);
            int diceVal = rand.nextInt(6) + 1;
            sum += diceVal;
            o.setDiceValue(diceVal);
        }

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 4, 0);
        slider.setSize(200, 35);
        slider.setLocation(625, 373);

        JButton button = new JButton("Roll");
        button.setContentAreaFilled(false);
        button.setSize(500, 100);
        button.setLocation(15, 300);
        button.setFont(new Font("Arial", Font.BOLD, 40));
        button.addActionListener(e -> {
            reValue = 0;
            slider.setValue(0);
            for (DiceIndicator o : objects) {
                if (!o.isHold()) {
                    o.roll(this::sum);
                }
            }
        });
        c.add(button);

        sumLabel = new JLabel();
        sumLabel.setSize(300, 80);
        sumLabel.setLocation(610, 300);
        updateSum(sum);
        sumLabel.setFont(new Font("Arial", Font.BOLD, 40));
        c.add(sumLabel);

        slider.setMajorTickSpacing(1);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(false);
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        for (int i = -8; i <= 4; i++) {
            String labelText = (i > 0) ? "+" + i : String.valueOf(i);
            labelTable.put(i, new JLabel(labelText));
        }
        slider.setLabelTable(labelTable);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.addChangeListener(e -> {
            reValue = slider.getValue();
            sum();
        });
        c.add(slider);

        setVisible(true);
    }

    private DiceIndicator newObject(Container c, int x, int y) {
        DiceIndicator o = new DiceIndicator();
        o.setSize(DICE_SIZE, DICE_SIZE + 45);
        o.setLocation(x, y);
        c.add(o);
        objects.add(o);
        return o;
    }

    private void sum() {
        int sum = 0;
        for (DiceIndicator o : objects) {
            sum += o.getNowNum();
        }
        sum += reValue;
        updateSum(sum);
    }

    private void updateSum(int n) {
        sumLabel.setText("Volume : " + n);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}