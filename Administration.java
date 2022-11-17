package Tema1;

import java.util.*;

public class Administration {
    PublishingRetailer[] publishingRetailers;
    Language[] languages;

    public Administration(PublishingRetailer[] publishingRetailers, Language[] languages) {
        this.publishingRetailers = publishingRetailers;
        this.languages = languages;
    }

    public PublishingRetailer[] getPublishingRetailers() {
        return publishingRetailers;
    }

    public void setPublishingRetailers(PublishingRetailer[] publishingRetailers) {
        this.publishingRetailers = publishingRetailers;
    }

    /**
     Complexitate O(n+m) am un hmap book in care adaug toate cartile unui retailer, extragandule pe toate
     din fiecare istanta a lui, daca deja exista nu o mai adaug
     */
    public Book[] getBooksForPublishingRetailerID(int publishingRetailerID){

        PublishingRetailer retailer = Utils.findPublishingRetailerByID(publishingRetailers,publishingRetailerID);
        Set<Book> set = new HashSet<>();
        Book[] books ;
        if(retailer==null) return null;
        IPublishingArtifact[] artifacts = retailer.getPublishingArtifacts();
        if(artifacts == null) {
            System.out.println("artefacts null");
            return null;
        }
        for (int i = 0; i<artifacts.length; i++){
            if(artifacts[i]==null) continue;
            if (artifacts[i] instanceof Book){
                set.add((Book) artifacts[i]);
            }
            if (artifacts[i] instanceof EditorialGroup){
               Collections.addAll(set,((EditorialGroup) artifacts[i]).getBooks());
            }
            if (artifacts[i] instanceof PublishingBrand){
                Collections.addAll(set,((PublishingBrand) artifacts[i]).getBooks());
            }
        }
        books = set.toArray(new Book[0]);
        return books;
    }

    /**
     *Gasesc retailerul cu ajutorul functiei si parcurg cartile din el adaug limbile in languages1
     *daca deja exista nu mai adaug.
     */
    public Language[] getLanguagesForPublishingRetailerID(int publishingRetailerID) {
        Language[] languages1 = new Language[0];
        Book[] books = getBooksForPublishingRetailerID(publishingRetailerID);
        if(books==null) return null;
        for (Book book : books) {
            Language l2 = Utils.findLanguageByID(languages,book.getLanguageID());
            if(!Utils.containsLanguage(languages1,l2))
                languages1 = Utils.addAtFinalOfLanguagesArrayLanguage(languages1,l2);
        }

        return languages1;
    }

    /**
     *In fiecare din publising retailer extrag cartea, si dupa extrag toate tarile
     *care sunt a cartii si le scriu in countries.
     */
    public Country[] getCountriesForBookID(int bookID){

        Country[] countries = new Country[0];

        for (PublishingRetailer publishingRetailer : publishingRetailers) {
            Integer publishingRetailerID = publishingRetailer.getID();
            Book[] books = getBooksForPublishingRetailerID(publishingRetailerID);
            for (Book book : books) {
                if(book.getID().equals(bookID)){
                    Country[] countries1 = publishingRetailer.getCountries();
                    for (Country country : countries1) {
                        if (!Utils.containsCountry(countries, country)) {
                            countries = Utils.addAtFinalOfContryArrayContry(countries, country);
                        }
                    }
                }

            }

        }
        return countries;
    }

    /**
     *Complexitate O(n+m) am doua hmap book.
     *In primul adauga toate cartile primului retailer in al doilea cartile pentru al doilea
     *si dupa in set scriu doar cartile comune intre set si set2
     */
    public Book[] getCommonBoksForRetailerIDs(int retailerID1, int retailerID2){
        Book[] books;
        Book[] booksID1 = getBooksForPublishingRetailerID(retailerID1);
        Book[] booksID2 = getBooksForPublishingRetailerID(retailerID2);
        Set<Book> set = new HashSet<>();
        Set<Book> set2 = new HashSet<>();
        Collections.addAll(set,(booksID1));
        Collections.addAll(set2,(booksID2));
        set.retainAll(set2);
        books = set.toArray(new Book[0]);
        return books;
    }

    /**
     Complexitate O(n+m) am un hmap book in care adaug toate cartile retailerilor,si pe cele care
     deja exista nu le mai adauga
     */
    public Book[] getAllBooksForRetailerIDs(int retailerID1, int retailerID2){
        Book[] books ;
        Book[] booksID1 = getBooksForPublishingRetailerID(retailerID1);
        Book[] booksID2 = getBooksForPublishingRetailerID(retailerID2);
        Set<Book> set = new HashSet<>();
        Collections.addAll(set,(booksID1));
        Collections.addAll(set,(booksID2));
        books = set.toArray(new Book[0]);
        return books;
    }
}
