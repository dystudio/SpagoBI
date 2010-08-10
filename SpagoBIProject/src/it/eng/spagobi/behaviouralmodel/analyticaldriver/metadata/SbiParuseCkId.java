/**

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

**/
package it.eng.spagobi.behaviouralmodel.analyticaldriver.metadata;

import it.eng.spagobi.behaviouralmodel.check.metadata.SbiChecks;




/**
 * SbiParuseCkId generated by hbm2java
 */
public class SbiParuseCkId  implements java.io.Serializable {

    // Fields    

     private SbiParuse sbiParuse;
     private SbiChecks sbiChecks;


    // Constructors

    /**
     * default constructor.
     */
    public SbiParuseCkId() {
    }
    
   
    
    

    // Property accessors

    /**
     * Gets the sbi paruse.
     * 
     * @return the sbi paruse
     */
    public SbiParuse getSbiParuse() {
        return this.sbiParuse;
    }
    
    /**
     * Sets the sbi paruse.
     * 
     * @param sbiParuse the new sbi paruse
     */
    public void setSbiParuse(SbiParuse sbiParuse) {
        this.sbiParuse = sbiParuse;
    }

    /**
     * Gets the sbi checks.
     * 
     * @return the sbi checks
     */
    public SbiChecks getSbiChecks() {
        return this.sbiChecks;
    }
    
    /**
     * Sets the sbi checks.
     * 
     * @param sbiChecks the new sbi checks
     */
    public void setSbiChecks(SbiChecks sbiChecks) {
        this.sbiChecks = sbiChecks;
    }

   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SbiParuseCkId) ) return false;
		 SbiParuseCkId castOther = ( SbiParuseCkId ) other; 
         
		 return (this.getSbiParuse()==castOther.getSbiParuse()) || ( this.getSbiParuse()!=null && castOther.getSbiParuse()!=null && this.getSbiParuse().equals(castOther.getSbiParuse()) )
 && (this.getSbiChecks()==castOther.getSbiChecks()) || ( this.getSbiChecks()!=null && castOther.getSbiChecks()!=null && this.getSbiChecks().equals(castOther.getSbiChecks()) );
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getSbiParuse().hashCode();
         result = 37 * result + this.getSbiChecks().hashCode();
         return result;
   }   


}