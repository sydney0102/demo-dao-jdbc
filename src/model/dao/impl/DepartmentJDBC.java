package model.dao.impl;

import model.dao.DepartmentDAO;
import model.entities.Department;

import java.util.List;

public class DepartmentJDBC implements DepartmentDAO {

    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
