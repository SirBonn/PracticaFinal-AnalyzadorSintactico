/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 *
 * @author aztk
 */
public class ButtonDriver {

     private StringSelection tmp;
     private int clicks = 0;

     public void initializeTextAreaButtons(JTextArea codeArea, JButton undoButton, JButton redoButton, JButton copyButton, JButton pasteButton) {
          UndoManager editManager = new UndoManager();
          codeArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
               @Override
               public void undoableEditHappened(UndoableEditEvent e) {
                    editManager.addEdit(e.getEdit());
               }
          });

          undoButton.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                    try {
                         editManager.undo();
                    } catch (Exception a) {

                    }
               }
          });
          redoButton.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                    try {
                         editManager.redo();
                    } catch (Exception a) {

                    }
               }
          });
          copyButton.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                    try {
                         tmp = new StringSelection(codeArea.getSelectedText());
                         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(tmp, tmp);
                    } catch (Exception a) {

                    }
               }
          });
          pasteButton.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                    Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
                    if (c.isDataFlavorAvailable(DataFlavor.stringFlavor)) {

                         try {
                              String temp = (String) c.getData(DataFlavor.stringFlavor);
                              codeArea.setText(codeArea.getText() + temp);
                         } catch (Exception a) {

                         }
                    }
               }
          });

     }

     public void changeLightMode(JPanel mainPane, JTextArea errorLogs, JTextArea textInput, JButton openFileButton, JButton analyzerButton,
            JButton saveToButton, JButton saveChangesButton, JButton newFileButton, JButton copyButton, JButton pasteButton, JButton undoButton,
            JButton redoButton, JButton aboutButton, JButton lightModeButton) {
          int DEFBACK1 = 60;
          int DEFBACK2 = 63;
          int DEFBACK3 = 65;
          if (clicks == 0) {
               mainPane.setBackground(new java.awt.Color(187, 187, 187));
               openFileButton.setBackground(new java.awt.Color(DEFBACK1, DEFBACK2, DEFBACK3));
               openFileButton.setForeground(new java.awt.Color(255, 255, 255));
               analyzerButton.setBackground(new java.awt.Color(DEFBACK1, DEFBACK2, DEFBACK3));
               analyzerButton.setForeground(new java.awt.Color(255, 255, 255));
               saveChangesButton.setBackground(new java.awt.Color(DEFBACK1, DEFBACK2, DEFBACK3));
               saveChangesButton.setForeground(new java.awt.Color(255, 255, 255));
               saveToButton.setBackground(new java.awt.Color(DEFBACK1, DEFBACK2, DEFBACK3));
               saveToButton.setForeground(new java.awt.Color(255, 255, 255));
               newFileButton.setBackground(new java.awt.Color(DEFBACK1, DEFBACK2, DEFBACK3));
               newFileButton.setForeground(new java.awt.Color(255, 255, 255));
               copyButton.setBackground(new java.awt.Color(DEFBACK1, DEFBACK2, DEFBACK3));
               copyButton.setForeground(new java.awt.Color(255, 255, 255));
               pasteButton.setBackground(new java.awt.Color(DEFBACK1, DEFBACK2, DEFBACK3));
               pasteButton.setForeground(new java.awt.Color(255, 255, 255));
               undoButton.setBackground(new java.awt.Color(DEFBACK1, DEFBACK2, DEFBACK3));
               undoButton.setForeground(new java.awt.Color(255, 255, 255));
               redoButton.setBackground(new java.awt.Color(DEFBACK1, DEFBACK2, DEFBACK3));
               redoButton.setForeground(new java.awt.Color(255, 255, 255));
               aboutButton.setBackground(new java.awt.Color(DEFBACK1, DEFBACK2, DEFBACK3));
               aboutButton.setForeground(new java.awt.Color(255, 255, 255));
               lightModeButton.setBackground(new java.awt.Color(DEFBACK1, DEFBACK2, DEFBACK3));
               clicks = 1;
          } else {

               mainPane.setBackground(new java.awt.Color(0, 102, 102));
               openFileButton.setBackground(new java.awt.Color(51, 0, 51));
               openFileButton.setForeground(new java.awt.Color(255, 255, 255));
               analyzerButton.setBackground(new java.awt.Color(102, 0, 51));
               analyzerButton.setForeground(new java.awt.Color(255, 255, 255));
               saveChangesButton.setBackground(new java.awt.Color(51, 0, 51));
               saveChangesButton.setForeground(new java.awt.Color(255, 255, 255));
               saveToButton.setBackground(new java.awt.Color(51, 0, 51));
               saveToButton.setForeground(new java.awt.Color(255, 255, 255));
               newFileButton.setBackground(new java.awt.Color(51, 0, 51));
               newFileButton.setForeground(new java.awt.Color(255, 255, 255));
               copyButton.setBackground(new java.awt.Color(51, 0, 51));
               copyButton.setForeground(new java.awt.Color(255, 255, 255));
               pasteButton.setBackground(new java.awt.Color(51, 0, 51));
               pasteButton.setForeground(new java.awt.Color(255, 255, 255));
               undoButton.setBackground(new java.awt.Color(51, 0, 51));
               undoButton.setForeground(new java.awt.Color(255, 255, 255));
               redoButton.setBackground(new java.awt.Color(51, 0, 51));
               redoButton.setForeground(new java.awt.Color(255, 255, 255));
               aboutButton.setBackground(new java.awt.Color(51, 0, 51));
               aboutButton.setForeground(new java.awt.Color(255, 255, 255));
               lightModeButton.setBackground(new java.awt.Color(0, 8, 27));
               lightModeButton.setForeground(new java.awt.Color(153, 153, 153));
               clicks = 0;
          }
     }

}
