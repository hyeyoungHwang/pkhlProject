package A0000001.Archidom.DAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class QnADAO{

	private static SqlMapClient sqlMapper;
	   
	   static{
	      try{
	         Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
	         sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
	         reader.close();
	      }catch(IOException e){
	         throw new RuntimeException(e);
	      }   
	   }
	   
	   /* QnA 게시글 카운트 */
	   public int selectCount(Map<String, Object> paramMap) throws SQLException{
	      return (int)sqlMapper.queryForObject("QnADAO.qnaListCount",paramMap);
	   }
	   
	   /* QnA 게시글 조회 */
	   public List<Map<String,Object>> qnaList(Map<String, Object> paramMap) throws SQLException{
	      return (List<Map<String, Object>>)sqlMapper.queryForList("QnADAO.qnaList", paramMap);
	   }
	   
	   /* QnA 게시글 등록 */
	   public void qnaInsert(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("QnADAO.qnaInsert", paramMap);
	   }
	   
	   /* QnA 게시글 상세보기 */
	   public Map<String, Object> qnaDetail(Map<String, Object> paramMap) throws SQLException{
	      /* QnA 게시글 조회수 */
	      sqlMapper.update("QnADAO.qnaHitUpdate", paramMap);
	      return (Map<String, Object>) sqlMapper.queryForObject("QnADAO.qnaDetail", paramMap);
	   }
	   
	   /* QnA 게시글 수정 */
	   public void qnaUpdate(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("QnADAO.qnaUpdate", paramMap);
	   }
	   
	   /* 게시글 삭제 */
	   public void qnaDelete(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("QnADAO.qnaDelete", paramMap);
	   }
	   
	   /* 유저 체크 */
	   public int qnaUserCheck(Map<String, Object> paramMap) throws SQLException{
	      return (int)sqlMapper.queryForObject("QnADAO.qnaUserCheck", paramMap);
	   }
	   
	   /* QnA 댓글 조회 */
	   public List<Map<String, Object>> ansList(Map<String, Object> paramMap) throws SQLException{
	      return (List<Map<String, Object>>)sqlMapper.queryForList("QnADAO.ansList", paramMap);
	   }
	   
	   /* QnA 댓글 작성 */
	   public void ansInsert(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("QnADAO.ansInsert", paramMap);
	   }
	   
	   /* QnA 댓글 삭제 */
	   public void ansDelete(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("QnADAO.ansDelete", paramMap);
	   }
	   
	   /* QnA 댓글 수정 */
	   public void ansUpdate(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("QnADAO.ansUpdate", paramMap);
	   }

}
