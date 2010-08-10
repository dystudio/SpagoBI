package it.eng.spagobi.tools.dataset.bo;

import org.apache.log4j.Logger;

import it.eng.spagobi.services.dataset.bo.SpagoBiDataSet;
import it.eng.spagobi.tools.dataset.common.dataproxy.IDataProxy;
import it.eng.spagobi.tools.dataset.common.dataproxy.JavaClassDataProxy;
import it.eng.spagobi.tools.dataset.common.datareader.XmlDataReader;

public class JavaClassDataSet extends ConfigurableDataSet {
	 
	public static String DS_TYPE = "SbiJClassDataSet";
	
	private static transient Logger logger = Logger.getLogger(JavaClassDataSet.class);
	 
	
	public JavaClassDataSet() {
		super();
		setDataProxy( new JavaClassDataProxy() );
		setDataReader( new XmlDataReader() );
	}
	
	public JavaClassDataSet(SpagoBiDataSet dataSetConfig) {
		super(dataSetConfig);
		setDataProxy( new JavaClassDataProxy() );
		setDataReader( new XmlDataReader() );		
		
		setClassName( dataSetConfig.getJavaClassName() );
	}
	
	public SpagoBiDataSet toSpagoBiDataSet() {
		SpagoBiDataSet sbd;
		
		sbd = super.toSpagoBiDataSet();
		
		sbd.setType( DS_TYPE );
				
		sbd.setJavaClassName( getClassName() );
		
		return sbd;
	}
	
	public JavaClassDataProxy getDataProxy() {
		IDataProxy dataProxy;
		
		dataProxy = super.getDataProxy();
		
		if(dataProxy == null) {
			setDataProxy( new JavaClassDataProxy() );
			dataProxy = getDataProxy();
		}
		
		if(!(dataProxy instanceof  JavaClassDataProxy)) throw new RuntimeException("DataProxy cannot be of type [" + 
				dataProxy.getClass().getName() + "] in FileDataSet");
		
		return (JavaClassDataProxy)dataProxy;
	}

	public void setClassName(String className) {
		getDataProxy().setClassName(className);
	}
	
	public String getClassName() {
		return getDataProxy().getClassName();
	}
	
	
	 
}
