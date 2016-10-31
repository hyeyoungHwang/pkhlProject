package A0000003.ModelHouse.DAO;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class ImgDAO {
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

	/* img 게시글 카운트 */
	public int imgListCount(Map<String, Object> paramMap) throws SQLException{
		return (int)sqlMapper.queryForObject("ImgDAO.imgListCount",paramMap);
	}

	/* img 게시글 조회 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> imgList(Map<String, Object> paramMap) throws SQLException{
		return (List<Map<String, Object>>)sqlMapper.queryForList("ImgDAO.imgList", paramMap);
	}

	/* img 게시글 등록 */
	public void imgInsert(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.insert("ImgDAO.imgInsert", paramMap);
	}

	/* img 게시글 상세보기 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> imgDetail(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.update("ImgDAO.imgHitUpdate", paramMap);
		return (Map<String, Object>) sqlMapper.queryForObject("ImgDAO.imgDetail", paramMap);
	}

	/* img 게시글 수정 */
	public void imgUpdate(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.insert("ImgDAO.imgUpdate", paramMap);
	}

	/* img 게시글 삭제 */
	public void imgDelete(Map<String, Object> paramMap) throws SQLException{
		sqlMapper.update("ImgDAO.imgDelete", paramMap);
	}
}
