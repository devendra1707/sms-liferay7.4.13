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


import com.armantec.lms.common.util.services.service.base.ZipUtilsServiceLocalServiceBaseImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the zip utils service local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.armantec.lms.common.util.services.service.ZipUtilsServiceLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ZipUtilsServiceLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.armantec.lms.common.util.services.model.ZipUtilsService",
	service = AopService.class
)
public class ZipUtilsServiceLocalServiceImpl
	extends ZipUtilsServiceLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.armantec.lms.common.util.services.service.ZipUtilsServiceLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.armantec.lms.common.util.services.service.ZipUtilsServiceLocalServiceUtil</code>.
	 */
private List<String> fileList;
	
	public  final String ASSESSMENT_ZIP_FOLDER_PATH = System.getProperty("catalina.home")+"/"+"AssessmentZips/";
	
	
	public String getAssessmentZipPath() {
		
		return ASSESSMENT_ZIP_FOLDER_PATH;
	}
	
	public ZipUtilsServiceLocalServiceImpl() {
		fileList = new ArrayList<String>();
	}


	public void zipIt(String zipFile,String sourceFolder) throws IOException{
		byte[] buffer = new byte[1024];
		String source = new File(sourceFolder).getName();
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(zipFile);
			zos = new ZipOutputStream(fos);

			_logger.debug("Output to Zip : " + zipFile);
			FileInputStream in = null;

			for (String file : this.fileList) {
				_logger.debug("File Added : " + file);
				ZipEntry ze = new ZipEntry(source + File.separator + file);
				zos.putNextEntry(ze);
				try {
					in = new FileInputStream(sourceFolder + File.separator + file);
					int len;
					while ((len = in.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
				} finally {
					
					in.close();
					
				}
			}

			zos.closeEntry();
			//fos.close();
			_logger.debug("Folder successfully compressed");
			try{
				File deleteUncompressedFolder = new File(sourceFolder);
				if(deleteUncompressedFolder.exists()){
					FileUtils.deleteDirectory(deleteUncompressedFolder);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}  catch (FileNotFoundException e) {
       	 _logger.debug("FileNotFoundException zipIt "+e.getMessage());
       } finally {
    	   zos.closeEntry();
    	   zos.close();
    	   fos.close();
    	   fileList = new ArrayList<String>();
		}
	}

	public void generateFileList(File node,String sourseFolder) {
		// add file only
		
		_logger.debug("inside zip util local service Util :"+node+"dsjhfdkj"+sourseFolder);
		if (node.isFile()) {
			fileList.add(generateZipEntry(node.toString(),sourseFolder));
		}

		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateFileList(new File(node, filename),sourseFolder);
			}
		}
	}

	private String generateZipEntry(String file, String sourseFolder) {
		return file.substring(sourseFolder.length() + 1, file.length());
	}
	 public  String unzip(String zipFilePath, String destDir) throws IOException{
		 String exportStr = "";
	        File dir = new File(destDir);

	        if(!dir.exists()) dir.mkdirs();
	        FileInputStream fis;
	        byte[] buffer = new byte[1024];
	        try {
	            fis = new FileInputStream(zipFilePath);
	            ZipInputStream zis = new ZipInputStream(fis);
	            ZipEntry ze = zis.getNextEntry();
	            while(ze != null){
	                String fileName = ze.getName();
	               // _logger.debug("split[0]: "+ fileName.split(File.separator)[0]);
	                if(exportStr.isEmpty()) {
		                if(fileName.indexOf("\\") > -1) {
			            	   exportStr = fileName.substring(0,fileName.indexOf("\\"));  
			               }else {
			            	   exportStr = fileName.substring(0,fileName.indexOf("/"));  
			               }
		               }
	               // _logger.debug("split[0]exportId: "+ exportStr);
	                File newFile = new File(destDir + File.separator + fileName);
	                _logger.debug("Unzipping to "+newFile.getAbsolutePath());
	                //create directories for sub directories in zip
	                new File(newFile.getParent()).mkdirs();
	                FileOutputStream fos = new FileOutputStream(newFile);
	                int len;
	                while ((len = zis.read(buffer)) > 0) {
	                fos.write(buffer, 0, len);
	                }
	                fos.close();
	                //close this ZipEntry
	                zis.closeEntry();
	                ze = zis.getNextEntry();
	            }
	            //close last ZipEntry
	            zis.closeEntry();
	            zis.close();
	            fis.close();
	            _logger.debug("fis.close() ");
	        }  catch (FileNotFoundException e) {
	        	 _logger.debug("FileNotFoundException "+e.getMessage());
	        }
	        
	        return exportStr;
	    }
	 public  ArrayList<File> extractZip(String fileName, String outputDir){
		 ArrayList<File> fileList = new ArrayList<File>();
	    	try {
	        	//_logger.debug("fileName\t"+fileName);
	        	ZipFile zipFile = new ZipFile(fileName);
				Enumeration<?> enu = zipFile.entries();
				while (enu.hasMoreElements()) {
					ZipEntry zipEntry = (ZipEntry) enu.nextElement();

					String name = zipEntry.getName();
					File file = new File(outputDir+name);
					if (name.endsWith("/")) {
						file.mkdirs();
						continue;
					}

					File parent = file.getParentFile();
					if (parent != null) {
						parent.mkdirs();
					}

					InputStream is = zipFile.getInputStream(zipEntry);
					FileOutputStream fos = new FileOutputStream(outputDir+name);
					byte[] bytes = new byte[1024];
					int length;
					while ((length = is.read(bytes)) >= 0) {
						fos.write(bytes, 0, length);
					}
					is.close();
					fos.close();
	                if (name.endsWith(".xls"))
	                	fileList.add(file);

	            }
	            zipFile.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    	return fileList;
	    }
	 private static final Log _logger = LogFactoryUtil.getLog(ZipUtilsServiceLocalServiceImpl.class);
}