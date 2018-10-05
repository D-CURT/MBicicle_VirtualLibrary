package support.sections;

import static support.constants.Constants.*;

public enum ContentSection {
    AUTHOR(FIND_AUTHOR, FIND_BOOK_BY_AUTHOR, FIND_BOOK_NAME_BY_ID),
    BOOK(FIND_BOOK, FIND_AUTHOR_BY_BOOK, FIND_AUTHOR_NAME_BY_ID);

    private final String contentSQL;
    private final String contentNamesSQL;
    private final String nameByIDSQL;

    ContentSection(String contentSQL, String contentNamesSQL, String nameByIDSQL) {
        this.contentSQL = contentSQL;
        this.contentNamesSQL = contentNamesSQL;
        this.nameByIDSQL = nameByIDSQL;
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
}
