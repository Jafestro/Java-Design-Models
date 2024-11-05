package Proxy;

import java.util.*;

class AccessControlService {
    private static AccessControlService instance = new AccessControlService();
    private final Map<String, Set<String>> permissions = new HashMap<>();

    private AccessControlService() {}

    public static AccessControlService getInstance() {
        return instance;
    }

    public void addPermission(String documentId, String username) {
        permissions.computeIfAbsent(documentId, k -> new HashSet<>()).add(username);
    }

    public boolean isAllowed(String documentId, String username) {
        return permissions.getOrDefault(documentId, Collections.emptySet()).contains(username);
    }
}