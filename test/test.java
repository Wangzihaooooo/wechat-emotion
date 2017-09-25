import com.module.recognition.service.TagRelationService;
import com.module.recognition.service.TagService;
import com.module.spider.service.MusicService;
import com.sys.core.RecognitionEmotionService;
import com.sys.core.SpeechDecorderService;
import com.sys.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.io.*;

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
    private MusicService              musicService;
    @Resource
    private SpeechDecorderService     speechDecorderService;
    @Resource
    private RecognitionEmotionService recognitionEmotionService;
    @Test
    public void select() {
        try {
            String encoding = "utf-8";
            File file = new File("C:\\Users\\wangzi\\Desktop\\setting\\silk-v3-decoder-master\\windows\\202.silk");
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                StringBuilder lineTxt = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    lineTxt.append(line);
                }
                read.close();

                String olddata = lineTxt.toString();
                olddata = olddata.replace("data:audio/webm;base64,", "");

                try {
                    File webmFile = new File("C:\\Users\\wangzi\\Desktop\\setting\\silk-v3-decoder-master\\windows\\202.webn");
                    BASE64Decoder base64Decoder=new BASE64Decoder();
                    byte[] bt = base64Decoder.decodeBuffer(olddata) ;
                    //byte[] bt = Base64Util.decode(olddata) ;
                    FileOutputStream in = new FileOutputStream(webmFile);
                    try {
                        in.write(bt, 0, bt.length);
                        in.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                log.warn("找不到指定的文件");
            }
        } catch (Exception e) {
            log.warn("读取文件内容出错");
            e.printStackTrace();
        }
        //创建一个日期对象
        /*Date d=new Date();
        System.out.println(d);
        SimpleDateFormat sdf=new SimpleDateFormat();
        System.out.println(sdf);*/
        //log.info(recognitionEmotion.recognition("209.wav"));
        //log.info(recognitionEmotion.recognition("209a.wav"));
        /*String fileName = PropertyUtil.getProperty("filePath.properties","speech.path")+"\\201.wav";
        String path = PropertyUtil.getProperty("filePath.properties","recognitionPy.path")+"\\Emotion.py";
        fileName="F:\\idea\\weixin\\src\\com\\module\\recognition\\pythonCode\\voice\\201.wav";
        path="F:\\idea\\weixin\\src\\com\\module\\recognition\\pythonCode\\Emotion.py";
        log.info(fileName+path);
        Runtime run = Runtime.getRuntime();
        try {
            // run.exec("cmd /k shutdown -s -t 3600");
            //Process process = run.exec("python D:\\study\\idea\\VoiceTest\\src\\main\\resources\\pythonCode\\test.py");
            String[] cmd={"python"+" "+path+" "+fileName};
            Process process = run.exec(cmd);
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
        }*/



        //log.info( PropertyUtil.getProperty("db-config.properties","jdbc.url"));
        //log.info(PropertyUtil.getProperty("filePath.properties","speech.path"));
        //log.info(musicService.getMusicListBySongId(tagRelationService.selectMusicListByTag(1,5)));
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
