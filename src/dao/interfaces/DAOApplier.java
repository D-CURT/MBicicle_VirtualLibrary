package dao.interfaces;

import beans.Content;
import support.sections.SQLSection;

import java.util.List;

public interface DAOApplier {
    boolean adding(String name, List<String> list, SQLSection sqlSection);
    Content apply(String name, SQLSection sqlSection);
}
