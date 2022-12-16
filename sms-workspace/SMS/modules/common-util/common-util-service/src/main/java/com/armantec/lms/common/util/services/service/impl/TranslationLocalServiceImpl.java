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

import com.armantec.lms.common.util.services.exception.NoSuchTranslationException;
import com.armantec.lms.common.util.services.model.Translation;
import com.armantec.lms.common.util.services.service.base.TranslationLocalServiceBaseImpl;
import com.armantec.lms.constants.SearchConstants;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.lock.LockManagerUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.PropsUtil;
//import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.lock.model.Lock;
import com.liferay.portal.lock.service.LockLocalService;
import com.liferay.portal.lock.service.persistence.LockPersistence;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the translation local service.
 *
 *
 * @author Brian Wing Shun Chan
 * @see TranslationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.armantec.lms.common.util.services.model.Translation", service = AopService.class)
public class TranslationLocalServiceImpl extends TranslationLocalServiceBaseImpl {

	public JSONArray getSupportedLocales() throws SystemException, PortalException {
		//Set<Locale> localeArr = LanguageUtil.getSupportedLocales();
		Set<Locale> localeArr = getSiteSupportedLocales();
		//Collections.reverse(Arrays.asList(localeArr));
		JSONArray localeJsonArr = JSONFactoryUtil.createJSONArray();
		for (Locale locale : localeArr) {
			JSONObject localeJsonObj = JSONFactoryUtil.createJSONObject();

			localeJsonObj.put("languageCode", locale.getLanguage());
			localeJsonObj.put("localeCode", locale.toString());
			localeJsonObj.put("displayName", locale.getDisplayName(locale));

			localeJsonArr.put(localeJsonObj);
		}
		return localeJsonArr;
	}
	
	
	
	public Set<Locale> getSiteSupportedLocales() throws SystemException, PortalException {
		//Set<Locale> localeArr = LanguageUtil.getSupportedLocales();
		long siteScopeId = Long.parseLong(PropsUtil.get("api.permission.scopegroup.id"));
		return LanguageUtil.getAvailableLocales(siteScopeId);
	}

	public JSONObject getDefaultJson() {
		JSONObject localeJsonObj = JSONFactoryUtil.createJSONObject();
		localeJsonObj.put("localeCode1", com.liferay.portal.kernel.util.LocaleUtil.getDefault().toString());
		localeJsonObj.put("localeCode2", LanguageUtil.getLanguage().toString());
		localeJsonObj.put("localeCode3", LocaleThreadLocal.getThemeDisplayLocale().toString());
		localeJsonObj.put("localeCode4", LocaleThreadLocal.getDefaultLocale().toString());
		return localeJsonObj;
	}

	public String getDefault() {
		return com.liferay.portal.kernel.util.LocaleUtil.getDefault().toString();
	}

	public Locale getDefaultLocale() {
		return com.liferay.portal.kernel.util.LocaleUtil.getDefault();
	}

	public JSONArray searchTopics(String searchKey, ServiceContext serviceContext) {
		List<String> translationList = search(searchKey, SearchConstants.TOPIC_SEARCH_COLUMN_NAME,
				SearchConstants.TOPIC_MODEL_NAME,serviceContext);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		int i = 0;
		for(String translation:translationList) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id",i++);
			jsonObject.put("text",translation);
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}

	public  List<String> search(String searchKey, String columnName, String modelName,ServiceContext serviceContext) {
		List<Organization> organizations = null;
        long userOrganizationId = 0;
		try {

			organizations = organizationLocalService.getUserOrganizations(PrincipalThreadLocal.getUserId(), false);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		if (organizations != null && organizations.size() > 0) {
			for (Organization org : organizations) {
				if (!org.getType().equalsIgnoreCase("Location")) {
					userOrganizationId = org.getOrganizationId();
				}
			}
		}
		DynamicQuery query = getDynamicQuery(userOrganizationId, searchKey,
				columnName, modelName,serviceContext.getLocale().toString());
		//query.setProjection(ProjectionFactoryUtil
				//.distinct(ProjectionFactoryUtil.property("text")));
		 ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		    projectionList.add(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.groupProperty("text")));
		   // projectionList.add(ProjectionFactoryUtil.property("recordId"));
		    query.setProjection(projectionList);

		return dynamicQuery(query, 0, SearchConstants.TOPIC_SEARCH_DELTA);
	}
	
