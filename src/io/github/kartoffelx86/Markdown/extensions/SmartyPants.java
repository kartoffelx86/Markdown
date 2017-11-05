/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kartoffelx86.Markdown.extensions;

/**
 *
 * @author Julian
 */
public class SmartyPants implements Extension {

    private final String path = "markdown.extensions.smarty";
    private boolean smart_dashes = true;
    private boolean smart_quotes = true;
    private boolean smart_angled_quotes = false;
    private boolean smart_ellipses = true;
    
    private boolean substitutions = false;
    

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getConfig() {
        return "";
    }
    
    private String getPyBoolValue(boolean bool){
        return (bool ? "True" : "False");
    }
}
