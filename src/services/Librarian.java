package services;

import beans.Content;
import beans.Result;
import dao.DB_in;
import dao.DB_out;
import support.exceptions.MBicicleException;
import support.sections.OperationSection;

import java.util.List;

public class Librarian {
    private String name;
    private List<String> list;
    private OperationSection section;

    public Librarian() {
    }

    public Librarian(String name, OperationSection section) {
        this.name = name;
        this.section = section;
    }

    public Librarian(String name, List<String> list, OperationSection section) {
        this.name = name;
        this.list = list;
        this.section = section;
    }

    public Result serve() {
        boolean addResult;
        Content content;
        try {
            if (section.getGroup().equals("add")) {
                addResult = new DB_in().apply(name, list, section.getSqlSection());
                return new Result(name, list,addResult, section);
            }
            content = new DB_out().apply(name, section.getSqlSection());
            return new Result(name, content, section);
        } catch (MBicicleException e) {
            return section.getGroup().equals("add") ? new Result(name, list, e.getMessage(), section)
                                                    : new Result(name, e.getMessage(), section);
        }
    }
}
