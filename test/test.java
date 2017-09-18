import com.sys.core.SpeechDecorder;
import com.module.recognition.service.TagRelationService;
import com.module.recognition.service.TagService;
import com.module.spider.service.MusicService;
import com.sys.service.UserService;
import com.sys.util.PropertyUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
    MusicService   musicService;
    @Resource
    SpeechDecorder speechDecorder;
    @Test
    public void select() {
        log.info( PropertyUtil.getProperty("jdbc.url"));
        /*speechDecorder.decode("C:\\Users\\wangzi\\Desktop\\silk-v3-decoder-master\\windows\\201.silk",
                "C:\\Users\\wangzi\\Desktop\\silk-v3-decoder-master\\windows\\202.webn",
                "C:\\Users\\wangzi\\Desktop\\silk-v3-decoder-master\\windows\\201.wav");*/
        //log.info(musicService.getMusicListBySongId(tagRelationService.selectMusicListByTag(1,5)));
        //log.info(tagRelationDao.selectMusicListByTag(2,5).get(0));
        //log.info(recommendMusic.getMusicGroup(1,10).get(1));
    }
}
