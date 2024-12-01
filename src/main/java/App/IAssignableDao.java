package App;

import java.util.List;

public interface IAssignableDao {

    void add(IAssignable iAssignable) throws Exception;

    void changeDevice(IAssignable iAssignable, int deviceId) throws Exception;

    void book(IAssignable iAssignable) throws Exception;

    void release(IAssignable iAssignable) throws Exception;

    void delete(int iAssignableId, String tableName) throws Exception;

    IAssignable findById(int iAssignableId, String tableName) throws Exception;

    List<IAssignable> findAll(String tableName) throws Exception;
}
