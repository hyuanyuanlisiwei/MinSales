package com.minsales.client.bean;

public class ClientIndexBean {

	//公告;
	private int noticeId;
	private String noticeName;
	
	//商品分类;
	private int categoryId;
	private String categoryName;
	
	//商品;
	private int goodsId;
	private int type;//1:分类，0：商品;
	private String address;
	private String addressSmall;
	private String addressBig;
	private String title;
	private double price;
	private double stock;
	private String description;
	private int scores;
	
	//查询的方式
	//三种方式:categoryId,categoryName,title
	private String queryType;
	
	
	//分页
	private int from;
	private int size;
	
	private int page;
	private int rows;
	
	
	@Override
	public String toString() {
		return "ClientIndexBean [goodsId=" + goodsId + ", address=" + address
				+ ", title=" + title + ", price=" + price + ", stock=" + stock
				+ ", description=" + description + "]";
	}
	
	
	
	
	public String getQueryType() {
		return queryType;
	}




	public void setQueryType(String queryType) {
		this.queryType = queryType;
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




	public int getPage() {
		return page;
	}




	public void setPage(int page) {
		this.page = page;
	}




	public int getRows() {
		return rows;
	}




	public void setRows(int rows) {
		this.rows = rows;
	}




	public int getGoodsId() {
		return goodsId;
	}




	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}




	public int getType() {
		return type;
	}




	public void setType(int type) {
		this.type = type;
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




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public double getStock() {
		return stock;
	}




	public void setStock(double stock) {
		this.stock = stock;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeName() {
		return noticeName;
	}
	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
