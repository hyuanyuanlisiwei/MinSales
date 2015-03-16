package client;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.minsales.admin.dao.AdminColorDao;
import com.minsales.client.bean.ClientIndexBean;
import com.minsales.client.dao.ClientIndexDao;

public class IndexDao {

	private ClientIndexDao dao;

    @Before
    public void setUp() {
        @SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/application-context.xml");
        this.dao = (ClientIndexDao)ac.getBean("clientIndexDao");
    }
	
    @Test
    public void demo1()
    {
    	System.out.println(this.dao);
    	
    	
    }
    
    
    
    @Test
    public void queryAllNoticeTest()
    {
    	List<ClientIndexBean> list=this.dao.queryAllNotice();
    	for(ClientIndexBean bean:list)
    	{
    		System.out.println(bean.getNoticeId()+","+bean.getNoticeName());
    	}
    }
    
    
    @Test
    public void queryAllCategoryTest()
    {
    	List<ClientIndexBean> list=this.dao.queryAllCategory();
    	for(ClientIndexBean bean:list)
    	{
    		System.out.println(bean.getCategoryId()+","+bean.getCategoryName());
    	}
    }
    
	
    @Test
    public void queryAllByCategoryIdTest()
    {
    	ClientIndexBean bean=new ClientIndexBean();
    	bean.setCategoryId(6);
    	List<ClientIndexBean> list=this.dao.queryAllGoodsByCategoryId(bean);
    	for(ClientIndexBean b:list)
    	{
    		System.out.println(b);
    	}
    }
    
    @Test
    public void queryCountByCategoryIdTest()
    {
    	ClientIndexBean bean=new ClientIndexBean();
    	bean.setCategoryId(6);
    	int r=this.dao.queryAllGoodsCountByCategoryId(bean);
    	System.out.println(r);
    }
    @Test
    public void queryCountByCategoryNameTest()
    {
    	ClientIndexBean bean=new ClientIndexBean();
    	bean.setCategoryName("手");
    	int r=this.dao.queryAllGoodsCountByCategoryName(bean);
    	System.out.println(r);
    }
    
    
    
    
    
    @Test
    public void queryAllByGoodsNameTest()
    {
    	ClientIndexBean bean=new ClientIndexBean();
    	bean.setTitle("星");
    	
    	List<ClientIndexBean> list=this.dao.queryAllGoodsByGoodsName(bean);
    	
    	for(ClientIndexBean b:list)
    	{
    		System.out.println(b);
    	}
    }
    
    
    @Test
    public void queryCountByGoodsNameTest()
    {
    	ClientIndexBean bean=new ClientIndexBean();
    	bean.setTitle("星");
    	
    	int r=this.dao.queryAllGoodsCountByGoodsName(bean);
    	System.out.println(r);
    }
    
    
    
	
}
