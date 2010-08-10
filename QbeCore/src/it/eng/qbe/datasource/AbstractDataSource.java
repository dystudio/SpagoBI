/**
 * SpagoBI - The Business Intelligence Free Platform
 *
 * Copyright (C) 2004 - 2008 Engineering Ingegneria Informatica S.p.A.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 **/
package it.eng.qbe.datasource;

import it.eng.qbe.bo.DatamartProperties;
import it.eng.qbe.model.accessmodality.DataMartModelAccessModality;

/**
 * @author Andrea Gioia
 */
public abstract class AbstractDataSource implements IDataSource {
	
	private String name;
	private int type;
	private DatamartProperties properties = null;	
	private DataMartModelAccessModality dataMartModelAccessModality;
	
	public DataMartModelAccessModality getDataMartModelAccessModality() {
		return dataMartModelAccessModality;
	}

	public void setDataMartModelAccessModality(
			DataMartModelAccessModality dataMartModelAccessModality) {
		this.dataMartModelAccessModality = dataMartModelAccessModality;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	protected void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
	
	
	// =========================================================================================================
	// Qbe properties
	// =========================================================================================================
	public DatamartProperties getProperties() {
		return properties;
	}
	
	public void setProperties(DatamartProperties properties) {
		this.properties = properties;
	}
	
}
