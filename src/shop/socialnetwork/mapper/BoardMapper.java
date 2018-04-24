package shop.socialnetwork.mapper;

import java.util.HashMap;
import java.util.List;

import shop.socialnetwork.dto.BdImgDto;
import shop.socialnetwork.dto.BdRplyMemberDto;
import shop.socialnetwork.dto.BdTagDto;
import shop.socialnetwork.dto.BoardDto;
import shop.socialnetwork.dto.BoardMemberDto;

/* 
 * Note: Board.xml과 BoardDao의 메소드를 연결해주는 역할을 하는 인터페이스 
 * Author: 안태현
 * Since: 24/04/2018
 * */
public interface BoardMapper {
	public List<BoardDto> printBoard();
	public List<BdImgDto> printImage();
	public List<BoardMemberDto> printNickName();
	public List<BdRplyMemberDto> printThreeReply();
	public List<BdTagDto> printTag(); // 미구현
	public Integer selectBoardBdNo(); // 가장 최신 글 번호 조회
	public int insertBoard(BoardDto boardDto);
	public int insertBoardImage(HashMap<String, Object> map);
	public int getBoardSeq(String bdContent);
}
