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
	   
	   /* QnA �Խñ� ī��Ʈ */
	   public int selectCount(Map<String, Object> paramMap) throws SQLException{
	      return (int)sqlMapper.queryForObject("QnADAO.qnaListCount",paramMap);
	   }
	   
	   /* QnA �Խñ� ��ȸ */
	   public List<Map<String,Object>> qnaList(Map<String, Object> paramMap) throws SQLException{
	      return (List<Map<String, Object>>)sqlMapper.queryForList("QnADAO.qnaList", paramMap);
	   }
	   
	   /* QnA �Խñ� ��� */
	   public void qnaInsert(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("QnADAO.qnaInsert", paramMap);
	   }
	   
	   /* QnA �Խñ� �󼼺��� */
	   public Map<String, Object> qnaDetail(Map<String, Object> paramMap) throws SQLException{
	      /* QnA �Խñ� ��ȸ�� */
	      sqlMapper.update("QnADAO.qnaHitUpdate", paramMap);
	      return (Map<String, Object>) sqlMapper.queryForObject("QnADAO.qnaDetail", paramMap);
	   }
	   
	   /* QnA �Խñ� ���� */
	   public void qnaUpdate(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("QnADAO.qnaUpdate", paramMap);
	   }
	   
	   /* �Խñ� ���� */
	   public void qnaDelete(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("QnADAO.qnaDelete", paramMap);
	   }
	   
	   /* ���� üũ */
	   public int qnaUserCheck(Map<String, Object> paramMap) throws SQLException{
	      return (int)sqlMapper.queryForObject("QnADAO.qnaUserCheck", paramMap);
	   }
	   
	   /* QnA ��� ��ȸ */
	   public List<Map<String, Object>> ansList(Map<String, Object> paramMap) throws SQLException{
	      return (List<Map<String, Object>>)sqlMapper.queryForList("QnADAO.ansList", paramMap);
	   }
	   
	   /* QnA ��� �ۼ� */
	   public void ansInsert(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("QnADAO.ansInsert", paramMap);
	   }
	   
	   /* QnA ��� ���� */
	   public void ansDelete(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("QnADAO.ansDelete", paramMap);
	   }
	   
	   /* QnA ��� ���� */
	   public void ansUpdate(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("QnADAO.ansUpdate", paramMap);
	   }

}
