package crud1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
 
public class mywordbook implements wordbookfunction {
 
    static HashMap<String, String> wordbook = new HashMap<>(); // 컴파일시 메모리 할당(static), 공유목적
 
    // 생성자
    public mywordbook() {
        wordbook.put("student", "학생(기본단어)");
        wordbook.put("people", "사람,닝겐(기본단어)");
        wordbook.put("apple", "사과(기본단어)");
        wordbook.put("pizza", "피자(기본단어)");
    }
 
    // 메뉴
    @Override
    public void Menu() {
 
        System.out.println("등록된 단어수: " + wordbook.size());
        System.out.println("-----하고싶은 것을 선택해주세요-----");
        System.out.println("1.단어등록");
        System.out.println("2.단어조회");
        System.out.println("3.단어삭제");
        System.out.println("4.테스트");
        System.out.println("5.단어목록보기");
        System.out.println("6.종료");
        System.out.println("----------------------------");
    }
 
    // 단어등록
    @Override
    public void addword() {
 
        String eng = null;
        String kor = null;
        while (true) {
 
            Scanner scr = new Scanner(System.in);
            System.out.print("등록할 영어단어를 입력하세요(Menu로 가려면 menu입력):");
            eng = scr.nextLine();
            if (eng.equals("menu") || eng.equals("Menu")) { // String 변수 비교시 .equals사용
                break;
            } else {
                if (wordbook.containsKey(eng) == true) {// key에대한 값이 존재하면
                    System.out.println("이미 등록된 단어입니다. 수정을 원하시면 삭제후 다시 등록해 주세요.");
                } else { // 등록이안된 단어일경우
                    System.out.print("뜻을 입력하세요: ");
                    kor = scr.nextLine();
 
                    try {
                        wordbook.put(eng, kor);
                    } catch (Exception e) {
                        System.out.println("다시입력해주세요");
                        e.printStackTrace();
                    } finally {
                        System.out.println("입력되었습니다.");
                    }
                }
            }
        }
    }
 
    // 단어조회
    @Override
    public void wordsearch() {
        while (true) {
            Scanner scr = new Scanner(System.in);
            System.out.println("조회하고싶은 영단어를 입력하세요(Menu로가려면 menu입력):");
            String eng = scr.nextLine();
            if (eng.equals("menu") || eng.equals("Menu")) {
                break;
            } else {
                if (wordbook.containsKey(eng) == true) {// 검색한 영단어가 key값에 존재하면
                    System.out.println(wordbook.get(eng)); // 입력한 key에 대응되는 value 출력
                } else {
                    System.out.println("등록되지 않은 단어입니다.");
                }
            }
        }
    }
 
    // 단어삭제
    @Override
    public void deleteword() {
        while (true) {
            Scanner scr = new Scanner(System.in);
            System.out.println("====단어 목록====");
            Set key = wordbook.keySet();
            Iterator iterator; // map전체 출력시 iterator 사용
 
            for (iterator = key.iterator(); iterator.hasNext();) {
                String keyValue = (String) iterator.next();// key값출력
                String valueVar = (String) wordbook.get(keyValue);// value값출력
 
                System.out.println("*" + keyValue + " : " + valueVar);
 
            }
            System.out.println("=============");
 
            System.out.println("삭제하고 싶은 단어를 입력하세요(Menu로가면 menu입력:");
            String del = scr.nextLine();
            if (del.equals("menu") || del.equals("Menu")) {
                break;
            } else {
                if (wordbook.containsKey(del) == true) {
                    System.out.println("입력한 단어 (" + del + ":" + wordbook.remove(del) + ")가 삭제되었습니다.");
                } else {
                    System.out.println("존재하지 않는 단어입니다.");
                }
            }
        }
    }
 
    // 단어 테스트
    @Override
    public void test() {
        // TODO Auto-generated method stub
        while (true) {
            Scanner scr = new Scanner(System.in);
            System.out.println("1.시작하기");
            System.out.println("2.종료하기");
            int a = scr.nextInt();
            if (a == 1) {
                Set key = wordbook.keySet();
                int count = 0;
                int totalCount = 0;
                Iterator iterator; // map전체 출력시 iterator 사용
                System.out.println("<====뜻에 맞는 영단어를 입력하세요====>");
                for (iterator = key.iterator(); iterator.hasNext();) {
                    String keyValue = (String) iterator.next();// key값
                    String valueVar = (String) wordbook.get(keyValue);// value값
                    Scanner scan = new Scanner(System.in);
                    System.out.println(valueVar);
                    String answer = scan.nextLine();
 
                    if (answer.equals(keyValue)) {
                        System.out.println("정답입니다.");
                        count++;
                        totalCount++;
                    } else {
                        System.out.println("틀렸습니다.  (답:" + keyValue + ")");
                        totalCount++;
                    }
                }
                System.out.println("<<결과 : " + count + "/" + totalCount + ">>");
                break;
 
            } else if (a == 2) {
                break;
            } else {
                System.out.println("1 또는 2만입력해주세요");
            }
        }
    }
 
    // 등록된 단어목록
    @Override
    public void wordlist() {
        System.out.println("-------------목록---------------");
//     System.out.println(wordbook.toString());
 
        Set key = wordbook.keySet();
 
        Iterator iterator; // map전체 출력시 iterator 사용
 
        for (iterator = key.iterator(); iterator.hasNext();) {
            String keyValue = (String) iterator.next();// key값출력
            String valueVar = (String) wordbook.get(keyValue);// value값출력
 
            System.out.println("*" + keyValue + " : " + valueVar);
 
        }
        System.out.println("-------------------------------");
 
        while (true) {
            System.out.println("돌아가려면 menu입력");
            Scanner scr = new Scanner(System.in);
            String menu = scr.nextLine();
            if (menu.equals("menu")) {
                break;
            } else {
                System.out.println("오류");
            }
        }
    }
 
    // 종료
    @Override
    public void exit() {
        System.out.println("단어장을 종료합니다.");
 
    }
 
}
