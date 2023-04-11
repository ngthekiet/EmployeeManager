package vn.com.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.com.employeemanager.model.Employee;
import vn.com.employeemanager.service.EmployeeService;

import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/dsnhanvien")
    public ModelAndView getEmployees() {
        ModelAndView mav = new ModelAndView("dsnhanvien");
        mav.addObject("listEmployee", employeeService.getEmployees());
        mav.addObject("numEmployee", employeeService.getEmployees().size());
        return mav;
    }

    @RequestMapping(value = "/chitietnhanvien/{id}")
    public ModelAndView employeeDetails(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView("chitietnhanvien");
        mav.addObject("employee", employeeService.getEmployee(id));
        return mav;
    }

    @RequestMapping(value = "/viewthemnhanvien")
    public String showAddEmployee(Model model) {
        Employee employee = new Employee();
        employee.setId("nv" + (employeeService.getSizeEmployee() + 1));
        ArrayList<String> listDepartment = new ArrayList<>();
        listDepartment.add("SX");
        listDepartment.add("KT");
        listDepartment.add("KHTV");
        listDepartment.add("BGĐ");
        ArrayList<String> listTitle = new ArrayList<>();
        listTitle.add("GĐ");
        listTitle.add("PGĐ");
        listTitle.add("TP");
        listTitle.add("PP");
        listTitle.add("NV");
        model.addAttribute("listDepartment", listDepartment);
        model.addAttribute("listTitle", listTitle);
        model.addAttribute("employee", employee);
        return "themnhanvien";
    }

    @RequestMapping(value = "/themnhanvien", method = RequestMethod.POST)
    public ModelAndView displayUserDetails(Employee employee, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("themnhanvien");
        if (bindingResult.hasErrors()) {
            mav.addObject("error", "Dữ liệu không đúng định dạng");
            ArrayList<String> listDepartment = new ArrayList<>();
            listDepartment.add("SX");
            listDepartment.add("KT");
            listDepartment.add("KHTV");
            listDepartment.add("BGĐ");
            ArrayList<String> listTitle = new ArrayList<>();
            listTitle.add("GĐ");
            listTitle.add("PGĐ");
            listTitle.add("TP");
            listTitle.add("PP");
            listTitle.add("NV");
            mav.addObject("employee", employee);
            mav.addObject("listDepartment", listDepartment);
            mav.addObject("listTitle", listTitle);
            return mav;
        }
        if (employeeService.addEmployee(employee))
            return getEmployees();
        mav.addObject("error", "Mã nhân viên đã tồn tại");
        return mav;
    }

    @RequestMapping(value = "/viewsuanhanvien/{id}")
    public String showEditEmployee(@PathVariable("id") String id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        ArrayList<String> listDepartment = new ArrayList<>();
        listDepartment.add("SX");
        listDepartment.add("KT");
        listDepartment.add("KHTV");
        listDepartment.add("BGĐ");
        ArrayList<String> listTitle = new ArrayList<>();
        listTitle.add("GĐ");
        listTitle.add("PGĐ");
        listTitle.add("TP");
        listTitle.add("PP");
        listTitle.add("NV");
        model.addAttribute("listDepartment", listDepartment);
        model.addAttribute("listTitle", listTitle);
        return "suanhanvien";
    }

    @RequestMapping(value = "/suanhanvien/{id}")
    public ModelAndView editEmployee(@PathVariable("id") String id, Employee employee, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("suanhanvien");
        if (bindingResult.hasErrors()) {
            mav.addObject("error", "Dữ liệu không đúng định dạng");
            ArrayList<String> listDepartment = new ArrayList<>();
            listDepartment.add("SX");
            listDepartment.add("KT");
            listDepartment.add("KHTV");
            listDepartment.add("BGĐ");
            ArrayList<String> listTitle = new ArrayList<>();
            listTitle.add("GĐ");
            listTitle.add("PGĐ");
            listTitle.add("TP");
            listTitle.add("PP");
            listTitle.add("NV");
            mav.addObject("employee", employee);
            mav.addObject("listDepartment", listDepartment);
            mav.addObject("listTitle", listTitle);
            return mav;
        }
        if (employeeService.editEmployee(id, employee))
            return getEmployees();
        mav.addObject("error", "Không thể cập nhật");
        return mav;
    }
}
