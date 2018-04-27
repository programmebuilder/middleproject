package shop.socialnetwork.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import shop.socialnetwork.dto.BdImgDto;
import shop.socialnetwork.dto.BdRplyDto;
import shop.socialnetwork.dto.BdRplyMemberDto;
import shop.socialnetwork.dto.BoardDto;
import shop.socialnetwork.dto.BoardMemberDto;
import shop.socialnetwork.dto.LikeTbDto;
import shop.socialnetwork.mapper.BoardMapper;

/* 
 * Note: 데이터를 조회 또는 조작하는 역할
 * Author: 안태현
 * Since: 22/04/2018
 * */
public class BoardDao {
	/* 매번 실행할 때 마다 BoardDao 객체가 메모리에 올라가는 것을 막기 위해서 static으로 선언 */
	private static BoardDao boarddao = new BoardDao();

	public static BoardDao getInstance() {
		return boarddao;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		// mybatis-config.xml이 src경로에 있기 때문에 xml 이름만 적어도 됨
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;

		try {
			// InputStream 객체 얻어 오기
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// sqlSessionFactory 생성 완료
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	/* 게시물 출력 */
	public List<BoardDto> printBoard() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<BoardDto> listBoardDto = null;
		try {
			listBoardDto = sqlSession.getMapper(BoardMapper.class).printBoard();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return listBoardDto;
	}

	/* 이미지 출력 */
	public List<BdImgDto> printImage() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<BdImgDto> listBdImgDto = null;
		try {
			listBdImgDto = sqlSession.getMapper(BoardMapper.class).printImage();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return listBdImgDto;
	}

	/* 닉네임 출력 */
	public List<BoardMemberDto> printNickName() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<BoardMemberDto> listBoardMemberDto = null;
		try {
			listBoardMemberDto = sqlSession.getMapper(BoardMapper.class).printNickName();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return listBoardMemberDto;
	}

	/* 댓글 출력 */
	public List<BdRplyMemberDto> printThreeReply() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<BdRplyMemberDto> listBdRplyDto = null;
		try {
			listBdRplyDto = sqlSession.getMapper(BoardMapper.class).printThreeReply();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return listBdRplyDto;
	}

	/* 가장 최근 글 번호 조회 */
	public int selectBoardBdNo() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			if (sqlSession.getMapper(BoardMapper.class).selectBoardBdNo() == null) {
				return 0;
			} else {
				return sqlSession.getMapper(BoardMapper.class).selectBoardBdNo();
			} // END OF IF

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		} // END OF FINALLY
	}
	
	/* 가장 최근 이미지 번호 조회 */
	public int selectBdImgImgNo() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			if (sqlSession.getMapper(BoardMapper.class).selectBdImgImgNo() == null) {
				return 0;
			} else {
				return sqlSession.getMapper(BoardMapper.class).selectBdImgImgNo();
			} // END OF IF
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}
	
	/* 가장 최근 댓글 번호 조회 */
	public int selectBdRplyBdRplyNo() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			if (sqlSession.getMapper(BoardMapper.class).selectBdRplyBdRplyNo() == null) {
				return 0;
			} else {
				return sqlSession.getMapper(BoardMapper.class).selectBdRplyBdRplyNo();
			} // END OF IF
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}
	
	/* 가장 최근 좋아요 번호 조회 */
	public int selectLikeTbLikeNo() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			if (sqlSession.getMapper(BoardMapper.class).selectLikeTbLikeNo() == null) {
				return 0;
			} else {
				return sqlSession.getMapper(BoardMapper.class).selectLikeTbLikeNo();
			} // END OF IF
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}

	/* 게시물 등록 */
	public int insertBoard(BoardDto boardDto) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(BoardMapper.class).insertBoard(boardDto);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			} // END OF IF
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;
	}
	
	/* 게시물 이미지 등록 */
	public int insertBoardImage(BdImgDto bdImgDto) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(BoardMapper.class).insertBoardImage(bdImgDto);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			} // END OF IF
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;
	}
	
	/* 댓글 등록 */
	public int insertReply(BdRplyDto bdRplyDto) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(BoardMapper.class).insertReply(bdRplyDto);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			} // END OF IF
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;
	}
	
	/* 좋아요 등록 */
	public int insertLike(LikeTbDto likeTbDto) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(BoardMapper.class).insertLike(likeTbDto);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			} // END OF IF
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
		return re;
	}
	
	/* 해당 게시물의 댓글 수 출력 */
	public int selectBoardRplyHits(int bdNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			if (sqlSession.getMapper(BoardMapper.class).selectBoardRplyHits(bdNo) == null) {
				return 0;
			} else {
				return sqlSession.getMapper(BoardMapper.class).selectBoardRplyHits(bdNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}
	
	/* 해당 게시물의 좋아요 수 출력 */
	public int selectBoardLikeHits(int bdNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			if (sqlSession.getMapper(BoardMapper.class).selectBoardLikeHits(bdNo) == null) {
				return 0;
			} else {
				return sqlSession.getMapper(BoardMapper.class).selectBoardLikeHits(bdNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			sqlSession.close();
		}
	}
	
	/* 댓글 수 업데이트 */
	public int updateBoardRplyHits(int rplyHits, int bdNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		String changedRplyHits = rplyHits + "";
		String changedBdNo = bdNo + "";
		try {
			re = sqlSession.getMapper(BoardMapper.class).updateBoardRplyHits(changedRplyHits, changedBdNo);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			} // END OF IF
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return re;
	}
}
