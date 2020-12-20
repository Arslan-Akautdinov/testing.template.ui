package common;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class ApplicationManager {
    public static final AppConfig config = new Yaml(new Constructor(AppConfig.class))
            .load(ApplicationManager.class.getClassLoader().getResourceAsStream("application/staging.yml"));
}
