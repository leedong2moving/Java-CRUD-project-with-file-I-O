package crud1;

import java.util.Scanner;
import com.java.wordbook.*;
 
public class wordbook {
 
    public static void main(String[] args) {
 
        mywordbook mybook = new mywordbook(); // ��ü����(Ŭ���� ��ü)
        while (true) {
 
            // ����ȭ��(�޴�)
            mybook.Menu();
 
            // �޴�����
            Scanner scan = new Scanner(System.in);
            String select = scan.nextLine();
 
            if (select.equals("1")) {
                mybook.addword();
            } else if (select.equals("2")) {
                mybook.wordsearch();
 
            } else if (select.equals("3")) {
                mybook.deleteword();
            } else if (select.equals("4")) {
                mybook.test();
            } else if (select.equals("5")) {
                mybook.wordlist();
            } else if (select.equals("6")) {
                mybook.exit();
                break;
            } else {
                System.out.println("1~6������ ���ڸ� �Է��ϼ���.");
            }
        }
    }
}
