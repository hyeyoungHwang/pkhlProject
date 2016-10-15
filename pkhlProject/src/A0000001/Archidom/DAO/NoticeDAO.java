package A0000001.Archidom.DAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class NoticeDAO {
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
	   
	   /* Notice 게시글 조회 */
	   public List<Map<String,Object>> noticeList(Map<String, Object> paramMap) throws SQLException{
	      return (List<Map<String, Object>>)sqlMapper.queryForList("NoticeDAO.noticeList", paramMap);
	   }
	   
	   
	   /* Notice 게시글 카운트 */
	   public int selectCount(Map<String, Object> paramMap) throws SQLException{
	      return (int)sqlMapper.queryForObject("NoticeDAO.noticeListCount",paramMap);
	   }
	   
	   /* Notice 게시글 등록 */
	   public void noticeInsert(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("NoticeDAO.noticeInsert", paramMap);
	   }
	   
	   // Notice걸로 바꿔줘야해요!!!
	   /* Notic 게시글 상세보기 */
	   public Map<String, Object> noticeDetail(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("NoticeDAO.noticeHitUpdate", paramMap);
	      return (Map<String, Object>) sqlMapper.queryForObject("NoticeDAO.noticeDetail", paramMap);
	   }
	   
	   /* Notic 게시글 수정 */
	   public void noticeUpdate(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("NoticeDAO.noticeUpdate", paramMap);
	   }
	   
	   /* 게시글 삭제 */
	   public void noticeDelete(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("NoticeDAO.noticeDelete", paramMap);
	   }
	    /*
	    유저 체크 
	   public int QnAUserCheck(Map<String, Object> paramMap) throws SQLException{
	      return (int)sqlMapper.queryForObject("QnADAO.QnAUserCheck", paramMap);
	   }
	   
	    QnA 댓글 조회 
	   public List<Map<String, Object>> AnsList(Map<String, Object> paramMap) throws SQLException{
	      return (List<Map<String, Object>>)sqlMapper.queryForList("QnADAO.AnsList", paramMap);
	   }
	   
	    QnA 댓글 작성 
	   public void AnsInsert(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("QnADAO.AnsInsert", paramMap);
	   }
	   
	    QnA 댓글 삭제 
	   public void AnsDelete(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("QnADAO.AnsDelete", paramMap);
	   }
	   
	    QnA 댓글 수정 
	   public void AnsUpdate(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("QnADAO.AnsUpdate", paramMap);
	   }
*/
}
