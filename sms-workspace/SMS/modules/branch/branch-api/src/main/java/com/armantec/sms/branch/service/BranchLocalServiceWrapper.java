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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BranchLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BranchLocalService
 * @generated
 */
public class BranchLocalServiceWrapper
	implements BranchLocalService, ServiceWrapper<BranchLocalService> {

	public BranchLocalServiceWrapper() {
		this(null);
	}

	public BranchLocalServiceWrapper(BranchLocalService branchLocalService) {
		_branchLocalService = branchLocalService;
	}

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
	@Override
	public com.armantec.sms.branch.model.Branch addBranch(
		com.armantec.sms.branch.model.Branch branch) {

		return _branchLocalService.addBranch(branch);
	}

	@Override
	public com.armantec.sms.branch.model.Branch create(
		String name, String code, int numberOfSeat) {

		return _branchLocalService.create(name, code, numberOfSeat);
	}

	/**
	 * Creates a new branch with the primary key. Does not add the branch to the database.
	 *
	 * @param id the primary key for the new branch
	 * @return the new branch
	 */
	@Override
	public com.armantec.sms.branch.model.Branch createBranch(long id) {
		return _branchLocalService.createBranch(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _branchLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public com.armantec.sms.branch.model.Branch delete(long id)
		throws com.armantec.sms.branch.exception.NoSuchBranchException {

		return _branchLocalService.delete(id);
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
	@Override
	public com.armantec.sms.branch.model.Branch deleteBranch(
		com.armantec.sms.branch.model.Branch branch) {

		return _branchLocalService.deleteBranch(branch);
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
	@Override
	public com.armantec.sms.branch.model.Branch deleteBranch(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _branchLocalService.deleteBranch(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _branchLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _branchLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _branchLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _branchLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _branchLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _branchLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _branchLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _branchLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _branchLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.armantec.sms.branch.model.Branch fetchBranch(long id) {
		return _branchLocalService.fetchBranch(id);
	}

	/**
	 * Returns the branch matching the UUID and group.
	 *
	 * @param uuid the branch's UUID
	 * @param groupId the primary key of the group
	 * @return the matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public com.armantec.sms.branch.model.Branch fetchBranchByUuidAndGroupId(
		String uuid, long groupId) {

		return _branchLocalService.fetchBranchByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.armantec.sms.branch.model.Branch> findAll() {
		return _branchLocalService.findAll();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _branchLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the branch with the primary key.
	 *
	 * @param id the primary key of the branch
	 * @return the branch
	 * @throws PortalException if a branch with the primary key could not be found
	 */
	@Override
	public com.armantec.sms.branch.model.Branch getBranch(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _branchLocalService.getBranch(id);
	}

	/**
	 * Returns the branch matching the UUID and group.
	 *
	 * @param uuid the branch's UUID
	 * @param groupId the primary key of the group
	 * @return the matching branch
	 * @throws PortalException if a matching branch could not be found
	 */
	@Override
	public com.armantec.sms.branch.model.Branch getBranchByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _branchLocalService.getBranchByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.armantec.sms.branch.model.Branch> getBranches(
		int start, int end) {

		return _branchLocalService.getBranches(start, end);
	}

	/**
	 * Returns all the branches matching the UUID and company.
	 *
	 * @param uuid the UUID of the branches
	 * @param companyId the primary key of the company
	 * @return the matching branches, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.armantec.sms.branch.model.Branch>
		getBranchesByUuidAndCompanyId(String uuid, long companyId) {

		return _branchLocalService.getBranchesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.armantec.sms.branch.model.Branch>
		getBranchesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.armantec.sms.branch.model.Branch> orderByComparator) {

		return _branchLocalService.getBranchesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of branches.
	 *
	 * @return the number of branches
	 */
	@Override
	public int getBranchesCount() {
		return _branchLocalService.getBranchesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _branchLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _branchLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _branchLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _branchLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.armantec.sms.branch.model.Branch update(
			long id, String name, String code, int numberOfSeat)
		throws com.armantec.sms.branch.exception.NoSuchBranchException {

		return _branchLocalService.update(id, name, code, numberOfSeat);
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
	@Override
	public com.armantec.sms.branch.model.Branch updateBranch(
		com.armantec.sms.branch.model.Branch branch) {

		return _branchLocalService.updateBranch(branch);
	}

	@Override
	public BranchLocalService getWrappedService() {
		return _branchLocalService;
	}

	@Override
	public void setWrappedService(BranchLocalService branchLocalService) {
		_branchLocalService = branchLocalService;
	}

	private BranchLocalService _branchLocalService;

}