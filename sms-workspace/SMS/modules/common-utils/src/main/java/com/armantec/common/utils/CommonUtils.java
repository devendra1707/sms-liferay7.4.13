package com.armantec.common.utils; 

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.service.ResourcePermissionServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.InternetAddress;

import org.apache.commons.io.FileUtils;


public class CommonUtils { 

	public static long getServiceScopeGroupId() {
		return Long.parseLong(PropsUtil.get("api.permission.scopegroup.id"));
	}

	public static ServiceContext getServiceContext() {
		return getServiceContext(true);
	}

	public static ServiceContext getServiceContext(boolean scopeGroup) {
		ServiceContext context = ServiceContextThreadLocal.getServiceContext();
		if (context == null) {
			context = new ServiceContext();
		}
		if (scopeGroup) {
			context.setScopeGroupId(getServiceScopeGroupId());
		}
		return context;
	}
	
	public static String evaluateVelocityTemplate(String templateContent, Map variable) {
		Iterator iter = variable.keySet().iterator();
		while (iter.hasNext()) {
			String variableName = (String) iter.next();
			String variableValue = String.valueOf(variable.get(variableName));
			
			templateContent = templateContent.replaceAll("[$]" + variableName, variableValue);
		}
		
		System.out.println("Mail body " + templateContent);
		
		return templateContent;
	}
	
