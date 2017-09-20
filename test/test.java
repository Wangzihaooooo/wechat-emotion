import com.sys.core.SpeechDecorderService;
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
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
    private MusicService          musicService;
    @Resource
    private SpeechDecorderService speechDecorderService;
    @Test
    public void select() {
        String fileName = "C:\\Users\\wangzi\\Desktop\\VoiceTest\\src\\main\\resources\\pythonCode\\voice\\201.wav";
        String path = "C:\\Users\\wangzi\\Desktop\\VoiceTest\\src\\main\\resources\\pythonCode\\Emotion.py";
        Runtime run = Runtime.getRuntime();
        try {
            // run.exec("cmd /k shutdown -s -t 3600");
            //Process process = run.exec("python D:\\study\\idea\\VoiceTest\\src\\main\\resources\\pythonCode\\test.py");
            Process process = run.exec("python " + path + " " + fileName);
            InputStream in = process.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(in));
            String line;
            int result = 0;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
                result = Integer.parseInt(line);
                break;
            }
            System.out.println(result);
            in.close();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }





        log.info( PropertyUtil.getProperty("db-config.properties","jdbc.url"));
        log.info(PropertyUtil.getProperty("filePath.properties","silk.path"));
        /*speechDecorder.decode("C:\\Users\\wangzi\\Desktop\\silk-v3-decoder-master\\windows\\201.silk",
                "C:\\Users\\wangzi\\Desktop\\silk-v3-decoder-master\\windows\\202.webn",
                "C:\\Users\\wangzi\\Desktop\\silk-v3-decoder-master\\windows\\201.wav");
        //log.info(musicService.getMusicListBySongId(tagRelationService.selectMusicListByTag(1,5)));*/
        //log.info(tagRelationDao.selectMusicListByTag(2,5).get(0));
        //log.info(recommendMusic.getMusicGroup(1,10).get(1));
    }
    /*public ResponseEntity<byte[]> download1(String fileName, File file) throws IOException {
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
    public static void downLoad2(HttpServletResponse response, File file)
    {
        if (file == null || !file.exists()) { return; } OutputStream out = null;
        try {
            response.reset(); response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            out = response.getOutputStream();
            out.write(FileUtils.readFileToByteArray(file));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

}
