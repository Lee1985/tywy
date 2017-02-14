package com.tywy.sc.services.aop.picture;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
	private SystemPictureInfoService systemPictureInfoService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Around("@annotation(picture)")
    public Object pictured(final ProceedingJoinPoint pjp,Pictureable picture) throws Throwable {
		Object[] args = pjp.getArgs();
		Annotation[][] pas = ((MethodSignature)pjp.getSignature()).getMethod().getParameterAnnotations();
        for(int i=0;i<pas.length;i++) {
        	for(Annotation an:pas[i]) {  
        		if(an instanceof PictureKey) {
        			if(args[i] == null){
        				continue;
        			}
        			StreamVO stream = (StreamVO)args[i];
        			if(stream == null){
        				continue;
        			}
        			SystemPictureInfo pictureInfo = insertPictureInfo(stream);
        			if(pictureInfo != null){
        				Object entity = args[0];
        				Class entityClass = entity.getClass();
        				Field field = entityClass.getDeclaredField("imgUuid");        				
        				String fieldSetName = parSetName(field.getName());
        				Method fieldSetMet = entityClass.getMethod(fieldSetName,field.getType());
        				fieldSetMet.invoke(entity, pictureInfo.getUuid());
        			}
        		}else if(an instanceof PictureIconKey){
        			Map<String,Object> map = (Map<String,Object>)args[i];
        			if(map == null || map.isEmpty()){
        				continue;
        			}
        			SystemPictureInfo pictureInfo = insertPictureInfo(map);
        			if(pictureInfo != null){
        				Object entity = args[0];
        				Class entityClass = entity.getClass();
        				Field field = entityClass.getDeclaredField("iconUrl");        				
        				String fieldSetName = parSetName(field.getName());
        				Method fieldSetMet = entityClass.getMethod(fieldSetName,field.getType());
        				fieldSetMet.invoke(entity, pictureInfo.getUrlPath());
        			}
        		}
        	}
        }
		return pjp.proceed();
    }
	
	private SystemPictureInfo insertPictureInfo(StreamVO stream){
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
		int result = systemPictureInfoService.insert(pictureInfo);
		if(result <= 0){
			return null;
		}
		return pictureInfo;
	}
	
	private SystemPictureInfo insertPictureInfo(Map<String,Object> map){
		SystemPictureInfo pictureInfo = new SystemPictureInfo();
		String prefix = (String)map.get("prefix");
		pictureInfo.setId(UUIDUtil.getUUID());
		pictureInfo.setUuid(UUIDUtil.getUUID());
		pictureInfo.setUrlPath((String)map.get(prefix + "_urlPath"));
		pictureInfo.setFwidth(Integer.parseInt((String)map.get(prefix + "_fwidth")));
		pictureInfo.setFheight(Integer.parseInt((String)map.get(prefix + "_fheight")));
		pictureInfo.setFsize(Integer.parseInt((String)map.get(prefix + "_size")));
		pictureInfo.setSuffix((String)map.get(prefix + "_suffix"));
		pictureInfo.setName((String)map.get(prefix + "_name"));
		pictureInfo.setCdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		int result = systemPictureInfoService.insert(pictureInfo);
		if(result <= 0){
			return null;
		}
		return pictureInfo;
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