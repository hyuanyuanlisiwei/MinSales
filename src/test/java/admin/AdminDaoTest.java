package admin;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.minsales.admin.bean.Admin;
import com.minsales.admin.dao.AdminLoginDao;
import com.minsales.admin.utils.AdminUtils;

public class AdminDaoTest {

	
	private AdminLoginDao adminDao;

    @Before
    public void setUp() {
        @SuppressWarnings("resource")
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spring/application-context.xml");
        this.adminDao = (AdminLoginDao)ac.getBean("adminLoginDao");
    }

    @Test
    public void fun5()
    {
    	Admin admin=new Admin();
    	admin.setUsername("admin");
    	admin.setPassword(AdminUtils.toMd5("123"));
    	
    	System.out.println(this.adminDao.query(admin));
    }
	
	
}
