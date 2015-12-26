package net.wings.dao;

import net.wings.domain.Train;

import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
public interface TrainDao {
    void add(Train c);

    void delete(String id);

    void update(Train item);

    Train find(String id);

    List<Train> getAll();
}
