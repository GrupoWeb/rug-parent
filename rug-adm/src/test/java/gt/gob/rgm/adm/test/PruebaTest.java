package gt.gob.rgm.adm.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class PruebaTest {

	public static long countMax(List<String> upRight) {
	    // Write your code here
	        List<Integer> ejeX = new ArrayList<Integer>();
	        List<Integer> ejeY = new ArrayList<Integer>();
	        
	        for(String linea:upRight){
	            String[] divide = linea.split("\\s+");
	            ejeX.add(new Integer(divide[0]));
	            ejeY.add(new Integer(divide[1]));
	        }
	        
	        int maxX = obtenerMaximo(ejeX);
	        int maxY = obtenerMaximo(ejeY);
	        
	        int[][] matriz = new int [maxX][maxY];
	        //inicializo matriz
	        int value = 0;
	        for(int i=0; i<maxX; i++){
	            for(int j=0; j<maxY; j++){
	                matriz[i][j] = value;
	            }
	        }
	        
	        //se hacen los steps
	        for(int k=0; k<upRight.size(); k++){
	            for(int l=0; l<ejeX.get(k); l++){
	                for(int m=0; m<ejeY.get(k); m++){
	                    matriz[l][m] = matriz[l][m]+1;
	                    if(matriz[l][m] > value){
	                        value = matriz[l][m];
	                    }
	                }
	            }
	        }
	        
	        // contar cuantos values hay 
	        int conteo = 0;
	        for(int p=0; p<maxX; p++){
	            for(int q=0; q<maxY; q++){
	                if(matriz[p][q] == value){
	                    conteo++;
	                }
	            }
	        }
	        
	        return new Long(conteo);
	    }

	    public static int obtenerMaximo(List<Integer> enteros){
	        int maximo = 0;
	        
	        for(int i:enteros){
	            if(i>maximo){
	                maximo = i;
	            }
	        }
	        return maximo;
	    }
	
	
	    private static String readAll(Reader rd) throws IOException {
	        StringBuilder sb = new StringBuilder();
	        int cp;
	        while ((cp = rd.read()) != -1) {
	          sb.append((char) cp);
	        }
	        return sb.toString();
	      }   
	    
	    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	        InputStream is = new URL(url).openStream();
	        try {
	          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	          String jsonText = readAll(rd);
	          JSONObject json = new JSONObject(jsonText);
	          return json;
	        } finally {
	          is.close();
	        }
	      }    
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		List<String> lista = new ArrayList<String>();
		
		lista.add("2  3");
		lista.add("3  7");
		lista.add("4  1");
		
		//System.out.println("Result" + countMax(lista));
		
		String url = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + "sparrow";
        
		JSONObject json;
		try {
			json = readJsonFromUrl(url);
			//System.out.println(json. get("text"));
		    //int count = StringUtils.countMatches(,"Pizza");
			Pattern pattern = Pattern.compile("sparrow", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(json.toString());
			int count = 0;
			while (matcher.find()) {
			    count++;
			}
		    
		    System.out.println(count);
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
