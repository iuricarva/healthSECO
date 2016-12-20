/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AcessaWS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;






/**
 *
 * @author icarv
 */
@ManagedBean
public class ConsultaCert {
    
    private String namePlatform;
    private PlatformModel model;

    public String getNamePlatform() {
        return namePlatform;
    }

    public void setNamePlatform(String namePlatform) {
        this.namePlatform = namePlatform;
    }
    
    
    
    public String getRetornaSust() throws ParserConfigurationException, SAXException{
        try {    
            URL url = new URL("http://localhost:8080/WSSecoRestiful/webresources/WSSecoRestful/getsustainability");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder;  
            try{  
                builder = factory.newDocumentBuilder();  
                Document document = builder.parse( new InputSource( new StringReader( output ) ) );
                ArrayList<NodeList> lista = new ArrayList<NodeList>();
                ArrayList<IndividualModel> lista2 = new ArrayList<IndividualModel>();
                IndividualModel model = new IndividualModel();
                NodeList nodes = document.getElementsByTagName("name");
                NodeList node;
                for(int i = 0; i < nodes.getLength(); i++){
                    node = nodes.item(i).getChildNodes();
                    lista.add(node);                    
                }
                
                for(int i = 0; i < lista.size(); i++){
                    System.out.println(i + lista.get(i).item(0).getNodeValue());
                }
                if(this.getNamePlatform().equals(lista.get(0).item(0).getNodeValue())){
                    return "The data confirms the presence of this health dimension.";
                }else{
                    return "Health dimension not defined.";
                }
                
            } catch (Exception e) {  
                e.printStackTrace();
                return e.getMessage();
            } 
            
            
            
        } catch (MalformedURLException e) {

		e.printStackTrace();
                return e.getMessage();

	  } catch (IOException e) {

		e.printStackTrace();
                return e.getMessage();

	}
        
        
    }

    
    public String getRetornaHet() throws ParserConfigurationException, SAXException{
        try {    
            URL url = new URL("http://localhost:8080/WSSecoRestiful/webresources/WSSecoRestful/getheterogeneity");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            if(output != null){
                return "Characteristic defined.";
            }else{
                return "Missing characteristic";
            }
            
        } catch (MalformedURLException e) {

		e.printStackTrace();
                return e.getMessage();

	  } catch (IOException e) {

		e.printStackTrace();
                return e.getMessage();

	}
        
        
    }
    public String getRetornaRegAb() throws ParserConfigurationException, SAXException{
        try {    
            URL url = new URL("http://localhost:8080/WSSecoRestiful/webresources/WSSecoRestful/getregenerationability");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
             if(output != null){
                return "Characteristic defined.";
            }else{
                return "Missing characteristic";
            }
             
        } catch (MalformedURLException e) {

		e.printStackTrace();
                return e.getMessage();

	  } catch (IOException e) {

		e.printStackTrace();
                return e.getMessage();

	  }
        
        
    }
    
    public String getRetornaEfBal() throws ParserConfigurationException, SAXException{
        try {    
            URL url = new URL("http://localhost:8080/WSSecoRestiful/webresources/WSSecoRestful/geteffortbalance");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            if(output != null){
                return "Characteristic defined.";
            }else{
                return "Missing characteristic";
            }
            
        } catch (MalformedURLException e) {

		e.printStackTrace();
                return e.getMessage();

	  } catch (IOException e) {

		e.printStackTrace();
                return e.getMessage();

	}
        
        
    }
    
    public String getRetornaExpBal() throws ParserConfigurationException, SAXException{
        try {    
            URL url = new URL("http://localhost:8080/WSSecoRestiful/webresources/WSSecoRestful/getexpertisebalance");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            if(output != null){
                return "Characteristic defined.";
            }else{
                return "Missing characteristic";
            }
            
        } catch (MalformedURLException e) {

		e.printStackTrace();
                return e.getMessage();

	  } catch (IOException e) {

		e.printStackTrace();
                return e.getMessage();

	}
        
        
    }
    
