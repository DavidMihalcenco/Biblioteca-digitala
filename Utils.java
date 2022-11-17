package Tema1;

import java.util.Arrays;

public abstract class Utils {

    /**
     * Metoda care controleaza daca in lista de limbi deja exista limba care doresc sa o adaug
     */
    public static boolean containsLanguage(Language[] languages,Language language){
        for (Language language1 : languages) {
            if(language1.getID().equals(language.getID())) return true;
        }
        return false;
    }

    /**
     *  Metoda care controleaza daca in lista de tari deja exista tara care doresc sa o adaug
     */
    public static boolean containsCountry(Country[] countries,Country country){
        for (Country country1 : countries) {
            if(country1.getID().equals(country.getID())) return true;
        }
        return false;
    }

    /**
     *  Metoda care dupa id cauta in lista de carti o carte
     */
    public static Book findBookByID(Book[] books , int ID){
        for (Book book : books) {
            if(book.getID().equals(ID)) {
                return book;
            }
        }
        return null;
    }

    /**
     *  Metoda care dupa un id cauta in lista de autori un autor
     */
    public static Author findAuthorByID(Author[] authors , int ID){
        for (Author author : authors) {
            if(author.getID().equals(ID)) {
                return author;
            }
        }
        return null;
    }

    /**
     *  Metoda care dupa un id cauta in lista de limbi o limba
     */
    public static Language findLanguageByID(Language[] languages, int ID){
        for(Language language : languages) {
            if(language.getID().equals(ID)){
                return language;
            }
        }
        return null;
    }

    /**
     *  Metoda care dupa un id cauta in lista de tari o tara
     */
    public static Country findCountryByID(Country[] countries, int ID){
        for(Country country : countries){
            if(country.getID().equals(ID)){
                return country;
            }
        }
        return null;
    }

    /**
     *  Metoda care dupa un id cauta in lista de publishingRetailers un publishingRetailer
     */
    public static PublishingRetailer findPublishingRetailerByID(PublishingRetailer[] publishingRetailers, int ID){
        for (PublishingRetailer publishingRetailer : publishingRetailers) {
            if(publishingRetailer.getID().equals(ID)){
                return publishingRetailer;
            }
        }
        return null;
    }

    /**
     *  Metoda care dupa un id cauta in lista de editorialGroups un editorialGroup
     */
    public static EditorialGroup findEditorialGroupByID(EditorialGroup[] editorialGroups,int ID){
        if(editorialGroups == null) return null;
        for(EditorialGroup editorialGroup : editorialGroups){

            if(editorialGroup == null) continue;
            if (editorialGroup.getID().equals(ID)) {

                return editorialGroup;
            }
        }
        return null;
    }

    /**
     *  Metoda care dupa un id cauta in lista de publishingBranduri un publishingBrand
     */
    public static PublishingBrand findPublishingBrandByID(PublishingBrand[] publishingBrands,int ID){
        if(publishingBrands == null) return null;
        for(PublishingBrand publishingBrand : publishingBrands){

            if(publishingBrand == null) continue;
            if (publishingBrand.getID().equals(ID)) {

                return publishingBrand;
            }
        }
        return null;
    }

    /**
     *  Metoda care adauga un autor in lista de autori
     */
    public static void addAtFinalOfBooksArrayAuthor(Book book, Author author){
        if (book.getAuthors() == null) {
            Author[] authors = new Author[1];
            authors[0] = author;
            book.setAuthors(authors);
            return;

        }
        Author[] authors = Arrays.copyOf(book.getAuthors(), book.getAuthors().length + 1);
        authors[authors.length-1] = author;
        book.setAuthors(authors);
    }

    /**
     *  Metoda care adauga o tara in lista de tari
     */
    public static Country[] addAtFinalOfContryArrayContry(Country[] countries, Country country){
        if(countries == null){
            Country[] countries1 = new Country[1];
            countries1[0] = country;
            return countries1;
        }
        Country[] countries1 = Arrays.copyOf(countries, countries.length + 1);
        countries1[countries1.length-1] = country;
        return  countries1;
    }

    /**
     *  Metoda care adauga o limba in lista de limbi
     */
    public static Language[] addAtFinalOfLanguagesArrayLanguage(Language[] languages, Language language){
        if(languages == null){
            Language[] languages1 = new Language[1];
            languages1[0] = language;
            return languages1;
        }
        Language[] languages1 = Arrays.copyOf(languages, languages.length + 1);
        languages1[languages1.length-1] = language;
        return  languages1;
    }

    /**
     *  Metoda care adauga in EditorialGroups o carte
     */
    public static void addAtFinalOfEditorialGroupsArray(EditorialGroup editorialGroup, Book book){
        if (editorialGroup.getBooks() == null){
            Book[] books = new Book[1];
            books[0] = book;
            editorialGroup.setBooks(books);
            return;
        }
        Book[] books = Arrays.copyOf(editorialGroup.getBooks(), editorialGroup.getBooks().length + 1);
        books[books.length-1] = book;
        editorialGroup.setBooks(books);
    }

    /**
     *  Metoda care adauga in publishingBrand o carte
     */
    public static void addAtFinalOfPublishingBrandArray(PublishingBrand publishingBrand, Book book){
        if (publishingBrand.getBooks() == null){
            Book[] books = new Book[1];
            books[0] = book;
            publishingBrand.setBooks(books);
            return;
        }
        Book[] books = Arrays.copyOf(publishingBrand.getBooks(), publishingBrand.getBooks().length + 1);
        books[books.length-1] = book;
        publishingBrand.setBooks(books);
    }

    /**
     *  Metoda care adauga in publishingRetailer o tara
     */
    public static void addAtFinalOfPublishingRetailerArray(PublishingRetailer publishingRetailer, Country country){
        if (publishingRetailer.getCountries() == null){
            Country[] countries = new Country[1];
            countries[0] = country;
            publishingRetailer.setCountries(countries);
            return;
        }
        Country[] countries = Arrays.copyOf(publishingRetailer.getCountries(),
                publishingRetailer.getCountries().length + 1);
        countries[countries.length-1] = country;
        publishingRetailer.setCountries(countries);
    }

    /**
     *  Metoda care adauga in iPublishingArtifact un publishingRetailer
     */
    public static void addAtFinalOfIPublishingArtifactArray(PublishingRetailer publishingRetailer,
                                                            IPublishingArtifact publishingArtifact){
        if(publishingRetailer.getPublishingArtifacts() == null){
            IPublishingArtifact[] publishingArtifact1 = new IPublishingArtifact[1];
            publishingArtifact1[0] = publishingArtifact;
            publishingRetailer.setPublishingArtifacts(publishingArtifact1);
            return;
        }
        IPublishingArtifact[] publishingArtifact1 = Arrays.copyOf(publishingRetailer.getPublishingArtifacts(),
                publishingRetailer.getPublishingArtifacts().length + 1);
        publishingArtifact1[publishingArtifact1.length-1] = publishingArtifact;
        publishingRetailer.setPublishingArtifacts(publishingArtifact1);
    }
}
