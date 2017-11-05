/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kartoffelx86.Markdown.extensions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Julian
 */
public class SmartyPants implements Extension {

    /**
     * @return the smart_dashes
     */
    public boolean isSmart_dashes() {
        return smart_dashes;
    }

    /**
     * @param smart_dashes the smart_dashes to set
     */
    public void setSmart_dashes(boolean smart_dashes) {
        this.smart_dashes = smart_dashes;
    }

    /**
     * @return the smart_quotes
     */
    public boolean isSmart_quotes() {
        return smart_quotes;
    }

    /**
     * @param smart_quotes the smart_quotes to set
     */
    public void setSmart_quotes(boolean smart_quotes) {
        this.smart_quotes = smart_quotes;
    }

    /**
     * @return the smart_angled_quotes
     */
    public boolean isSmart_angled_quotes() {
        return smart_angled_quotes;
    }

    /**
     * @param smart_angled_quotes the smart_angled_quotes to set
     */
    public void setSmart_angled_quotes(boolean smart_angled_quotes) {
        this.smart_angled_quotes = smart_angled_quotes;
    }

    /**
     * @return the smart_ellipses
     */
    public boolean isSmart_ellipses() {
        return smart_ellipses;
    }

    /**
     * @param smart_ellipses the smart_ellipses to set
     */
    public void setSmart_ellipses(boolean smart_ellipses) {
        this.smart_ellipses = smart_ellipses;
    }

    public SmartyPants() {
        this.substitutes = new HashMap<>();
    }

    public enum SubstitutionKeys {

        left_single_quote,
        right_single_quote,
        left_double_quote,
        right_double_quote,
        left_angle_quote,
        right_angle_quote,
        ellipsis,
        ndash,
        mdash;
    }
    private final String path = "markdown.extensions.smarty";
    private boolean smart_dashes = true;
    private boolean smart_quotes = true;
    private boolean smart_angled_quotes = false;
    private boolean smart_ellipses = true;

    private boolean substitutions = false;
    private HashMap<SubstitutionKeys, String> substitutes;

    public void addSubstitution(SubstitutionKeys key, String substitute) {
        substitutions = true;
        substitutes.put(key, substitute);
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getConfig() {
        String config = "";
        config += "'smart_dashes': " + getPyBoolValue(smart_dashes);
        config += ", 'smart_quotes': " + getPyBoolValue(smart_quotes);
        config += ", 'smart_angled_quotes': " + getPyBoolValue(smart_angled_quotes);
        config += ", 'smart_ellipses': " + getPyBoolValue(smart_ellipses);
        if (substitutions) {
            config += ", 'substitutions': {";
            for (Map.Entry<SubstitutionKeys, String> entry : substitutes.entrySet()) {
                String key = entry.getKey().name().replace('_', '-');
                String value = entry.getValue();
                config += ("'" + key + "': '" + value + "', ");
            }
            config += "}";
        }
        return config;
    }

    private String getPyBoolValue(boolean bool) {
        return (bool ? "True" : "False");
    }
}
