package Proxy;

import java.util.Date;

public interface IDocument {
    String getIdentifier();
    Date getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}