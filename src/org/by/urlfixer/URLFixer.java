/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.by.urlfixer;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import org.by.urlfixer.modules.MailTo;

/**
 *
 * @author byoung
 */
public class URLFixer implements Runnable {

    private MailTo mailTo = new MailTo();
    private  static Owner owner = new Owner();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new URLFixer();
    }
    
    public URLFixer() {
        new Thread(this).start();
        out("Starting URLFixer..");
    }
    
    public static void out(String s) {
        System.out.println(s);
    }
    
    public static Owner getOwner() {
        return owner;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
                if (c.getContents(null).isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    Transferable t = c.getContents(null);
                    String s = (String)t.getTransferData(DataFlavor.stringFlavor);
                    if (mailTo.canAccept(s))
                        mailTo.execute(s, c);
                }
                
                
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
