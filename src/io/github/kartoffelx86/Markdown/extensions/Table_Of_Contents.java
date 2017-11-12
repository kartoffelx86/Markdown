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
public class Table_Of_Contents implements Extension {

    /**
     * @return the marker
     */
    public String getMarker() {
        return marker;
    }

    /**
     * @param marker the marker to set
     */
    public void setMarker(String marker) {
        this.marker = marker;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the anchorlink
     */
    public boolean isAnchorlink() {
        return anchorlink;
    }

    /**
     * @param anchorlink the anchorlink to set
     */
    public void setAnchorlink(boolean anchorlink) {
        this.anchorlink = anchorlink;
    }

    /**
     * @return the permalink
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     * @param permalink the permalink to set
     */
    public void setPermalink(String permalink) {
        usePermalink = true;
        this.permalink = permalink;
    }

    /**
     * @return the baselevel
     */
    public int getBaselevel() {
        return baselevel;
    }

    /**
     * @param baselevel the baselevel to set
     */
    public void setBaselevel(int baselevel) {
        this.baselevel = baselevel;
    }

    /**
     * @return the separator
     */
    public String getSeparator() {
        return separator;
    }

    /**
     * @param separator the separator to set
     */
    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public void setUsePermalink(boolean use) {
        usePermalink = use;
    }

    private final String path = "markdown.extensions.toc";
    private String marker = "[TOC]";
    private String title = "";
    private boolean anchorlink = false;
    private String permalink = "&para;";
    private int baselevel = 1;
    private String separator = "-";
    private boolean usePermalink = false;

    private String getPyBoolValue(boolean bool) {
        return (bool ? "True" : "False");
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getConfig() {
        String config = "";
        String val;
        config += "'marker': '" + marker + "'";
        if (title == "") {
            val = "None";
        } else {
            val = "'" + title + "'";
        }
        config += ", 'title': " + val;
        config += ", 'anchorlink': " + getPyBoolValue(anchorlink);
        if (usePermalink) {
            val = "'" + permalink + "'";
        } else {
            val = "False";
        }
        config += ", 'permalink': " + val;
        config += ", 'baselevel': " + baselevel;
        config += ", 'separator': '" + separator + "'";
        return config;
    }
}
