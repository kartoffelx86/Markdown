/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kartoffelx86.Markdown;

/**
 *
 * @author Julian
 */
public class ExtensionNotFoundException extends Exception {

    public ExtensionNotFoundException() {
        super();
    }

    public ExtensionNotFoundException(String message) {
        super(message);
    }

    public ExtensionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExtensionNotFoundException(Throwable cause) {
        super(cause);
    }
}
