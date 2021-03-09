package com.ipiecoles.java.java240;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BitcoinService bitcoinService = ctx.getBean(BitcoinService.class);
        //bitcoinService peut etre utilisé dans ce main et les beans declarés
        //dans la configuration ont été intégrés dans le conteneur
        // à la place de :        BitcoinService bitcoinService = new BitcoinService();

        ProduitManager pm = ctx.getBean(ProduitManager.class);
        WebPageManager webPageManager = ctx.getBean(WebPageManager.class);
//        ProduitManager pm = new ProduitManager();
 //      WebPageManager webPageManager = new WebPageManager(); //remplacer  dans spring config
//        pm.setWebPageManager(webPageManager); remplacer  dans spring config
//        bitcoinService.setWebPageManager(webPageManager); remplacer  dans spring config
//        pm.setBitcoinService(bitcoinService); remplacer par ligne 18 dans spring config



        System.out.println("Bienvenue !");
        while(true){
            System.out.println("Vous souhaitez : ");
            System.out.println("1 - Connaître le cours du bitcoin");
            System.out.println("2 - Ajouter un produit au catalogue");
            System.out.println("3 - Voir tous les produits du catalogue");
            System.out.println("4 - Voir les détails d'un produit");
            System.out.println("5 - Initialiser le catalogue");
            System.out.println("0 - Quitter");

            Scanner scanner = new Scanner(System.in);
            int saisie = scanner.nextInt();
            switch (saisie){
                case 1:
//                    BitcoinService bitcoinService = new BitcoinService();
                    bitcoinService.setWebPageManager(webPageManager);
                    System.out.println("1 BTC = " + bitcoinService.getBitcoinRate() + " €");
                    break;
                case 2:
                    pm.ajouterProduit();
                    break;
                case 3:
                    pm.afficherTousLesProduits();
                    break;
                case 4:
                    System.out.println("Quel numéro de produit ?");
                    pm.afficherDetailProduit(scanner.nextInt());
                    break;
                case 5:
                    pm.initialiserCatalogue();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    return;
            }
        }
    }
}
