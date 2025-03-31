package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingApp extends JFrame {
    private DrawingPanel drawingPanel;

    public DrawingApp() {
        setTitle("Приложение для рисования");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel controlPanel = createControlPanel();

        drawingPanel = new DrawingPanel();

        controlPanel.add(createColorChooser());
        controlPanel.add(createThicknessChooser());

        controlPanel.add(createEraserButton());

        controlPanel.add(createClearButton());

        add(controlPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);
    }

    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        return controlPanel;
    }

    private JComboBox<String> createColorChooser() {
        Color[] colorOptions = {
                Color.BLACK,
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.YELLOW,
                new Color(128, 0, 128),
                Color.ORANGE
        };

        String[] colorNames = {"Черный", "Красный", "Зеленый", "Синий", "Желтый", "Фиолетовый", "Оранжевый"};

        JComboBox<String> colorComboBox = new JComboBox<>(colorNames);

        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = colorOptions[colorComboBox.getSelectedIndex()];
                drawingPanel.setPenColor(color);
            }
        });

        return colorComboBox;
    }

    private JComboBox<String> createThicknessChooser() {
        String[] thicknessOptions = {"min", "mean", "max"};
        float[] thicknessValues = {2.0f, 5.0f, 15.0f};

        JComboBox<String> thicknessComboBox = new JComboBox<>(thicknessOptions);
        thicknessComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float penThickness = thicknessValues[thicknessComboBox.getSelectedIndex()];
                drawingPanel.setPenThickness(penThickness);
            }
        });
        return thicknessComboBox;
    }

    private JButton createEraserButton() {
        JButton eraserButton = new JButton("Ластик");
        eraserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.setPenColor(Color.WHITE);
            }
        });
        return eraserButton;
    }

    private JButton createClearButton() {
        JButton clearButton = new JButton("Очистить");
        clearButton.addActionListener(e -> {
            drawingPanel.clear();
            clearButton.setFocusable(false);
        });
        return clearButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawingApp().setVisible(true));
    }
}