package gameProject;

import java.awt.event.*;

public class Listeners implements MouseListener, KeyListener, MouseMotionListener {
    // проверка нажатой клавиши
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();// получить код нажатой клавиши
        // проверка  клавиши
        if (key == KeyEvent.VK_W) {
            Player.up = true;
        }
        if (key == KeyEvent.VK_S) {
            Player.down = true;
        }
        if (key == KeyEvent.VK_A) {
            Player.left = true;
        }
        if (key == KeyEvent.VK_D) {
            Player.right = true;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            if (Panel.state == Panel.STATES.PLAY)Panel.state = Panel.STATES.MENUE; // переход в меню из игры
        }
    }
    // проверка отжатой клавиши
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            Player.up = false;
        }
        if (key == KeyEvent.VK_S) {
            Player.down = false;
        }
        if (key == KeyEvent.VK_A) {
            Player.left = false;
        }
        if (key == KeyEvent.VK_D) {
            Player.right = false;
        }


    }
    public void keyTyped(KeyEvent e){

        }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {

            if (Panel.state == Panel.STATES.MENUE) {
                Menue.click = true;// нажатие ЛКМ в меню
            }
        }



    }

    public void mouseReleased(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON1) {

            if (Panel.state == Panel.STATES.MENUE) {
                Menue.click = false;// отпуск ЛКМ в меню
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {// метод переноса мышкой

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Panel.mouseX = e.getX();// получить координату х при перемещении мышки
        Panel.mouseY = e.getY();// получить координату у при перемещении мышки
    }



}
