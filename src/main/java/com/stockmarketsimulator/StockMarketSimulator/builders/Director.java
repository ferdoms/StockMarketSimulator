/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import java.util.Random;

/**f
 *
 * @author fernandoms
 */
public class Director {
    
    Random rand = new Random();
    String[] fname = {"Lindsay","Andee","Clemence","Silas","Chick","Ilaire","Francoise","Frazer","Kailey","Kania","Thedric","Rochette","Alethea","Bryan","Millie","Nona","Pattin","Mendy","Darsie","Merna","Gerrard","Leodora","Zonda","Billie","Domenico","Eric","Lynnell","Katha","Renell","Fawn","Ricky","Vivianna","Yankee","Lenette","Reynold","Tobin","Giffy","Darrelle","Darelle","Emile","Debra","Micheline","Erminia","Morgan","Veronica","Godfrey","Cherish","Delainey","Blinni","Jose","De witt","Willem","Kathi","Maurita","Otho","Caralie","Tiffi","Bernie","Charmine","Amandi","Brendis","Constantine","Storm","Darbee","Isaiah","Gracie","Shaine","Jessi","Rickie","Patricio","Saunderson","Vlad","Raymond","Ciro","Thomasa","Vale","Lek","Kim","Geneva","Charil","Belicia","Isador","Kermit","Christiano","Wyn","Allina","Nelia","Joni","Berri","Evan","Herman","Morissa","Pandora","Germain","Gerty","Anita","Alvis","Vevay","Guntar","Hilde"};
    String[] lname = {"Grcic","Giaomozzo","Dare","Defew","Sawdy","Strainge","Cawkwell","Ties","Crenage","Negro","Reightley","Earnshaw","Peddel","Robbings","Pietruszewicz","Heisler","Callcott","De Beauchamp","Hurt","Pele","Durden","Stenyng","Fantini","Stubbes","Durrett","Avramovitz","Baccas","Hannaway","Belin","Duffell","Arblaster","Stuehmeier","Josephson","Bridgen","Wyllis","Bingell","Newsome","Wandrich","Nobbs","Oganesian","Lemery","Jennemann","Antonias","Baughan","Berkeley","Cosens","Wixon","Speenden","Grealey","Mollatt","Cordoba","Longstreeth","Rimer","McAw","Deignan","Radin","Rickhuss","Barukh","Dei","Dunrige","Dallow","Spellessy","Blackston","Rizzotto","Yuill","Rayer","Tanman","Nials","Juste","Dunstan","Topp","Rozea","Bushe","Marvin","Prestie","Muzzillo","Lars","Lowrie","Van Saltsberg","Punyer","Luto","Elis","Widdocks","Muck","Fyfe","Hurler","Pendell","Combes","Coronas","Tatters","Raecroft","Spurdens","Langley","Edger","Searby","Saleway","Morgue","Meric","Ormiston","Jellman"};
    String[] cname = {"Facebook", "Google", "Microsoft", "Amazon","Keeling, Berge and Nienow","Dickinson Inc","Koss, Frami and Rolfson","Breitenberg, Graham and Becker","Hyatt, Eichmann and Crist","Kuvalis-Romaguera","Armstrong, Kerluke and Bailey","Kuhlman-Considine","Schneider Group","Treutel, Emmerich and Rath","Stroman Inc","Turcotte, Harris and Kihn","Thompson Group","Haag, Mertz and Hoeger","Moore-Adams","Reichel, Waelchi and Okuneva","Haley-Kuhlman","Parisian LLC","Cassin-Swaniawski","Emard, Howell and Kuhlman","Kessler Inc","Gibson Inc","Lehner-Larkin","Berge, Beier and Nader","Connelly, Windler and Murazik","Goodwin, Gorczany and Hamill","Crooks Group","Lang, Sporer and Pfeffer","Halvorson-Waters","Feest and Sons","Tillman-Bailey","McGlynn-Gusikowski","Wilderman Group","Hayes LLC","Langosh, Bayer and Thompson","Botsford LLC","Ortiz, Roberts and Wolf","Reichert-Wolff","Ritchie-Pfeffer","Harber Group","Runolfsson LLC","Marvin, Cremin and Parker","Rempel, Johns and Tremblay","Prohaska, Lang and Kihn","Tillman, Padberg and Hilpert","Casper-Jacobson","Dickens LLC","Orn-Mann","Denesik, Hirthe and Langworth","Brown-Klein","Kulas-Mueller","Will-Goodwin","Jast Group","Hirthe-Maggio","Schoen Group","Waters-Jones","Hammes-Swift","Runolfsson and Sons","Romaguera-Zulauf","Koelpin, Muller and Pagac","Barrows LLC","Beahan, Kessler and Pouros","Bayer-Feest","Windler Inc","Abshire, Zboncak and Boehm","Morissette, Crooks and Kuhlman","Crooks-King","Shields-Emmerich","Daniel-Stroman","Jenkins-Jast","Gulgowski-Reichert","Hauck, Streich and Champlin","Hermann-Cronin","Johnston-Abshire","Friesen Group","Hickle, O'Kon and Stroman","Rutherford, Armstrong and Dare","Kautzer-Morar","Kautzer-Frami","Reichert Group","Jacobi LLC","Emard-Paucek","Wuckert, Renner and Friesen","Kertzmann, O'Keefe and Block","Jones, Kub and Mueller","Wolff and Sons","Braun-Wehner","Heidenreich, O'Reilly and Schaefer","Wehner-Harris","Toy-Raynor","Pagac-Bartoletti","Pfeffer, Hane and Frami","Lindgren and Sons","Torp, Pfannerstill and Lockman","Ruecker, Leannon and Kihn","Watsica, Romaguera and Tremblay","Gutkowski-Heathcote","Gottlieb-Graham","Buckridge-Gusikowski","Padberg Inc"};
    
    public void constructInvestor(InvestorBuilder builder){
        String fname = this.fname[rand.nextInt(this.fname.length)];
        builder.setFirstName(fname);
        String lname = this.lname[rand.nextInt(this.lname.length)];
        builder.setLastName(lname);
        builder.setBudget(rand.nextInt(9000)+1000);
    }
    public void constructCompany(CompanyBuilder builder){
        String name = this.cname[rand.nextInt(this.cname.length)];
        builder.setName(name);
        builder.setNShare(rand.nextInt(500)+500);
        builder.setIPOShareValue(rand.nextInt(90)+10);
    }   
}
