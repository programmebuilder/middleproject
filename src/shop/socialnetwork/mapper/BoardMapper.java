package shop.socialnetwork.mapper;

import java.util.List;

import shop.socialnetwork.dto.BdImgDto;
import shop.socialnetwork.dto.BdRplyDto;
import shop.socialnetwork.dto.BdRplyMemberDto;
import shop.socialnetwork.dto.BdTagDto;
import shop.socialnetwork.dto.BoardDto;
import shop.socialnetwork.dto.BoardMemberDto;
import shop.socialnetwork.dto.LikeTbDto;

/* 
 * Note: Board.xml과 BoardDao의 메소드를 연결해주는 역할을 하는 인터페이스 
 * Author: 안태현
 * Since: 26/04/2018
 * */
public interface BoardMapper {
	public List<BoardDto> printBoard(); // 게시물 출력
	public List<BdImgDto> printImage(); // 게시물 이미지 출력
	public List<BoardMemberDto> printNickName(); // 게시물 작성자 닉네임 출력
	public List<BdRplyMemberDto> printThreeReply(); // 게시물 댓글 출력
	public List<BdTagDto> printTag(); // 미구현
	public Integer selectBoardBdNo(); // 가장 최신 글 번호 조회
	public Integer selectBdImgImgNo(); // 가장 최신 이미지 번호 조회
	public Integer selectBdRplyBdRplyNo(); // 가장 최신 댓글 번호 조회
	
	public int insertBoard(BoardDto boardDto); // 게시물 등록
	public int insertBoardImage(BdImgDto bdImgDto); // 게시물 이미지 등록
	public int insertReply(BdRplyDto bdRplyDto); // 댓글 등록
	public Integer selectBoardRplyHits(int bdNo); // 해당 게시물의 댓글 수 출력
	 
	public int updateBoardRplyHits(String rplyHits, String bdNo); // 댓글 수 업데이트
	
	public Integer selectLikeTbLikeNo(); // 가장 최근 좋아요 번호 조회
	public Integer selectBoardLikeHits(int bdNo); // 해당 게시물의 좋아요 수 출력
	public int insertLike(LikeTbDto likeTbDto); // 좋아요 등록
}