	public List<Translation> search(long entryId, String columnName, String modelName,long groupId) {
		
		DynamicQuery query = getDynamicQuery(groupId,
				columnName, modelName,entryId);
		return dynamicQuery(query);
	}
	
	
public List<Translation> search(long entryId, String columnName, String modelName) {
		
		List<Organization> organizations = null;
        long userOrganizationId = 0;
		try {

			organizations = organizationLocalService.getUserOrganizations(PrincipalThreadLocal.getUserId(), false);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		if (organizations != null && organizations.size() > 0) {
			for (Organization org : organizations) {
				if (!org.getType().equalsIgnoreCase("Location")) {
					userOrganizationId = org.getOrganizationId();
				}
			}
		}
		DynamicQuery query = getDynamicQuery(userOrganizationId,
				columnName, modelName,entryId);
		return dynamicQuery(query);
	}

	/**
	 * This method is used for getting the topic List based on the search parameters
	 * using dynamic query This method will be executed when the user performs
	 * search operations.
	 * 
	 * @param groupId   : holds the groupId
	 * @param searchKey : holds the search keyword from search container.
	 * @param           columnName: holds the column name.
	 * @param           modelName: holds the model name.
	 * @return DynamicQuery : holds the msg list return from the dynamic query based
	 *         on search values.
	 */
	private DynamicQuery getDynamicQuery(long groupId, String searchKey, String columnName, String modelName,String localeCode) {
		System.out.println("groupId:"+groupId);
		System.out.println("searchKey:"+searchKey);
		System.out.println("columnName:"+columnName);
		System.out.println("modelName:"+modelName);
		System.out.println("localeCode:"+localeCode);
		Junction searchjunction = RestrictionsFactoryUtil.disjunction();
		Junction deletedJunction = RestrictionsFactoryUtil.disjunction();
		Junction modelNameJunction = RestrictionsFactoryUtil.disjunction();
		Junction columnNameJunction = RestrictionsFactoryUtil.disjunction();
		Junction localeJunction = RestrictionsFactoryUtil.disjunction();

		Criterion searchCriteria = null;
         if(searchKey != null && !searchKey.trim().isEmpty()) {
			if (Validator.isNotNull(searchKey) && !Validator.isBlank(searchKey)) {
				searchCriteria = RestrictionsFactoryUtil.ilike("text", com.liferay.petra.string.StringPool.PERCENT + searchKey + com.liferay.petra.string.StringPool.PERCENT);
				searchjunction.add(searchCriteria);
			}
         }
		/*select * from lms_common_translation where modelName = 'com.armantec.lms.model.Topic' and 
				languageCode = 'en_US' and columnName = 'title' and text_ like '%a%'*/

		Criterion modelNameCriteria = RestrictionsFactoryUtil.eq("modelName", modelName);
		modelNameJunction.add(modelNameCriteria);
		Criterion columnNameCriteria = RestrictionsFactoryUtil.eq("columnName", columnName);
		columnNameJunction.add(columnNameCriteria);
		Criterion deletedCriteria = RestrictionsFactoryUtil.eq("deleted", false);
		deletedJunction.add(deletedCriteria);
		Criterion languageCodeCriteria = RestrictionsFactoryUtil.eq("languageCode", localeCode);
		localeJunction.add(languageCodeCriteria);

		Criterion groupCriteria = RestrictionsFactoryUtil.eq("groupId", groupId);
		DynamicQuery dynamicQuery = null;
        if(dynamicQuery != null) {
        	dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.and(deletedJunction,RestrictionsFactoryUtil.and(modelNameJunction, RestrictionsFactoryUtil.and(columnNameJunction,
						RestrictionsFactoryUtil.and(groupCriteria, searchjunction)))));
        }else {
        	dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.and(deletedJunction,RestrictionsFactoryUtil.and(modelNameJunction,
    						RestrictionsFactoryUtil.and(groupCriteria, columnNameJunction))));
        }
	
