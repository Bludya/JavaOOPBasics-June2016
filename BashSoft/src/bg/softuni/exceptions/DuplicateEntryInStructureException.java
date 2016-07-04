package bg.softuni.exceptions;

/**
 * Created by Bludya on 4.7.2016 г..
 * All rights reserved!
 */
public class DuplicateEntryInStructureException extends RuntimeException {
    private static final String DUPLICATE_ENTRY = "The %s already exists in %s.";

    public DuplicateEntryInStructureException(String entryName, String structureName) {
        super(String.format(DUPLICATE_ENTRY, entryName, structureName));
    }

    protected DuplicateEntryInStructureException(String message) {
        super(message);
    }
}
