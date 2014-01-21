/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.by.urlfixer.modules;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import org.by.urlfixer.URLFixer;

/**
 *
 * @author byoung
 */
public class MailTo implements Module {

    @Override
    public boolean canAccept(Object o) {
        String s = (String)o;
        URLFixer.out(s);
        URLFixer.out(Boolean.toString(s.startsWith("mailto:")));
        return s.startsWith("mailto:");
    }

    @Override
    public void execute(Object o, Clipboard c) {
        final String s = (String)o;
        Transferable n = new Transferable() {

            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[] { DataFlavor.stringFlavor, DataFlavor.getTextPlainUnicodeFlavor() };
            }

            @Override
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                for (DataFlavor a : getTransferDataFlavors())
                    if (a.equals(flavor))
                        return true;
                return false;
            }

            @Override
            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                return s.substring(7);
            }
        };
        c.setContents(n, URLFixer.getOwner());
        URLFixer.out("Fixing " + s + " into " + s.substring(7));
    }
    
}
