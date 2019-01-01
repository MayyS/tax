package gdpu.tax.test;

import java.io.IOException;
import java.text.DateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import gdpu.tax.entity.Info;
import gdpu.tax.service.InfoService;
import jodd.io.NetUtil;
import jodd.jerry.Jerry;
import jodd.jerry.JerryFunction;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class getInfoTest {
	@Autowired
	private InfoService infoService;
	private String url="http://www.gd-n-tax.gov.cn/pub/gzsgsww/xxgk/tzgg/gstg/index.html";
	
	@Test
	public void getInfo() throws IOException {
		String html=NetUtil.downloadString(url);
		Jerry doc=Jerry.jerry(html);
		DateFormat df=DateFormat.getDateInstance();
		String xpath=".tab_con_main.box li";
		doc.$(xpath).each(new JerryFunction() {
			

			@Override
			public Boolean onNode(Jerry $this, int index) {
				try {
					Info info=new Info();
					info.setType("通知公告");
					info.setState("0");
					info.setCreator("itcast");
					info.setSource("广州国家税务局");
					info.setTitle($this.$("a").text());
					info.setCreateTime(df.parse($this.$(".date").text()));
					String url=$this.$("a").attr("href").replace("./", "http://www.gd-n-tax.gov.cn/pub/gzsgsww/xxgk/tzgg/gstg/");
					Jerry doc=Jerry.jerry(NetUtil.downloadString(url));
					String content=doc.$(".TRS_Editor p").htmlAll(true);
					info.setContent(content);
					infoService.save(info);
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("数据抓取完成");
				return true;
			}
		});

}
}