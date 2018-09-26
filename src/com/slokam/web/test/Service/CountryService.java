package com.slokam.web.test.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.web.test.Dao.CountryDao;
import com.slokam.web.test.pojo.Countrypojo;
import com.slokam.web.test.pojo.StatePojo;

@Service
public class CountryService {

	@Autowired
	private CountryDao countryDao;
	
	
	public List<Countrypojo> getAllCountrys(){
		return (List<Countrypojo>)	countryDao.getAllCountrys();
		
		
	}
	public List<StatePojo> getStatesById(Integer cid){
		return countryDao.getStatesById(cid);
	}
}
