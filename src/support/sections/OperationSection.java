package support.sections;

public enum OperationSection {
    ADD_AUTHOR("add", SQLSection.AUTHOR),
    ADD_BOOK("add", SQLSection.BOOK),
    GET_AUTHOR("get", SQLSection.AUTHOR),
    GET_BOOK("get", SQLSection.BOOK);

    private final String group;
    private final SQLSection sqlSection;

    OperationSection(String group, SQLSection sqlSection) {
        this.group = group;
        this.sqlSection = sqlSection;
    }

    public String getGroup() {
        return group;
    }

    public SQLSection getSqlSection() {
        return sqlSection;
    }
}
