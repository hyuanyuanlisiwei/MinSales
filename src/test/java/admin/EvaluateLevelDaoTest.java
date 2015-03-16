package admin;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.minsales.admin.bean.Admin;
import com.minsales.admin.bean.EvaluateLevel;
import com.minsales.admin.bean.EvaluateLevel;
import com.minsales.admin.dao.AdminLoginDao;
import com.minsales.admin.dao.AdminEvaluateLevelDao;
import com.minsales.admin.utils.AdminUtils;

import java.util.*;
public class EvaluateLevelDaoTest {

	
	private AdminEvaluateLevelDao dao;

    @Before
    public void setUp() {
        @SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/application-context.xml");
        this.dao = (AdminEvaluateLevelDao)ac.getBean("adminEvaluateLevelDao");
    }

    @Test
    public void insert()
    {
    	EvaluateLevel d=new EvaluateLevel();
    	d.setName("test");
    	
    	int c=this.dao.add(d);
    	System.out.println(c);
    	
    }
    @Test
    public void query()
    {
    	EvaluateLevel color=new EvaluateLevel();
    	List<EvaluateLevel> list=this.dao.query(color);
    	for(EvaluateLevel d:list)
    	{
    		System.out.println(d.getId()+","+d.getName());
    	}
    }
    
    @Test
    public void update()
    {
    	EvaluateLevel d=new EvaluateLevel();
    	d.setId(4);
    	d.setName("test2");
    	
    	int c=this.dao.update(d);
    	System.out.println(c);
    }
    
    @Test
    public void delete()
    {
    	EvaluateLevel d=new EvaluateLevel();
    	d.setId(4);
    	
    	int c=this.dao.delete(d);
    	System.out.println(c);
    }
    
    @Test
    public void query2()
    {
    	EvaluateLevel color=new EvaluateLevel();
    	color.setName("好");
    	List<EvaluateLevel> list=this.dao.query(color);
    	for(EvaluateLevel d:list)
    	{
    		System.out.println(d.getId()+","+d.getName());
    	}
    }
    
    
	
}
