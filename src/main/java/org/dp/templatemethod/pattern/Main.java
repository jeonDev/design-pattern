package org.dp.templatemethod.pattern;

public class Main {

    public static void main(String[] args) {
        AbstractTemplate templateA = new TemplateA();
        AbstractTemplate templateB = new TemplateB();
        templateA.method();
        templateB.method();

    }
}
