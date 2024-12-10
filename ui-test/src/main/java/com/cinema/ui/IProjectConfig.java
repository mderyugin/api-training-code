package com.cinema.ui;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config.properties")
public interface IProjectConfig extends Config{
        @Key("base.uri")
        String baseUri();

}


