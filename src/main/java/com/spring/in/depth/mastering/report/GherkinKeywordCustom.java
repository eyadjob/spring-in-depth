package com.spring.in.depth.mastering.report;

import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.exceptions.GherkinKeywordNotFoundException;
import com.aventstack.extentreports.gherkin.GherkinDialect;
import com.aventstack.extentreports.gherkin.GherkinDialectProvider;
import com.aventstack.extentreports.gherkin.model.Asterisk;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import freemarker.template.utility.StringUtil;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GherkinKeywordCustom {

    private static final Logger logger = Logger.getLogger(GherkinKeyword.class.getName());

    private Class<IGherkinFormatterModel> clazz = IGherkinFormatterModel.class;
    private IGherkinFormatterModel keywordClazz;

    public GherkinKeywordCustom(String keyword) throws ClassNotFoundException {
        GherkinDialect dialect =  null;
        String apiKeyword = StringUtil.capitalize(keyword.trim());
        String refPath = clazz.getPackage().getName();

        try {
            apiKeyword = apiKeyword.equals("*") ? Asterisk.class.getSimpleName() : apiKeyword;
            dialect = GherkinDialectProvider.getDialect();
            if (dialect != null && !dialect.getLanguage().equalsIgnoreCase(GherkinDialectProvider.getDefaultLanguage())) {
                apiKeyword = null;
                Map<String, List<String>> keywords = dialect.getKeywords();

                for (Map.Entry<String, List<String>> key : keywords.entrySet()) {
                    boolean keywordLocated = key.getValue()
                            .stream()
                            .anyMatch(x -> x.trim().equalsIgnoreCase(keyword.trim()));
                    if (keywordLocated) {
                        apiKeyword = StringUtil.capitalize(key.getKey());
                        break;
                    }
                }
            }

            if (apiKeyword == null) {
                throw new GherkinKeywordNotFoundException("Keyword " + apiKeyword + " cannot be null");
            }

            String clazzName = refPath + "." + apiKeyword.replace(" ", "");
            Class<?> c = Class.forName(clazzName);
            keywordClazz = (IGherkinFormatterModel) c.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            logger.log(Level.SEVERE, "", e);
        }
    }

    IGherkinFormatterModel getKeyword() {
        return keywordClazz;
    }
}

