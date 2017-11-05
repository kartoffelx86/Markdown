/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kartoffelx86.Markdown.extensions;

/**
 * highlight.js?
 *
 * @author Julian
 */
public class Fenced_Code_Blocks implements Extension {

    private final String path = "markdown.extensions.fenced_code";

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getConfig() {
        return null;
    }
}
