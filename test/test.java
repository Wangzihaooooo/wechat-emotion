import com.module.recognition.core.RecommendMusic;
import com.module.recognition.persistence.dao.TagRelationDao;
import com.module.recognition.persistence.domain.Tag;
import com.module.recognition.service.TagRelationService;
import com.module.recognition.service.TagService;
import com.module.recognition.util.RandomRecommendUtil;
import com.module.spider.persistence.dao.MusicDao;
import com.module.spider.persistence.domain.Music;
import com.module.spider.service.MusicService;
import com.sys.persistence.domain.User;
import com.sys.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用Springtest框架
@ContextConfiguration(locations = {"/mybatis/mybatis3.xml", "/spring/springmvc.xml"}) //加载配置
public class test {
    @Resource
    private UserService  userService;
    @Resource
    TagService         tagService;
    @Resource
    TagRelationService tagRelationService;
    private static Logger log = Logger.getLogger(test.class.getName());
    @Resource
    MusicService musicService;
    @Test
    public void select() {
        log.info(musicService.getMusicListBySongId(tagRelationService.selectMusicListByTag(1,5)));
        //log.info(tagRelationDao.selectMusicListByTag(2,5).get(0));
        //log.info(recommendMusic.getMusicGroup(1,10).get(1));
    }
}
