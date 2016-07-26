package com.github.raimu.template;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;

public class TemplateTest
{
    @Test
    public void testRawText() {
        Template template = new Template("Hello World!");
        String result = template.render(new HashMap<String, String>());
        assertEquals("Hello World!", result);
    }

    @Test
    public void testSimpleVariable() {
        Template template = new Template("Hello {{ name }}!");
        String result = template.render(this.getContext("John"));
        assertEquals("Hello John!", result);
    }

    @Test
    public void testSimpleVariableWithouthSpace() {
        Template template = new Template("Hello {{name}}!");
        String result = template.render(this.getContext("John"));
        assertEquals("Hello John!", result);
    }

    @Test
    public void testRenderTwice() {
        Template template = new Template("Hello {{ name }}!");
        String result = template.render(this.getContext("John"));
        String result2 = template.render(this.getContext("Doe"));
        assertEquals("Hello John!", result);
        assertEquals("Hello Doe!", result2);
    }

    @Test
    public void testMissingVariable() {
        Template template = new Template("Hello {{ name }}!");
        String result = template.render(new HashMap<String, String>());
        assertEquals("Hello !", result);
    }

    @Test
    public void testMultipleVariables() {
        HashMap<String, String> context = new HashMap<String, String>();
        context.put("firstname", "John");
        context.put("lastname", "Doe");
        Template template = new Template("Hello {{ firstname }} {{ lastname }}!");
        String result = template.render(context);
        assertEquals("Hello John Doe!", result);
    }

    private HashMap<String, String> getContext(String name) {
        HashMap<String, String> context = new HashMap<String, String>();
        context.put("name", name);
        return context;
    }
}
