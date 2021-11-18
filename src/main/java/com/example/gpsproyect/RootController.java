package com.example.gpsproyect;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable{
	
	@FXML
    private TextArea textArea;

    @FXML
    private Button buttonGPGGA;

    @FXML
    private Button buttonGPGSV;

    @FXML
    private Button buttonGPGLL;

    @FXML
    private Button buttonGPGSA;
    
    String informacion = "";

    @FXML
    void GPGGA(MouseEvent event) {
    	
    	textArea.clear();
    	
    	String[] array = informacion.split("\\$");
    	for(int x=0; x<array.length; x++) {
    		System.out.println(x);
    		System.out.println(array[x]);
    		if(array[x].contains("GPGGA")) {
    			
    			String[] gpgga= array[x].split("\\,");
    			
    			String latitud= gpgga[2];
    			String grados= latitud.substring(0, 2);
    			float gradosFloat= Float.parseFloat(grados);
    			String minutos= latitud.substring(2);
    			float  minutosFloat= Float.parseFloat(minutos);
    			
    			float latitudFinal= gradosFloat+(minutosFloat/60);
    			
    			String Ub= gpgga[3];
    			
    			String longitud= gpgga[4];
    			String  gradosLong= longitud.substring(1, 3);
    			float gradosLFloat= Float.parseFloat(gradosLong);
    			String minutosLong= longitud.substring(3);
    			float minutosLFloat= Float.parseFloat(minutosLong);
    			
    			float longitudFinal= gradosLFloat+(minutosLFloat/60);
    			
    			String UbLong= gpgga[5];
    			
    			String tramaHora= gpgga[1];
    			String hora= tramaHora.substring(0,2)+":"+tramaHora.substring(2, 4)+":"+ tramaHora.substring(4,6);
    			
    			textArea.setText(textArea.getText()+" Hora: "+hora+"\n");
    			textArea.setText(textArea.getText()+"\n Fila: "+x+" Latitud "+latitud+ " Grados y minutos: "+ grados+"�"+ minutos+"' "+Ub+" Latitud Final: "+ latitudFinal);
    			textArea.setText(textArea.getText()+"\n Fila: "+x+" Longitud "+longitud+ " Grados y minutos: "+ gradosLong+"�"+ minutosLong+"' "+UbLong+" Longitud Final: "+ longitudFinal+ "\n\n");
    			
    		}
    	}
    }

    @FXML
    void GPGLL(MouseEvent event) {
    	textArea.clear();
    	
    	String[] array = informacion.split("\\$");
    	for(int x=0; x<array.length; x++) {
    		System.out.println(x);
    		System.out.println(array[x]);
    		if(array[x].contains("GPGLL")) {
    			
    			String[] gpgll= array[x].split("\\,");
    			
    			String latitud= gpgll[1];
    			String grados= latitud.substring(0, 2);
    			float gradosFloat= Float.parseFloat(grados);
    			String minutos= latitud.substring(2);
    			float  minutosFloat= Float.parseFloat(minutos);
    			
    			float latitudFinal= gradosFloat+(minutosFloat/60);
    			
    			String Ub= gpgll[2];
    			
    			String longitud= gpgll[3];
    			String  gradosLong= longitud.substring(1, 3);
    			float gradosLFloat= Float.parseFloat(gradosLong);
    			String minutosLong= longitud.substring(3);
    			float minutosLFloat= Float.parseFloat(minutosLong);
    			
    			float longitudFinal= gradosLFloat+(minutosLFloat/60);
    			
    			String UbLong= gpgll[4];
    			
    			String tramaHora= gpgll[5];
    			String hora= tramaHora.substring(0,2)+":"+tramaHora.substring(2, 4)+":"+ tramaHora.substring(4,6);
    			
    			textArea.setText(textArea.getText()+" Hora: "+hora+"\n");
    			textArea.setText(textArea.getText()+"\n Fila: "+x+" Latitud "+latitud+ " Grados y minutos: "+ grados+"�"+ minutos+"' "+Ub+" Latitud Final: "+ latitudFinal);
    			textArea.setText(textArea.getText()+"\n Fila: "+x+" Longitud "+longitud+ " Grados y minutos: "+ gradosLong+"�"+ minutosLong+"' "+UbLong+" Longitud Final: "+ longitudFinal+ "\n\n");
    			
    		}
    	}
    }

    @FXML
    void GPGSA(MouseEvent event) {
    	textArea.clear();
    	
    	String[] array = informacion.split("\\$");
    	for(int x=0; x<array.length; x++) {
    		System.out.println(x);
    		System.out.println(array[x]);
    		if(array[x].contains("GPGSA")) {
    			
    			textArea.setText(textArea.getText()+" Fila: "+ x);
    			
    			String[] gpgsa= array[x].split("\\,");
    			
    			String modo1= gpgsa[1];
    			
    			if(modo1.equals("A")) {
    				textArea.setText(textArea.getText()+ "Automatico"+ "  ");
    			}else {
    				textArea.setText(textArea.getText()+ "Forzado"+ "  ");
    			}
    			
    			String modo2= gpgsa[2];
    			
    			switch(modo2) {
    				case("1"): 
						textArea.setText(textArea.getText()+"Sin modo"+"\n");
						break;
    				case("2"): 
						textArea.setText(textArea.getText()+"2D"+"\n");
						break;
    				case("3"): 
    					textArea.setText(textArea.getText()+"3D"+"\n");
    					break;
    				default: break;
    			}
    			
    			for(int  z= 3; z< 7; z++) {
    				textArea.setText(textArea.getText()+" Id Sat�lite:  "+ gpgsa[z]+"\n");
    			}
    			textArea.setText(textArea.getText()+" PDOP: "+ gpgsa[15]+"\n");
    			textArea.setText(textArea.getText()+" HDOP: "+ gpgsa[16]+"\n");
    			textArea.setText(textArea.getText()+" VDOP: "+ gpgsa[17].substring(0,4)+"\n");
    			textArea.setText(textArea.getText()+" Suma de verificaci�n: "+ gpgsa[17].substring(4)+"\n");
    		}
    	}

    }

    @FXML
    void GPGSV(MouseEvent event) {
    	textArea.clear();
    	
    	String[] array = informacion.split("\\$");
    	for(int x=0; x<array.length; x++) {
    		System.out.println(x);
    		System.out.println(array[x]);
    		if(array[x].contains("GPGSV")) {
    			
    			textArea.setText(textArea.getText()+" Fila: "+ x+"\n");
    			
    			String[] gpgsv= array[x].split("\\,");
    			if(gpgsv.length<=8) {
    				textArea.setText(textArea.getText()+"Numero de mensajes: "+ gpgsv[1]+"\n");
        			textArea.setText(textArea.getText()+"Numero de secuencia: "+ gpgsv[2]+"\n");
        			textArea.setText(textArea.getText()+"Satelites a la vista: "+ gpgsv[3]+"\n");
        			textArea.setText(textArea.getText()+"Id del satelite: "+ gpgsv[4]+"\n");
        			textArea.setText(textArea.getText()+"Elevacion 1: "+ gpgsv[5]+"\n");
        			textArea.setText(textArea.getText()+"Azimut 1: "+ gpgsv[6]+"\n");
        			textArea.setText(textArea.getText()+"SNR 1: "+ gpgsv[7]+"\n\n");
    			}
    			if(gpgsv.length>8 && gpgsv.length<=12) {
    				textArea.setText(textArea.getText()+"Numero de mensajes: "+ gpgsv[1]+"\n");
        			textArea.setText(textArea.getText()+"Numero de secuencia: "+ gpgsv[2]+"\n");
        			textArea.setText(textArea.getText()+"Satelites a la vista: "+ gpgsv[3]+"\n");
        			textArea.setText(textArea.getText()+"Id del satelite: "+ gpgsv[4]+"\n");
        			textArea.setText(textArea.getText()+"Elevacion 1: "+ gpgsv[5]+"\n");
        			textArea.setText(textArea.getText()+"Azimut 1: "+ gpgsv[6]+"\n");
        			textArea.setText(textArea.getText()+"SNR 1: "+ gpgsv[7]+"\n");
        			textArea.setText(textArea.getText()+"Elevacion 2: "+ gpgsv[8]+"\n");
        			textArea.setText(textArea.getText()+"Azimut 2: "+ gpgsv[9]+"\n");
        			textArea.setText(textArea.getText()+"SNR 2: "+ gpgsv[10]+"\n\n");
    			}
    			if(gpgsv.length>12) {
    			textArea.setText(textArea.getText()+"Numero de mensajes: "+ gpgsv[1]+"\n");
    			textArea.setText(textArea.getText()+"Numero de secuencia: "+ gpgsv[2]+"\n");
    			textArea.setText(textArea.getText()+"Satelites a la vista: "+ gpgsv[3]+"\n");
    			textArea.setText(textArea.getText()+"Id del satelite: "+ gpgsv[4]+"\n");
    			textArea.setText(textArea.getText()+"Elevacion 1: "+ gpgsv[5]+"\n");
    			textArea.setText(textArea.getText()+"Azimut 1: "+ gpgsv[6]+"\n");
    			textArea.setText(textArea.getText()+"SNR 1: "+ gpgsv[7]+"\n");
    			textArea.setText(textArea.getText()+"Elevacion 2: "+ gpgsv[8]+"\n");
    			textArea.setText(textArea.getText()+"Azimut 2: "+ gpgsv[9]+"\n");
    			textArea.setText(textArea.getText()+"SNR 2: "+ gpgsv[10]+"\n");
    			textArea.setText(textArea.getText()+"Elevacion 3: "+ gpgsv[11]+"\n");
    			textArea.setText(textArea.getText()+"Azimut 3: "+ gpgsv[12]+"\n");
    			textArea.setText(textArea.getText()+"SNR 3: "+ gpgsv[13]+"\n\n");
    			}
    		}
    	}
    	
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		  File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      
		 try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File ("/home/felipe/Documentos/GPSproyect/src/main/Texto/GPS.txt"); //path en Ubuntu
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null) {
	            informacion+=linea+"\n";
	         }
	         textArea.setText(informacion);
	
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si toda va bien como si salta  una expcion
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
		
	}
}

