package JavaPrograms;
import java.io.StringReader;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XmlReader {

  /**
   * @param args
 * @throws Exception 
   */
  public static void main(String[] args) throws Exception {
     
	  String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
	  		+ "<GMF xmlns=\"com/fiserv/Merchant/gmfV12.04\">\r\n"
	  		+ "   <CreditRequest>\r\n"
	  		+ "       <CommonGrp>\r\n"
	  		+ "           <PymtType>Credit</PymtType>\r\n"
	  		+ "           <TxnType>Verification</TxnType>\r\n"
	  		+ "           <LocalDateTime>20241129053208</LocalDateTime>\r\n"
	  		+ "           <TrnmsnDateTime>20241129053208</TrnmsnDateTime>\r\n"
	  		+ "           <STAN>695326</STAN>\r\n"
	  		+ "           <RefNum>4334695326</RefNum>\r\n"
	  		+ "           <OrderNum>59725636</OrderNum>\r\n"
	  		+ "           <TPPID>RPA227</TPPID>\r\n"
	  		+ "           <TermID>00000001</TermID>\r\n"
	  		+ "           <MerchID>RCTST1000106710</MerchID>\r\n"
	  		+ "           <MerchCatCode>5967</MerchCatCode>\r\n"
	  		+ "           <POSEntryMode>010</POSEntryMode>\r\n"
	  		+ "           <POSCondCode>08</POSCondCode>\r\n"
	  		+ "           <TermCatCode>00</TermCatCode>\r\n"
	  		+ "           <TermEntryCapablt>01</TermEntryCapablt>\r\n"
	  		+ "           <TxnAmt>000000000000</TxnAmt>\r\n"
	  		+ "           <TxnCrncy>840</TxnCrncy>\r\n"
	  		+ "           <TermLocInd>1</TermLocInd>\r\n"
	  		+ "           <CardCaptCap>0</CardCaptCap>\r\n"
	  		+ "           <GroupID>40001</GroupID>\r\n"
	  		+ "           <TranInit>Merchant</TranInit>\r\n"
	  		+ "       </CommonGrp>\r\n"
	  		+ "       <CardGrp>\r\n"
	  		+ "           <AcctNum>6011361011111119</AcctNum>\r\n"
	  		+ "           <CardExpiryDate>20491220</CardExpiryDate>\r\n"
	  		+ "           <CardType>Discover</CardType>\r\n"
	  		+ "           <CCVInd>Prvded</CCVInd>\r\n"
	  		+ "           <CCVData>123</CCVData>\r\n"
	  		+ "       </CardGrp>       \r\n"
	  		+ "       <DSGrp>\r\n"
	  		+ "           <DiscAuthInd>CrdOnFile</DiscAuthInd>\r\n"
	  		+ "           <StoredCrdnInd>Initial</StoredCrdnInd>\r\n"
	  		+ "           <CofSchInd>Scheduled</CofSchInd>\r\n"
	  		+ "       </DSGrp>       \r\n"
	  		+ "       <CustInfoGrp>\r\n"
	  		+ "           <AVSBillingAddr>1307 Broad Hollow Road</AVSBillingAddr>\r\n"
	  		+ "           <AVSBillingPostalCode>11747</AVSBillingPostalCode>\r\n"
	  		+ "       </CustInfoGrp>\r\n"
	  		+ "   </CreditRequest>\r\n"
	  		+ "</GMF>";

	  
	  DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	  InputSource src = new InputSource();
	  src.setCharacterStream(new StringReader(xml));

	  Document doc = builder.parse(src);
	  String AcctNum = doc.getElementsByTagName("AcctNum").item(0).getTextContent();
//	  String name = doc.getElementsByTagName("name").item(0).getTextContent();
	  System.out.println("AcctNum = "+ AcctNum);
	  
  }

}