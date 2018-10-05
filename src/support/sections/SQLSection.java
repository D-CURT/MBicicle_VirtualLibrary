package support.sections;

import static support.constants.Constants.*;

public enum SQLSection {
    AUTHOR(FIND_AUTHOR,
           FIND_BOOK_BY_AUTHOR,
           FIND_BOOK_NAME_BY_ID,
           INSERT_AUTHOR),
    BOOK(FIND_BOOK,
         FIND_AUTHOR_BY_BOOK,
         FIND_AUTHOR_NAME_BY_ID,
         INSERT_BOOK);

    private final String contentSQL;
    private final String contentNamesSQL;
    private final String nameByIDSQL;
    private final String insertionSQL;

    SQLSection(String contentSQL, String namesSQL,
               String nameByIDSQL, String insertionSQL) {
        this.contentSQL = contentSQL;
        this.contentNamesSQL = namesSQL;
        this.nameByIDSQL = nameByIDSQL;
        this.insertionSQL = insertionSQL;
    }

    public String getContentSQL() {
        return contentSQL;
    }

    public String getContentNamesSQL() {
        return contentNamesSQL;
    }

    public String getNameByIDSQL() {
        return nameByIDSQL;
    }

    public String getInsertionSQL() {
        return insertionSQL;
    }
}
