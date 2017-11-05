/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kartoffelx86.Markdown;

import io.github.kartoffelx86.Markdown.extensions.Extension;
import io.github.kartoffelx86.Markdown.extensions.SmartyPants;
import java.util.ArrayList;
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
        py.exec("import markdown");
        String args = prepareArgs();
        String config = prepareConfig();
        String evalString = "markdown.markdown('" + text + "'" + args + ", " + config + ")";
        value = py.eval(evalString).asString();
        return value;
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
        args += (", output_format='" + output.name() + "'");
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
