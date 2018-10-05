package services;

import beans.Result;
import support.sections.OperationSection;

import java.util.List;

public class Librarian {
    public Result add(String name, List<String> list, OperationSection section) {
        switch (section) {
            case ADD_AUTHOR:
            case ADD_BOOK:
        }
        return new Result();
    }

    public Result get(String name, OperationSection section) {
        switch (section) {
            case GET_AUTHOR:
            case GET_BOOK:
        }
        return new Result();
    }

}
