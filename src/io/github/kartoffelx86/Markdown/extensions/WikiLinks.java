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
public class WikiLinks implements Extension {

    /**
     * @return the base_url
     */
    public String getBase_url() {
        return base_url;
    }

    /**
     * @param base_url the base_url to set
     */
    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    /**
     * @return the end_url
     */
    public String getEnd_url() {
        return end_url;
    }

    /**
     * @param end_url the end_url to set
     */
    public void setEnd_url(String end_url) {
        this.end_url = end_url;
    }

    /**
     * @return the html_class
     */
    public String getHtml_class() {
        return html_class;
    }

    /**
     * @param html_class the html_class to set
     */
    public void setHtml_class(String html_class) {
        this.html_class = html_class;
    }

    private final String path = "markdown.extensions.wikilinks";
    private String base_url = "/";
    private String end_url = "/";
    private String html_class = "wikilink";

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getConfig() {
        String config = "";
        config += "'base_url' = '" + base_url + "'";
        config += ", 'end_url' = '" + end_url + "'";
        config += ", 'html_class' = '" + html_class + "'";
        return config;
    }
}