	public static boolean sendEmail(String toAddress, String subject, Map variables, String emailTemplate) throws Exception {
		
		try {
			
			System.out.println("Sending mail to " + toAddress);
			System.out.println(variables);
			System.out.println("Template " + emailTemplate);
			
			
			String mailBody = evaluateVelocityTemplate(emailTemplate, variables);
			// String senderMailAddress = CommonUtilServiceLocalServiceImpl.getSenderMail();
			// //System.out.println(mailBody);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setBody(mailBody.replaceAll("\n", "<br/>"));
			mailMessage.setSubject(subject);
			mailMessage.setHTMLFormat(true);
			mailMessage.setFrom(new InternetAddress("demo@armantecsystems.com", "Portal System"));
			mailMessage.setTo(new InternetAddress(toAddress));
			MailServiceUtil.sendEmail(mailMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static String getUsageFile(long scopeGroupId, String usage) {

		if (Validator.isNotNull(usage)) {
			AssetTag assetTag = AssetTagLocalServiceUtil.fetchTag(scopeGroupId, usage);
			if (Validator.isNotNull(assetTag)) {
				List<AssetEntry> assetEntryList = AssetEntryLocalServiceUtil
						.getAssetTagAssetEntries(assetTag.getTagId());
				if (Validator.isNotNull(assetEntryList) && !assetEntryList.isEmpty()) {
					AssetEntry assetEntry = assetEntryList.get(0);
					if (Validator.isNotNull(assetEntry)) {
						DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(assetEntry.getClassPK());
						return getDLFileEntryURL(dlFileEntry);
					}
				}

			}
		}

		return "#";
	}

	public static String getDLFileEntryURL(DLFileEntry entry) {
		if (Validator.isNotNull(entry)) {
			try {
				return "/documents/" + entry.getGroupId() + "/" + entry.getFolderId() + "/"
						+ HttpUtil.URLtoString(HtmlUtil.unescape(entry.getTitle()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return StringPool.BLANK;
	}

	public static String getUserOrganizationNameByOrgId(long[] orgId) throws SystemException {
		Organization organization = null;
		try {
			for (int i = 0; i < orgId.length; i++) {
				organization = OrganizationLocalServiceUtil.getOrganization(orgId[i]);
				if (organization != null) {
					return organization.getName();
				}
			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	public static File getUsageFileV2(long scopeGroupId, String usage) throws PortalException, IOException {

		if (Validator.isNotNull(usage)) {
			AssetTag assetTag = AssetTagLocalServiceUtil.fetchTag(scopeGroupId, usage);
			if (Validator.isNotNull(assetTag)) {
				List<AssetEntry> assetEntryList = AssetEntryLocalServiceUtil
						.getAssetTagAssetEntries(assetTag.getTagId());
				if (Validator.isNotNull(assetEntryList) && !assetEntryList.isEmpty()) {
					AssetEntry assetEntry = assetEntryList.get(0);
					if (Validator.isNotNull(assetEntry)) {
						DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(assetEntry.getClassPK());
						
							 File file =new File("data");
							 FileUtils.copyInputStreamToFile(DLFileEntryLocalServiceUtil.getFileAsStream(dlFileEntry.getFileEntryId(),
										dlFileEntry.getVersion(), false), file);
								return file	;
									
						
					}
				}

			}
		}

		return null;
	}
	
	public static String getFileUrl(File file, String folderName, ServiceContext serviceContext, String uniqueName,
			String defaultUrl, long scopeGroupId, String viewRole) throws PortalException, SystemException {
		
			uniqueName = uniqueName.replaceAll(" ", "_");
		
			FileEntry entry = getFileEntry(file, folderName, serviceContext, uniqueName, defaultUrl, scopeGroupId, viewRole);
			
			if(entry!=null) {
				return "/documents/" + entry.getGroupId() + "/" + entry.getFolderId() + "/" + entry.getTitle() + "/"
					+ entry.getUuid() + "?t=" + System.currentTimeMillis();
			}else {
				return defaultUrl;
			}
	}
	
	private static Folder createFolder(long userId, long groupId, long parentFolderId, String folderName,
			ServiceContext context, long scopeGroupId, String viewRole) {

		Folder folder = null;
		Role userRole = null;
		try {
			User user = UserLocalServiceUtil.fetchUser(userId);
			// folder=DLFolderLocalServiceUtil.createDLFolder(CounterLocalServiceUtil.increment(DLFolder.class.getName(),1));

			System.out.println("Repository ID = " + scopeGroupId);
			try {
				folder = DLAppLocalServiceUtil.getFolder(scopeGroupId, parentFolderId,
						folderName);
			} catch (Exception ex) {
				ex.printStackTrace();

			}
			if (folder == null) {
				folder = DLAppLocalServiceUtil.addFolder(user.getUserId(), scopeGroupId,
						parentFolderId, folderName, folderName + " description", context);
				// DLFileEntryType
				// dlFileEntryType=DLFileEntryTypeLocalServiceUtil.createDLFileEntryType(CounterLocalServiceUtil.increment(DLFileEntryType.class.getName(),
				// 1));
				// DLFolderLocalServiceUtil.addDLFileEntryTypeDLFolder(0,
				// folder.getFolderId());
			}

			if (userRole == null) {
				userRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Township Admin");
			}

			// userRole =
			// RoleLocalServiceUtil.fetchRole(CompanyThreadLocal.getCompanyId(),
			// "Meeting Requester");

			ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
					DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + folder.getFolderId(),
					userRole.getRoleId(), new String[] { "ACCESS", "ADD_DOCUMENT", "ADD_SHORTCUT", "ADD_SUBFOLDER",
							"UPDATE", "VIEW", "PERMISSIONS" });
			String roleNames [] = viewRole.split(",");
			for(String roleName : roleNames) {
				userRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), roleName);
				ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
						DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + folder.getFolderId(),
						userRole.getRoleId(), new String[] { "ACCESS", "VIEW" });
			}
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return folder;

	}
	
	public static FileEntry getFileEntry(File file, String folderName, ServiceContext serviceContext, String uniqueName,
			String defaultUrl, long scopeGroupId, String viewRole) throws PortalException, SystemException {
		// System.out.println("Mobile Number = "+serviceContext);
		// System.out.println(CompanyThreadLocal.getCompanyId()+" folder class
		// name = "+DLFolder.class.getName()+" folder z =
		// "+ResourceConstants.SCOPE_INDIVIDUAL+" 2 = "+folder.getFolderId()+"
		// 3= ");
		//System.out.println("File Name = " + file.getName());
		if (file == null || !file.exists() || !file.isFile() || file.getName().endsWith(".")
				|| file.getName().endsWith(".tmp")) {
			return null;
		}

		User currUser = getCurrentUser();

		Folder folder = createFolder(currUser.getUserId(), getUserOrganizationId(), 0L, folderName,
				serviceContext, scopeGroupId, viewRole);


		// Folder subFolder=createFolder(currUser.getUserId(),
		// currUser.getGroupId(),
		// folder.getFolderId(),meetingRequest.getRequestId()+"",serviceContext);
		// DLFileEntry
		// entry=DLFileEntryLocalServiceUtil.addFileEntry(currUser.getUserId(),
		// currUser.getGroupId(), currUser.getGroupId(),
		// subFolder.getFolderId(), imageName,
		// MimeTypesUtil.getContentType(imageName), "", "", changeLog,
		// fileEntryTypeId, fieldsMap, file, is, size, serviceContext)
		String imageName = uniqueName + "-" + file.getName();
		try {
			FileEntry entry = DLAppLocalServiceUtil.addFileEntry(currUser.getUserId(),
					scopeGroupId, folder.getFolderId(), imageName,
					MimeTypesUtil.getContentType(imageName), imageName, "", "", file, serviceContext);
			Role userRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Township Admin");
			ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + entry.getFileEntryId(),
					userRole.getRoleId(), new String[] { "UPDATE", "VIEW", "PERMISSIONS" });
			String roleNames [] = viewRole.split(",");
			for(String roleName : roleNames) {
				userRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), roleName);
				ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
						DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + entry.getFileEntryId(),
					userRole.getRoleId(), new String[] {"VIEW"});
			}
			// ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(),DLFileEntry.class.getName(),ResourceConstants.SCOPE_INDIVIDUAL,""+entry.getFileEntryId(),
			// userRole.getRoleId(), new
			// String[]{"UPDATE","VIEW","PERMISSIONS"});
			// http://localhost:8080/documents/1579932/1581907/test+Doc/10c8a0f1-5fe5-4134-99f6-3a4d9324c5a0
			return entry;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
	
	public static String getDownloadeUrl(String imageUrl) throws NumberFormatException, PortalException, SystemException {
		if(imageUrl==null || !imageUrl.startsWith("/c/document_library/get_file")) {
			return imageUrl;
		}
		
		imageUrl = imageUrl.replaceAll("/c/document_library/get_file[?]uuid=","");
		imageUrl = imageUrl.replaceAll("[&]groupId=",":");
		String [] uuidGroupId = imageUrl.split(":");
		FileEntry entry=DLAppLocalServiceUtil.getFileEntryByUuidAndGroupId(uuidGroupId[0], Long.valueOf(uuidGroupId[1]));
		Folder folder = entry.getFolder();
		return "/documents/" + entry.getGroupId() + "/" + folder.getFolderId() + "/" + entry.getTitle() + "/"+ entry.getUuid() + "?t=0";
	}
	
	
	public static JSONObject getJSONObject(Map <String, Object>modelAttributes){
		Iterator<String> iter = modelAttributes.keySet().iterator();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		while(iter.hasNext()){
			String key = iter.next();
			Object value = modelAttributes.get(key);
			if(value  == null){
				//jsonObject.put(key, null);
			}else if(value instanceof Date){
				jsonObject.put(key, ((Date)value).getTime());
			}else if(value instanceof Integer){
				jsonObject.put(key, (Integer)value);
			}else if(value instanceof Long){
				jsonObject.put(key, (Long)value);
			}else if(value instanceof Boolean){
				jsonObject.put(key, (Boolean)value);
			}else{
				jsonObject.put(key, String.valueOf(value));
			}
		}
		
		return jsonObject;
	}
	
	public static boolean containsIllegals(String toExamine) throws PortalException {
		if(toExamine==null) {
			return false;
		}
		Pattern pattern =Pattern.compile("[-+=@<>]");
		//Pattern pattern = Pattern.compile("[<>+-@=]");
	   // Pattern pattern = Pattern.compile("[<>]");
	    Matcher matcher = pattern.matcher(toExamine);
	    if(matcher.find()) {
	    	System.out.println("Invalid input - " + toExamine);
	    	throw new PortalException("Invalid characters are not allowed.");
	    }
	    
	    return false;
	}

	public static long getUserOrganizationLogoId() throws SystemException {
		List<Organization> organizations = null;
		try {
			organizations = OrganizationLocalServiceUtil.getUserOrganizations(PrincipalThreadLocal.getUserId(), false);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (organizations != null && organizations.size() > 0) {
			for (Organization org : organizations) {
				if (!org.getType().equalsIgnoreCase("Location")) {
					//// System.out.println("org id:" + org.getOrganizationId() + " name:" +
					//// org.getName());
					return org.getLogoId();
				}
			}
		}
		return 0;
	}

	public static User getCurrentUser() throws SystemException, PortalException {
		return UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
	}

	public static long getUserOrganizationId() throws SystemException {
		List<Organization> organizations = null;

		try {
			organizations = OrganizationLocalServiceUtil.getUserOrganizations(PrincipalThreadLocal.getUserId(), false);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		if (organizations != null && organizations.size() > 0) {
			for (Organization org : organizations) {
				if (!org.getType().equalsIgnoreCase("Location")) {
					return org.getOrganizationId();
				}
			}
		}
		return 0;
	}
	
	public static String getLocale(Locale locale) {

		String locale1 = locale + "";
		String correctlocale = locale1.replace('_', '-');

		return correctlocale;

	}
	
	
	public static long getUserOrganizationGroupId() throws SystemException {
		List<Organization> organizations = null;

		try {
			organizations = OrganizationLocalServiceUtil.getUserOrganizations(PrincipalThreadLocal.getUserId(), false);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		if (organizations != null && organizations.size() > 0) {
			for (Organization org : organizations) {
				if (!org.getType().equalsIgnoreCase("Location")) {
					return org.getOrganizationId();
				}
			}
		}
		return 0;
	}

	public static long getUserOrganizationId(long userId) throws SystemException {
		List<Organization> organizations = null;
		try {
			organizations = OrganizationLocalServiceUtil.getUserOrganizations(userId, false);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("organizations.size():" + organizations.size());
		if (organizations != null && organizations.size() > 0) {
			for (Organization org : organizations) {
				if (!org.getType().equalsIgnoreCase("Location")) {
					return org.getOrganizationId();
				}
			}
		}
		return 0;
	}

	public static User getCurrentOrganizationAdminWithPermissionChecker() throws PortalException, SystemException {
		long companyId = CompanyThreadLocal.getCompanyId();

		if (companyId == 0) {
			companyId = getCompanyId();
		}
		Role adminRole = RoleLocalServiceUtil.getRole(companyId, "Administrator");

		List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());

		User currUser = null;
		if (adminUsers != null && !adminUsers.isEmpty()) {
			currUser = adminUsers.get(0);
		}
		PermissionChecker permissionChecker = null;
		try {
			permissionChecker = PermissionCheckerFactoryUtil.create(currUser);
		} catch (Exception e) {
			// System.out.println("userIduserIduserIdex:" + e.getMessage());
		}
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
		return currUser;
	}

	public static User addRole(User user, String roleName) throws SystemException, PortalException {
		Role liferayRole = RoleLocalServiceUtil.fetchRole(CompanyThreadLocal.getCompanyId(), roleName);
		RoleLocalServiceUtil.addUserRole(user.getUserId(), liferayRole.getRoleId());
		UserLocalServiceUtil.updateUser(user);
		return user;
	}

	public static long getCompanyId() {
		try {
			Company company = CompanyLocalServiceUtil.getCompany(PortalUtil.getDefaultCompanyId());
			if (company != null) {
				// System.out.println("company id --" + company.getCompanyId());
				return company.getCompanyId();
			}
		} catch (SystemException e) {

			return 0;
		} catch (PortalException e) {
			return 0;
		}
		return 0;
	}

	public static boolean hasRole(User user, String roleName) {
		boolean hasRole = false;
		try {
			List<Role> roles = user.getRoles();
			for (Role role : roles) {
				if (role.getName().equalsIgnoreCase(roleName)) {
					hasRole = true;
					break;
				}
			}
		}catch (Exception e) {
			// Need not handle
		}
		return hasRole;
		
	}

	public static void printLog(String str) {
		 System.out.println(str);
	}
	

	public static boolean checkContainsIllegals(ArrayList<String> toExamineList) throws PortalException {
		if(toExamineList.size()<=0) {
			return false;
		}
		for(String paramValue : toExamineList)
		{            paramValue.startsWith("=");

		boolean matches = paramValue.startsWith("+") || paramValue.startsWith("-")  || paramValue.startsWith("@") 
				||paramValue.startsWith("=")  ;
		if(matches==true)
		{
			//throw new PortalException("Invalid characters are not allowed.");
			throw new PortalException("Text input can not start with an =, @, -,+ ");
		}	    
		
		}
		
		   return false;
	}
}