package admin;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.minsales.admin.bean.Admin;
import com.minsales.admin.bean.City;
import com.minsales.admin.bean.Goods;
import com.minsales.admin.bean.Province;
import com.minsales.admin.dao.AdminCityDao;
import com.minsales.admin.dao.AdminGoodsDao;
import com.minsales.admin.dao.AdminLoginDao;
import com.minsales.admin.dao.AdminProvinceDao;
import com.minsales.admin.utils.AdminUtils;

import java.util.*;
public class GoodsDaoTest {

	
	private AdminGoodsDao dao;

    @Before
    public void setUp() {
        @SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/application-context.xml");
        this.dao = (AdminGoodsDao)ac.getBean("adminGoodsDao");
    }

   
    @Test
    public void insert()
    {
    	Goods goods=new Goods();
    	goods.setCategoryId(2);
    	goods.setTitle("乐视牌");
    	goods.setPrice(3000);
    	goods.setStock(123);
    	goods.setDescription("我们是乐视牌电视机");
    	int r=this.dao.add(goods);
    	System.out.println(goods.getId());
    	System.out.println(r);
    }
    
    @Test
    public void update()
    {
    	Goods goods=new Goods();
    	goods.setId(2);
    	goods.setTitle("乐视test2");
    	goods.setPrice(4000);
    	goods.setStock(223);
    	int r=this.dao.update(goods);
    	System.out.println(r);
    }
    
    @Test
    public void delete()
    {
    	Goods goods=new Goods();
    	goods.setId(2);
    	int r=this.dao.delete(goods);
    	System.out.println(r);
    }
    
    @Test
    public void queryByCategoryId()
    {
    	Goods goods=new Goods();
    	goods.setCategoryId(1);
    	List<Goods> list=this.dao.queryByCategoryId(goods);
    	for(Goods g:list)
    	{
    		System.out.println(g.getId()+","+g.getTitle());
    	}
    }
    
    
    
}
