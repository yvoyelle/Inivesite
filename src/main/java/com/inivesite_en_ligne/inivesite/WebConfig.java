package com.inivesite_en_ligne.inivesite;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
@Configuration
//this the class for manage various languade
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();

        slr.setDefaultLocale(new Locale("en"));

        return slr;


    }
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci= new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return  lci;

    }
    @Override
    public  void  addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(localeChangeInterceptor());
    }
}
