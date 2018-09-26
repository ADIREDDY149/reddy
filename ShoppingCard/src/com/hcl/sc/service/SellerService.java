package com.slokam.sc.service;

import java.util.List;

import javax.transaction.Transactional;

import com.slokam.sc.Dao.SellerDao;
import com.slokam.sc.pojo.billpojo;
import com.slokam.sc.pojo.sellerpojo;


public class SellerService {

	private SellerDao sellerDao;

	public void setSellerDao(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
	}
	public void SellerSave(sellerpojo seller){
		
		sellerDao.SellerSave(seller);
		
		
	}
	public List<sellerpojo> getallseller(){
		
		return sellerDao.getallseller();
	}
	public sellerpojo getsellerById(Integer id){
		return sellerDao.getsellerById(id);
		
	}
	
	
	public void Updateseller(sellerpojo seller){
		
		sellerDao.Updateseller(seller);
		
	}
	
	public void Deleteseller(sellerpojo seller){
		
		sellerDao.Deleteseller(seller);
		
	}
	// orders by buyerpge another controller
	public void billsave(billpojo bill){
		sellerDao.billsave(bill);
	}
	
	public List<billpojo> getbill(){
		return sellerDao.getbill();
		
	}
	public billpojo getBuyuyerById(Integer id){
		return sellerDao.getBuyuyerById(id);
		
	}
	
public void Updateorder(billpojo bill){
		
		sellerDao.Updateorder(bill);
		
	}
	
	public void Deleteorder(billpojo bill){
		
		sellerDao.Deleteorder(bill);
		
	}
}
