package com.example.servingwebcontent.WayLun.Borrow;

import com.example.servingwebcontent.Daniel.Classroom.Classroom;
import com.example.servingwebcontent.Daniel.Classroom.ClassroomService;
import com.example.servingwebcontent.Daniel.Equipment.Equipment;
import com.example.servingwebcontent.Daniel.Equipment.EquipmentRepository;
import com.example.servingwebcontent.Daniel.Equipment.EquipmentService;
import com.example.servingwebcontent.WayLun.BorrowClassroom.BorrowClassroom;
import com.example.servingwebcontent.WayLun.BorrowClassroom.BorrowClassroomRepository;
import com.example.servingwebcontent.WayLun.BorrowClassroom.BorrowClassroomService;
import com.example.servingwebcontent.WayLun.BorrowEquipment.BorrowEquipment;
import com.example.servingwebcontent.WayLun.BorrowEquipment.BorrowEquipmentRepository;
import com.example.servingwebcontent.WayLun.BorrowEquipment.BorrowEquipmentService;
import com.example.servingwebcontent.WayLun.BorrowForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping(path = "/borrow")
public class BorrowController {

    private final BorrowService borrowService;
    private final ClassroomService classroomService;
    private final EquipmentService equipmentService;
    private final BorrowClassroomService borrowClassroomService;
    private final BorrowEquipmentService borrowEquipmentService;
    private final BorrowClassroomRepository borrowClassroomRepository;
    private final BorrowRepository borrowRepository;
    private final BorrowEquipmentRepository borrowEquipmentRepository;
    private final EquipmentRepository equipmentRepository;


