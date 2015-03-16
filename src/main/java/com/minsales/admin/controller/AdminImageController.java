package com.minsales.admin.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.minsales.admin.service.AdminCategoryService;
import com.minsales.admin.service.AdminColorService;
import com.minsales.admin.service.AdminGoodsService;
import com.minsales.admin.service.AdminImageService;
import com.minsales.base.BaseController;
import com.minsales.base.ExecuteResult;
import com.minsales.base.Pagination;
import com.minsales.base.ResultCode;
import com.minsales.admin.bean.*;

import java.io.File;
import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping("/AdminImageController")
public class AdminImageController extends BaseController {

	@Autowired
	private AdminImageService adminImageService;
	@Autowired
	private AdminGoodsService adminGoodsService;
	@Autowired
	private AdminColorService adminColorService;
	@Autowired
	private AdminCategoryService adminCategoryService;
	
	
	
	//query all category
	
	@RequestMapping("/queryAllCategory.do")
	@ResponseBody
	public List<Category> queryAllCategory(Category category)
	{
		List<Category> list=this.adminCategoryService.query(category);
		Category first=new Category();
		first.setId(0);
		first.setName("全部...");
		
		list.add(0,first);
		
		return list;
	}
	
	//query all goods by category id;
	@RequestMapping("/queryAllGoodsByCategoryId.do")
	@ResponseBody
	public List<Goods> queryAllGoodsByCategoryId(Goods goods)
	{
		List<Goods> list=this.adminGoodsService.queryByCategoryId(goods);
		Goods first=new Goods();
		first.setId(0);
		first.setTitle("全部...");
		
		list.add(0, first);
		
		return list;
	}
	//query all goods that have color and img;
	@RequestMapping("/query.do")
	public String  query(Image image,ModelMap map)
	{
		//get total;
		int total=this.adminImageService.queryCount(image);
		//get rows;
		Pagination pagination=new Pagination(image.getPage(),image.getRows());
		//设置froma and size;
		image.setFrom(pagination.getFormIndex());
		image.setSize(pagination.getSize());
		
		List<Image> rows=this.adminImageService.query(image);
		//return total and rows;
		map.put("total", total);
		map.put("rows", rows);
		
		return "json";
	}
	// query all color that the unique goods have;
	@RequestMapping("/queryGoodsColorImg.do")
	@ResponseBody
	public List<Image> queryGoodsColorImg(Image image) {
		return this.adminImageService.queryGoodsColorImg(image);
	}

	// query all color that the unique goods don't have;
	@RequestMapping("/queryGoodsNotColorImg.do")
	@ResponseBody
	public List<Image> queryGoodsNotColorImg(Image image) {
		return this.adminImageService.queryGoodsNotColorImg(image);
	}
	
	//insert the color and img to the unique goods;
	@RequestMapping("/insertGoodsColorImg.do")
	public String insertGoodsColorImg(Image image,@RequestParam("files") MultipartFile[] files,ModelMap map) throws IOException
	{
		//prepare result;
		ExecuteResult<String> result=new ExecuteResult<String>();
		// execute controller
		int count = this.adminImageService.insertGoodsColorImg(image);

		result.setInfo("添加了" + count + "行数据!");
		if (count > 0) {
			//物理保存数据;
			//保存图片的格式为:id.jpg , id_big.jpg, id_small.jpg;
			
			for(int i=0;i<files.length;i++)
			{
				MultipartFile file=files[i];
				//保存到upload中;
				String upload=super.getSession().getServletContext().getRealPath("upload");
				File dirs=new File(upload);
				if(!dirs.exists())
				{
					dirs.mkdir();
				}
				//正式保存;
				//原始文件名
				String fileName=file.getOriginalFilename();
				//文件扩展名;
				String ext=fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
				//重命名之后的文件名
				String name="";
				//重命名文件;
				if(i==0)
				{
					//原始文件;
					name=image.getId()+ext;
					
					image.setAddress(name);
					
				}else if(i==1)
				{
					//大图片：
					name=image.getId()+"_"+"big"+ext;
					image.setAddressBig(name);
					
				}else if(i==2)
				{
					//小图片;
					name=image.getId()+"_"+"small"+ext;
					image.setAddressSmall(name);
				}
				//物理保存;
				File saveFile=new File(upload,name);
				FileUtils.copyInputStreamToFile(file.getInputStream(),saveFile);
			}
			//保存该文件的image address到数据库;
			int saveResult=this.adminImageService.insertGoodsImgAddress(image);
			//判断是否保存成功：
			if(saveResult>0)
			{
				result.setCode(ResultCode.SUCCESS.code);
				result.setMsg("添加成功！");
			}else
			{
				result.setCode(ResultCode.FAIL.code);
				result.setMsg("保存图片路径失败!");
			}

		} else {
			result.setCode(ResultCode.FAIL.code);
			result.setMsg("添加失败!");
		}
		
		
		//return result;
		map.put("result",result);
		
		//返回原页面;
		return "admin/image";
		
	}
	
	
	//delete the color and img that the unique goods;
	@RequestMapping("/deleteGoodsColorImg.do")
	@ResponseBody
	public ExecuteResult<String> deleteGoodsColorImg(Image image)
	{
		//prepare result;
		ExecuteResult<String> result=new ExecuteResult<String>();
		//先查出该商品指定颜色的三张图片的地址,然后物理删除；
        image=this.adminImageService.queryGoodsImgAddress(image);
		//物理删除;
        String upload=this.getSession().getServletContext().getRealPath("upload");
		File file=new File(upload+"/"+image.getAddress());
		FileUtils.deleteQuietly(file);
		
		file=new File(upload+"/"+image.getAddressBig());

		FileUtils.deleteQuietly(file);
		
		file=new File(upload+"/"+image.getAddressSmall());
		System.out.println(file.getAbsolutePath());

		FileUtils.deleteQuietly(file);
		
		
		//execute controller
		int count=this.adminImageService.deleteGoodsColorImg(image);
		
		result.setInfo("删除了"+count+"行数据!");
		if(count>0)
		{
			result.setCode(ResultCode.SUCCESS.code);
			result.setMsg("删除成功！");
			
		}else
		{
			result.setCode(ResultCode.FAIL.code);
			result.setMsg("删除失败!");
		}
		//return result;
		return result;
	}
}
