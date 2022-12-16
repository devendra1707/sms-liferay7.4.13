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

package com.armantec.sms.student.service.impl;

import com.armantec.sms.student.exception.NoSuchStudentException;
import com.armantec.sms.student.model.Student;
import com.armantec.sms.student.service.base.StudentServiceBaseImpl;
import com.armantec.sms.student.service.persistence.StudentUtil;
import com.liferay.portal.aop.AopService;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=sms",
		"json.web.service.context.path=Student"
	},
	service = AopService.class
)
public class StudentServiceImpl extends StudentServiceBaseImpl {
	
	// Create Student

			public Student create(String name, String email,  String address , long branchId, int semester, Date doj) {
				return studentLocalService.create(name,email,address, branchId, semester, doj);
			}

			// Update Student

			public Student update(long id, String name, String email,  String address , long branchId, int semester, Date doj) throws NoSuchStudentException {
				return studentLocalService.update(id, name,email,address, branchId, semester, doj);
			}

			// Find By BranchId
			public List<Student> find(long branchId) throws NoSuchStudentException {
				return studentLocalService.find(branchId);
			} 
			
			// Find All Student

			public List<Student> findAll() {
				return studentLocalService.findAll();
			}

			// delete Student 

			public Student delete(long id) throws NoSuchStudentException {
				return studentLocalService.delete(id);
			}
		
	}