package gameProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 Панель игры
 */
public class Panel  extends JPanel implements ActionListener {
    //размер панели
    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    // координаты мышки
    public static int mouseX;
    public static int mouseY;

    //активные страницы меню
    public static boolean buttmenue = true;
    public static boolean settmenue = false;

    public static  enum STATES{MENUE,PLAY} //обьявляем перечсления
    public static STATES state = STATES.MENUE;// переменная игры по изначально - меню

    private BufferedImage image; // ссылка на обьект класса
    private Graphics2D g; // ссылка на обьект класса




    Timer mainTimer = new Timer(30,this);// Таймер - задает интервал обновления всех событий


    Back back = new Back();
    Player player = new Player();
    Menue menue = new Menue();



    public Panel() {// конструктор
        super(); // активируем консруктор родителя
        setFocusable(true); //передаем фокус
        requestFocus(); // акивируем
        mainTimer.start();

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);// создаём объект буфера для хранения картинок
        g = (Graphics2D) image.getGraphics();// граф объекту присвоим элемент из буфера - картинка Graphics2D применив метод getGraphics()



        addMouseListener( new Listeners());// добавляем обработчик событий клик мышь
        addKeyListener( new Listeners());// добавляем обработчик событий клава
        addMouseMotionListener(new Listeners());//добавляем обработчик событий перемещение мышь
    }

    public void actionPerformed(ActionEvent e){//  все события игры
        if (state.equals(STATES.MENUE)){// если пер state == MENUE
            back.draw(g);// отобразить фон

            if (buttmenue){

            menue.draw(g);// отобразить меню
            moveButt(menue.button1);

            }

            /*menue.moveButt(menue.button1);
            menue.moveButt(menue.button2);
            menue.moveButt(menue.button3);
            menue.moveButt(menue.button4);
            menue.moveButt(menue.button5);*/
            gameDraw();// прорисовать в панели

        }

        if (state.equals(STATES.PLAY)){// игра
            gameUpdate();
            gameRender();
            gameDraw();
        }
    }
    // попадание курсора на кнопку меню
    public void moveButt(Menue.ButtMenue e){
        if (Panel.mouseX >e.getX() && Panel.mouseX <e.getX() + e.getW()  &&
                Panel.mouseY >e.getY() && Panel.mouseY < e.getY()+ e.getH()) {// если курсор попал в кнопку
            e.s = "image/playGameButton.png";
            if (Menue.click) {  //клик ЛКМ
                Panel.state = Panel.STATES.PLAY; //переход в игру
                Menue.click = false;
            }
        }
    }
    //рисуем в виртуальном окне
    public void gameRender() {
        back.draw(g);
        player.draw(g);

    }
    public void gameUpdate() { //обновление
        player.update();

    }
    //перенос изображения на панель
    private void gameDraw() {
        Graphics g2 = this.getGraphics();// переоппред Graphics2d на Graphics
        g2.drawImage(image, 0, 0, null);// рисуем
        g2.dispose();// команда для уборщщика мусора

    }

}
