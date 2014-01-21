/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.by.urlfixer.modules;

import java.awt.datatransfer.Clipboard;

/**
 *
 * @author byoung
 */
public interface Module {
    
    public boolean canAccept(Object o);
    
    public void execute(Object o, final Clipboard c);
    
}
