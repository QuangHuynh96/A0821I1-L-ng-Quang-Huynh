package model.service.impl;

import model.bean.KieuThue;
import model.repository.RentalTypeDAO;
import model.repository.impl.RentalTypeDAOImpl;
import model.service.RentalTypeBO;

import java.util.List;

public class RentalTypeBOImpl implements RentalTypeBO {
    RentalTypeDAO rentalTypeDAO = new RentalTypeDAOImpl();
    @Override
    public List<KieuThue> findAll() {
        return rentalTypeDAO.findAll();
    }
}
