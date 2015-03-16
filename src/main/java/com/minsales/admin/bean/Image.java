package com.minsales.admin.bean;

public class Image {

	//添加到数据库中goodsId,colorId后，返回的主键;
	private int id;
	
	
	//column
	private int goodsId;//goodsId;
	private String  goodsName;
	
	//view color;
	private int colorId;
	private String colorName;
	
	//上传图片；
	private String address;
	private String addressSmall;
	private String addressBig;
	
	
	//pagination
	private int rows;
	private int page;
	
	//generate data;
	private int from;
	private int size;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressSmall() {
		return addressSmall;
	}
	public void setAddressSmall(String addressSmall) {
		this.addressSmall = addressSmall;
	}
	public String getAddressBig() {
		return addressBig;
	}
	public void setAddressBig(String addressBig) {
		this.addressBig = addressBig;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	//---------------
	
}
