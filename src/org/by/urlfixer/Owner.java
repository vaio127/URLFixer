/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.by.urlfixer;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

/**
 *
 * @author byoung
 */
public class Owner implements ClipboardOwner {

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
    }
    
}
