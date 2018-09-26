package com.slokam.web.util;

import java.beans.PropertyDescriptor;
import java.util.Date;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import com.slokam.web.test.Dao.AuditDao;
import com.slokam.web.test.pojo.AuditPojo;
import com.slokam.web.test.pojo.studentpojo;

public class AuditUtil {

	/*public static void main(String[] args) {
		studentpojo st=new studentpojo();
		st.setAge(12);
		st.setName("adi");
		audit(st, st);
	}*/
	private AuditDao auditDao;
	public void setAuditDao(AuditDao auditDao) {
		this.auditDao = auditDao;
	}
	public  void audit(Object old,Object current){
		
		BeanWrapper oldbw=PropertyAccessorFactory.forBeanPropertyAccess(old);
		BeanWrapper currentBw=PropertyAccessorFactory.forBeanPropertyAccess(current);

		PropertyDescriptor[] prperties=oldbw.getPropertyDescriptors();
		
		for (PropertyDescriptor pd : prperties) {
			String pn=pd.getName();
			Object currentValue=currentBw.getPropertyValue(pn);
			boolean result=false;
			Object oldValue=oldbw.getPropertyValue(pn);
			
			
			System.out.println(pn+"::"+oldValue+"::"+currentValue);
			if(oldValue==null && currentValue!=null){
				result=true;
			}
			else if(oldValue!=null && !oldValue.equals(currentValue)){
				result=true;
			}
			
			if(result){
				String userName=SecurityContextHolder.getContext().getAuthentication().getName();
				AuditPojo audit=new AuditPojo();
				audit.setClassName(old.getClass().getName());
				if(currentValue!=null){
				audit.setCurrentValue(currentValue.toString());
				}else{
					audit.setCurrentValue(null);

				}
				if(oldValue!=null){
				audit.setPreValue(oldValue.toString());
				
				}else{
					
					audit.setPreValue(null);

				}
				audit.setHappendAt(new Date());
				audit.setPropertyName(pn);
				audit.setUid(userName);
				auditDao.saveAudit(audit);
		}
	}
}
}