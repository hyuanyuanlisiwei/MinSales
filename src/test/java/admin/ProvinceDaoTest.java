package admin;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.minsales.admin.bean.Admin;
import com.minsales.admin.bean.Province;
import com.minsales.admin.dao.AdminLoginDao;
import com.minsales.admin.dao.AdminProvinceDao;
import com.minsales.admin.utils.AdminUtils;

import java.util.*;
public class ProvinceDaoTest {

	
	private AdminProvinceDao dao;

    @Before
    public void setUp() {
        @SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/application-context.xml");
        this.dao = (AdminProvinceDao)ac.getBean("adminProvinceDao");
    }

    @Test
    public void fun1()
    {
    	Province pro=new Province();
    	//pro.setName("山");
    	List<Province> list=this.dao.query(pro);
    	for(Province p:list)
    	{
    		System.out.println(p);
    	}
    }
	
    
    @Test
    public void fun2()
    {
    	Province pro=new Province();
    	pro.setName("山东");
    	int res=this.dao.add(pro);
    	System.out.println(res);
    }
    
    @Test
    public void fun3()
    {
    	Province pro=new Province();
    	pro.setId(8);
    	pro.setName("山西");
    	int res=this.dao.update(pro);
    	System.out.println(res);
    	
    }
    
    @Test
    public void fun4()
    {
    	Province pro=new Province();
    	pro.setId(1);
    	int res=this.dao.delete(pro);
    	System.out.println(res);
    	
    	
    }
    
    @Test
    public void fun5()
    {
    	List<Province> list=this.dao.queryAll();
    	System.out.println(list);
    	
    	
    	
    }
    
    
	
}
