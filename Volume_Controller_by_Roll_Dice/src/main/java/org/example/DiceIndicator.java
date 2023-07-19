package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class DiceIndicator extends JLabel {
    private Timer timer;
    private int nowIndex;
    private int nowNum;
    private boolean isRoll;
    private JCheckBox checkBox;
    private final Map<Integer, ImageIcon> diceNums;
    private final Map<Integer, ImageIcon> diceNumsH;
    private Runnable callback;

    public int getNowNum() {
        return nowNum;
    }
    public boolean isRoll() {
        return isRoll;
    }
    public boolean isHold() {
        return checkBox.isSelected();
    }
    public void setRoll(boolean roll) {
        this.isRoll = roll;
    }
    public void setNowNum(int n) {
        this.nowNum = n;
    }
    public void setDiceValue(int n) {
        setNowNum(n);
        setIcon(diceNums.get(n));
    }
    public void setDiceValueH(int n) {
        setNowNum(n);
        setIcon(isHold() ? diceNumsH.get(n) : diceNums.get(n));
    }

    public DiceIndicator() {
        setOpaque(false);

        diceNums = new HashMap<>();
        diceNumsH = new HashMap<>();

        for (int i = 1; i <= 6; i++) {
            ImageIcon diceNum = new ImageIcon("src/images/dice" + i + ".png");
            diceNums.put(i, convert(diceNum));
            ImageIcon diceNumH = new ImageIcon("src/images/Hdice_" + i + ".png");
            diceNumsH.put(i, convert(diceNumH));
        }

        timer = new Timer(200 / 40, e -> {
            if (nowIndex < 20) diceIndicator();
            else {
                timer.stop();
                setRoll(false);
                checkBox.setEnabled(true);
                repaint();
                revalidate();
                if (callback != null) callback.run();
            }
        });

        checkBox = new JCheckBox("Hold");
        setHorizontalAlignment(JCheckBox.CENTER);
        checkBox.setSize(95, 20);
        checkBox.setLocation(15, 120);
        checkBox.setOpaque(false);
        checkBox.setEnabled(true);
        checkBox.addItemListener(e -> {
            setDiceValueH(nowNum);
        });
        add(checkBox);
    }

    private void diceIndicator() {
        Random rand = new Random();
        int i = rand.nextInt(6) + 1;
        if (isRoll()) {
            if (!isHold()) {
                setDiceValue(i);
            }
        }
        nowIndex++;
    }

    private ImageIcon convert(ImageIcon img) {
        Image converted = img.getImage().getScaledInstance(95, 95, Image.SCALE_SMOOTH);
        return new ImageIcon(converted);
    }

    public void roll(Runnable callback) {
        nowIndex = 0;
        setRoll(true);
        checkBox.setEnabled(false);
        checkBox.setSelected(false);
        this.callback = callback;
        timer.start();
    }
}
