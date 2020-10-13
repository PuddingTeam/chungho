package Music.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("myDjDao")
public class DjDao {
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	private String namespace="Music.model.Dj";
	
	public void insertData(Dj dj) {
		sqlsessiontemplate.insert(namespace+".insertDj",dj);
	}

	public List<Dj> getDataList() {
		List<Dj> lists = new ArrayList<Dj>();
		lists = sqlsessiontemplate.selectList(namespace+".GetDjList");
		return lists;
		
	}

}
