package Tema1;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Book extends NameAndId implements IPublishingArtifact{
    private String subtitle;
    private String ISBN;
    private Integer pageCount;
    private String[] keywords;
    private Integer languageID;
    private Calendar createdOn;
    private Author[] authors;
    /**
     * Constructor cu parametri
     */
    public Book(int ID, String name, String subtitle, String ISBN, int pageCount,
                String[] keywords, Integer languageID, String createdOn, Author[] authors) {
        super(ID, name);
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = dateToCalendar(createdOn);
        this.authors = authors;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public Integer getLanguageID() {
        return languageID;
    }

    public String getCreatedOn() {
        return dateToString(createdOn);
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public void setLanguageID(Integer languageID) {
        this.languageID = languageID;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = dateToCalendar(createdOn);;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    /**
     * Data extrasa din Stringul primit in init in fisierul cu carti, il verific daca este valid
     * @param data este stringul
     * @return calendar daca data este valida
     */
    private Calendar dateToCalendar(String data){

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.US);
        try {
            calendar.setTime(simpleDateFormat.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return calendar;

    }

    /**
     * Inserez inapoi data care a fost procesata
     * @param calendar data care a fost procesata
     * @return returnez data procesata
     */
    private String dateToString(Calendar calendar){

        if(calendar == null) return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        return simpleDateFormat.format(calendar.getTime());

    }

    /**
     * Publish-ul pentru o carte am folosit toString care afiseaza cartea fara <xml></xml>
     * de accea am adaugat la inceput si la sfarsit. Taburile = 1 deoarece avem doar un tab.
     * @return stringul creat pentru o carte
     */
    @Override
    public String publish() {
        final StringBuffer sb = new StringBuffer("<xml>\n");
        sb.append(this.toString(1));
        sb.append("<xml>\n");
        return sb.toString();
    }

    /**
     *  Imi adauga taburi la inceputul unei linii noi
     */
    public static String Tab(int NrTab){
        final StringBuffer sb = new StringBuffer("");

        for(int i=0;i<NrTab;i++){

            sb.append("\t");

        }
    return sb.toString();

    }

    /**
     * Aceasta functie imi creeaza cartea care este folosita in toate publish-urile
     * @param nrTab numarul de taburi care este folosit
     * @return returnez stringul format
     */
    public String toString(int nrTab) {
        final StringBuffer sb = new StringBuffer();
        sb.append(Tab(nrTab)).append("<title>").append(this.getName()).append("</title>\n");
        sb.append(Tab(nrTab)).append("<subtitle>").append(this.subtitle).append("</subtitle>\n");
        sb.append(Tab(nrTab)).append("<isbn>").append(this.getISBN()).append("</isbn>\n");
        sb.append(Tab(nrTab)).append("<keywords>").append(Arrays.asList(keywords).toString()).append("</keywords>\n");
        sb.append(Tab(nrTab)).append("<languageID>").append(this.languageID).append("</languageID>\n");
        sb.append(Tab(nrTab)).append("<createdOn>").append(this.getCreatedOn()).append("</createdOn>\n");
        sb.append(Tab(nrTab)).append("<authors>");
        if(this.authors != null)
        for (Author author : this.authors) {

            sb.append(" ");
            sb.append(author.firstName);
            sb.append(" ");
            sb.append(author.lastName);


        }
        sb.append("</authors>\n");

        return sb.toString();
    }

}
