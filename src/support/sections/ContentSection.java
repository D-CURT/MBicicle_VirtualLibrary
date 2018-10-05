package support.sections;

import static support.constants.Constants.*;

public enum ContentSection {
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

    ContentSection(String contentSQL, String contentNamesSQL, String nameByIDSQL, String insertionSQL) {
        this.contentSQL = contentSQL;
        this.contentNamesSQL = contentNamesSQL;
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
