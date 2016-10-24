package A0000003.ModelHouse.DAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class NtcDAO {
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

	/* Ntc 게시글 카운트 */
	public int ntcListCount(Map<String, Object> paramMap) throws SQLException{
		return (int)sqlMapper.queryForObject("NtcDAO.ntcListCount",paramMap);
	}

	/* Ntc 게시글 조회 */
	public List<Map<String,Object>> ntcList(Map<String, Object> paramMap) throws SQLException{
		return (List<Map<String, Object>>)sqlMapper.queryForList("NtcDAO.ntcList", paramMap);
	}

	/* Ntc 게시글 등록 */
	public void ntcInsert(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.insert("NtcDAO.ntcInsert", paramMap);
	}

	/* Ntc 게시글 상세보기 */
	public Map<String, Object> ntcDetail(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.update("NtcDAO.ntcHitUpdate", paramMap);
		return (Map<String, Object>) sqlMapper.queryForObject("NtcDAO.ntcDetail", paramMap);
	}

	/* Ntc 게시글 수정 */
	public void ntcUpdate(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.insert("NtcDAO.ntcUpdate", paramMap);
	}

	/* Ntc 게시글 삭제 */
	public void ntcDelete(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.update("NtcDAO.ntcDelete", paramMap);
	}
}