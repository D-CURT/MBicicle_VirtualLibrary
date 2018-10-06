package beans;

import support.sections.OperationSection;

import java.util.List;
import java.util.stream.Collectors;

import static support.constants.Constants.LINE;

public class Result {
    private InputHolder holder;
    private StringBuilder builder;
    private Content content;
    private boolean addResult;
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

    private void setBuilder() {
        if (builder != null) builder.setLength(0);
        else builder = new StringBuilder();
    }

    private void drawList() {
        holder.list.forEach(s -> builder.append(s).append(LINE));
    }

    private String getPrefix() {
        setBuilder();
        switch (section) {
            case GET_AUTHOR: builder.append("Searching author by name: ")
                                            .append(holder.name).toString();
            case   GET_BOOK: builder.append("Searching book by name: ")
                                            .append(holder.name).toString();
            case   ADD_BOOK: builder.append("Adding book with name: ")
                                            .append(holder.name).append(LINE)
                                            .append(holder.list.size() > 1 ? "and authors:\n" : "and author: ");
                                            drawList();
            case ADD_AUTHOR: builder.append("Adding author with name: ")
                                            .append(holder.name).append(LINE)
                                            .append(holder.list.size() > 1 ? "and books:\n" : "and book: ");
                                            drawList();
        }
        return builder.toString();
    }

    private String getBody() {
        return "";
    }

    private String getSuffix() {
        return "";
    }

    @Override
    public String toString() {
        return "";
    }
}
