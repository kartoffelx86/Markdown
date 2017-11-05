/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kartoffelx86.Markdown.extensions;

/**
 * @deprecated @author Julian
 */
public class HeaderId implements Extension {

    private final String path = "markdown.extensions.codehilite";
    private int level = 1;
    private boolean forceid = true;
    private String separator = "-";

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getConfig() {
        return ("'level' = " + level + ", 'forceid' = " + (forceid ? "True" : "False") + ", 'separator' = '" + separator + "'");
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the forceid
     */
    public boolean isForceid() {
        return forceid;
    }

    /**
     * @param forceid the forceid to set
     */
    public void setForceid(boolean forceid) {
        this.forceid = forceid;
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
}
