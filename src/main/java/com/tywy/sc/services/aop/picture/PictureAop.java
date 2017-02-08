package com.tywy.sc.services.aop.picture;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tywy.sc.data.model.SystemPictureInfo;
import com.tywy.sc.services.SystemPictureInfoService;
import com.tywy.utils.UUIDUtil;
import com.tywy.utils.stream.util.StreamVO;

@Aspect
@Component
public class PictureAop {
	
	@Autowired
	private SystemPictureInfoService pictureInfoService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Around("@annotation(picture)")
    public Object pictured(final ProceedingJoinPoint pjp,Pictureable picture) throws Throwable {
		Object[] args = pjp.getArgs();
		Annotation[][] pas = ((MethodSignature)pjp.getSignature()).getMethod().getParameterAnnotations();
		StreamVO stream = null;
        for(int i=0;i<pas.length;i++) {
        	for(Annotation an:pas[i]) {  
        		if(an instanceof PictureKey) {
        			stream = (StreamVO)args[i];
        			break;
        		}  
        	}
        }
		if(stream == null){
			return null;
		}
		SystemPictureInfo pictureInfo = new SystemPictureInfo();
		pictureInfo.setId(UUIDUtil.getUUID());
		pictureInfo.setUuid(UUIDUtil.getUUID());
		pictureInfo.setUrlPath(stream.getUrlPath());
		pictureInfo.setFwidth(stream.getFwidth());
		pictureInfo.setFheight(stream.getFheight());
		pictureInfo.setFsize((int)stream.getSize());
		pictureInfo.setSuffix(stream.getSuffix());
		pictureInfo.setName(stream.getName());
		pictureInfo.setCdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		int result = pictureInfoService.insert(pictureInfo);
		if(result > 0){
			Object entity = args[0];
			Class entityClass = entity.getClass();
			Field field = entityClass.getDeclaredField("imgUuid");
			
			String fieldSetName = parSetName(field.getName());
			Method fieldSetMet = entityClass.getMethod(fieldSetName,field.getType());
			fieldSetMet.invoke(entity, pictureInfo.getUuid());
		}		
		return pjp.proceed();
    }
    
    private String parSetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {  
            return null;
        }  
        int startIndex = 0;  
        if (fieldName.charAt(0) == '_')  
            startIndex = 1;  
        return "set"  
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()  
                + fieldName.substring(startIndex + 1);  
    } 
}
