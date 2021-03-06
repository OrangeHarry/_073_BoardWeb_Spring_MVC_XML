package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		//1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring 컨테이너로부터 BoardServiceImpl 객체를 Lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//3. 글 등록 테스트
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("임시 제목");
		vo.setWriter("하헌민");
		vo.setContent("임시 내용.........");
//		boardService.insertBoard(vo); //이렇게 돌렸을 때 100번값이 들어가지 않고 나와 왜냐하면 롤백처리가 됬으니깐!!
		
		//4. 글 목록 조회 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		//5. Spring 컨테이너 종료
		container.close();
	}
}
