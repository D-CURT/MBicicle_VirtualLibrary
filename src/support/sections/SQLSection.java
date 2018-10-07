package support.sections;

import static support.constants.Constants.*;

public enum SQLSection {
    AUTHOR(FIND_AUTHOR,
           FIND_BOOKS_BY_AUTHOR,
           INSERT_AUTHOR),
    BOOK(FIND_BOOK,
         FIND_AUTHORS_BY_BOOK,
         INSERT_BOOK);

    private final String contentSQL;
    private final String contentNamesSQL;
    private final String insertionSQL;

    SQLSection(String contentSQL, String namesSQL, String insertionSQL) {
        this.contentSQL = contentSQL;
        this.contentNamesSQL = namesSQL;
        this.insertionSQL = insertionSQL;
    }

    public String getContentSQL() {
        return contentSQL;
    }

    public String getContentNamesSQL() {
        return contentNamesSQL;
    }

    public String getInsertionSQL() {
        return insertionSQL;
    }
}
