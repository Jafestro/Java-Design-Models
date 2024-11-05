package Proxy;

import java.util.Date;

public class Document implements IDocument{
    private final String identifier;
    private final Date creationDate;
    private final String content;

    public Document(String identifier, String content) {
        this.identifier = identifier;
        this.creationDate = new Date(); // Set to current date at creation
        this.content = content;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }

}