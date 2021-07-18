package com.spring.in.depth.mastering.utility;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class JsonToPogo {



    public static void generatePogoFromJson() {

            try {
                JCodeModel codeModel = new JCodeModel();
                URL source = new File("D:\\mycoding\\spring-in-depth\\src\\main\\java\\com\\spring\\in\\depth\\mastering\\utility\\schema\\required.json").toURI().toURL();
                GenerationConfig config = new DefaultGenerationConfig() {

                    @Override
                    public boolean isGenerateBuilders() { // set config option by overriding method
                        return true;
                    }
                };
                SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
                mapper.generate(codeModel, "ClassName", "com.JsonToPogo2", source);
                codeModel.build(Files.createTempDirectory("required").toFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {

        generatePogoFromJson();

    }
}
