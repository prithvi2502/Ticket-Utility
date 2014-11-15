import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 







import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TicketUtility {


	static ArrayList<Ticket> ticketList = new ArrayList<>();
	
	public static void main(String[] args){
		System.out.println("TicketUtility");
		System.out.println("Owned by Mavericks Corp");
		
		
		
	
		boolean exit = false;
		while(!exit){
			System.out.print("$");
			Scanner sc = new Scanner(System.in);
			String command = sc.nextLine();
			
			if(command.substring(0,2).equals("ls")){
				read();
			}else if(command.substring(0,3).equals("add")){
				addRecord();
			}else if(command.substring(0,4).equals("find")){	
				
			}
		}
			
		

	}
	
	public static void addRecord(){
		try {
			Scanner sc = new Scanner(System.in);
			String filepath = "file.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);
	 
			// Get the root element
			Node company = doc.getFirstChild();
	 
			// Get the staff element , it may not working if tag has spaces, or
			// whatever weird characters in front...it's better to use
			// getElementsByTagName() to get it directly.
			// Node staff = company.getFirstChild();
	 
			// Get the staff element by tag name directly
			Element staff = doc.createElement("Ticket");
			company.appendChild(staff);
	 
			Attr attr = doc.createAttribute("id");
			attr.setValue(sc.nextLine());
			staff.setAttributeNode(attr);
	 
			// shorten way
			// staff.setAttribute("id", "1");
	 
			// firstname elements
			Element firstname = doc.createElement("ProblemName");
			firstname.appendChild(doc.createTextNode(sc.nextLine()));
			staff.appendChild(firstname);
	 
			// lastname elements
			Element lastname = doc.createElement("Discription");
			lastname.appendChild(doc.createTextNode(sc.nextLine()));
			staff.appendChild(lastname);
	 
			// nickname elements
			Element nickname = doc.createElement("DateIssued");
			nickname.appendChild(doc.createTextNode(sc.nextLine()));
			staff.appendChild(nickname);
	 
			// salary elements
			Element salary = doc.createElement("DateDoneBy");
			salary.appendChild(doc.createTextNode(sc.nextLine()));
			staff.appendChild(salary);
	 
			Element salarys = doc.createElement("FixType");
			salarys.appendChild(doc.createTextNode(sc.nextLine()));
			staff.appendChild(salarys);
	 
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);
	 
			System.out.println("Done");
	 
		   } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		   } catch (TransformerException tfe) {
			tfe.printStackTrace();
		   } catch (IOException ioe) {
			ioe.printStackTrace();
		   } catch (SAXException sae) {
			sae.printStackTrace();
		   }
	}
	public static void read(){
		try {
			 
			File fXmlFile = new File("file.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		 
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
		 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		 
			NodeList nList = doc.getElementsByTagName("Ticket");
		 
			System.out.println("----------------------------");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);
		 
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
		 
					System.out.println("id : " + eElement.getAttribute("id"));
					System.out.println("Problem Name : " + eElement.getElementsByTagName("ProblemName").item(0).getTextContent());
					System.out.println("Discription : " + eElement.getElementsByTagName("Discription").item(0).getTextContent());
					System.out.println("Date Issued : " + eElement.getElementsByTagName("DateIssued").item(0).getTextContent());
					System.out.println("Date Done By : " + eElement.getElementsByTagName("DateDoneBy").item(0).getTextContent());
					System.out.println("Fix Type : " + eElement.getElementsByTagName("FixType").item(0).getTextContent());
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
	}

}
