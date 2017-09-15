import com.module.spider.persistence.dao.MusicDao;
import com.module.spider.persistence.domain.Music;
import com.sys.persistence.domain.User;
import com.sys.service.Impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用Springtest框架
@ContextConfiguration(locations = {"/mybatis/mybatis3.xml", "/spring/springmvc.xml"}) //加载配置
public class test {
    @Resource //注入
    private MusicDao        musicDao;
    @Resource
    private UserServiceImpl userService;

    static Logger log = Logger.getLogger(test.class.getName());
    @Test
    public void selectAll() {
        User user = userService.getUserById(new Integer(1));
        Music music=musicDao.selectByPrimaryKey(new Integer(1));
        log.info(user);
    }
}
