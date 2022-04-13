package model.service.impl;

import model.bean.TrinhDo;
import model.repository.TrinhDoRepository;
import model.repository.impl.TrinhDoRepositoryImpl;
import model.service.TrinhDoService;

import java.util.List;

public class TrinhDoServiceImpl implements TrinhDoService {
    TrinhDoRepository trinhDoRepository = new TrinhDoRepositoryImpl();
    @Override
    public List<TrinhDo> findAll() {
        return trinhDoRepository.findAll();
    }
}
