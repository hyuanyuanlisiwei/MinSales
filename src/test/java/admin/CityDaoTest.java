package admin;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.minsales.admin.bean.Admin;
import com.minsales.admin.bean.City;
import com.minsales.admin.bean.Province;
import com.minsales.admin.dao.AdminCityDao;
import com.minsales.admin.dao.AdminLoginDao;
import com.minsales.admin.dao.AdminProvinceDao;
import com.minsales.admin.utils.AdminUtils;

import java.util.*;
public class CityDaoTest {

	
	private AdminCityDao dao;

    @Before
    public void setUp() {
        @SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/application-context.xml");
        this.dao = (AdminCityDao)ac.getBean("adminCityDao");
    }

    @Test
    public void insert()
    {
    	City city=new City();
    	city.setParentId(11);
    	city.setName("朝阳");
    	int count=this.dao.add(city);
    	System.out.println(count);
    }
    
    @Test
    public void upate()
    {
    	City city=new City();
    	city.setId(3);
    	city.setName("昌平");
    	int count=this.dao.update(city);
    	System.out.println(count);
    }
    
    @Test
    public void query()
    {
    	City city=new City();
    	city.setName("");
    	city.setParentId(0);
    	city.setFrom(0);
    	city.setSize(10);
    	
    	List<City> list=this.dao.query(city);
    	for(City c: list)
    	{
    		System.out.println(c);
    	}
    }
    
    @Test
    public void queryCount()
    {
    	City city=new City();
    	city.setName("");
    	city.setParentId(0);
    	int count=this.dao.queryCount(city);
    	System.out.println("count----------"+count);
    	
    }
    
    
    
    @Test
    public void delete()
    {
    	City city=new City();
    	city.setId(6);
    	int count=this.dao.delete(city);
    	System.out.println(count);
    }
    
    @Test
    public void queryAll()
    {
    	City city=new City();
    	city.setParentId(11);
    	List<City> list=this.dao.queryAll(city);
    	for(City c:list)
    	{
    		System.out.println(c);
    	}
    }
}
