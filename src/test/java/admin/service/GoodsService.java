package admin.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.minsales.admin.bean.Goods;
import com.minsales.admin.dao.AdminGoodsDao;
import com.minsales.admin.service.AdminGoodsService;
public class GoodsService {

	private AdminGoodsService service;

    @Before
    public void setUp() {
        @SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/application-context.xml");
        this.service= (AdminGoodsService)ac.getBean("adminGoodsService");
    }

    @Test
    public void addGoods()
    {
    	Goods goods=new Goods();
    	goods.setCategoryId(1);
    	goods.setTitle("woshileshi");
    	goods.setPrice(120);
    	goods.setStock(1234);
    	goods.setDescription("woshi le shi");
    	
    	int r=this.service.add(goods);
    	System.out.println(r);
    	
    	
    	
    }
    
    
    
    
    
    
    
    
	
}
