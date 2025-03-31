package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tes {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Создание окна
            JFrame frame = new JFrame("Мое окно");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout()); // Устанавливаем менеджер компоновки

            // Создание кнопки
            JButton button = new JButton("Нажми меня");

            // Добавление обработчика событий
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Кнопка нажата!");
                }
            });

            // Добавление кнопки в окно
            frame.add(button);

            // Отображение окна
            frame.setVisible(true);
        });
    }
    /*
    private JComboBox<String> createColorChooser() {
        String[] colors = {"Черный", "Красный", "Зеленый", "Синий", "Желтый", "Фиолетовый", "Оранжевый"};
        JComboBox<String> colorComboBox = new JComboBox<>(colors);
        colorComboBox.addActionListener(e -> {
            switch (colorComboBox.getSelectedIndex()) {
                case 0:
                    penColor = Color.BLACK;
                    break;
                case 1:
                    penColor = Color.RED;
                    break;
                case 2:
                    penColor = Color.GREEN;
                    break;
                case 3:
                    penColor = Color.BLUE;
                    break;
                case 4:
                    penColor = Color.YELLOW; // Добавляем желтый цвет
                    break;
                case 5:
                    penColor = new Color(128, 0, 128); // Фиолетовый цвет (RGB)
                    break;
                case 6:
                    penColor = Color.ORANGE; // Оранжевый цвет
                    break;
            }
            drawingPanel.setPenColor(penColor); // Обновляем цвет пера на панели
        });
        return colorComboBox;
    }

     */
}
