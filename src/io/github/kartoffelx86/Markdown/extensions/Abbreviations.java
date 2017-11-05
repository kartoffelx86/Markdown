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
public class Abbreviations implements Extension {

    public final String path = "markdown.extensions.abbr";

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getConfig() {
        return null;
    }

}
