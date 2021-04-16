/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kn_31.Mercer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Mercer
 */
public class ExceptionQuest {
   
   

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     * @throws javazoom.jl.decoder.JavaLayerException
     */
    public static void main(String[] args) throws IOException, InterruptedException, JavaLayerException {
        Random Rnd = new Random();// Використовуємо для отримання випадкового числа 
        Zagatka Zag = new Zagatka();// Отримуємо необхідні загадки та відгадки
        
        FileInputStream f = new FileInputStream("D:\\1.mp3"); // створюємо файл для програвання музики
        Player player = new Player(f);
        
    // асинхронний поток програвання музики  
    new Thread(() -> {
            try {
                player.play();
               if( player.isComplete()){
                   player.play();
               }
            } catch (JavaLayerException ex) {
                Logger.getLogger(ExceptionQuest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }).start();
        
        
        String key = ""; //керуюча змінна для обрання варіантів
        int money = 1000;// Початкова кількість грошей, які видаються гравцю
        int answers = 0; // змінна правильних відповідей
        boolean b = true, m = true;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in,"Cp1251"));
        Zag.printFile();// метод записує загадки із файлу в масив

        while(b && m){
        System.out.println("**********************************************\n"
                         + "  ##    ##  #######  ##       ##      ####### \n"
                         + "  ##    ##  ##       ##       ##      ##   ## \n"
                         + "  ########  #######  ##       ##      ##   ## \n"
                         + "  ##    ##  ##       ##       ##      ##   ## \n"
                         + "  ##    ##  #######  #######  ######  ####### \n"
                         + "**********************************************\n");
        System.out.println("Привіт ти влип, а щоб дізнатися куди ти вплип натисни 1");
        while(!"1".equals(key)){
            key = stdin.readLine();
         if (key.length()>1){
            
            System.out.println("Я тобі казав тільки 1. А фіг з тобою тепер ти отримаєш не 1000 грн а 500 грн");
            money = 500;
            
            }
        }
        
        
        
        System.out.println("Короче кажучи, ти став одним із виключень");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Виключення це ті люди які не повинні були з'явитися на світ,"
                + " \nале через помилку творця ти тепер в "
                + "моїх руках, і тільки \nя можу визначить що робити з тобою далі");
        System.out.println("Ти повинен пройти декілька рівнів в моїй грі");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Я завжди даю своїм гравцям можливість обирати, у тебе є "+money +" грн\n"
                + "Якщо вони закінчаться то ти ніколь не потрапиш в світ живих");
        
        
        while (true){
            
            System.out.println("Перед тобою три двері, яку ти обиреш? 1,2,3?");
            
            key = stdin.readLine();
            
            if ("1".equals(key)){
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Ти програв, бувай");
                b = false;
                break;
            }
            
            if ("2".equals(key)){
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Я бачу ти везучий, проходиш на наступний рівень");               
                break;
            }
            
            if ("3".equals(key)){
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Опа, після того як ти ввійшов, двері відраза зачинились і\n"
                        + "перед тобою з'явився турникет. Прохід через нього коштував 100грн");
                money -=100;
                break;
            }
            
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Це прикол якийсь, нема такої двері, скажи бувай 100 грн");
            money -= 100;
            
            
        }
        
        if (!b) break;
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Ти бачиш перед собою бідну дівчину, яка просить від тебе милостинню\n"
                + "1 - Ввіддати 50 грн\n"
                + "2 - Ввіддати 75 грн\n"
                + "3 - Ввіддати 100 грн\n");
        
        key = stdin.readLine();
        
        switch (key){
            case "1":{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Дівчина сказала що так мало їй ще ніхто не давав, і повернула тобі гроші");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Ти зберіг власні кошти, але не допоміг бідолашній дівчині");
                answers -=1;
                break;
            }
            case "2":{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Молодець, завжди потрібно знати золоту середину, дівчина тобі подякувала");
                answers +=1;
                break;
            }
            
            case "3":{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Ти запропонував занадто багато, коли дівчина побачила що в тебе\n"
                        + "є ще гроші то відлупцювала тебе та забрала 300 грн");
                money -=300;
                break;
            }
            
            default:{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Ха, надумав мене провести? Я забираю в тебе 100 грн");
                money -= 100;
            }
            
        }
        
        if (money <= 0){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Твої гроші закінчились");
            m = false;
            break;
        }
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Я задам тобі одну загадку і якщьо ти відгадаєш, \n"
                + "то я відпущу тебе у світ живих. Цю загадку не відгадував ніхто");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Що зимою та літом, одного кольору?");
        key = stdin.readLine();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Хмммм");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Зачекай йде обробка інформації");
        if ("твої очі".equals(key)){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Я не враховую відповіді з другої спроби.");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Ахахахаха. Грай далі");
        }
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Нажаль ти не відгадав. Відповідь -  мої очі. Я думав ти особливий");
        
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Щоб перейти на наступний рівень ти маєш 3 варіанти");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1 - Відгадати загадку, тут я уже не буду знущатись\n"
                + "2 - Пройти випробовування рандомом\n"
                + "3 - Придбати мені кофе за 300 грн");
        key = stdin.readLine();
        String tmp ="",answ = Zag.getZag("1");
        switch (key){
            
            case "1":{
                
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Zag.getZag("0"));
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Якою буде твоя відповідь?");
                tmp = stdin.readLine();
                
                if(answ.contains(tmp.toLowerCase())){
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Ти починаєш мене дивувати. Відповідь вірна");
                    answers +=1;
                }else{
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Ха. Відповідь не вірна а за спроби потрібно платити. \n"
                            + "-200грн");
                    money -=200;
                }
                break;
            }
            
            case "2":{
                int k = 0;
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Натисни Enter. Якщо число, яке ти отримаєш буде\n"
                        + "більше ніж 5 то ти пройшов\n"
                        + "інакше -300грн");
                tmp = stdin.readLine();
                k = Rnd.getRndNum(0,10);
                if (k>5){
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(k);
                    System.out.println("Не люблю щасливчиків, але правила є правила");
                    answers +=1;
                }else {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(k);
                    System.out.println("Ой, я щьось не те натиснув, ти здається втратиш\n"
                            + "200грн. Вибач з ким не буває");
                    money -=200;
                }
                
            }
            
            case "3":{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Щось мені кави мало, потрібно ще одну чашечку");
                money -=300;
            }
            
        }
        
        
        
        if(money <= 0){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Опа а у когось закінчились гроші. Допобачення");
            continue;
        }
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Ти потрапив в місце де нічого не видно. Твої дії?");
        TimeUnit.SECONDS.sleep(2);
        boolean bb = true;
        
        while(bb){
            
        
        System.out.println("1 - Помолитись мені та надіятись на те що я тобі допоможу\n"
                + "2 - Постаратись щось знайти\n"
                + "3 - Почати тікати");
        key = stdin.readLine();
        switch (key){
            case "1":{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Ок. Я увімкну світло.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Від цього нічого не зміниось, тут абсолютна пустота");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Але мої послуги не безкоштовні. -200 грн");
                money -= 200;
                break;
                
            }
            
            case "2":{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Ти ненароком натиснув на якусь кнопку кнопку.\n"
                        + "Перед тобою з'явився екран");
                bb = false;
                break;
            }
            
            case "3":{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Ти, пробіжав 3 хвилини, та відчув різкий удар в голову.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Це булла бетонна стіна. Ти прокинувся і побачив перед собою екран\n"
                        + "І в тебе зникло 200 грн");
                
                money -=200;
                bb = false;
                break;
            }
            default:{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Ти що читати не вмієш? -200грн");
                money -=200;
                
            }
         }
        }
        
        if(money <= 0){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Опа а у когось закінчились гроші. Допобачення");
            break;
        }
        
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Загадка на екрані, звучить так: \n"+ Zag.getZag("2"));
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Якою буде твоя відповідь?");
        
        
        key = "";
        
        while(key.length() < 3){
            key = stdin.readLine();
            
            if (key.toLowerCase() == null ? Zag.getZag("3") == null : key.toLowerCase().equals(Zag.getZag("3"))){
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Хмм. А ти достойний гравець. Вірна відповідь");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Але не думай що далі буде простіше");
                answers +=1;
                break;
            }else{
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Ахахаах. Такими темпами ти ніколи не вийдеш з виключень");
                answers -=1;
                break;
            }
            
            
        }
        
        if(money <= 0){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Опа а у когось закінчились гроші. Допобачення");
            continue;
        }
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Ти ще не програв?");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Ну добре тоді далі на тебе чекає останне випробування");
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Ти будеш грати в Російську рулетку. Моє улюблене виробовування\n"
                + "Ще не було такого випадку що хтось його пройшов");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Спробуй або програй");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Коли ти вводиш 1 ти отримуєш номер,\n"
                    + "якщо він співпаде з номером кулі то ти програв");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("У тебе є 3 спроби щоби програти");
        
        boolean bbb = true;
        int i = 0;
        int a1,bullet;
        key ="";
        while(i < 3){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Починаємо");
            bullet = Rnd.getRndNum(0, 6);
            System.out.println("Номер кулі: "+ bullet);
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Твоя черга. Введи 1");
            key = stdin.readLine();
            
            if("1".equals(key)){
                a1 = Rnd.getRndNum(0, 6);
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Твій номер: "+a1);
                if (a1 == bullet){
                    System.out.println("Ти програв");
                    i = 4;
                } else {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("На цей раз пощастило");
                    i++;
                    
                }
            }
            
            
            
        }
        
        if (i == 4 ){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Я ж казав що це найважче випробування");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("У тебе є змога почати спочатку");
            continue;
        }
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Я просто в шоці, ТИ ПЕРШИЙ\n"
                + "до цього моменту ще ніхто не доходив");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Але це ще не все, я так просто не здамся\n"
                + "Спочатку ми подивимось на твої результати");
        
        if (answers > 3){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Неймовірно ти можеш пишатись собою. Таких результатів\n"
                    + "ще ніхто не отримував. Ти пройшов гру");
            break;
        }
        
        if (money > 500){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Ти просто неймовірний чувак, я ввіддам твої гроші тобі в реальному житті");
            break;
        }
        
        if (money <= 500){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Не можна витрачати так багато грошей, спробуй знову");
            continue;
        }
        
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Хмм. Що я можу тобі сказати. Напевно тобі варто спробувати ще один раз");
        break;
        }// end of programm
        
        //Thread.interrupted();
        player.close();
    }
    
}