		return dynamicQuery.addOrder(OrderFactoryUtil.asc("text"));
	}
	
	/**
	 * This method is used for getting the topic List based on the search parameters
	 * using dynamic query This method will be executed when the user performs
	 * search operations.
	 * 
	 * @param groupId   : holds the groupId
	 * @param           columnName: holds the column name.
	 * @param           modelName: holds the model name.
	 * @param           entryId: holds the entry id.
	 * @return DynamicQuery : holds the msg list return from the dynamic query based
	 *         on search values.
	 */
	private DynamicQuery getDynamicQuery(long groupId,String columnName, String modelName, long entryId) {
		System.out.println("groupId:"+groupId);
		System.out.println("columnName:"+columnName);
		System.out.println("modelName:"+modelName);
		System.out.println("entryId:"+entryId);
		Junction deletedJunction = RestrictionsFactoryUtil.disjunction();
		Junction modelNameJunction = RestrictionsFactoryUtil.disjunction();
		Junction columnNameJunction = RestrictionsFactoryUtil.disjunction();
		Junction entryIdJunction = RestrictionsFactoryUtil.disjunction();

		Criterion modelNameCriteria = RestrictionsFactoryUtil.eq("modelName", modelName);
		modelNameJunction.add(modelNameCriteria);
		Criterion columnNameCriteria = RestrictionsFactoryUtil.eq("columnName", columnName);
		columnNameJunction.add(columnNameCriteria);
		Criterion deletedCriteria = RestrictionsFactoryUtil.eq("deleted", false);
		deletedJunction.add(deletedCriteria);
		Criterion entryIdCriteria = RestrictionsFactoryUtil.eq("recordId", entryId);
		entryIdJunction.add(entryIdCriteria);

		Criterion groupCriteria = RestrictionsFactoryUtil.eq("groupId", groupId);
	
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.and(modelNameJunction,
				RestrictionsFactoryUtil.and(columnNameJunction,
						RestrictionsFactoryUtil.and(groupCriteria, entryIdJunction))));
	
		return dynamicQuery.addOrder(OrderFactoryUtil.asc("text"));
	}
	
	
	public String backgroundTaskCleanUp() throws PortalException {
		BackgroundTaskManagerUtil.cleanUpBackgroundTasks();
		long siteScopeId = Long.parseLong(PropsUtil.get("api.permission.scopegroup.id"));
		BackgroundTaskManagerUtil.deleteGroupBackgroundTasks(siteScopeId);
		List<Lock> lockList = lockPersistence.findAll();
		for(Lock lock : lockList) {
			try {
			lockLocalService.deleteLock(lock);
			}catch(Exception ex) {
				
			}
		}
		return "Done";
	}
	
	
	public String backgroundTaskCleanUp(long backgroundTaskId) throws PortalException {
		BackgroundTask backgroundTask = BackgroundTaskManagerUtil.getBackgroundTask(backgroundTaskId);
		BackgroundTaskManagerUtil.cleanUpBackgroundTask(backgroundTask, BackgroundTaskConstants.STATUS_FAILED);
		BackgroundTaskManagerUtil.cleanUpBackgroundTask(backgroundTask, BackgroundTaskConstants.STATUS_IN_PROGRESS);
		BackgroundTaskManagerUtil.cleanUpBackgroundTask(backgroundTask, BackgroundTaskConstants.STATUS_NEW);
		BackgroundTaskManagerUtil.cleanUpBackgroundTask(backgroundTask, BackgroundTaskConstants.STATUS_QUEUED);
		BackgroundTaskManagerUtil.cleanUpBackgroundTask(backgroundTask, BackgroundTaskConstants.STATUS_SUCCESSFUL);
		BackgroundTaskManagerUtil.deleteBackgroundTask(backgroundTaskId);
		try {
			Lock lock = lockLocalService.getLock(backgroundTask.getTaskExecutorClassName(), backgroundTask.getTaskExecutorClassName());
			lockLocalService.deleteLock(lock);
		}catch(Exception ex) {
			
		}
		
		return "Done";
	}
	
	public String backgroundTaskUnLock(String taskExecutorClassName) throws PortalException {
	Boolean status = Boolean.valueOf(lockLocalService.isLocked(taskExecutorClassName, taskExecutorClassName));
	 if(status) {
		lockLocalService.unlock(taskExecutorClassName,taskExecutorClassName);
	 }
		return status+"";
	}
	
	public Translation findByGroupModelNameColumnNameLangCodeRecordId(long groupId,String modelName,String columnName,String languageCode,long recordId) throws NoSuchTranslationException {
		return translationPersistence.findByGroupModelNameColumnNameLangCodeRecordId(groupId, false, modelName,
				columnName, languageCode, recordId);
	}
	@Reference
	OrganizationLocalService organizationLocalService;
	@Reference
	LockLocalService lockLocalService;
	@Reference
	LockPersistence lockPersistence;
	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		// TODO Auto-generated method stub
		return 0;
	}
}