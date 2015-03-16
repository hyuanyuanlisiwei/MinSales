package admin;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.minsales.admin.bean.Image;
import com.minsales.admin.dao.AdminImageDao;

import java.util.*;
public class ImageDaoTest {

	
	private AdminImageDao dao;

    @Before
    public void setUp() {
        @SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/application-context.xml");
        this.dao = (AdminImageDao)ac.getBean("adminImageDao");
    }

    @Test
    public void queryGoodsImgAddress()
    {
    	Image image=new Image();
    	image.setGoodsId(28);
    	image.setColorId(2);
    	
    	image=this.dao.queryGoodsImgAddress(image);
    	System.out.println(image.getAddress()+","+image.getAddressBig()+","+image.getAddressSmall());
    	
    }
    
    
    
    @Test
    public void queryCount()
    {
    	Image image=new Image();
    	int total=this.dao.queryCount(image);
    	System.out.println(total);
    }
    
    @Test
    public void query()
    {
    	Image image=new Image();
    	image.setFrom(0);
    	image.setSize(5);
    	
    	List<Image> list=this.dao.query(image);
    	
    	for(Image i:list)
    	{
    		System.out.println(i.getGoodsId()+","+i.getGoodsName());
    	}
    }
    
    @Test
    public void queryGoodsColorImg()
    {
    	Image image=new Image();
    	image.setGoodsId(19);
    	List<Image> list=this.dao.queryGoodsColorImg(image);
    	for(Image im:list)
    	{
    		System.out.println(im.getColorId()+","+im.getColorName());
    	}
    }
    
    
    @Test
    public void deleteGoodsColorImg()
    {
    	Image image=new Image();
    	image.setGoodsId(18);
    	image.setColorId(2);
    	int r=this.dao.deleteGoodsColorImg(image);
    	System.out.println(r);
    }
    
    @Test
    public void insertGoodsColorImg()
    {
    	Image image=new Image();
    	image.setGoodsId(18);
    	image.setColorId(2);
    	image.setAddress("18address");
    	image.setAddressSmall("18addressSmall");
    	image.setAddressBig("18addressBig");
    	int r=this.dao.insertGoodsColorImg(image);
    	System.out.println(r);
    }
    
    @Test
    public void queryGoodsNotColorImg()
    {
    	Image image=new Image();
    	image.setGoodsId(18);
    	List<Image> list=this.dao.queryGoodsNotColorImg(image);
    	for(Image im:list)
    	{
    		System.out.println(im.getColorId()+","+im.getColorName());
    	}
    }
    
    
   
   
}
