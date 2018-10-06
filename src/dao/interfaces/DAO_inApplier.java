package dao.interfaces;

import support.sections.SQLSection;

import java.util.List;

public interface DAO_inApplier {
    boolean apply(String name, List<String> list, SQLSection sqlSection);
}
