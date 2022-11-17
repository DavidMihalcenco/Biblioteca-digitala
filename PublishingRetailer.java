package Tema1;

public class PublishingRetailer extends NameAndId{

    private IPublishingArtifact[] publishingArtifacts;
    private Country[] countries;

    public PublishingRetailer(int ID, String name, IPublishingArtifact[] publishingArtifacts, Country[] countries) {
        super(ID, name);
        this.publishingArtifacts = publishingArtifacts;
        this.countries = countries;
    }

    public IPublishingArtifact[] getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public Country[] getCountries() {
        return countries;
    }

    public void setPublishingArtifacts(IPublishingArtifact[] publishingArtifacts) {
        this.publishingArtifacts = publishingArtifacts;
    }

    public void setCountries(Country[] countries) {
        this.countries = countries;
    }
}
