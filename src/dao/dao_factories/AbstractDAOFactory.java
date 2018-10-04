package dao.dao_factories;

import dao.DBIn;
import dao.DBOut;
import interfaces.DAOFactory;

public abstract class AbstractDAOFactory implements DAOFactory {
    @Override
    public DBIn createIN() {
        return new DBIn();
    }

    @Override
    public DBOut createOUT() {
        return new DBOut();
    }
}
