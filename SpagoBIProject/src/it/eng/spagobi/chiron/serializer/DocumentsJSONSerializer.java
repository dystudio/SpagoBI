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
package it.eng.spagobi.chiron.serializer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;

import it.eng.spagobi.analiticalmodel.document.bo.BIObject;
import it.eng.spagobi.commons.bo.Domain;
import it.eng.spagobi.commons.dao.DAOFactory;
import it.eng.spagobi.commons.dao.IDomainDAO;
import it.eng.spagobi.commons.utilities.messages.MessageBuilder;
import it.eng.spagobi.engines.config.bo.Engine;
import it.eng.spagobi.engines.config.bo.Exporters;
import it.eng.spagobi.engines.config.dao.IEngineDAO;

/**
 * @author Antonella Giachino (antonella.giachino@eng.it)
 */
public class DocumentsJSONSerializer implements Serializer {
	
	// please modify also documentBrowser.xml properly everytime this serializer is modified
	public static final String ID = "id";
	public static final String LABEL = "label";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String TYPECODE = "typeCode";
	public static final String TYPEID = "typeId";
	public static final String ENCRYPT = "encrypt";
	public static final String VISIBLE = "visible";
	public static final String PROFILEDVISIBILITY = "profiledVisibility";
	public static final String ENGINE = "engine";
	public static final String DATASOURCE = "datasource";
	public static final String DATASET = "dataset";
	public static final String UUID = "uuid";
	public static final String RELNAME = "relname";
	public static final String STATECODE = "stateCode";
	public static final String STATEID = "stateId";
	public static final String FUNCTIONALITIES = "functionalities";
	public static final String CREATIONDATE = "creationDate";
	public static final String CREATIONUSER = "creationUser";
	public static final String REFRESHSECONDS = "refreshSeconds";
	public static final String ACTIONS = "actions";
	public static final String EXPORTERS = "exporters";
	
	
	public Object serialize(Object o, Locale locale) throws SerializationException {
		JSONObject  result = null;
		
		if( !(o instanceof BIObject) ) {
			throw new SerializationException("DocumentsJSONSerializer is unable to serialize object of type: " + o.getClass().getName());
		}
		
		try {
			BIObject obj = (BIObject)o;
			result = new JSONObject();
			
			result.put(ID, obj.getId() );
			result.put(LABEL, obj.getLabel() );
			MessageBuilder msgBuild=new MessageBuilder();
			String objName=msgBuild.getUserMessage(obj.getName(),null, locale);
			result.put(NAME, objName );
			String description=msgBuild.getUserMessage( obj.getDescription() ,null, locale);
			result.put(DESCRIPTION, description);		
			result.put(TYPECODE, obj.getBiObjectTypeCode());
			result.put(TYPEID, obj.getBiObjectTypeID());
			result.put(ENCRYPT, obj.getEncrypt());
			result.put(VISIBLE, obj.getVisible());
			result.put(PROFILEDVISIBILITY, obj.getProfiledVisibility());
			// engine property MUST be not null because it is iproperly used for the moment
			// by the extjs template class to discriminate between folders and document
			if(obj.getEngine().getDescription() != null) {
				result.put(ENGINE, obj.getEngine().getDescription());
			} else if(obj.getEngine().getName() != null) {
				result.put(ENGINE, obj.getEngine().getName());
			} else {
				result.put(ENGINE, obj.getEngine().getId());
			}
			result.put(DATASOURCE, obj.getDataSourceId());
			result.put(DATASET, obj.getDataSetId());
			result.put(UUID, obj.getUuid());
			result.put(RELNAME, obj.getRelName());
			result.put(STATECODE, obj.getStateCode());
			result.put(STATEID, obj.getStateID());
			result.put(FUNCTIONALITIES, obj.getFunctionalities());
			result.put(CREATIONDATE, obj.getCreationDate());
			result.put(CREATIONUSER, obj.getCreationUser());
			result.put(REFRESHSECONDS, obj.getRefreshSeconds());
			result.put(ACTIONS, new JSONArray());
			 
			Integer engineId=null;
				Engine engineObj=obj.getEngine();
				JSONArray prova = new JSONArray();
				if(engineObj!=null){	
					
					IEngineDAO engineDao=DAOFactory.getEngineDAO();
					List exporters=new ArrayList();
					exporters=engineDao.getAssociatedExporters(engineObj);			
					if(!exporters.isEmpty()){
						for (Iterator iterator = exporters.iterator(); iterator.hasNext();) {
							
							 Exporters exp = (Exporters) iterator.next();
							 Integer domainId=exp.getDomainId();
							 
							 IDomainDAO domainDao=DAOFactory.getDomainDAO();
							 Domain domain=domainDao.loadDomainById(domainId);
							 if(domain!=null){
								 String value_cd=domain.getValueCd();
								 String urlExporter=null;	
								 if (value_cd!=null){
									 prova.put(value_cd);
								 }
							 }
						}
					}
				}
				
				result.put(EXPORTERS, prova);
			
			
		} catch (Throwable t) {
			throw new SerializationException("An error occurred while serializing object: " + o, t);
		} finally {
			
		}
		
		return result;
	}
	
	
}
