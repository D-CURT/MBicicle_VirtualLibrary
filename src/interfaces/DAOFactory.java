package interfaces;

import dao.DBIn;
import dao.DBOut;

public interface DAOFactory {
    DBIn createIN();
    DBOut createOUT();
}
