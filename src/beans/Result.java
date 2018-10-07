package beans;

import support.sections.OperationSection;

import java.util.List;

import static support.constants.Constants.EMPTY;
import static support.constants.Constants.LINE;
import static support.sections.OperationSection.GET_AUTHOR;
import static support.sections.OperationSection.GET_BOOK;

public class Result {
    private InputHolder holder;
    private Content content;
    private boolean addResult = false;
    private String error;
    private OperationSection section;

    public Result() {
    }

    public Result(String name, Content content, OperationSection section) {
        holder = new InputHolder(name);
        this.content = content;
        this.section = section;
    }

    public Result(String name, List<String> list, boolean addResult, OperationSection section) {
        holder = new InputHolder(name, list);
        this.addResult = addResult;
        this.section = section;
    }

    public Result(String name, String error, OperationSection section) {
        holder = new InputHolder(name);
        this.error = error;
        this.section = section;
    }

    public Result(String name, List<String> list,String error, OperationSection section) {
        holder = new InputHolder(name, list);
        this.error = error;
        this.section = section;
    }

    private class InputHolder {
        private String name;
        private List<String> list;

        InputHolder(String name) {
            this.name = name;
        }

        InputHolder(String name, List<String> list) {
            this.name = name;
            this.list = list;
        }
    }

    private boolean hasError() {
        return error != null;
    }

    private StringBuilder drawList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(s -> sb.append(s).append(LINE));
        return sb;
    }

    private StringBuilder getPrefix() {
        StringBuilder sb = new StringBuilder();
        switch (section) {
            case GET_AUTHOR: sb.append("Searching author by name: ")
                               .append(holder.name); break;
            case   GET_BOOK: sb.append("Searching book by name: ")
                               .append(holder.name); break;
            case   ADD_BOOK: sb.append("Adding book with name: ")
                               .append(holder.name).append(LINE)
                               .append(holder.list.size() > 1 ? "and authors:\n" : "and author: ")
                               .append(drawList(holder.list)); break;
            case ADD_AUTHOR: sb.append("Adding author with name: ")
                               .append(holder.name).append(LINE)
                               .append(holder.list.size() > 1 ? "and books:\n" : "and book: ")
                               .append(drawList(holder.list));
        }
        return sb;
    }

    private String getBody() {
        if (hasError()) return EMPTY;
        if (content != null) {
            return section == GET_AUTHOR ? "\nThe author wrote books:\n" + drawList(content.getList())
                                         : "\nBook with such name have following authors:\n" + drawList(content.getList());
        }
        if (addResult) return "\nPassed successfully\n";
        return section == GET_AUTHOR || section == GET_BOOK ? "\nNothing found\n"
                                                            : "\nThe notes already exist\n";
    }

    private String getSuffix() {
        return hasError() ? " - " + error : EMPTY;
    }

    @Override
    public String toString() {
        return String.valueOf(getPrefix()) + getBody() + getSuffix();
    }
}
