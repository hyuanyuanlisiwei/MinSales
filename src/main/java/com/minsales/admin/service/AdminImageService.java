package com.minsales.admin.service;
import java.util.*;

import com.minsales.admin.bean.*;
public interface AdminImageService {

	public List<Image> query(Image image);
	
	public int queryCount(Image image);

	public List<Image> queryGoodsColorImg(Image image);
	
	public int deleteGoodsColorImg(Image image);
	
	public int insertGoodsColorImg(Image image);
	
	public int insertGoodsImgAddress(Image image);
	
	public List<Image> queryGoodsNotColorImg(Image image);
	
	public Image queryGoodsImgAddress(Image image);
}
