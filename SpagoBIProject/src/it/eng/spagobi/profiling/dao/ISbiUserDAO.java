/**

SpagoBI - The Business Intelligence Free Platform

Copyright (C) 2005-2009 Engineering Ingegneria Informatica S.p.A.

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

**/
package it.eng.spagobi.profiling.dao;

import it.eng.spago.error.EMFUserError;
import it.eng.spagobi.commons.metadata.SbiExtRoles;
import it.eng.spagobi.profiling.bean.SbiAttribute;
import it.eng.spagobi.profiling.bean.SbiExtUserRoles;
import it.eng.spagobi.profiling.bean.SbiUser;
import it.eng.spagobi.profiling.bean.SbiUserAttributes;
import it.eng.spagobi.profiling.bo.UserBO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ISbiUserDAO {
	
	public Integer loadByUserId(String userId) throws EMFUserError;
	
	public SbiUser loadSbiUserByUserId(String userId) throws EMFUserError;
	
	public SbiUser loadSbiUserById(Integer id) throws EMFUserError;
	
	public UserBO loadUserById(Integer id) throws EMFUserError;
	
	public void deleteSbiUserById(Integer id) throws EMFUserError;
	
	public Integer saveSbiUser(SbiUser user) throws EMFUserError;
	
	public void updateSbiUserRoles(SbiExtUserRoles role) throws EMFUserError;
	
	public void updateSbiUserAttributes(SbiUserAttributes attribute) throws EMFUserError;
	
	public ArrayList<SbiExtRoles> loadSbiUserRolesById(Integer id) throws EMFUserError;
	
	public ArrayList<SbiUserAttributes> loadSbiUserAttributesById(Integer id) throws EMFUserError;
	
	public ArrayList<SbiUser> loadSbiUsers() throws EMFUserError;
	
	public ArrayList<UserBO> loadUsers() throws EMFUserError;
	
	public void updateSbiUser(SbiUser user, Integer userID) throws EMFUserError;
	
	public Integer fullSaveOrUpdateSbiUser(SbiUser user, List roles, HashMap<Integer, String> attributes) throws EMFUserError;

}
