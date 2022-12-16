/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.armantec.lms.common.util.services.service.impl;

import com.armantec.lms.common.util.services.service.base.TimeUtilServiceLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.armantec.lms.common.util.services.service.base.TimeUtilServiceLocalServiceBaseImpl;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the time util service local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.armantec.lms.common.util.services.service.TimeUtilServiceLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimeUtilServiceLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.armantec.lms.common.util.services.model.TimeUtilService",
	service = AopService.class
)
public class TimeUtilServiceLocalServiceImpl
	extends TimeUtilServiceLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.armantec.lms.common.util.services.service.TimeUtilServiceLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.armantec.lms.common.util.services.service.TimeUtilServiceLocalServiceUtil</code>.
	 */
	

	 public  String getTime(long remainingTrial) {
	        String str = "";
	        long secondsTrial = remainingTrial / 1000;
	        long minutesTrial = secondsTrial / 60;
	        long hoursTrial = minutesTrial / 60;

	        if (hoursTrial > 0) {
	            str = getNoOfHoursString(hoursTrial, remainingTrial);
	        } else if (minutesTrial > 0) {
	            str = getNoOfMinutesString(minutesTrial);
	        }
	        if(str.equals("")){
	        	
	        	str = "0 "+LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(),"hrs","hrs");
	        }
	        return str;
	    }
	
	    private  String getNoOfHoursString(long hrsTrial, long remainingTrial) {
	        String str = " ";
	        if (hrsTrial > 0) {
	            if (hrsTrial == 1) {
	                str = hrsTrial + " "+LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(),"hr","hr");
	            } else if (hrsTrial > 1) {
	                str = hrsTrial + " "+LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(),"hrs","hrs");
	            }
	            long remMilliSec = remainingTrial - (hrsTrial * 3600000l);
	            long tmpHoursTrial = ((remMilliSec / 1000) / 60);
	            str += " " + getNoOfMinutesString(tmpHoursTrial);
	        }
	        return str;
	    }

	    private  String getNoOfMinutesString(long minsTrial) {
	        String str = " ";
	        if (minsTrial > 0) {
	            if (minsTrial == 1) {
	                str = minsTrial + " "+LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(),"min","min");
	            } else if (minsTrial > 1) {
	                str = minsTrial + " "+LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(),"mins","mins");;
	            }
	        }
	        return str;
	    }
}