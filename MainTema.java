package Tema1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Aici am folosit toate functiile create si am afisat in fisiere ce am primit pentru fiecare,
 * cu cate 5 exemple dupa cum a fost spus dupa conditie
 */
public class MainTema {
    public static void main(String[] args) throws IOException {
        ReadFromFile r = new ReadFromFile();
        r.readLanguage();

        Book[] books = r.readBooks();
        EditorialGroup[] editorialGroups = r.readEditorialGroup();
        Author[] authors = r.readAuthors();
        PublishingBrand[] publishingBrands = r.readPublishingBrand();
        PublishingRetailer[] publishingRetailers = r.readPublishingRetailer();
        Country[] countries = r.readCountries();
        Language[] languages = r.readLanguage();

        r.readIdAuthorBook(books,authors);
        r.readIDBookEditorialGroup(books, editorialGroups);
        r.readIDBookPublishingBrand(books,publishingBrands);
        r.readIDCountryPublishRetailer(countries,publishingRetailers);
        r.readIDBookPublishRetailer(books,publishingRetailers);
        r.readIDEditorialGroupPublishRetailer(editorialGroups,publishingRetailers);
        r.readIDPublishingBrandsPublishRetailer(publishingBrands,publishingRetailers);


        Administration a = new Administration(publishingRetailers,languages);
        WritterInFile e = new WritterInFile();

        Book[] rezultatb0 = a.getBooksForPublishingRetailerID(4);
        Book[] rezultatb1 = a.getBooksForPublishingRetailerID(7);
        Book[] rezultatb2 = a.getBooksForPublishingRetailerID(15);
        Book[] rezultatb3 = a.getBooksForPublishingRetailerID(19);
        Book[] rezultatb4 = a.getBooksForPublishingRetailerID(33);

        Language[] rezultatl0 = a.getLanguagesForPublishingRetailerID(4);
        Language[] rezultatl1 = a.getLanguagesForPublishingRetailerID(1);
        Language[] rezultatl2 = a.getLanguagesForPublishingRetailerID(28);
        Language[] rezultatl3 = a.getLanguagesForPublishingRetailerID(15);
        Language[] rezultatl4 = a.getLanguagesForPublishingRetailerID(26);

        Country[] rezultatc0 = a.getCountriesForBookID(204);
        Country[] rezultatc1 = a.getCountriesForBookID(8183);
        Country[] rezultatc2 = a.getCountriesForBookID(6390);
        Country[] rezultatc3 = a.getCountriesForBookID(11548);
        Country[] rezultatc4 = a.getCountriesForBookID(9856);

        Book[] rezultatbo0 = a.getCommonBoksForRetailerIDs(1,2 );
        Book[] rezultatbo1 = a.getCommonBoksForRetailerIDs(3,6);
        Book[] rezultatbo2 = a.getCommonBoksForRetailerIDs(4,10);
        Book[] rezultatbo3 = a.getCommonBoksForRetailerIDs(12,16);
        Book[] rezultatbo4 = a.getCommonBoksForRetailerIDs(11,7);

        Book[] rezultatboo0 = a.getAllBooksForRetailerIDs(1,2);
        Book[] rezultatboo1 = a.getAllBooksForRetailerIDs(3,6);
        Book[] rezultatboo2 = a.getAllBooksForRetailerIDs(4,10);
        Book[] rezultatboo3 = a.getAllBooksForRetailerIDs(12,16);
        Book[] rezultatboo4 = a.getAllBooksForRetailerIDs(11,7);


        BufferedWriter writerb0 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getBooksForPublishingRetailerID(4).out"));

        BufferedWriter writerb1 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getBooksForPublishingRetailerID(7).out"));

        BufferedWriter writerb2 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getBooksForPublishingRetailerID(15).out"));

        BufferedWriter writerb3 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getBooksForPublishingRetailerID(19).out"));

        BufferedWriter writerb4 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getBooksForPublishingRetailerID(33).out"));

        e.ex1(rezultatb0,writerb0);
        e.ex1(rezultatb1,writerb1);
        e.ex1(rezultatb2,writerb2);
        e.ex1(rezultatb3,writerb3);
        e.ex1(rezultatb4,writerb4);

        BufferedWriter writerl0 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getLanguagesForPublishingRetailerID(4).out"));

        BufferedWriter writerl1 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getLanguagesForPublishingRetailerID(1).out"));

        BufferedWriter writerl2 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getLanguagesForPublishingRetailerID(28).out"));

        BufferedWriter writerl3 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getLanguagesForPublishingRetailerID(15).out"));

        BufferedWriter writerl4 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getLanguagesForPublishingRetailerID(26).out"));


        e.ex2(rezultatl0,writerl0);
        e.ex2(rezultatl1,writerl1);
        e.ex2(rezultatl2,writerl2);
        e.ex2(rezultatl3,writerl3);
        e.ex2(rezultatl4,writerl4);

        BufferedWriter writerc0 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getCountriesForBookID(204).out"));

        BufferedWriter writerc1 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getCountriesForBookID(8183).out"));

        BufferedWriter writerc2 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getCountriesForBookID(6390).out"));

        BufferedWriter writerc3 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getCountriesForBookID(11548).out"));

        BufferedWriter writerc4 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getCountriesForBookID(9856).out"));

        e.ex3(rezultatc0,writerc0);
        e.ex3(rezultatc1,writerc1);
        e.ex3(rezultatc2,writerc2);
        e.ex3(rezultatc3,writerc3);
        e.ex3(rezultatc4,writerc4);

        BufferedWriter writerbo0 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getCommonBoksForRetailerIDs(1,2).out"));

        BufferedWriter writerbo1 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getCommonBoksForRetailerIDs(3,6).out"));

        BufferedWriter writerbo2 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getCommonBoksForRetailerIDs(4,10).out"));

        BufferedWriter writerbo3 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getCommonBoksForRetailerIDs(12,16).out"));

        BufferedWriter writerbo4 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getCommonBoksForRetailerIDs(11,7).out"));

        e.ex1(rezultatbo0,writerbo0);
        e.ex1(rezultatbo1,writerbo1);
        e.ex1(rezultatbo2,writerbo2);
        e.ex1(rezultatbo3,writerbo3);
        e.ex1(rezultatbo4,writerbo4);

        BufferedWriter writerboo0 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getAllBooksForRetailerIDs(1,2).out"));

        BufferedWriter writerboo1 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getAllBooksForRetailerIDs(3,6).out"));

        BufferedWriter writerboo2 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getAllBooksForRetailerIDs(4,10).out"));

        BufferedWriter writerboo3 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getAllBooksForRetailerIDs(12,6).out"));

        BufferedWriter writerboo4 = new BufferedWriter(new FileWriter("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/outs/getAllBooksForRetailerIDs(12,16).out"));

        e.ex1(rezultatboo0,writerboo0);
        e.ex1(rezultatboo1,writerboo1);
        e.ex1(rezultatboo2,writerboo2);
        e.ex1(rezultatboo3,writerboo3);
        e.ex1(rezultatboo4,writerboo4);

    }
}
