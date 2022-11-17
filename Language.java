package Tema1;

public class Language extends NameAndId {

    private String code;

    public Language(int ID, String name, String code) {
        super(ID, name);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
