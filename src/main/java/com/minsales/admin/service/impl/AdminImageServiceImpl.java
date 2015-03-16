package com.minsales.admin.service.impl;

import java.util.List;

import com.minsales.admin.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minsales.admin.bean.Image;
import com.minsales.admin.service.AdminImageService;
@Service("adminImageServcie")
public class AdminImageServiceImpl implements AdminImageService {

	@Autowired
	private AdminImageDao adminImageDao;
	
	
	@Override
	public List<Image> query(Image image) {
		// TODO Auto-generated method stub
		return this.adminImageDao.query(image);
	}

	@Override
	public int queryCount(Image image) {
		// TODO Auto-generated method stub
		return this.adminImageDao.queryCount(image);
	}

	@Override
	public List<Image> queryGoodsColorImg(Image image) {
		// TODO Auto-generated method stub
		return this.adminImageDao.queryGoodsColorImg(image);
	}

	@Override
	public int deleteGoodsColorImg(Image image) {
		// TODO Auto-generated method stub
		return this.adminImageDao.deleteGoodsColorImg(image);
	}

	@Override
	public int insertGoodsColorImg(Image image) {
		// TODO Auto-generated method stub
		return this.adminImageDao.insertGoodsColorImg(image);
	}

	@Override
	public List<Image> queryGoodsNotColorImg(Image image) {
		// TODO Auto-generated method stub
		return this.adminImageDao.queryGoodsNotColorImg(image);
	}

	@Override
	public int insertGoodsImgAddress(Image image) {
		// TODO Auto-generated method stub
		return this.adminImageDao.insertGoodsImgAddress(image);
	}

	@Override
	public Image queryGoodsImgAddress(Image image) {
		// TODO Auto-generated method stub
		return this.adminImageDao.queryGoodsImgAddress(image);
	}
}
