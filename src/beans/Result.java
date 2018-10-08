package beans;

import support.sections.OperationSection;

import java.util.List;

import static support.constants.Constants.EMPTY;
import static support.constants.Constants.LINE;

public class Result {
    private Content content;
    private boolean addResult = false;
    private String error;
    private OperationSection section;

    public Result() {
    }

    public Result(Content content, OperationSection section) {
        this.content = content;
        this.section = section;
    }

    public Result(boolean addResult, OperationSection section) {
        this.addResult = addResult;
        this.section = section;
    }

    public Result(String error, OperationSection section) {
        this.error = error;
        this.section = section;
    }

    private boolean hasError() {
        return error != null;
    }

    private String drawList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(s -> sb.append(s).append(list.size() > 1 ? LINE : EMPTY));
        return sb.toString();
    }

    private String getBody() {
        if (hasError()) return EMPTY;
        if (content != null) {
            return drawList(content.getTiedNames());
        }
        if (addResult) return "Data added";
        return section.getGroup().equals("get") ? "Nothing found"
                                                : "The notes already exist";
    }

    private String getSuffix() {
        return hasError() ? " - " + error : EMPTY;
    }

    @Override
    public String toString() {
        return String.valueOf(getBody() + getSuffix());
    }
}
