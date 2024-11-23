package App;

import java.util.List;

public interface ICornerDao {

    void add(Corner corner) throws Exception;

    void changeDevice(Corner corner, int deviceId) throws Exception;

    void bookCorner(Corner corner) throws Exception;

    void releaseCorner(Corner corner) throws Exception;

    void delete(int deviceId) throws Exception;

    Corner findById(int cornerId) throws Exception;

    List<IAssignable> findAll() throws Exception;
}
