package dao.interfaces;

import beans.Content;
import support.sections.SQLSection;

public interface DAO_outApplier {
    Content apply(String name, SQLSection sqlSection);
}
