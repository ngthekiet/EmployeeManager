package vn.com.employeemanager.service;

import org.springframework.stereotype.Service;
import vn.com.employeemanager.model.Employee;

import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private static final EmployeeService instance = new EmployeeService();
    private Map<String, Employee> employeeMap;

    public EmployeeService() {
        init();
    }

    public void init() {
        employeeMap = new HashMap<String, Employee>();
        employeeMap.put("nv1", new Employee("nv1", "kiet", false, Date.valueOf("2001-01-22"), "vinh long", "0123456789", "BGĐ", "GĐ", 5000));
        employeeMap.put("nv2", new Employee("nv2", "long", false, Date.valueOf("2001-08-12"), "dak lak", "01122334455", "KHTV", "PP", 3000));
        employeeMap.put("nv3", new Employee("nv3", "phan", true, Date.valueOf("2001-06-09"), "binh duong", "0987654321", "SX", "NV", 1000));
        employeeMap.put("nv4", new Employee("nv4", "hong", true, Date.valueOf("2001-03-11"), "dong thap", "0258123987", "SX", "NV", 1000));
    }

    public Collection<Employee> getEmployees() {
        return employeeMap.values();
    }

    public Employee getEmployee(String id) {
        return employeeMap.get(id);
    }

    public boolean addEmployee(Employee employee) {
        if (!existEmployee(employee.getId())) {
            employeeMap.put(employee.getId(), employee);
            return true;
        }
        return false;
    }

    public boolean existEmployee(String id) {
        if (employeeMap.containsKey(id))
            return true;
        return false;
    }

    public boolean editEmployee(String id, Employee employee) {
        try {
            Employee emp = getEmployee(id);
            emp.setName(employee.getName());
            emp.setMale(employee.isMale());
            emp.setBirthDay(employee.getBirthDay());
            emp.setAddress(employee.getAddress());
            emp.setPhone(employee.getPhone());
            emp.setDepartment(employee.getDepartment());
            emp.setTitle(employee.getTitle());
            emp.setWageRange(employee.getWageRange());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getSizeEmployee() {
        return employeeMap.size();
    }
}
