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
import com.armantec.sms.student.service.base.StudentLocalServiceBaseImpl;
import com.armantec.sms.student.service.persistence.StudentUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.armantec.sms.student.model.Student",
	service = AopService.class
)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {

	// Create Student

	public Student create(String name, String email,  String address , long branchId, int semester, Date doj) {
		long id = CounterLocalServiceUtil.increment(this.getClass().getName());
		Student student = StudentUtil.create(id);
		student.setName(name);
		student.setEmail(email);
		student.setAddress(address);
		student.setSemester(semester);
		student.setBranchId(branchId);
		student.setDoj(doj);
		return StudentUtil.update(student);
	}

	// Update Student

	public Student update(long id, String name, String email,  String address , long branchId, int semester, Date doj) throws NoSuchStudentException
			 {

		Student student = StudentUtil.findByPrimaryKey(id);
		student.setName(name);
		student.setEmail(email);
		student.setAddress(address);
		student.setSemester(semester);
		student.setBranchId(branchId);
		student.setDoj(doj);
		return StudentUtil.update(student);

	}

		// Find By BranchId
	
	public List<Student> find(long branchId) throws NoSuchStudentException {
		List<Student> studentList = StudentUtil.findByBranchId(branchId, false);
		return studentList;
	}
		
		// Find All Student

		public List<Student> findAll() {
			List<Student> studentList = StudentUtil.findAll();
			return studentList;
		}

		// Delete Student

		public Student delete(long id) throws NoSuchStudentException   {
			
			Student student = StudentUtil.findByPrimaryKey(id);
			student.setDeleted(true);;
			return StudentUtil.update(student);
		}

}