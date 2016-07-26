package com.github.raimu.template;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Template
{
    private String Template;

    public Template(String templateString) {
        this.Template = templateString;
    }

    public String render(Map<String, String> context) {
        String tokenRegex = "(\\{\\{\\s*\\w+\\s*}})|.";
        Matcher tokens = Pattern.compile(tokenRegex).matcher(this.Template);
        StringBuilder result = new StringBuilder();
        while (tokens.find()) {
            String token = tokens.group();
            if (token.startsWith("{{")) {
                String name = token.replace("{", "").replace("}", "").trim();
                if (context.containsKey(name)) {
                    result.append(context.get(name));
                }
            }
            else {
                result.append(tokens.group());
            }
        }

        return result.toString();
    }
}
