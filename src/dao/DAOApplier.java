package dao;

import beans.Result;
import support.sections.OperationSection;

import java.util.List;

public interface DAOApplier {
    Result apply(String name, List<String> list, OperationSection section);
}
