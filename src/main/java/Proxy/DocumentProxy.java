package Proxy;

import java.util.Date;

class DocumentProxy implements IDocument {
    private final Document document;

    public DocumentProxy(Document document, String allowedUser) {
        this.document = document;
        AccessControlService.getInstance().addPermission(document.getIdentifier(), allowedUser);
    }

    @Override
    public String getIdentifier() {
        return document.getIdentifier();
    }

    @Override
    public Date getCreationDate() {
        return document.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (AccessControlService.getInstance().isAllowed(document.getIdentifier(), user.username())) {
            return document.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.username());
        }
    }
}