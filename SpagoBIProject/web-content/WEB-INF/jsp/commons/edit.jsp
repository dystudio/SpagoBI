<!--
SpagoBI - The Business Intelligence Free Platform

Copyright (C) 2005-2008 Engineering Ingegneria Informatica S.p.A.

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
-->

<%@ page import="javax.portlet.PortletURL,
				 java.util.Collection,
				 java.util.List,
				 java.util.Iterator,
				 it.eng.spago.base.SourceBean,
				 it.eng.spago.security.IEngUserProfile,
				 it.eng.spago.configuration.ConfigSingleton,
				 it.eng.spagobi.commons.utilities.PortletUtilities" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="it.eng.spago.navigation.LightNavigationManager"%>

<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>

<%@ include file="/WEB-INF/jsp/commons/portlet_base.jsp"%>

<portlet:defineObjects/>

<div class='div_background_no_img' >
<table width='100%' cellspacing='0' border='0'>		
	<tr height='40'>
		<th align='left'>&nbsp;&nbsp;<spagobi:message key="editConf.configuration"/></th>
	</tr>
</table>

<%

	Collection roles = null;;
		roles = ((UserProfile)userProfile).getRolesForUse();
	

	boolean hasPortletEditPermissionRoles = false;
	ConfigSingleton configSingleton = ConfigSingleton.getInstance();
	List rolesSB = (List) configSingleton.getAttributeAsList("SPAGOBI.PORTLET_EDIT_MODE_ROLES.ROLE");
	Iterator rolesIt = rolesSB.iterator();
	while (rolesIt.hasNext()) {
		SourceBean roleSB = (SourceBean) rolesIt.next();
		String roleName = (String) roleSB.getAttribute("name");
		if (roles.contains(roleName)) {
			hasPortletEditPermissionRoles = true;
			break;
		}
	}
	
	if (!hasPortletEditPermissionRoles) {
		%>
		<spagobi:message key="editConf.configurationNotPermissible"/>
		<%
	} else {
	
    PortletURL formUrl = renderResponse.createActionURL();
    formUrl.setParameter("PAGE", "SaveConfigurationPage");  
    //boolean it = false;
    //boolean en = false;
	//String[] langPref = renderRequest.getPreferences().getValues("language", null);	
    //if(langPref[0].equals("it")) {
    //	it = true;
    //} else {
    //	en = true;
    //}
%>

<div class="div_detail_area_forms">

<form action="<%= formUrl.toString() %>" method="POST" > 

<input type="hidden" name="<%=LightNavigationManager.LIGHT_NAVIGATOR_DISABLED%>" value="true" />

<table width="100%" cellspacing="0" border="0" >
  	<tr height='1'>
  		<td width="30px"><span>&nbsp;</span></td>
  		<td width="70px"><span>&nbsp;</span></td>
  		<td width="30px"><span>&nbsp;</span></td>
  		<td><span>&nbsp;</span></td>
  	</tr>	
  	<%
  	javax.portlet.PortletRequest portReq = PortletUtilities.getPortletRequest();
  	javax.portlet.PortletPreferences prefs = portReq.getPreferences();
  	Map map = prefs.getMap();
	String[] prefNames = new String[map.size()];
	prefNames = (String[]) map.keySet().toArray(prefNames);
	// order the preferences by name
	Arrays.sort(prefNames);
	String prefPrefix = "PORTLET_PREF_";
  	for (int i = 0; i < prefNames.length; i++) {
  		String prefName = prefNames[i];
		String[] prefValues = prefs.getValues(prefName, null);
		String prefValue = prefValues[0];
		for (int j = 1; j < prefValues.length; j++) {
			prefValue += "," + prefValues[j];
		}
		%>
		<tr height='30'>
      		<td>&nbsp;</td>
      		<td class='portlet-form-field-label' ><%=prefName%>:</td>
      		<td>&nbsp;</td>
      		<td>	
      			<input type="text" name="<%=prefPrefix+prefName%>" value="<%=prefValue != null ? prefValue : ""%>" />
      		</td>
   		</tr>
		<%	
  	}
	%>
	
	<tr height='30'>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>
			<input type='image' name='save' id='save' value='true' class='header-button-image-portlet-section'
				src='<%=urlBuilder.getResourceLinkByTheme(request, "/img/save.png", currTheme) %>'
      				title='<spagobi:message key="editConf.save"/>' 
      				alt='<spagobi:message key="editConf.save"/>'
			/>
		</td>
	</tr>
</table>
</form>
</div>
<% } %>
</div>


<!-- ************************************************************* -->
<!-- ESEMPIO DI UTILIZZO DELLA CONFIGURAZIONE 
	 CONFIGURAZIONE DELLA LINGUA DEPRECATA
	 LA PAGINA DI CONFIGURAZIONE E IL MODULO ESISTONO ANCORA PER EVENTUALI UTILIZZI FUTURI -->
	 
<%--
<form action="<%= formUrl.toString() %>" method="POST" > 
<table width="100%" cellspacing="0" border="0" >
  	<tr height='1'>
  		<td width="30px"><span>&nbsp;</span></td>
  		<td width="70px"><span>&nbsp;</span></td>
  		<td width="30px"><span>&nbsp;</span></td>
  		<td><span>&nbsp;</span></td>
  	</tr>
  	<tr height='40'>
      	<td>&nbsp;</td>
      	<td class='portlet-form-field-label' ><spagobi:message key="editConf.language"/>:</td>
      	<td>&nbsp;</td>
      	<td>	
      		<input type="radio" name="language" value="it,IT" <% if(it) {out.write(" checked='checked' ");} %> >
      			<spagobi:message key="editConf.italian"/>
      		</input>
      	</td>
    </tr>
    <tr height='40'>
      	<td>&nbsp</td>
      	<td>&nbsp;</td>
      	<td>&nbsp;</td>
      	<td>	
      		<input type="radio" name="language" value="en,US" <% if(en) {out.write(" checked='checked' ");} %> >
      			<spagobi:message key="editConf.english"/>
      		</input>
      	</td>
    </tr>
    <tr height='10'>
    	<td colspan="4">&nbsp;</td>
    </tr>
    <tr height='40'>
    	<td>&nbsp;</td>
    	<td colspan="3">
    		<input type="submit" value="<spagobi:message key="editConf.save"/>"/>
    	</td>
    </tr>
</table>
</form>
--%>
<!-- ************************************************************* -->

<br/><br/>
<!-- 
<div width="100%" align="center">
	<span class='portlet-form-field-label' ><spagobi:message key="editConf.noConfiguration"/></span>
</div>

<br/><br/>
-->







