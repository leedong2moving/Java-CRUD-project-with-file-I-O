package com.dong.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
	ArrayList<Word> list;
	Scanner s ; 
	/*
	 * => ���̵�(1,2,3) & �� �ܾ� �Է� :1 driveway
	 * �� �Է� :���� ���Է�
	 * �� �ܾ �ܾ��忡 �߰��Ǿ����ϴ�.
	 */
	
	WordCRUD(Scanner s){
		list = new ArrayList<>();
		this.s = s;
	}

	@Override
	public Object add() {
		System.out.print("-> ���̵�(1,2,3) & �� �ܾ� �Է� :");
		int level = s.nextInt();
		String word = s.next();

		System.out.print("�� �Է� : ");
		String meaning = s.nextLine();

		return null;
	}
	
	public void addWord() {
		
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void selectOne(int id) {
		// TODO Auto-generated method stub
		
	}

}
