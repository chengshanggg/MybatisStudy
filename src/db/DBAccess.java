package db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	public SqlSession getSqlSession() throws IOException{
		//通过配置文件读取数据库链接信息
		Reader reader=Resources.getResourceAsReader("com/imooc/configing/Configuration.xml");
		//通过配置信息构建一个sqlsessionfactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//通过sqlsessionfactory打开一个数据库会话
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//返回得到的sqlsession 操作数据库的对象
		return sqlSession;
	}
}