    @Autowired
    public BorrowController(BorrowService borrowService, ClassroomService classroomService,
                            EquipmentService equipmentService, BorrowClassroomService borrowClassroomService,
                            BorrowEquipmentService borrowEquipmentService, BorrowClassroomRepository borrowClassroomRepository,
                            BorrowRepository borrowRepository, BorrowEquipmentRepository borrowEquipmentRepository,
                            EquipmentRepository equipmentRepository) {
        this.borrowService = borrowService;
        this.classroomService = classroomService;
        this.equipmentService = equipmentService;
        this.borrowClassroomService = borrowClassroomService;
        this.borrowEquipmentService = borrowEquipmentService;
        this.borrowRepository = borrowRepository;
        this.borrowEquipmentRepository = borrowEquipmentRepository;
        this.borrowClassroomRepository = borrowClassroomRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @GetMapping("/editBorrow")
    public ModelAndView editBorrowForm(@RequestParam Long borrowId) {
        ModelAndView modelAndView = new ModelAndView("WayLun/editBorrow");
        Optional<Borrow> optionalBorrow = borrowService.findById(borrowId);
        Borrow borrow = optionalBorrow.orElse(null);
        BorrowForm borrowForm = new BorrowForm();
        borrowForm.setBorrow(borrow);
        modelAndView.addObject("borrowForm", borrowForm);

        Iterable<Classroom> classrooms = classroomService.findAll();
        Iterable<Equipment> equipments = equipmentService.findAll();

        modelAndView.addObject("classrooms", classrooms);
        modelAndView.addObject("equipments", equipments);
        return modelAndView;
    }

    @PostMapping("/editBorrow")
    public String editBorrow(@ModelAttribute BorrowForm borrowForm,
                             @RequestParam("selectedClassroomId") Long selectedClassroomId,
                             @RequestParam("selectedEquipmentId") Long selectedEquipmentId,
                             @RequestParam("borrowId") Long borrowId) {
        // 更新借用資料
        Optional<Borrow> existingBorrow = borrowService.findById(borrowId);
        Borrow newborrow = existingBorrow.orElse(null);
        // 設定新的借用資料...
        newborrow.setName(borrowForm.getBorrow().getName());
        newborrow.setIdentity(borrowForm.getBorrow().getIdentity());
        newborrow.setPhone(borrowForm.getBorrow().getPhone());
        newborrow.setDepartment_grade(borrowForm.getBorrow().getDepartment_grade());
        newborrow.setIdentitycard(borrowForm.getBorrow().getIdentitycard());

        Classroom classroom = new Classroom();
        classroom.setId_classroom(selectedClassroomId);

        // 更新借用教室資料
        Optional<BorrowClassroom> existingBorrowClassroom = borrowClassroomService.findById(borrowId);
        BorrowClassroom newborrowClassroom = existingBorrowClassroom.orElse(null);
        // 設定新的借用教室資料...
        newborrowClassroom.setPurpose(borrowForm.getBorrowClassroom().getPurpose());
        newborrowClassroom.setTeacher(borrowForm.getBorrowClassroom().getTeacher());
        newborrowClassroom.setNote(borrowForm.getBorrowClassroom().getNote());
        newborrowClassroom.setClassroom(classroom);

        Equipment equipment = new Equipment();
        equipment.setId_equipment(selectedEquipmentId);

        // 更新借用設備資料
        Optional<BorrowEquipment> existingBorrowEquipment = borrowEquipmentService.findById(borrowId);
        BorrowEquipment newborrowEquipment = existingBorrowEquipment.orElse(null);
        // 設定新的借用設備資料...
        newborrowEquipment.setEquipment(equipment);
        //編輯newborrow的category和label
        Equipment newE = equipmentRepository.findById(selectedEquipmentId).orElse(null);
        newborrow.setCategory(newE.getCategory());
        newborrow.setLabel(newE.getLabel());

        // 保存更新後的資料
        borrowService.save(newborrow);
        borrowClassroomService.save(newborrowClassroom);
        borrowEquipmentService.save(newborrowEquipment);

        String status = newborrow.getStatus();

        if(status.equals("審核中")){
            return "redirect:/borrow/review";
        } else if (status.equals("租借中")) {
            return "redirect:/borrow/borrowing";
        }
        else{
            return "redirect:/borrow/returned";
        }
    }


    //刪除整筆
    @GetMapping("/deleteBorrow")
    public String deleteBorrow(Long borrowId) {
        // 檢查borrowClassroomRepository中是否存在相應的記錄
        Optional<BorrowClassroom> classroomOptional = borrowClassroomRepository.findById(borrowId);
        if (classroomOptional.isPresent()) {
            // 如果存在，刪除相應的borrowClassroom記錄
            borrowClassroomRepository.deleteById(borrowId);
        }

        // 檢查borrowEquipmentRepository中是否存在相應的記錄
        Optional<BorrowEquipment> equipmentOptional = borrowEquipmentRepository.findById(borrowId);
        if (equipmentOptional.isPresent()) {
            // 如果存在，刪除相應的borrowEquipment記錄
            borrowEquipmentRepository.deleteById(borrowId);
        }

        // 刪除borrow記錄
        borrowService.deleteById(borrowId);

        return "redirect:/borrow/borrowing";
    }

    //刪除教室租借
    @GetMapping("/deleteBorrowC")
    public String deleteBorrowC(Long borrowId) {
        // 檢查borrowClassroomRepository中是否存在相應的記錄
        Optional<BorrowClassroom> classroomOptional = borrowClassroomRepository.findById(borrowId);
        if (classroomOptional.isPresent()) {
            // 如果存在，刪除相應的borrowClassroom記錄
            borrowClassroomRepository.deleteById(borrowId);
        }

        return "redirect:/borrow/borrowing";
    }

    //刪除設備
    @GetMapping("/deleteBorrowE")
    public String deleteBorrowE(Long borrowId) {
        // 檢查borrowEquipmentRepository中是否存在相應的記錄
        Optional<BorrowEquipment> equipmentOptional = borrowEquipmentRepository.findById(borrowId);
        if (equipmentOptional.isPresent()) {
            // 如果存在，刪除相應的borrowEquipment記錄
            borrowEquipmentRepository.deleteById(borrowId);
        }

        return "redirect:/borrow/borrowing";
    }

    @GetMapping("/addBorrow")
    public ModelAndView addBorrow(){
        ModelAndView modelAndView = new ModelAndView("WayLun/addBorrow");
        modelAndView.addObject("borrowForm", new BorrowForm());

        Iterable<Classroom> classrooms = classroomService.findAll();
        Iterable<Equipment> equipments = equipmentService.findAll();

        modelAndView.addObject("classrooms", classrooms);
        modelAndView.addObject("equipments", equipments);

        return modelAndView;
    }

    @PostMapping("/addBorrow")
    public String addBorrow(@ModelAttribute BorrowForm borrowForm,
                            @RequestParam(name = "selectedClassroomId", required = false, defaultValue = "0") Long selectedClassroomId,
                            @RequestParam(name = "selectedEquipmentId", required = false, defaultValue = "0" ) Long selectedEquipmentId){
        Borrow borrow = borrowForm.getBorrow();
        borrowService.save(borrow);


        // Save BorrowClassroom information
        BorrowClassroom borrowClassroom = borrowForm.getBorrowClassroom();
        borrowClassroom.setBorrow(borrow);

        //set borrowForm的classroom
        if(selectedClassroomId != 0){
            Classroom classroom = new Classroom();
            classroom.setId_classroom(selectedClassroomId);
            borrowForm.setClassroom(classroom);
            borrowClassroom.setClassroom(borrowForm.getClassroom());
        }
        /*else{
            BorrowClassroom nullClassroom = new BorrowClassroom();

        }*/

        borrowClassroomService.save(borrowClassroom);

        // Save BorrowEquipment information
        BorrowEquipment borrowEquipment = borrowForm.getBorrowEquipment();
        borrowEquipment.setBorrow(borrow);

        //set borrowForm的equipment

        if(selectedEquipmentId != 0){
            Equipment equipment = new Equipment();
            equipment.setId_equipment(selectedEquipmentId);
            borrowForm.setEquipment(equipment);
            borrowEquipment.setEquipment(equipment);
            Equipment newE = equipmentRepository.findById(selectedEquipmentId).orElse(null);
            borrow.setCategory(newE.getCategory());
            borrow.setLabel(newE.getLabel());
        }


        borrowService.save(borrow);
        borrowEquipmentService.save(borrowEquipment);

        return "redirect:/borrow/review";
    }

    @GetMapping("/borrowing")
    public ModelAndView Borrowing(){
        ModelAndView modelAndView = new ModelAndView("WayLun/BorrowingList");
        Iterable<Borrow> borrowList = borrowService.getBorrowing();
        modelAndView.addObject("borrowList", borrowList);

        return modelAndView;
    }

    @GetMapping("/borrowDetails/{id}")
    public ModelAndView showBorrowDetails(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("WayLun/BorrowingDetails");

        Optional<Borrow> optionalBorrow = borrowService.findById(id);
        Borrow borrow = optionalBorrow.orElse(null);

        Optional<BorrowClassroom> optionalBorrowClassroom = borrowClassroomService.findById(borrow.getId_borrow());
        BorrowClassroom borrowClassroom = optionalBorrowClassroom.orElse(null);

        Optional<BorrowEquipment> optionalBorrowEquipment = borrowEquipmentService.findById(borrow.getId_borrow());
        BorrowEquipment borrowEquipment = optionalBorrowEquipment.orElse(null);

        Optional<Equipment> optionalEquipment = equipmentService.findById(borrowEquipment.getEquipment().getId_equipment());
        BorrowEquipment equipment = optionalBorrowEquipment.orElse(null);

        borrow.setClassroomname(borrowClassroom.getClassroom().getName());

        borrow.setCategory(borrowEquipment.getEquipment().getCategory());
        borrow.setLabel(borrowEquipment.getEquipment().getLabel());

        modelAndView.addObject("borrow", borrow);
        modelAndView.addObject("borrowClassroom", borrowClassroom);
        modelAndView.addObject("borrowEquipment", borrowEquipment);

        return modelAndView;
    }

    @GetMapping("/review")
    public ModelAndView reviewBorrow(){
        ModelAndView modelAndView = new ModelAndView("WayLun/BorrowReview");
        Iterable<Borrow> borrowList = borrowService.getReviewBorrow();
        modelAndView.addObject("borrowList", borrowList);

        return modelAndView;
    }

    @GetMapping("/reviewDetails/{id}")
    public ModelAndView showReviewDetails(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("WayLun/BorrowReviewDetails");

        Optional<Borrow> optionalBorrow = borrowService.findById(id);
        Borrow borrow = optionalBorrow.orElse(null);

        Optional<BorrowClassroom> optionalBorrowClassroom = borrowClassroomService.findById(borrow.getId_borrow());
        BorrowClassroom borrowClassroom = optionalBorrowClassroom.orElse(null);

        Optional<BorrowEquipment> optionalBorrowEquipment = borrowEquipmentService.findById(borrow.getId_borrow());
        BorrowEquipment borrowEquipment = optionalBorrowEquipment.orElse(null);

        if(borrowClassroom != null) {
            borrow.setClassroomname(borrowClassroom.getClassroom().getName());
        }

        if(borrowEquipment != null){
            borrow.setCategory(borrowEquipment.getEquipment().getCategory());
            borrow.setLabel(borrowEquipment.getEquipment().getLabel());
        }

        modelAndView.addObject("borrow", borrow);
        modelAndView.addObject("borrowClassroom", borrowClassroom);
        modelAndView.addObject("borrowEquipment", borrowEquipment);

        return modelAndView;
    }

    @GetMapping("/approveBorrow")
    public String approveBorrow(Long borrowId) {
        // 實現通過審核的邏輯，例如更新 Borrow 狀態為已通過
        borrowService.approveBorrow(borrowId);
        borrowEquipmentService.approveBorrow(borrowId);
        return "redirect:/borrow/review";
    }
    @GetMapping("rejectBorrow")
    public String rejectBorrow(Long borrowId) {
        borrowClassroomRepository.deleteById(borrowId);
        borrowEquipmentRepository.deleteById(borrowId);
        borrowRepository.deleteById(borrowId);
        return "redirect:/borrow/review";
    }

    @GetMapping("/return")
    public String returnBorrow(@RequestParam Long borrowId) {
        borrowService.returnBorrow(borrowId);
        Optional<Borrow> optionalBorrow = borrowService.findById(borrowId);
        Borrow borrow = optionalBorrow.orElse(null);
        Optional<BorrowEquipment> optionalBorrowEquipment = borrowEquipmentService.findById(borrow.getId_borrow());
        BorrowEquipment borrowEquipment = optionalBorrowEquipment.orElse(null);

        borrowEquipment.setReturnTime(new Date());
        return "redirect:/borrow/borrowing";
    }

    @GetMapping("/returned")
    public ModelAndView Returned(){
        ModelAndView modelAndView = new ModelAndView("WayLun/returnBorrow");
        Iterable<Borrow> borrowList = borrowService.getReturned();
        modelAndView.addObject("borrowList", borrowList);

        return modelAndView;
    }

    @GetMapping("/returnDetails/{id}")
    public ModelAndView showReturnedDetails(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("WayLun/returnDetails");

        Optional<Borrow> optionalBorrow = borrowService.findById(id);
        Borrow borrow = optionalBorrow.orElse(null);

        Optional<BorrowClassroom> optionalBorrowClassroom = borrowClassroomService.findById(borrow.getId_borrow());
        BorrowClassroom borrowClassroom = optionalBorrowClassroom.orElse(null);

        Optional<BorrowEquipment> optionalBorrowEquipment = borrowEquipmentService.findById(borrow.getId_borrow());
        BorrowEquipment borrowEquipment = optionalBorrowEquipment.orElse(null);

        Optional<Equipment> optionalEquipment = equipmentService.findById(borrowEquipment.getEquipment().getId_equipment());
        BorrowEquipment equipment = optionalBorrowEquipment.orElse(null);

        borrow.setClassroomname(borrowClassroom.getClassroom().getName());

        borrow.setCategory(borrowEquipment.getEquipment().getCategory());
        borrow.setLabel(borrowEquipment.getEquipment().getLabel());

        modelAndView.addObject("borrow", borrow);
        modelAndView.addObject("borrowClassroom", borrowClassroom);
        modelAndView.addObject("borrowEquipment", borrowEquipment);

        return modelAndView;
    }

    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("WayLun/findAllBorrow");
        Iterable<BorrowEquipment> borrowEList = borrowEquipmentRepository.findAll();
        modelAndView.addObject("borrowEList", borrowEList);

        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("WayLun/borrowEquipmentList");
        // Retrieve data from MySQL and add it to the model
        Iterable<Borrow> borrowList = borrowService.findAll();
        modelAndView.addObject("borrowList", borrowList);
        // Get distinct category
        List<String> categories = equipmentService.findDistinctCategories();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
}
