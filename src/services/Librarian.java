package services;

import beans.Content;
import beans.Result;
import dao.interfaces.DAOApplier;
import support.exceptions.MBicicleException;
import support.sections.OperationSection;

import java.util.List;

public class Librarian {
    private DAOApplier applier;

    public Librarian() {
    }

    public Librarian(DAOApplier applier) {
        this.applier = applier;
    }



    public Result serve(String name, OperationSection section) {
        Content content;
        try {
            content = applier.apply(name, section.getSqlSection());
            return new Result(name, content, section);
        } catch (MBicicleException e) {
            return new Result(name, e.getMessage(), section);
        }
    }

    public Result serve(String name, List<String> list, OperationSection section) {
        boolean addingResult;
        try {
            addingResult = applier.apply(name, list, section.getSqlSection());
            return new Result(name, list, addingResult, section);
        } catch (MBicicleException e) {
            return new Result(name, list, e.getMessage(), section);
        }
    }
}
