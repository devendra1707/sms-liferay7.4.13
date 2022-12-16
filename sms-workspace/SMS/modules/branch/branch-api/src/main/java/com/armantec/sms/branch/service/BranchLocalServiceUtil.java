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

package com.armantec.sms.branch.service;

import com.armantec.sms.branch.model.Branch;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Branch. This utility wraps
 * <code>com.armantec.sms.branch.service.impl.BranchLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BranchLocalService
 * @generated
 */
public class BranchLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.armantec.sms.branch.service.impl.BranchLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the branch to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BranchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param branch the branch
	 * @return the branch that was added
	 */
	public static Branch addBranch(Branch branch) {
		return getService().addBranch(branch);
	}

	public static Branch create(String name, String code, int numberOfSeat) {
		return getService().create(name, code, numberOfSeat);
	}

	/**
	 * Creates a new branch with the primary key. Does not add the branch to the database.
	 *
	 * @param id the primary key for the new branch
	 * @return the new branch
	 */
	public static Branch createBranch(long id) {
		return getService().createBranch(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static Branch delete(long id)
		throws com.armantec.sms.branch.exception.NoSuchBranchException {

		return getService().delete(id);
	}

	/**
	 * Deletes the branch from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BranchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param branch the branch
	 * @return the branch that was removed
	 */
	public static Branch deleteBranch(Branch branch) {
		return getService().deleteBranch(branch);
	}

	/**
	 * Deletes the branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BranchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the branch
	 * @return the branch that was removed
	 * @throws PortalException if a branch with the primary key could not be found
	 */
	public static Branch deleteBranch(long id) throws PortalException {
		return getService().deleteBranch(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.armantec.sms.branch.model.impl.BranchModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.armantec.sms.branch.model.impl.BranchModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Branch fetchBranch(long id) {
		return getService().fetchBranch(id);
	}

	/**
	 * Returns the branch matching the UUID and group.
	 *
	 * @param uuid the branch's UUID
	 * @param groupId the primary key of the group
	 * @return the matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchBranchByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchBranchByUuidAndGroupId(uuid, groupId);
	}

	public static List<Branch> findAll() {
		return getService().findAll();
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the branch with the primary key.
	 *
	 * @param id the primary key of the branch
	 * @return the branch
	 * @throws PortalException if a branch with the primary key could not be found
	 */
	public static Branch getBranch(long id) throws PortalException {
		return getService().getBranch(id);
	}

	/**
	 * Returns the branch matching the UUID and group.
	 *
	 * @param uuid the branch's UUID
	 * @param groupId the primary key of the group
	 * @return the matching branch
	 * @throws PortalException if a matching branch could not be found
	 */
	public static Branch getBranchByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getBranchByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.armantec.sms.branch.model.impl.BranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @return the range of branches
	 */
	public static List<Branch> getBranches(int start, int end) {
		return getService().getBranches(start, end);
	}

	/**
	 * Returns all the branches matching the UUID and company.
	 *
	 * @param uuid the UUID of the branches
	 * @param companyId the primary key of the company
	 * @return the matching branches, or an empty list if no matches were found
	 */
	public static List<Branch> getBranchesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getBranchesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of branches matching the UUID and company.
	 *
	 * @param uuid the UUID of the branches
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching branches, or an empty list if no matches were found
	 */
	public static List<Branch> getBranchesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return getService().getBranchesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of branches.
	 *
	 * @return the number of branches
	 */
	public static int getBranchesCount() {
		return getService().getBranchesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static Branch update(
			long id, String name, String code, int numberOfSeat)
		throws com.armantec.sms.branch.exception.NoSuchBranchException {

		return getService().update(id, name, code, numberOfSeat);
	}

	/**
	 * Updates the branch in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BranchLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param branch the branch
	 * @return the branch that was updated
	 */
	public static Branch updateBranch(Branch branch) {
		return getService().updateBranch(branch);
	}

	public static BranchLocalService getService() {
		return _service;
	}

	private static volatile BranchLocalService _service;

}