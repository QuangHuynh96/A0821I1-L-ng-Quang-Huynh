package model.service.impl;

import model.bean.LoaiDichVu;
import model.repository.ServiceTypeDAO;
import model.repository.impl.ServiceTypeDAOImpl;
import model.service.ServiceTypeBO;

import java.util.List;

public class ServiceTypeBOImpl implements ServiceTypeBO {
    ServiceTypeDAO serviceTypeDAO = new ServiceTypeDAOImpl();
    @Override
    public List<LoaiDichVu> findAll() {
        return serviceTypeDAO.findAll();
    }
}
