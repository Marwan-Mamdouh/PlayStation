package App;

import java.util.List;

public interface IDeviceDao {

    // insert into the db
    void insert(Device device) throws Exception;

    // update values in db
    void update(Device device) throws Exception;

    // delete values in db
    void delete(int deviceId) throws Exception;

    // find some deviceId
    Device findById(int deviceId) throws Exception;

    // read all the table
    List<Device> findAll() throws Exception;
}

