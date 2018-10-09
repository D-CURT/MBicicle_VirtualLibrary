package services;

import beans.Content;
import beans.Result;
import dao.interfaces.DAOApplier;
import support.exceptions.MBicycleException;
import support.sections.OperationSection;

import java.util.List;

public class Librarian {
    private DAOApplier applier;

    public Librarian() {
    }

    public Librarian(DAOApplier applier) {
        this.applier = applier;
    }

    public Result get(String name, OperationSection section) {
        Content content;
        try {
            content = applier.apply(name, section.getSqlSection());
            return new Result(content, section);
        } catch (MBicycleException e) {
            return new Result(e.getMessage(), section);
        }
    }

    public Result add(String name, List<String> tiedNames, OperationSection section) {
        boolean addingResult;
        try {
            addingResult = applier.adding(name, tiedNames, section.getSqlSection());
            return new Result(addingResult, section);
        } catch (MBicycleException e) {
            return new Result(e.getMessage(), section);
        }
    }
}
