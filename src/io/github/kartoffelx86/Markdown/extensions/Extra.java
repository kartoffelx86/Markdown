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
public class Extra implements Extension{
    
    private final String path = "markdown.extensions.extra";
    
    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getConfig() {
        return null;
    }
    
}
