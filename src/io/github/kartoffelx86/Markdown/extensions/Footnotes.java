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
public class Footnotes implements Extension {

    private final String path = "markdown.extensions.footnotes";
    private String placeMarker = "///Footnotes Go Here///";
    private String backlinkText = "&#8617;"; //↩

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getConfig() {
        return ("'PLACE_MARKER': '" + placeMarker + "', 'BACKLINK_TEXT': '" + backlinkText + "'");
    }

    /**
     * @return the placeMarker
     */
    public String getPlaceMarker() {
        return placeMarker;
    }

    /**
     * @param placeMarker the placeMarker to set
     */
    public void setPlaceMarker(String placeMarker) {
        this.placeMarker = placeMarker;
    }

    /**
     * @return the backlinkText
     */
    public String getBacklinkText() {
        return backlinkText;
    }

    /**
     * @param backlinkText the backlinkText to set
     */
    public void setBacklinkText(String backlinkText) {
        this.backlinkText = backlinkText;
    }

}
