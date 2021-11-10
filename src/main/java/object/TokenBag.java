/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.ArrayList;

/**
 *
 * @author aztk
 */
public class TokenBag {

     private final ArrayList<String> tokensArrayList;
     private final ArrayList<String> errorArrayList;
     private int tokenCount = 1;
     private int errorCount =1;

     public TokenBag() {
          tokensArrayList = new ArrayList<>();
          errorArrayList = new ArrayList<>();
     }

     public void saveToken(String tokenIn) {
          tokensArrayList.add(tokenIn);
          System.out.println("se guardo el token " + tokenIn +" numero " +tokenCount);
          tokenCount++;
      }
     public void logError(int line, int column, char symbol){
          String tmpData = errorCount +") " +"existe un error con el symbolo " + symbol + " en la linea " + line + " casila " + column+ "\n";
          System.out.println(tmpData);
          errorArrayList.add(tmpData);
          errorCount++;
     }
     
     public String showErrors() {
        String errors = "";
          
          for (int i = 0; i < errorArrayList.size(); i++) {
            errors +=errorArrayList.get(i);
        }
          
          if(errors.equals("")){
               errors = "No se detecto ningun error";
          }    
          return errors;
    }
     
}
