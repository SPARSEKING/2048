package gameProject;

/**
 Конструктор для игр
 */
import javax.swing.*;
import java.awt.*;

public class Window {
    public static void main(String[] args)
    {

        JFrame startFrame = new JFrame("game");// создаем окно с названием
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// закрытие окна при клике крестика
        startFrame.setLocation(0, 0);// имзменяем местоположение фрейма.
        Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();// получим размер экрана
       // startFrame.setSize(screenSize);// установим его
        startFrame.setSize(680,1024); // размер окна
        startFrame.add(new Panel());

        //Panel panel = new Panel();// создаём объект панель
        //startFrame.setContentPane(panel); // перенос в фрейм панели с Panel

        //panel.mainTimer.start();// запуск Таймера

        // окно видемо
        startFrame.setVisible(true);
    }

}
