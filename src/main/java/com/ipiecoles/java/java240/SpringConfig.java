package com.ipiecoles.java.java240;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    // @Scope(value = "singleton") facultatif car scope par defaut est un singleton
    public BitcoinService bitcoinService(){
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setWebPageManager(webPageManager());
        return bitcoinService;
    }

    @Bean
    public ProduitManager produitManager(){
        ProduitManager produitManager = new ProduitManager();
        produitManager.setWebPageManager(webPageManager());
        produitManager.setBitcoinService(bitcoinService());
        return produitManager;
    }

    @Bean
    public WebPageManager webPageManager(){
        return new WebPageManager();
    }

}
