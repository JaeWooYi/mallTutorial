package kr.inflearn.service;

import java.util.List;

import kr.inflearn.model.BoardVO;

public interface BoardService {
	public List<BoardVO> getList();			// 게시물 리스트 가져오기
	public void register(BoardVO boardVO);	// 게시물 등록
	public BoardVO get(int bno);			// 게시물 상세 보기
	public int remove(int bno);				// 게시물 삭제
	public int modify(BoardVO boardVO);		// 게시물 수정
}
