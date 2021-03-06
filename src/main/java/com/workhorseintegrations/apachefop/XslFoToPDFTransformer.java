/**
 * 
 */
package com.workhorseintegrations.apachefop;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.fop.apps.MimeConstants;
import org.mule.api.annotations.Category;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Transformer;
import org.mule.api.annotations.param.Payload;
import org.mule.transport.NullPayload;
import org.xml.sax.SAXException;

import com.workhorseintegrations.apachefop.util.ApacheFOPTransformerUtil;

/**
 * @author mbrigilin
 *
 */
@Connector(minMuleVersion="3.7.3", name="xslfo-to-pdf", schemaVersion="1.0-SNAPSHOT", friendlyName="XSL-FO To PDF")
@Category(name = "org.mule.tooling.category.transformers", description = "Apache FOP XSL-FO to PDF")
public class XslFoToPDFTransformer
{
	/**
	 * 
	 * @param payload
	 * @return byte[]
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws FileNotFoundException 
	 */
	@Transformer(sourceTypes={String.class})
	public static byte[] xslfoToPdf(@Payload Object payload) throws FileNotFoundException, SAXException, IOException
	{	
		if( payload instanceof NullPayload || payload == null )
			return null;
		
		return ApacheFOPTransformerUtil.transform( payload, MimeConstants.MIME_PDF ) ;
	}
}