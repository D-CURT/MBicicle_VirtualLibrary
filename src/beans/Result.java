package beans;

import support.sections.OperationSection;

import java.util.List;

public class Result {
    private InputHolder holder;
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

        public InputHolder(String name) {
            this.name = name;
        }

        public InputHolder(String name, List<String> list) {
            this.name = name;
            this.list = list;
        }
    }

    private boolean hasError() {
        return error != null;
    }
}
