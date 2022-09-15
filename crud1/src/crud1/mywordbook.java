package crud1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
 
public class mywordbook implements wordbookfunction {
 
    static HashMap<String, String> wordbook = new HashMap<>(); // �����Ͻ� �޸� �Ҵ�(static), ��������
 
    // ������
    public mywordbook() {
        wordbook.put("student", "�л�(�⺻�ܾ�)");
        wordbook.put("people", "���,�װ�(�⺻�ܾ�)");
        wordbook.put("apple", "���(�⺻�ܾ�)");
        wordbook.put("pizza", "����(�⺻�ܾ�)");
    }
 
    // �޴�
    @Override
    public void Menu() {
 
        System.out.println("��ϵ� �ܾ��: " + wordbook.size());
        System.out.println("-----�ϰ���� ���� �������ּ���-----");
        System.out.println("1.�ܾ���");
        System.out.println("2.�ܾ���ȸ");
        System.out.println("3.�ܾ����");
        System.out.println("4.�׽�Ʈ");
        System.out.println("5.�ܾ��Ϻ���");
        System.out.println("6.����");
        System.out.println("----------------------------");
    }
 
    // �ܾ���
    @Override
    public void addword() {
 
        String eng = null;
        String kor = null;
        while (true) {
 
            Scanner scr = new Scanner(System.in);
            System.out.print("����� ����ܾ �Է��ϼ���(Menu�� ������ menu�Է�):");
            eng = scr.nextLine();
            if (eng.equals("menu") || eng.equals("Menu")) { // String ���� �񱳽� .equals���
                break;
            } else {
                if (wordbook.containsKey(eng) == true) {// key������ ���� �����ϸ�
                    System.out.println("�̹� ��ϵ� �ܾ��Դϴ�. ������ ���Ͻø� ������ �ٽ� ����� �ּ���.");
                } else { // ����̾ȵ� �ܾ��ϰ��
                    System.out.print("���� �Է��ϼ���: ");
                    kor = scr.nextLine();
 
                    try {
                        wordbook.put(eng, kor);
                    } catch (Exception e) {
                        System.out.println("�ٽ��Է����ּ���");
                        e.printStackTrace();
                    } finally {
                        System.out.println("�ԷµǾ����ϴ�.");
                    }
                }
            }
        }
    }
 
    // �ܾ���ȸ
    @Override
    public void wordsearch() {
        while (true) {
            Scanner scr = new Scanner(System.in);
            System.out.println("��ȸ�ϰ���� ���ܾ �Է��ϼ���(Menu�ΰ����� menu�Է�):");
            String eng = scr.nextLine();
            if (eng.equals("menu") || eng.equals("Menu")) {
                break;
            } else {
                if (wordbook.containsKey(eng) == true) {// �˻��� ���ܾ key���� �����ϸ�
                    System.out.println(wordbook.get(eng)); // �Է��� key�� �����Ǵ� value ���
                } else {
                    System.out.println("��ϵ��� ���� �ܾ��Դϴ�.");
                }
            }
        }
    }
 
    // �ܾ����
    @Override
    public void deleteword() {
        while (true) {
            Scanner scr = new Scanner(System.in);
            System.out.println("====�ܾ� ���====");
            Set key = wordbook.keySet();
            Iterator iterator; // map��ü ��½� iterator ���
 
            for (iterator = key.iterator(); iterator.hasNext();) {
                String keyValue = (String) iterator.next();// key�����
                String valueVar = (String) wordbook.get(keyValue);// value�����
 
                System.out.println("*" + keyValue + " : " + valueVar);
 
            }
            System.out.println("=============");
 
            System.out.println("�����ϰ� ���� �ܾ �Է��ϼ���(Menu�ΰ��� menu�Է�:");
            String del = scr.nextLine();
            if (del.equals("menu") || del.equals("Menu")) {
                break;
            } else {
                if (wordbook.containsKey(del) == true) {
                    System.out.println("�Է��� �ܾ� (" + del + ":" + wordbook.remove(del) + ")�� �����Ǿ����ϴ�.");
                } else {
                    System.out.println("�������� �ʴ� �ܾ��Դϴ�.");
                }
            }
        }
    }
 
    // �ܾ� �׽�Ʈ
    @Override
    public void test() {
        // TODO Auto-generated method stub
        while (true) {
            Scanner scr = new Scanner(System.in);
            System.out.println("1.�����ϱ�");
            System.out.println("2.�����ϱ�");
            int a = scr.nextInt();
            if (a == 1) {
                Set key = wordbook.keySet();
                int count = 0;
                int totalCount = 0;
                Iterator iterator; // map��ü ��½� iterator ���
                System.out.println("<====�濡 �´� ���ܾ �Է��ϼ���====>");
                for (iterator = key.iterator(); iterator.hasNext();) {
                    String keyValue = (String) iterator.next();// key��
                    String valueVar = (String) wordbook.get(keyValue);// value��
                    Scanner scan = new Scanner(System.in);
                    System.out.println(valueVar);
                    String answer = scan.nextLine();
 
                    if (answer.equals(keyValue)) {
                        System.out.println("�����Դϴ�.");
                        count++;
                        totalCount++;
                    } else {
                        System.out.println("Ʋ�Ƚ��ϴ�.  (��:" + keyValue + ")");
                        totalCount++;
                    }
                }
                System.out.println("<<��� : " + count + "/" + totalCount + ">>");
                break;
 
            } else if (a == 2) {
                break;
            } else {
                System.out.println("1 �Ǵ� 2���Է����ּ���");
            }
        }
    }
 
    // ��ϵ� �ܾ���
    @Override
    public void wordlist() {
        System.out.println("-------------���---------------");
//     System.out.println(wordbook.toString());
 
        Set key = wordbook.keySet();
 
        Iterator iterator; // map��ü ��½� iterator ���
 
        for (iterator = key.iterator(); iterator.hasNext();) {
            String keyValue = (String) iterator.next();// key�����
            String valueVar = (String) wordbook.get(keyValue);// value�����
 
            System.out.println("*" + keyValue + " : " + valueVar);
 
        }
        System.out.println("-------------------------------");
 
        while (true) {
            System.out.println("���ư����� menu�Է�");
            Scanner scr = new Scanner(System.in);
            String menu = scr.nextLine();
            if (menu.equals("menu")) {
                break;
            } else {
                System.out.println("����");
            }
        }
    }
 
    // ����
    @Override
    public void exit() {
        System.out.println("�ܾ����� �����մϴ�.");
 
    }
 
}
