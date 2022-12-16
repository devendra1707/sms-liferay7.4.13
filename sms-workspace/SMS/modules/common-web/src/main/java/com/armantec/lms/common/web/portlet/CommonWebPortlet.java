package com.armantec.lms.common.web.portlet;

import com.armantec.lms.common.web.constants.CommonWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author indigouser
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=category.lms",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CommonWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CommonWebPortletKeys.COMMONWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CommonWebPortlet extends MVCPortlet {
}