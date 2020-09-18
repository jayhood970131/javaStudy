import com.jayhood.Utils.MyBatisUtil;
import com.jayhood.mapper.UserMapper;
import com.jayhood.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
