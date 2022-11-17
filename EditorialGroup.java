package Tema1;

import java.util.Arrays;

public class EditorialGroup extends IdNameBooks implements IPublishingArtifact{

    public EditorialGroup(int ID, String name, Book[] books) {
        super(ID, name, books);
    }

    /**
     * Am folosit functia din book care formeaza cartea si am mai adaugat ce era necesar
     * pentru Editorial Group
     */
    @Override
    public String publish() {
        final StringBuffer sb = new StringBuffer("<xml>\n");
        sb.append(Book.Tab(1)).append("<editorialGroup>\n");
        sb.append(Book.Tab(2)).append("<ID>").append(this.getID()).append("</ID>\n");
        sb.append(Book.Tab(2)).append("<Name>").append(this.getName()).append("</Name>\n");
        sb.append(Book.Tab(1)).append("</editorialGroup>\n");
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