    public String getRetornaVisib() throws ParserConfigurationException, SAXException{
        try {    
            URL url = new URL("http://localhost:8080/WSSecoRestiful/webresources/WSSecoRestful/getvisibility");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            if(output != null){
                return "Characteristic defined.";
            }else{
                return "Missing characteristic";
            }
            
        } catch (MalformedURLException e) {

		e.printStackTrace();
                return e.getMessage();

	  } catch (IOException e) {

		e.printStackTrace();
                return e.getMessage();

	}
        
        
    }
    
    public PlatformModel getRetornaProductivity() throws ParserConfigurationException, SAXException{
        try {    
            URL url = new URL("http://localhost:8080/WSSecoRestiful/webresources/WSSecoRestful/getproductivity");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            this.model = new PlatformModel();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder;  
            try{
                String teste;
                builder = factory.newDocumentBuilder();  
                Document document = builder.parse( new InputSource( new StringReader( output ) ) );
                NodeList nodes = document.getElementsByTagName("name");
                this.model.setName(nodes.item(0).getChildNodes().item(0).getNodeValue());
                
                nodes = document.getElementsByTagName("averageTimeUse");
                this.model.setAverageTimeUse(Integer.parseInt(nodes.item(0).getChildNodes().item(0).getNodeValue()));
                nodes = document.getElementsByTagName("bugFixTime");
                this.model.setBugFixTime(Integer.parseInt(nodes.item(0).getChildNodes().item(0).getNodeValue()));
                nodes = document.getElementsByTagName("creationData");
                this.model.setCreationData(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("^^http://www.w3.org/2001/XMLSchema#dateTime", ""));
                nodes = document.getElementsByTagName("eventName");
                this.model.setEventName(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("fileName");
                this.model.setFileName(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("KLOC");
                this.model.setKLOC(Integer.parseInt(nodes.item(0).getChildNodes().item(0).getNodeValue()));
                nodes = document.getElementsByTagName("newMemberName");
                this.model.setNewMemberName(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("numMessages");
                this.model.setNumMessages(Integer.parseInt(nodes.item(0).getChildNodes().item(0).getNodeValue()));
                nodes = document.getElementsByTagName("numberOfUser");
                this.model.setNumberOfUser(Integer.parseInt(nodes.item(0).getChildNodes().item(0).getNodeValue()));
                nodes = document.getElementsByTagName("occurredDate");
                this.model.setOccurredDate(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("^^http://www.w3.org/2001/XMLSchema#dateTime", ""));
                nodes = document.getElementsByTagName("projectName");
                this.model.setProjectName(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("starData");
                this.model.setStarData(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("^^http://www.w3.org/2001/XMLSchema#dateTime", ""));
                
                
                
                
                if(this.getNamePlatform().equals(this.model.getName())){
                    return this.model;
                }else{
                    return null;
                }
                
            } catch (Exception e) {  
                e.printStackTrace();
                //return e.getMessage();
            } 
            
        } catch (MalformedURLException e) {

		e.printStackTrace();
                //return e.getMessage();

	  } catch (IOException e) {

		e.printStackTrace();
                //return e.getMessage();

	}
        return null;
        
    }
    
    public PlatformModel getRetornaDiversity() throws ParserConfigurationException, SAXException{
        try {    
            URL url = new URL("http://localhost:8080/WSSecoRestiful/webresources/WSSecoRestful/getdiversity");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            this.model = new PlatformModel();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder;  
            try{
                builder = factory.newDocumentBuilder();  
                Document document = builder.parse( new InputSource( new StringReader( output ) ) );
                NodeList nodes = document.getElementsByTagName("name");
                this.model.setName(nodes.item(0).getChildNodes().item(0).getNodeValue());
                
                nodes = document.getElementsByTagName("numberOfUsersGroups");
                this.model.setNumberOfUsersGroups(Integer.parseInt(nodes.item(0).getChildNodes().item(0).getNodeValue()));
                nodes = document.getElementsByTagName("nameDeveloper1");
                this.model.setNameDeveloper1(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("nameDeveloper2");
                this.model.setNameDeveloper2(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("nameHardwareSupport1");
                this.model.setNameHardwareSupport1(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("nameHardwareSupport2");
                this.model.setNameHardwareSupport1(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("techName1");
                this.model.setTechName1(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("techName2");
                this.model.setTechName2(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("planForCollapse");
                this.model.setPlanForCollapse(nodes.item(0).getChildNodes().item(0).getNodeValue());
            if(this.getNamePlatform().equals(this.model.getName())){
                    return this.model;
                }else{
                    return null;
                }
                
            } catch (Exception e) {  
                e.printStackTrace();
                //return e.getMessage();
            }     
            
        } catch (MalformedURLException e) {

		e.printStackTrace();
                //return e.getMessage();

	  } catch (IOException e) {

		e.printStackTrace();
                //return e.getMessage();

	}
        
        return null;
    }
    
    public PlatformModel getRetornaNicheCreation() throws ParserConfigurationException, SAXException{
        try {    
            URL url = new URL("http://localhost:8080/WSSecoRestiful/webresources/WSSecoRestful/getnichecreation");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            this.model = new PlatformModel();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder;  
            try{
                builder = factory.newDocumentBuilder();  
                Document document = builder.parse( new InputSource( new StringReader( output ) ) );
                NodeList nodes = document.getElementsByTagName("name");
                this.model.setName(nodes.item(0).getChildNodes().item(0).getNodeValue());
                
                nodes = document.getElementsByTagName("nameDevTech1");
                this.model.setNameDevTech1(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("nameDevTech2");
                this.model.setNameDevTech2(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("techName1");
                this.model.setTechName1(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("techName2");
                this.model.setTechName2(nodes.item(0).getChildNodes().item(0).getNodeValue().replace("http://www.semanticweb.org/icarv/ontologies/2016/7/seco-4.owl#", ""));
                nodes = document.getElementsByTagName("nameSupport1");
                this.model.setNameSupport1(nodes.item(0).getChildNodes().item(0).getNodeValue());
                nodes = document.getElementsByTagName("nameSupport2");
                this.model.setNameSupport2(nodes.item(0).getChildNodes().item(0).getNodeValue());
                nodes = document.getElementsByTagName("supportNaturalLanguages");
                this.model.setSupportNaturalLanguages(nodes.item(0).getChildNodes().item(0).getNodeValue());
                nodes = document.getElementsByTagName("haveDocumentation");
                this.model.setHaveDocumentation(nodes.item(0).getChildNodes().item(0).getNodeValue());
            
                if(this.getNamePlatform().equals(this.model.getName())){
                    return this.model;
                }else{
                    return null;
                }
                
            } catch (Exception e) {  
                e.printStackTrace();
                //return e.getMessage();
            }
            
        } catch (MalformedURLException e) {

		e.printStackTrace();
                //return e.getMessage();

	  } catch (IOException e) {

		e.printStackTrace();
                //return e.getMessage();

	}
        return null;
        
    }
    
    public String getRetornaHeatlh() throws ParserConfigurationException, SAXException{
        try {    
            URL url = new URL("http://localhost:8080/WSSecoRestiful/webresources/WSSecoRestful/gethealth");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            if(output != null){
                return "The platform have heath.";
            }else{
                return "The platform doesn't have heath";
            }
            
        } catch (MalformedURLException e) {

		e.printStackTrace();
                return e.getMessage();

	  } catch (IOException e) {

		e.printStackTrace();
                return e.getMessage();

	}
        
        
    }
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        ConsultaCert c = new ConsultaCert();
        System.out.println(c.getRetornaHet());
    }
}
