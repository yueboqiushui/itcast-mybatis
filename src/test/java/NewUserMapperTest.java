import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class NewUserMapperTest {
    private UserMapper userMapper;
    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //参数为true,事务自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void testSelectOne(){
        User user = new User();
        user.setId(1L);
        System.out.println(userMapper.selectOne(user));
    }
    @Test
    public void testQueryUserByPage(){
        //第几页开始，显示多少条数据
        PageHelper.startPage(1,2);
        List<User> select = userMapper.select(null);
        for (User user : select) {
            System.out.println(user);
        }
        //显示分页信息
        PageInfo<User> pageInfo = new PageInfo<>(select);
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getTotal());
    }
}
