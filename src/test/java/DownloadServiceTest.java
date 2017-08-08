import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wd.model.Download;
import com.wd.service.DownloadService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:spring.xml")
public class DownloadServiceTest {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DownloadService downloadService;
	
	@Test
	public void insert(){
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Download download = new Download();
		download.setStrategy_id(1);
		download.setTime(sdf.format(new Date()));
		downloadService.insert(download);
	}
	
	@Test
	public void seletctList(){
		List<Download> list = downloadService.seletctList();
		
		for (Download temp : list) {
			System.out.println(temp.getDownload_id());
			System.out.println(temp.getStrategy_id());
			System.out.println(temp.getTime());
		}
	}
	
	@Test
	public void seletctByTime(){
	List<Download> list = downloadService.seletctByTime("2017-08-01", "2017-09-01");
		
		for (Download temp : list) {
			System.out.println(temp.getDownload_id());
			System.out.println(temp.getStrategy_id());
			System.out.println(temp.getTime());
		}
	}
}
