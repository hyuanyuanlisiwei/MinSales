package admin;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.minsales.admin.bean.Admin;
import com.minsales.admin.bean.Delivery;
import com.minsales.admin.bean.Province;
import com.minsales.admin.dao.AdminDeliveryDao;
import com.minsales.admin.dao.AdminLoginDao;
import com.minsales.admin.dao.AdminProvinceDao;
import com.minsales.admin.utils.AdminUtils;

import java.util.*;
public class AdminDeliveryDaoTest {

	
	private AdminDeliveryDao dao;

    @Before
    public void setUp() {
        @SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/application-context.xml");
        this.dao = (AdminDeliveryDao)ac.getBean("adminDeliveryDao");
    }

    @Test
    public void insert()
    {
    	Delivery d=new Delivery();
    	d.setName("test");
    	
    	int c=this.dao.add(d);
    	System.out.println(c);
    	
    }
    @Test
    public void query()
    {
    	Delivery delivery=new Delivery();
    	List<Delivery> list=this.dao.query(delivery);
    	for(Delivery d:list)
    	{
    		System.out.println(d.getId()+","+d.getName());
    	}
    }
    
    @Test
    public void update()
    {
    	Delivery d=new Delivery();
    	d.setId(7);
    	d.setName("test2");
    	
    	int c=this.dao.update(d);
    	System.out.println(c);
    }
    
    @Test
    public void delete()
    {
    	Delivery d=new Delivery();
    	d.setId(7);
    	
    	int c=this.dao.delete(d);
    	System.out.println(c);
    }
    
    @Test
    public void query2()
    {
    	Delivery delivery=new Delivery();
    	delivery.setName("东");
    	List<Delivery> list=this.dao.query(delivery);
    	for(Delivery d:list)
    	{
    		System.out.println(d.getId()+","+d.getName());
    	}
    }
    
	
}
