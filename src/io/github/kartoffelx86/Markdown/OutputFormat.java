/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kartoffelx86.Markdown;

/**
 * Output Formats that can be used
 * 
 * @author Julian
 */
public enum OutputFormat {
    
    /**
     * Outputs XHTML 1.x (Default)
     */
    xhtml1,
    
    /**
     * Outputs XHTML style tags of HTML 5
     */
    xhtml5,
    
    /**
     * Outputs latest supported version of XHTML (currently XHTML 1.1).
     */
    xhtml,
    
    /**
     * Outputs HTML 4
     */
    html4,
    
    /**
     * Outputs HTML style tags of HTML 5
     */
    html5,
    
    /**
     * Outputs latest supported version of HTML (currently HTML 4).
     */
    html
}
