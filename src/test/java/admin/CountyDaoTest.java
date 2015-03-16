package admin;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.minsales.admin.bean.Admin;
import com.minsales.admin.bean.County;
import com.minsales.admin.dao.AdminCountyDao;
import com.minsales.admin.dao.AdminLoginDao;
import com.minsales.admin.utils.AdminUtils;

public class CountyDaoTest {

	
	private AdminCountyDao dao;

    @Before
    public void setUp() {
        @SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/application-context.xml");
        this.dao = (AdminCountyDao)ac.getBean("adminCountyDao");
    }

    @Test
    public void insert()
    {
    	County c=new County();
    	c.setProvinceId(11);
    	c.setCityId(1);
    	c.setName("test");
    	int r=this.dao.add(c);
    	System.out.println(r);
    }
    @Test
    public void update()
    {
    	County c=new County();
    	c.setId(6);
    	c.setName("test2");
    	int r=this.dao.update(c);
    	System.out.println(r);
    }
    
    @Test
    public void delete()
    {
    	County c=new County();
    	c.setId(6);
    	int r=this.dao.delete(c);
    	System.out.println(r);
    }
    
    @Test
    public void queryAll()
    {
    	County c=new County();
    	c.setCityId(1);
    	List<County> list=this.dao.queryAll(c);
    	for(County l:list)
    	{
    		System.out.println(l);
    	}
    }
    
    @Test
    public void query()
    {
    	County c=new County();
    	c.setCityId(1);
    	c.setProvinceId(11);
    	c.setName("天");
    	c.setFrom(0);
    	c.setSize(3);
    	
    	List<County> list=this.dao.query(c);
    	for(County l:list)
    	{
    		System.out.println(l.getId()+","+l.getName()+","+l.getProvinceName()+","+l.getCityName());
    	}
    }
    
    @Test
    public void queryCount()
    {
    	County c=new County();
    	c.setCityId(1);
    	c.setProvinceId(11);
    	c.setName("天");
    	
    	int r=this.dao.queryCount(c);
    	System.out.println(r);
    }
    
    
    
    
    
    
    
}
