/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kartoffelx86.Markdown;

import java.util.ArrayList;
import java.util.List;
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
    private ArrayList<Extensions> extensions = null;

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
        value = py.eval("markdown.markdown('" + text + "'" + args + ")").asString();

        return value;
    }

    private String prepareArgs() {
        String args = "";
        args += (", output_format='" + output.name() + "'");
        args += (", extensions=[");
        if (extensions != null) {
            for (Extensions extension : extensions) {
                args += "'" + extension.path() + "', ";
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

    public void setExtensions(List<Extensions> extensions) {
        this.extensions = (ArrayList<Extensions>) extensions;
    }

}
