package demo1;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.minsales.base.ResultCode;

import java.io.*;
public class Demo2 {

	@Test
	public void fun1() throws IOException
	{
		String str="Hello";
	    InputStream is=IOUtils.toInputStream(str);
		File dir=new File("H:/upload");
	    dir.mkdir();
	    File file=new File(dir,"file.txt");
	    FileUtils.copyInputStreamToFile(is, file);
		
	    
	}
	
}
