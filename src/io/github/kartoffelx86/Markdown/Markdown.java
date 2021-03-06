/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kartoffelx86.Markdown;

import io.github.kartoffelx86.Markdown.extensions.Extension;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.python.util.PythonInterpreter;

/**
 *
 * @author Julian
 */
public class Markdown {

    PythonInterpreter py;

    private OutputFormat output = OutputFormat.xhtml1;
    private boolean lazy_ol = true;
    private int tab_length = 4;
    private ArrayList<Extension> extensions = new ArrayList<>();

    public Markdown() {
        py = new PythonInterpreter();
        py.exec("import markdown");
        py.exec("md = markdown.Markdown()");
    }

    public Markdown(PythonInterpreter py) {
        this.py = py;
    }

    public PythonInterpreter getPyInterpreter() {
        return new PythonInterpreter();
    }

    public String markdown(String text) {
        text = text.replace("\n", "\\n");
        String value = null;
        String args = prepareArgs();
        String config = prepareConfig();
        py.exec("md = markdown.Markdown(" + args + ", " + config + ")");
        String evalString = "md.convert('" + text + "')";
        value = py.eval(evalString).asString();
        return value;
    }

    public Map getMeta() throws ExtensionNotFoundException {
        String s = null;
        try {
            s = py.eval("md.Meta").toString();
        } catch (org.python.core.PyException e) {
            throw new ExtensionNotFoundException("Extension Meta_Data not present. This is needed to return the Meta Attribute!");
        }
        s = s.replaceAll("u(?='.+')", "");
        s = s.replace("'", "\"");
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(Markdown.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONObject jsnobj = (JSONObject) obj;
        Map map = (Map) jsnobj;
        return map;
    }

    public String getToc() throws ExtensionNotFoundException {
        String s = null;
        try {
            s = py.eval("md.toc").toString();
        } catch (org.python.core.PyException e){
            throw new ExtensionNotFoundException("Extension Table_Of_Contents not present. This is needed to return the TOC Attribute!");
        }
        return s;
    }

    private String prepareConfig() {
        String config = "";
        config += "extension_configs = {";
        if (extensions != null) {
            for (Extension extension : extensions) {
                if (extension.getConfig() != null) {
                    config += "'" + extension.getPath() + "': {";
                    config += extension.getConfig();
                    config += "}, ";
                }
            }
        }
        config += "}";
        return config;
    }

    private String prepareArgs() {
        String args = "";
        args += (" output_format ='" + output.name() + "'");
        args += (", lazy_ol = " + (lazy_ol ? "True" : "False"));
        args += (", tab_length = " + tab_length);
        args += (", extensions=[");
        if (extensions != null) {
            for (Extension extension : extensions) {
                args += "'" + extension.getPath() + "', ";
            }
        }
        args += "]";
        return args;
    }

    public void setOutputFormat(OutputFormat format) {
        output = format;
    }

    public void setLazylistEnabled(Boolean bool) {
        lazy_ol = bool;
    }

    public void setTabLength(int length) {
        tab_length = length;
    }

    public void addExtensions(Extension extension) {
        this.extensions.add(extension);
    }
    
}
