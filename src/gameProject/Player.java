package gameProject;

import javax.swing.*;
import java.awt.*;



public class Player {
    //  нач координаты и размер объекта
    private  double x;//координа х героя
    private  double y;//координа y героя
    private double w ; //ширина обьекта
    private double h ; // высота объекта

    private int speed;// скорость

    private int arr[][] = new int [4][4];


    // стаич прем - кавиши перемещения
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    Image img2 = new ImageIcon("image/second.png").getImage();
    Image img4 = new ImageIcon("image/fourth.png").getImage();
    Image img8 = new ImageIcon("image/eight.png").getImage();
    Image img16 = new ImageIcon("image/sixteen.png").getImage();
    Image img32= new ImageIcon("image/thirtytwo.png").getImage();
    Image img64 = new ImageIcon("image/sixtyfour.png").getImage();

    // Constructor
    public Player(){
        // нач координаты героя
        x = 199;
        y = 119;
        // размеры картинки героя
        w = 142;
        h = 229;
        speed = 145;// скорость перемещения героя
        // нач знач клавиш
        up = false;
        down = false;
        left = false;
        right = false;
        int a = (int)(Math.random() * 4);
        int b = (int)(Math.random() * 4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; i < 4; i++) {
                arr[i][j] = 0;
            }
            arr[a][b]=2;
        }

    }


    void upArray(int ms[][], int k)
    {
        int i, j, r, a = 0, b = 0;
        {	for (j = 0; j <= 3; j++)
            for (i = 1; i <= 3; i++) {
                if (ms[i][j] != 0) {
                    while ((i - k) >= 0)
                    {
                        if (ms[i - k][j] == 0) {//если число столкнется с 0, они должны поменятся поменятся местами
                            r = ms[i][j];
                            ms[i][j] = ms[i - k][j];
                            ms[i - k][j] = r;
                            i = i - k;
                        }
                        else
                        if (ms[i - k][j] == ms[i][j]) {//если число столкнется с таким же числом, оно должно увеличить его вдвое, а само замениться на 0
                            ms[i - k][j] = ms[i - k][j] * 2;
                            ms[i][j] = 0;
                            i = i - k;
                            break;
                        }
                        else
                            break;
                    }
                }
                while (ms[a][b] > 0)//создание новой двойки в случайном месте
                {
                    a = (int)(Math.random() * 4);
                    b = (int)(Math.random() * 4);
                }
            }
            ms[a][b] = 2;         //появление новой двойки
            }
        }

    void rightArray(int ms[][], int k) {
        int i, j, r, a = 0, b = 0;
        int sms[][] = new int[4][4];
        for (i = 0; i <= 3; i++)
            for (j = 0; j <= 3; j++)  //переворачиваю матрицу
                sms[i][j] = ms[j][3 - i];
        {
            for (j = 0; j <= 3; j++)
                for (i = 1; i <= 3; i++) {
                    if (sms[i][j] != 0) {
                        while ((i - k) >= 0) {
                            if (sms[i - k][j] == 0) {//если число столкнется с 0, они должны поменятся поменятся местами
                                r = sms[i][j];
                                sms[i][j] = sms[i - k][j];
                                sms[i - k][j] = r;
                                i = i - k;
                            } else if (sms[i - k][j] == sms[i][j]) {//если число столкнется с таким же числом, оно должно увеличить его вдвое, а само замениться на 0
                                sms[i - k][j] = sms[i - k][j] * 2;
                                sms[i][j] = 0;
                                i = i - k;
                                break;
                            } else
                                break;
                        }
                    }

                    while (sms[a][b] > 0)//создание новой двойки в случайном месте
                    {
                        a = (int)(Math.random() * 4);
                        b = (int)(Math.random() * 4);
                    }
                }
            sms[a][b] = 2;  // появление новой двойки


            for (i = 0; i <= 3; i++)
                for (j = 0; j <= 3; j++)  //переворачиваю матрицу обратно
                    ms[j][3 - i] = sms[i][j];
        }
    }
    //  гетеры
    public double getX(){
        return  x;
    }
    public double getY(){
        return  y;
    }
    public double getW(){
        return  w;
    }
    public double getH(){
        return  h;
    }

    // обновления
    public void update(){
        int temp, i, j;
        // смещение клеток по игровому полю
        if (up){
            upArray(arr,1);
            up=false;
        }

        if (down){
            for (i = 0; i<2; i++){
                for (j = 0; j<2; j++){
                    temp=arr[i][j];
                    arr[i][j]= arr[3-i][j];
                    arr[3-i][j]=temp;
                }
            }
           upArray(arr, 1);
            for (i = 0; i<2; i++){
                for (j = 0; j<4; j++){
                    temp=arr[i][j];
                    arr[i][j]= arr[3-i][j];
                    arr[3-i][j]=temp;
                }
            }
            down=false;
        }
        if (left){
            for (i = 0; i<4; i++){
                for (j = 0; j<2; j++){
                    temp=arr[i][j];
                    arr[i][j]= arr[i][3-j];
                    arr[i][3-j]=temp;
                }
            }
            rightArray(arr, 1);
            for (i = 0; i<4; i++){
                for (j = 0; j<2; j++){
                    temp=arr[i][j];
                    arr[i][j]= arr[i][3-j];
                    arr[i][3-j]=temp;
                }
            }
            left=false;
        }
        if (right){

            rightArray(arr, 1);
            right=false;
        }



    }

    // отрисовка клеток
    public void draw(Graphics2D g){
        for (int i =0; i<4; i++){
            for (int j = 0; j<4; j++){
                if (arr[i][j] == 2){
                    g.drawImage(img2,(int)54+j*145,(int)119+i*145,null); // здесь рисуем картинку
                }
                if (arr[i][j] == 4){
                    g.drawImage(img4,(int)54+j*145,(int)119+i*145,null); // здесь рисуем картинку
                }
                if (arr[i][j] == 8){
                    g.drawImage(img8,(int)54+j*145,(int)119+i*145,null); // здесь рисуем картинку
                }
                if (arr[i][j] == 16){
                    g.drawImage(img16,(int)54+j*145,(int)119+i*145,null); // здесь рисуем картинку
                }
                if (arr[i][j] == 32){
                    g.drawImage(img32,(int)54+j*145,(int)119+i*145,null); // здесь рисуем картинку
                }
                if (arr[i][j] == 64){
                    g.drawImage(img64,(int)54+j*145,(int)119+i*145,null); // здесь рисуем картинку
                }
            }
        }

    }
}
