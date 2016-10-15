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
	   
	   /* Notice �Խñ� ��ȸ */
	   public List<Map<String,Object>> noticeList(Map<String, Object> paramMap) throws SQLException{
	      return (List<Map<String, Object>>)sqlMapper.queryForList("NoticeDAO.noticeList", paramMap);
	   }
	   
	   
	   /* Notice �Խñ� ī��Ʈ */
	   public int selectCount(Map<String, Object> paramMap) throws SQLException{
	      return (int)sqlMapper.queryForObject("NoticeDAO.noticeListCount",paramMap);
	   }
	   
	   /* Notice �Խñ� ��� */
	   public void noticeInsert(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("NoticeDAO.noticeInsert", paramMap);
	   }
	   
	   // Notice�ɷ� �ٲ�����ؿ�!!!
	   /* Notic �Խñ� �󼼺��� */
	   public Map<String, Object> noticeDetail(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("NoticeDAO.noticeHitUpdate", paramMap);
	      return (Map<String, Object>) sqlMapper.queryForObject("NoticeDAO.noticeDetail", paramMap);
	   }
	   
	   /* Notic �Խñ� ���� */
	   public void noticeUpdate(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("NoticeDAO.noticeUpdate", paramMap);
	   }
	   
	   /* �Խñ� ���� */
	   public void noticeDelete(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("NoticeDAO.noticeDelete", paramMap);
	   }
	    /*
	    ���� üũ 
	   public int QnAUserCheck(Map<String, Object> paramMap) throws SQLException{
	      return (int)sqlMapper.queryForObject("QnADAO.QnAUserCheck", paramMap);
	   }
	   
	    QnA ��� ��ȸ 
	   public List<Map<String, Object>> AnsList(Map<String, Object> paramMap) throws SQLException{
	      return (List<Map<String, Object>>)sqlMapper.queryForList("QnADAO.AnsList", paramMap);
	   }
	   
	    QnA ��� �ۼ� 
	   public void AnsInsert(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.insert("QnADAO.AnsInsert", paramMap);
	   }
	   
	    QnA ��� ���� 
	   public void AnsDelete(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("QnADAO.AnsDelete", paramMap);
	   }
	   
	    QnA ��� ���� 
	   public void AnsUpdate(Map<String, Object> paramMap) throws SQLException{
	      sqlMapper.update("QnADAO.AnsUpdate", paramMap);
	   }
*/
}
