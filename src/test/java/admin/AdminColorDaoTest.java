package admin;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.minsales.admin.bean.Admin;
import com.minsales.admin.bean.Color;
import com.minsales.admin.bean.Province;
import com.minsales.admin.dao.AdminColorDao;
import com.minsales.admin.dao.AdminLoginDao;
import com.minsales.admin.dao.AdminProvinceDao;
import com.minsales.admin.utils.AdminUtils;

import java.util.*;
public class AdminColorDaoTest {

	
	private AdminColorDao dao;

    @Before
    public void setUp() {
        @SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/application-context.xml");
        this.dao = (AdminColorDao)ac.getBean("adminColorDao");
    }

    @Test
    public void insert()
    {
    	Color d=new Color();
    	d.setName("test");
    	
    	int c=this.dao.add(d);
    	System.out.println(c);
    	
    }
    @Test
    public void query()
    {
    	Color color=new Color();
    	List<Color> list=this.dao.query(color);
    	for(Color d:list)
    	{
    		System.out.println(d.getId()+","+d.getName());
    	}
    }
    
    @Test
    public void update()
    {
    	Color d=new Color();
    	d.setId(4);
    	d.setName("test2");
    	
    	int c=this.dao.update(d);
    	System.out.println(c);
    }
    
    @Test
    public void delete()
    {
    	Color d=new Color();
    	d.setId(4);
    	
    	int c=this.dao.delete(d);
    	System.out.println(c);
    }
    
    @Test
    public void query2()
    {
    	Color color=new Color();
    	color.setName("r");
    	List<Color> list=this.dao.query(color);
    	for(Color d:list)
    	{
    		System.out.println(d.getId()+","+d.getName());
    	}
    }
    
	
}
