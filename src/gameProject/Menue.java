package gameProject;


import javax.swing.*;
import java.awt.*;

public class Menue {

    public static boolean click = false; // клик мышкой в режиме меню

    ButtMenue button1 = new ButtMenue(200,400,200,100,"image/playGameButton.png","2048");

    public void draw(Graphics2D g) {

        button1.draw(g);

    }

    // попадание курсора на кнопку меню
    public void moveButt(ButtMenue e){

        if (Panel.mouseX >e.getX() && Panel.mouseX <e.getX() + e.getW()  &&
                Panel.mouseY >e.getY() && Panel.mouseY < e.getY()+ e.getH()) {// если курсор попал в кнопку
            e.s = "image/playGameButton.png";
                if (Menue.click) {  //клик ЛКМ
                    Panel.state = Panel.STATES.PLAY; //переход в игру
                    Menue.click = false;
                }
            }
    }

    class ButtMenue{
        //  нач координаты и размер объекта
        private double x;//координа х героя
        private double y;//координа y героя
        private double w ; //ширина обьекта
        private double h ; // высота объекта

        public Color color1;// цвет

        public String f;// надпись над кнопкой

        public String s; // строка адреса картинки

        // Constructor
        public ButtMenue(int x,int y,int w,int h,String s,String f){

            this.x =x;// нач координаты героя
            this.y = y;
            this.w = w;
            this.h = h;
            this.f = f;
            this.s = s;
            color1 = Color.orange;

        }
        //  гетеры
        public double getX(){
            return  this.x;
        }
        public double getY(){
            return  this.y;
        }
        public double getW(){
            return  this.w;
        }
        public double getH(){
            return  this.h;
        }





        // отрисовка героя
        public void draw(Graphics2D g){
            g.drawImage( new ImageIcon(s).getImage(), (int)x,(int) y, null);//отрисовываем элемент в координатах
            g.setColor(color1);//задаем цвет объекту Соlor
            Font font = new Font("Arial",Font.ITALIC,150);//Создём объект класса фонт (передаем в конструктор параметры)
            g.setFont(font);//устанвливаем наш шрифт

            long length = (int) g.getFontMetrics().getStringBounds(f,g).getWidth();// длина надписи в пиксилях
            g.drawString(f,(int)(x - 15),(int)(y - 50));// рисуем строчку в центре панели

        }
    }
}





