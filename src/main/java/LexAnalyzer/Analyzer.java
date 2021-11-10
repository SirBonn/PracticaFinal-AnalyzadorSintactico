/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LexAnalyzer;

import object.TokenBag;

/**
 *
 * @author aztk
 */
public class Analyzer {

     private final String inputText;
     //private String token = "";
     private final int[][] stateAutom = new int[16][13]; //matrizEstados[estado][simbolo]
     private int actualState = 0;
     private int line = 1;
     private int column = 0;
     private int previousState;
     private final TokenBag tokenBag;

     {
          //Asignamos los estados de transicion     
          stateAutom[0][0] = 1;
          stateAutom[1][0] = 1;
          stateAutom[2][0] = 1;
          stateAutom[3][0] = 1;
          stateAutom[10][0] = 10;
          stateAutom[11][0] = 11;
          stateAutom[0][1] = 6;
          stateAutom[1][1] = 3;
          stateAutom[2][1] = 3;
          stateAutom[3][1] = 3;
          stateAutom[4][1] = 5;
          stateAutom[5][1] = 5;
          stateAutom[6][1] = 6;
          stateAutom[7][1] = 8;
          stateAutom[8][1] = 8;
          stateAutom[10][1] = 10;
          stateAutom[11][1] = 11;
          stateAutom[0][2] = 4;
          stateAutom[1][2] = 2;
          stateAutom[2][2] = 2;
          stateAutom[3][2] = 2;
          stateAutom[10][2] = 10;
          stateAutom[11][2] = 11;
          stateAutom[1][3] = 2;
          stateAutom[2][3] = 2;
          stateAutom[3][3] = 2;
          stateAutom[10][3] = 10;
          stateAutom[11][3] = 11;
          stateAutom[5][4] = 7;
          stateAutom[10][4] = 10;
          stateAutom[11][4] = 11;
          stateAutom[0][5] = 9;
          stateAutom[9][5] = 10;
          stateAutom[10][5] = 10;
          stateAutom[11][5] = 11;
          stateAutom[0][6] = 11;
          stateAutom[10][6] = 10;
          stateAutom[11][6] = 12;
          stateAutom[0][7] = 13;
          stateAutom[0][8] = 14;
          stateAutom[0][12] = 15;
          stateAutom[1][12] = 15;
          stateAutom[2][12] = 15;
          stateAutom[3][12] = 15;
          stateAutom[10][12] = 10;
          stateAutom[11][12] = 11;
          stateAutom[15][0] = 1;
          stateAutom[15][1] = 1;
          stateAutom[15][2] = 1;

          //llenamos la matriz con estados de error
          for (int i = 0; i < stateAutom.length; i++) {
               System.out.println("\n");
               for (int j = 0; j < stateAutom[0].length; j++) {
                    if (stateAutom[i][j] == 0) {
                         stateAutom[i][j] = -1;
                    }
                    System.out.print("[" + stateAutom[i][j] + "] ");
               }
          }
          System.out.println("");

     }

     public Analyzer(String inputText, TokenBag tokenBag) {
          this.inputText = inputText;
          this.tokenBag = tokenBag;
          readTokens(inputText);
     }

     private void readTokens(String inputString) {
          char tmpChar;
          String token = "";
          for (int i = 0; i < inputString.length(); i++) {

               if (Character.isSpaceChar(tmpChar = inputString.charAt(i)) || inputString.charAt(i) == '\n') {
                    readState(actualState, token);
                    token = "";
                    if (inputString.charAt(i) == '\n') {
                         column = 0;
                         line++;
                    }
               } else {

                    if (tmpChar != '\t' && tmpChar != '\f' && tmpChar != '\r') {
                         execute(tmpChar, line, column);
                         token += tmpChar;
                    }
               }
               column++;
          }
          readState(actualState, token);
     }

     private void execute(char symbol, int row, int column) {
          int tmpState = nextState(actualState, getTypeChar(symbol));
          previousState = actualState;
          actualState = tmpState;
          if (symbol != '\n') {
               System.out.println("Del estado " + previousState + " pasamos con " + symbol + " al estado " + actualState);
          }
          if (actualState == -1) {
               System.out.println("hubo un error ");
               if (symbol != '\n') {
                       actualState = 0;
                       tokenBag.logError(line, column, symbol);
               }
          }
     }

     private int nextState(int previousState, int typeChar) {
          int state = -1;
          if (typeChar >= 0 && typeChar <= 16) {
               state = stateAutom[previousState][typeChar];
          } else if (state == -1) {
               System.out.println("Se encuentra en un estado de error" );

          }
          return state;
     }

     private int getTypeChar(char symbol) {
          int type = -1;

          if (Character.isLetter(symbol)) {
               type = 0;
          } else if (Character.isDigit(symbol)) {
               type = 1;
          } else if (symbol == '-') {
               type = 2;
          } else if (symbol == '_') {
               System.out.println("");
               type = 3;
          } else if (symbol == '.') {
               System.out.println("");
               type = 4;
          } else if (symbol == '/') {
               System.out.println("");
               type = 5;
          } else if (symbol == '"') {
               System.out.println("");
               type = 6;
          } else if (symbol == '{') {
               System.out.println("");
               type = 7;
          } else if (symbol == '\n') {
               System.out.println("");
               type = 8;
          } else if (symbol == '\t' || symbol == '\r' || symbol == '\f') {
               System.out.println("");

          } else if (symbol == '+' || symbol == '=' || symbol == '*') {
               type = 12;
          } else {
               System.out.println("Se reconocio un caracter fuera del alfabeto");
               type = 0;
          }
          return type;
     }

     private void readState(int state, String token) {
          if (state == 1 || state == 2 || state == 3 || state == 5 || state == 6 || state == 7 || state == 10 || state == 12 || state == 13) {
               System.out.println("se reconocio el token " + token);
               tokenBag.saveToken(token);
               actualState = 0;
          }

     }

}
