import com.jayhood.config.JConfig;
import com.jayhood.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JConfig.class);
        User user = (User) context.getBean("getUser");
        System.out.println(user.getName());
    }
}
