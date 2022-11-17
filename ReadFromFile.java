package Tema1;

import java.io.*;
import java.util.ArrayList;

public class ReadFromFile {

    /**
     * Am citit cartile din fisierul necesar si am creat cartea
     * @return intorc lista de carti care am citito, adica toate cartile
     */
    public Book[] readBooks() throws FileNotFoundException {

        Book[] books = new Book[1000];
        FileReader file = new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/books.in");

        try (BufferedReader br = new BufferedReader(file)) {
            int i =0;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] lineS = line.split("###");

                books[i] = new Book(Integer.parseInt(lineS[0]),lineS[1],lineS[2],lineS[3],
                        Integer.parseInt(lineS[4]),lineS[5].split(";"),Integer.parseInt(lineS[6]),
                        lineS[7],null);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;

    }

    /**
     * Am citit autorii din fisierul necesar si am creat autorul cu id, nume si prenume
     * @return intorc lista de autori creata
     */
    public Author[] readAuthors() throws FileNotFoundException {

        Author[] authors = new Author[2381];
        FileReader file = new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/authors.in");

        try (BufferedReader br = new BufferedReader(file)) {
            int i =0;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null){

                String[] lineS = line.split("###");

                authors[i] = new Author(Integer.parseInt(lineS[0]),lineS[1],lineS[2]);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return authors;
    }

    /**
     * Am citit limbile din fisierul necesar si am creat lista de limbi
     * @return intorc lista de limbi
     */
    public Language[] readLanguage() throws  FileNotFoundException {

        Language[] languages = new Language[4];
        FileReader file = new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/languages.in");

        try (BufferedReader br = new BufferedReader(file)) {
            int i = 0;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] lineS = line.split("###");

                languages[i] = new Language(Integer.parseInt(lineS[0]), lineS[1], lineS[2]);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return languages;
    }

    /**
     *  In aceasta functie am citit id-urile cartilor si autorilor si la fiecare carte am pus un autor
     *  sau mai multi daca aceasta are.
     *  Dupa ce am am gasit id-urile am cautot in lista de book si lista de autori autorul si cartea cu
     *  ajutorul a doua metode si am adaugat la finalul cartii cu ajutorul functie de inserare in carte
     * @param books lista de carti
     * @param authors lista de autori
     */
    public void readIdAuthorBook(Book[] books, Author[] authors) throws FileNotFoundException {

        FileReader file =  new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/books-authors.in");

        try(BufferedReader br = new BufferedReader(file)) {
            int i = 0;
            String line;
            br.readLine();
            while((line= br.readLine()) != null){
                String[] lineS = line.split("###");
                Book book = Utils.findBookByID(books,Integer.parseInt(lineS[0]));
                Author author = Utils.findAuthorByID(authors,Integer.parseInt(lineS[1]));
                Utils.addAtFinalOfBooksArrayAuthor(book,author);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Am citit editorialGrupurile din fisierul necesar, i-am creat
     * @return intorc lista citita
     */
    public EditorialGroup[] readEditorialGroup() throws FileNotFoundException {

        EditorialGroup[] editorialGroups = new EditorialGroup[264];
        FileReader file =  new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/editorial-groups.in");

        try(BufferedReader br = new BufferedReader(file)) {
            int i = 0 ;
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] lineS = line.split("###");
                editorialGroups[i] = new EditorialGroup(Integer.parseInt(lineS[0]),lineS[1],null);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return editorialGroups;
    }

    /**
     *  Am citit id-urile la carti si editorialGroup si am facut legatura dintre ei fiecarui editorial
     *  group i-am dat cartile necesare
     * @param books lista de carti
     * @param editorialGroups lista de editorialGroups
     */
    public void readIDBookEditorialGroup(Book[] books,  EditorialGroup[] editorialGroups)
            throws FileNotFoundException{

        FileReader file =  new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/editorial-groups-books.in");

        try(BufferedReader br = new BufferedReader(file)) {

            String line;
            br.readLine();
            while((line= br.readLine()) != null){
                String[] lineS = line.split("###");
                EditorialGroup editorialGroup = Utils.findEditorialGroupByID(editorialGroups,
                        Integer.parseInt(lineS[0]));
                Book book = Utils.findBookByID(books,Integer.parseInt(lineS[1]));
                if((editorialGroup==null)|| (book == null)) continue;
                Utils.addAtFinalOfEditorialGroupsArray(editorialGroup,book);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Am citit publishBrandurile din fisier
     */
    public PublishingBrand[] readPublishingBrand() throws FileNotFoundException {

        PublishingBrand[] publishingBrands = new PublishingBrand[317];
        FileReader file =  new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/publishing-brands.in");

        try(BufferedReader br = new BufferedReader(file)) {
            int i = 0 ;
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] lineS = line.split("###");
                publishingBrands[i] = new PublishingBrand(Integer.parseInt(lineS[0]),lineS[1],null);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publishingBrands;
    }

    /**
     *  Aceasta functie raspunde de conexiunea dintre Book si Publishing Brand, dupa ce am extras
     *  id-urile le caut in liste si dupa ce am gasit adaug cartea in publishingBrand
     * @param books lista de carti
     * @param publishingBrands lista de publishing Brands
     */
    public void readIDBookPublishingBrand(Book[] books,  PublishingBrand[] publishingBrands)
            throws FileNotFoundException{

        FileReader file =  new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/publishing-brands-books.in");

        try(BufferedReader br = new BufferedReader(file)) {

            String line;
            br.readLine();
            while((line= br.readLine()) != null){
                String[] lineS = line.split("###");
                PublishingBrand publishingBrand = Utils.findPublishingBrandByID(publishingBrands,
                        Integer.parseInt(lineS[0]));
                Book book = Utils.findBookByID(books,Integer.parseInt(lineS[1]));
                if((publishingBrand==null)|| (book == null)) continue;
                Utils.addAtFinalOfPublishingBrandArray(publishingBrand,book);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *  Am citit tarile din fisier
     */
    public Country[] readCountries() throws FileNotFoundException{

        Country[] countries = new Country[249];
        FileReader file =  new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/countries.in");

        try(BufferedReader br = new BufferedReader(file)) {
            int i = 0 ;
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] lineS = line.split("###");
                countries[i] = new Country(Integer.parseInt(lineS[0]),lineS[1]);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    /**
     *  Am citit publishingRetailerii din fisier
     */
    public PublishingRetailer[] readPublishingRetailer() throws FileNotFoundException{

        PublishingRetailer[] publishingRetailers = new PublishingRetailer[31];
        FileReader file =  new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/publishing-retailers.in");

        try(BufferedReader br = new BufferedReader(file)) {
            int i = 0 ;
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] lineS = line.split("###");
                publishingRetailers[i] = new PublishingRetailer(Integer.parseInt(lineS[0]),
                        lineS[1],null,null);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publishingRetailers;
    }

    /**
     *  Metoda care raspunde de conectarea dintre tari si publishingRetailer, caut tarile care ii
     *  corespund si le adaug
     * @param countries lista de tari
     * @param publishingRetailers lista de publishingRetailers
     */
    public void readIDCountryPublishRetailer(Country[] countries,  PublishingRetailer[] publishingRetailers)
            throws FileNotFoundException{

        FileReader file =  new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/publishing-retailers-countries.in");

        try(BufferedReader br = new BufferedReader(file)) {

            String line;
            br.readLine();
            while((line= br.readLine()) != null){
                String[] lineS = line.split("###");
                PublishingRetailer publishingRetailer = Utils.findPublishingRetailerByID(publishingRetailers,
                        Integer.parseInt(lineS[0]));
                Country country = Utils.findCountryByID(countries,Integer.parseInt(lineS[1]));
                if((publishingRetailer==null)|| (country == null)) continue;
                Utils.addAtFinalOfPublishingRetailerArray(publishingRetailer,country);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *  Metoda care raspunde de conectarea dintre carti si publishingRetailer, lucreaza fix ca cea cu tarile
     * @param books lista de carti
     * @param publishingRetailer lista de publisingRetailers
     */
    public void readIDBookPublishRetailer(Book[] books,  PublishingRetailer[] publishingRetailer)
            throws FileNotFoundException{

        FileReader file =  new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/publishing-retailers-books.in");

        try(BufferedReader br = new BufferedReader(file)) {

            String line;
            br.readLine();
            while((line= br.readLine()) != null){

                String[] lineS = line.split("###");

                PublishingRetailer publishingRetailer1 = Utils.findPublishingRetailerByID(publishingRetailer,
                        Integer.parseInt(lineS[0]));
                Book book = Utils.findBookByID(books,Integer.parseInt(lineS[1]));

                if((publishingRetailer1==null)|| (book == null)) {

                    continue;
                }

                Utils.addAtFinalOfIPublishingArtifactArray(publishingRetailer1,book);

            }

        } catch (IOException e) {
            System.out.println("laskjbgdlkasbdlkasb");
            e.printStackTrace();
        }

    }

    /**
     *  Aceasta Metoda raspunde de conectarea dintre editorialGoups si publishingRetailer
     * @param editorialGroups lista de editorialGroups
     * @param publishingRetailer lista de publisingRetailers
     */
    public void readIDEditorialGroupPublishRetailer(
            EditorialGroup[] editorialGroups, PublishingRetailer[] publishingRetailer) throws FileNotFoundException{

        FileReader file =  new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/publishing-retailers-editorial-groups.in");

        try(BufferedReader br = new BufferedReader(file)) {

            String line;
            br.readLine();
            while((line= br.readLine()) != null){
                String[] lineS = line.split("###");
                PublishingRetailer publishingRetailer1 = Utils.findPublishingRetailerByID(publishingRetailer,
                        Integer.parseInt(lineS[0]));
                EditorialGroup editorialGroup = Utils.findEditorialGroupByID(editorialGroups,
                        Integer.parseInt(lineS[1]));
                if((publishingRetailer1==null)|| (editorialGroup == null)) continue;
                Utils.addAtFinalOfIPublishingArtifactArray(publishingRetailer1,editorialGroup);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Aceasta metoda raspunde de conectarea dintre publishingBrands si publishingRetailer
     * @param publishingBrands lista de publishingBrands
     * @param publishingRetailer lista de publisingRetailers
     */
    public void readIDPublishingBrandsPublishRetailer(
            PublishingBrand[] publishingBrands,  PublishingRetailer[] publishingRetailer) throws FileNotFoundException{

        FileReader file =  new FileReader("C://Users/david.mihalcenco" +
                "/IdeaProjects/Media/src/Tema1/init/publishing-retailers-publishing-brands.in");

        try(BufferedReader br = new BufferedReader(file)) {

            String line;
            br.readLine();
            while((line= br.readLine()) != null){
                String[] lineS = line.split("###");
                PublishingRetailer publishingRetailer1 = Utils.findPublishingRetailerByID(publishingRetailer,
                        Integer.parseInt(lineS[0]));
                PublishingBrand publishingBrand= Utils.findPublishingBrandByID(publishingBrands,
                        Integer.parseInt(lineS[1]));
                if((publishingRetailer1==null)|| (publishingBrand == null)) continue;
                Utils.addAtFinalOfIPublishingArtifactArray(publishingRetailer1,publishingBrand);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
