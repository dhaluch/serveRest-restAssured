package config;

import org.aeonbits.owner.Config;

@Config.Sources({"file:C:\\LabAutomacao\\API\\Rest-Assured\\test\\src\\test\\resources\\properties\\test.properties"})
public interface Configuracoes extends Config {
    @Key("baseURI")
    String baseURI();



}
