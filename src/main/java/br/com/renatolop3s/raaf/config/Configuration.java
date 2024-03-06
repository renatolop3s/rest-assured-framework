package br.com.renatolop3s.raaf.config;

import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.Mutable;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@LoadPolicy(MERGE)
@Sources({
    "system:properties",
    "classpath:config.properties",
    "system:env"
})
public interface Configuration extends Mutable {

    @Key("env")
    @DefaultValue("qa")
    String env();

    @Key("${env}.base.url")
    String baseUrl();

    @Key("${env}.app.id")
    String appId();

    static Configuration cfg() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}
