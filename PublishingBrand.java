package Tema1;

public class PublishingBrand extends IdNameBooks implements IPublishingArtifact{

    public PublishingBrand(int ID, String name, Book[] books) {
        super(ID, name, books);
    }

    /**
     *  Asa arata un publishing brand
     */
    @Override
    public String publish() {
        final StringBuffer sb = new StringBuffer("<xml>\n");
        sb.append(Book.Tab(1)).append("<publishingBrand>\n");
        sb.append(Book.Tab(2)).append("<ID>").append(this.getID()).append("</ID>\n");
        sb.append(Book.Tab(2)).append("<Name>").append(this.getName()).append("</Name>\n");
        sb.append(Book.Tab(1)).append("</publishingBrand>\n");
        sb.append(Book.Tab(1)).append("<books>\n");
        if(this.getBooks() != null)
            for (Book book : this.getBooks()) {
                sb.append(Book.Tab(2)).append("<book>\n");
                sb.append(book.toString(3));
                sb.append(Book.Tab(2)).append("</book>\n");
            }
        sb.append(Book.Tab(1)).append("<books>\n");
        sb.append("</xml>\n");
        return sb.toString();
    }


}
